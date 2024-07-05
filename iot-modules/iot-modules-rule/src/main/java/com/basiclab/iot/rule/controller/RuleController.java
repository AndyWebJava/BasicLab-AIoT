package com.basiclab.iot.rule.controller;

import com.basiclab.iot.common.core.annotation.NoRepeatSubmit;
import com.basiclab.iot.common.core.domain.R;
import com.basiclab.iot.common.core.enums.ConditionTypeEnum;
import com.basiclab.iot.common.core.enums.FieldTypeEnum;
import com.basiclab.iot.common.core.enums.OperatorEnum;
import com.basiclab.iot.common.core.enums.TriggeringEnum;
import com.basiclab.iot.common.core.utils.CompareUtil;
import com.basiclab.iot.common.core.web.controller.BaseController;
import com.basiclab.iot.common.core.web.domain.AjaxResult;
import com.basiclab.iot.common.core.web.page.TableDataInfo;
import com.basiclab.iot.common.log.annotation.Log;
import com.basiclab.iot.common.log.enums.BusinessType;
import com.basiclab.iot.common.security.annotation.PreAuthorize;
import com.basiclab.iot.link.api.RemoteDeviceService;
import com.basiclab.iot.link.api.RemoteProductService;
import com.basiclab.iot.link.api.domain.product.entity.Product;
import com.basiclab.iot.link.api.domain.product.entity.ProductProperties;
import com.basiclab.iot.link.api.domain.product.entity.ProductServices;
import com.basiclab.iot.rule.api.domain.Rule;
import com.basiclab.iot.rule.api.domain.RuleConditions;
import com.basiclab.iot.rule.api.domain.model.RuleModel;
import com.basiclab.iot.rule.service.RuleConditionsService;
import com.basiclab.iot.rule.service.RuleService;
import com.basiclab.iot.tdengine.api.RemoteTdEngineService;
import com.basiclab.iot.tdengine.api.domain.TagsSelectDao;
import com.basiclab.iot.tdengine.api.domain.model.TagsSelectDTO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;


/**
 * 规则处理类
 *
 * @author shisen
 */
@RestController
@RequestMapping("/rule")
public class RuleController extends BaseController {

    @Autowired
    private RuleService ruleService;

    @Autowired
    private RuleConditionsService ruleConditionsService;

    @Resource
    private RemoteProductService remoteProductService;

    @Resource
    private RemoteTdEngineService remoteTdEngineService;

    @Resource
    private RemoteDeviceService remoteDeviceService;


    /**
     * 查询规则管理列表
     */
    @PreAuthorize(hasPermi = "rule:rule:list")
    @GetMapping("/list")
    public TableDataInfo list(Rule rule) {
        startPage();
        List<Rule> list = ruleService.selectRuleList(rule);
        return getDataTable(list);
    }


