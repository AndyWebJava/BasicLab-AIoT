package com.basiclab.iot.rule.service.impl;

import com.basiclab.iot.common.core.domain.R;
import com.basiclab.iot.common.core.exception.ServiceException;
import com.basiclab.iot.common.core.text.UUID;
import com.basiclab.iot.common.core.utils.StringUtils;
import com.basiclab.iot.common.core.utils.bean.BeanUtils;
import com.basiclab.iot.common.security.service.TokenService;
import com.basiclab.iot.link.api.RemoteDeviceService;
import com.basiclab.iot.link.api.RemoteProductPropertiesService;
import com.basiclab.iot.link.api.RemoteProductService;
import com.basiclab.iot.link.api.RemoteProductServicesService;
import com.basiclab.iot.link.api.domain.device.entity.Device;
import com.basiclab.iot.link.api.domain.product.entity.Product;
import com.basiclab.iot.link.api.domain.product.entity.ProductProperties;
import com.basiclab.iot.link.api.domain.product.entity.ProductServices;
import com.basiclab.iot.rule.api.domain.ActionCommands;
import com.basiclab.iot.rule.api.domain.Rule;
import com.basiclab.iot.rule.api.domain.RuleConditions;
import com.basiclab.iot.rule.api.domain.model.RuleConditionsModel;
import com.basiclab.iot.rule.api.domain.model.RuleModel;
import com.basiclab.iot.rule.mapper.RuleMapper;
import com.basiclab.iot.rule.service.ActionCommandsService;
import com.basiclab.iot.rule.service.RuleConditionsService;
import com.basiclab.iot.rule.service.RuleService;
import com.basiclab.iot.system.api.domain.SysUser;
import com.basiclab.iot.system.api.model.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: basiclabiot
 * @description: ${description}
 * @packagename: com.basiclab.iot.rule.service.impl
 * @author: BasiclabIoT
 * @e-mainl: andywebjava@163.com
 * @date: 2022-07-21 18:47
 **/
@Slf4j
@Service
public class RuleServiceImpl implements RuleService {

    @Resource
    private TokenService tokenService;
    @Resource
    private RuleMapper ruleMapper;
    @Resource
    private RuleConditionsService ruleConditionsService;


    @Resource
    private ActionCommandsService actionCommandsService;


    @Override
    public int deleteByPrimaryKey(Long id) {

        //删除关联条件
        return ruleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Rule selectByRuleIdentification(String ruleIdentification) {
        return ruleMapper.selectByRuleIdentification(ruleIdentification);
    }

    @Override
    public Rule insert(Rule record) {
        //判断name重复
        Rule ruleQuery = new Rule();
        ruleQuery.setRuleName(record.getRuleName());
        List<Rule> ruleList = ruleMapper.selectRuleList(ruleQuery);
        if (!ruleList.isEmpty()) {
            throw new ServiceException("规则名称重复");
        }
        record.setRuleIdentification(UUID.getUUID());

        record.setCreateBy(getSysUserName());
        int res = ruleMapper.insert(record);
        if(res > 0){
            return record;
        }
        throw new ServiceException("添加规则失败");
    }

    @Override
    public int insertOrUpdate(Rule record) {
        return ruleMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(Rule record) {
        return ruleMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(Rule record) {
        return ruleMapper.insertSelective(record);
    }

    @Override
    public Rule selectByPrimaryKey(Long id) {
        return ruleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Rule record) {
        //job-todo
        record.setJobIdentification(UUID.getUUID());
        record.setUpdateBy(getSysUserName());
        return ruleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Rule record) {
        return ruleMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Rule> list) {
        return ruleMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<Rule> list) {
        return ruleMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<Rule> list) {
        return ruleMapper.batchInsert(list);
    }
    @Override
    public List<Rule> selectRuleList(Rule rule){
        return ruleMapper.selectRuleList(rule);
    }

    @Override
    public RuleModel selectFullRuleById(Long id){
        Rule rule = ruleMapper.selectByPrimaryKey(id);
        if(null == rule){
            throw new ServiceException("rule not exist");
        }
        RuleModel  ruleModel = new RuleModel();
        BeanUtils.copyProperties(rule,ruleModel);

        List<RuleConditions> ruleConditionsList = ruleConditionsService.selectByRuleId(id);
        log.info("List<RuleConditions>:{}",ruleConditionsList.toString());

        ruleModel.setRuleConditionsModelList(ruleConditionsService.ruleConditionsListToRuleConditionsModelList(ruleConditionsList));
        ActionCommands actionCommands = new ActionCommands();
        actionCommands.setRuleIdentification(rule.getRuleIdentification());
        log.info("RuleIdentification:{}",rule.getRuleIdentification());
        List<ActionCommands> actionCommandsList = actionCommandsService.selectByActionCommandsSelective(actionCommands);
        ruleModel.setActionCommandsModelList(actionCommandsService.actionCommandsToActionCommandsModelList(actionCommandsList));
        return ruleModel;
    }


    private String getSysUserName(){
        LoginUser loginUser = tokenService.getLoginUser();
        SysUser sysUser = loginUser.getSysUser();
        return sysUser.getUserName();
    }
}