    /**
     * 获取规则详细信息
     */
    //@PreAuthorize(hasPermi = "rule:rule:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(ruleService.selectByPrimaryKey(id));
    }

    /**
     * 获取规则详细信息
     */
    //@PreAuthorize(hasPermi = "rule:rule:query")
    @GetMapping(value = "/getFullInfo/{id}")
    public AjaxResult getFullInfo(@PathVariable("id") Long id) {
        RuleModel ruleModel = ruleService.selectFullRuleById(id);
        return AjaxResult.success(ruleModel);
    }

    /**
     * 新增规则
     */
    @NoRepeatSubmit
    @PreAuthorize(hasPermi = "rule:rule:add")
    @Log(title = "新增规则", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Rule rule) {

        Rule insertRule = ruleService.insert(rule);
        return AjaxResult.success(insertRule);
    }

    /**
     * 修改规则
     */
    @NoRepeatSubmit
    @PreAuthorize(hasPermi = "rule:rule:edit")
    @Log(title = "规则管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Rule rule) {
        return toAjax(ruleService.updateByPrimaryKeySelective(rule));
    }

    /**
     * 删除产品管理
     */
    @PreAuthorize(hasPermi = "rule:rule:remove")
    @Log(title = "规则删除", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public AjaxResult remove(@PathVariable Long id) {
        return toAjax(ruleService.deleteByPrimaryKey(id));
    }

    /**
     * 规则触发条件验证
     */
    @GetMapping(value = "/check-rule-conditions/{ruleIdentification}")
    public R<?> checkRuleConditions(@PathVariable("ruleIdentification") String ruleIdentification) {
        // 查询规则
        Rule rule = ruleService.selectByRuleIdentification(ruleIdentification);
        if (Objects.isNull(rule)) {
            return R.fail("规则不存在");
        }
        // 查询触发条件
        List<RuleConditions> ruleConditions = ruleConditionsService.selectByRuleId(rule.getId());
        // 存放比较结果
        List<Boolean> flags = new ArrayList<>();
        for (RuleConditions conditions : ruleConditions) {
            // 获取属性字段和类型，和设备上报的数据进行比对
            R<?> properties = remoteProductService.selectByIdProperties(conditions.getPropertiesId());
            ProductProperties propertiesData = (ProductProperties) properties.getData();
            if (propertiesData == null) {
                continue;
            }
            // 获取该产品下的所有设备数据
            Map<String, Map<String, Object>> maps = extractedDeviceData(conditions);
            // 属性名称
            String productPropertiesName = propertiesData.getPropertyName();
            // 属性类型
            String productPropertiesType = propertiesData.getDatatype();
            // 比较模式
            String comparisonMode = conditions.getComparisonMode();
            // 比较值
            String comparisonValue = conditions.getComparisonValue();
            //  条件类型(0:匹配设备触发、1:指定设备触发、2:按策略定时触发)
            switch (ConditionTypeEnum.getBySymbol(conditions.getConditionType())) {
                case MATCH:
                    R<?> deviceResponse = remoteDeviceService.selectByProductIdentification(conditions.getProductIdentification());
                    List<String> datas = (List<String>) deviceResponse.getData();
                    if (CollectionUtils.isEmpty(datas)) {
                        break;
                    }
                    datas.stream().forEach(s -> {
                        if (maps.containsKey(s)) {
                            Map<String, Object> stringObjectMap = maps.get(s);
                            if (stringObjectMap.containsKey(productPropertiesName)) {
                                // 获取属性实际的值
                                flags.add(compare(comparisonMode, productPropertiesType, stringObjectMap.get(productPropertiesName).toString(), comparisonValue));
                            }
                        }
                    });
                    break;
                case SPECIFY:
                    List<String> deviceDatas = Arrays.asList(conditions.getDeviceIdentification().split(","));
                    deviceDatas.stream().forEach(s -> {
                        if (maps.containsKey(s)) {
                            Map<String, Object> stringObjectMap = maps.get(s);
                            if (stringObjectMap.containsKey(productPropertiesName)) {
                                // 获取属性实际的值
                                flags.add(compare(comparisonMode, productPropertiesType, stringObjectMap.get(productPropertiesName).toString(), comparisonValue));
                            }
                        }
                    });
                    break;
                case STRATEGY:
                    break;
                default:
                    break;
            }
        }
        boolean mark = false;
        if (CollectionUtils.isEmpty(flags)) {
            // 验证条件
            return R.ok(mark);
        }
        switch (TriggeringEnum.getBySymbol(Integer.valueOf(rule.getTriggering()))) {
            case ALL:
                mark = flags.stream().allMatch(s -> s.equals(true));
                break;
            case ANY:
                mark = flags.stream().anyMatch(s -> s.equals(true));
                break;
            default:
                break;
        }
        return R.ok(mark);
    }

    /**
     * 获取设备上报数据
     *
     * @param conditions
     * @return
     */
    private Map<String, Map<String, Object>> extractedDeviceData(RuleConditions conditions) {
        Map<String, Map<String, Object>> maps = new HashMap<>();
        // 获取产品信息
        R productResponse = remoteProductService.selectByProductIdentification(conditions.getProductIdentification());
        Product product = (Product) productResponse.getData();
        if (product == null) {
            return maps;
        }
        // 获取服务信息
        R<?> productServicesResponse = remoteProductService.selectProductServicesById(conditions.getServiceId());
        ProductServices productServices = (ProductServices) productServicesResponse.getData();
        if (productServices == null) {
            return maps;
        }
        // 获取超级表名称 产品类型+产品标识+服务名称
        String superName = product.getProductType() + "_" + conditions.getProductIdentification() + "_" + productServices.getServiceName();

        // 查询最新的设备记录
        TagsSelectDTO tagsSelectDao = new TagsSelectDTO();
        tagsSelectDao.setDataBaseName("basiclabiot");
        tagsSelectDao.setStableName(superName);
        R<?> lastDataByTags = remoteTdEngineService.getLastDataByTags(tagsSelectDao);
        if (lastDataByTags != null && lastDataByTags.getData() != null) {
            maps = (Map<String, Map<String, Object>>) lastDataByTags.getData();
        }
        return maps;
    }


    /**
     * 实现计算
     *
     * @param symbol          运算符
     * @param propertiesType  属性类型
     * @param actualValue     实际值
     * @param comparisonValue 比较值
     * @return
     */
    private boolean compare(String symbol, String propertiesType, String actualValue, String comparisonValue) {
        boolean flag = false;
        FieldTypeEnum bySymbol = FieldTypeEnum.getBySymbol(propertiesType);
        // 判断比较类型
        switch (OperatorEnum.getBySymbol(symbol)) {
            case eq:
                // 判断属性值类型
                switch (bySymbol) {
                    case INT:
                        flag = Integer.parseInt(actualValue) == Integer.parseInt(comparisonValue);
                        break;
                    case STRING:
                        flag = actualValue.equals(comparisonValue);
                        break;
                    case DECIMAL:
                        flag = Double.parseDouble(actualValue) == Double.parseDouble(comparisonValue);
                        break;
                    case TIMESTAMP:
                        break;
                    case BOOL:
                        break;
                    default:
                        break;
                }
                break;
            case not:
                // 判断属性值类型
                switch (bySymbol) {
                    case INT:
                        flag = Integer.parseInt(actualValue) != Integer.parseInt(comparisonValue);
                        break;
                    case STRING:
                        flag = !actualValue.equals(comparisonValue);
                        break;
                    case DECIMAL:
                        flag = Double.parseDouble(actualValue) != Double.parseDouble(comparisonValue);
                        break;
                    case TIMESTAMP:
                        break;
                    case BOOL:
                        break;
                    default:
                        break;
                }
                break;
            case gt:
                // 判断属性值类型
                switch (bySymbol) {
                    case INT:
                        flag = Integer.parseInt(actualValue) > Integer.parseInt(comparisonValue);
                        break;
                    case DECIMAL:
                        flag = Double.parseDouble(actualValue) > Double.parseDouble(comparisonValue);
                        break;
                    case TIMESTAMP:
                        break;
                    case BOOL:
                        break;
                    default:
                        break;
                }
                break;
            case lt:
                // 判断属性值类型
                switch (bySymbol) {
                    case INT:
                        flag = Integer.parseInt(actualValue) < Integer.parseInt(comparisonValue);
                        break;
                    case DECIMAL:
                        flag = Double.parseDouble(actualValue) < Double.parseDouble(comparisonValue);
                        break;
                    case TIMESTAMP:
                        break;
                    case BOOL:
                        break;
                    default:
                        break;
                }
                break;
            case gte:
                // 判断属性值类型
                switch (bySymbol) {
                    case INT:
                        flag = Integer.parseInt(actualValue) >= Integer.parseInt(comparisonValue);
                        break;
                    case DECIMAL:
                        flag = Double.parseDouble(actualValue) >= Double.parseDouble(comparisonValue);
                        break;
                    case TIMESTAMP:
                        break;
                    case BOOL:
                        break;
                    default:
                        break;
                }
                break;
            case lte:
                // 判断属性值类型
                switch (bySymbol) {
                    case INT:
                        flag = Integer.parseInt(actualValue) <= Integer.parseInt(comparisonValue);
                        break;
                    case DECIMAL:
                        flag = Double.parseDouble(actualValue) <= Double.parseDouble(comparisonValue);
                        break;
                    case TIMESTAMP:
                        break;
                    case BOOL:
                        break;
                    default:
                        break;
                }
                break;
            case between:
                // 判断属性值类型
                switch (bySymbol) {
                    case INT:
                        int[] arrayint = Arrays.asList(comparisonValue.split(",")).stream().mapToInt(Integer::parseInt).toArray();
                        flag = CompareUtil.rangeInDefinedInt(Integer.parseInt(actualValue), arrayint[0], arrayint[1]);
                        break;
                    case DECIMAL:
                        double[] arrayDouble = Arrays.asList(comparisonValue.split(",")).stream().mapToDouble(Double::parseDouble).toArray();
                        flag = CompareUtil.rangeInDefinedDouble(Double.parseDouble(actualValue), arrayDouble[0], arrayDouble[1]);
                        break;
                    case TIMESTAMP:
                        break;
                    case BOOL:
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
        return flag;
    }

}
