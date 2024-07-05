package com.basiclab.iot.link.service.device.impl;

import com.basiclab.iot.common.core.domain.R;
import com.basiclab.iot.common.core.utils.DateUtils;
import com.basiclab.iot.common.core.utils.bean.BeanPlusUtil;
import com.basiclab.iot.link.api.domain.cache.device.DeviceCacheVO;
import com.basiclab.iot.link.api.domain.cache.product.ProductCacheVO;
import com.basiclab.iot.link.api.domain.cache.product.ProductModelCacheVO;
import com.basiclab.iot.link.api.domain.device.vo.query.DeviceShadowPageQuery;
import com.basiclab.iot.link.api.domain.product.enumeration.ProductTypeEnum;
import com.basiclab.iot.link.api.domain.product.vo.result.ProductPropertyResultVO;
import com.basiclab.iot.link.api.domain.product.vo.result.ProductResultVO;
import com.basiclab.iot.link.api.domain.product.vo.result.ProductServiceResultVO;
import com.basiclab.iot.link.common.cache.helper.CacheDataHelper;
import com.basiclab.iot.link.service.device.DeviceShadowService;
import com.basiclab.iot.tdengine.api.RemoteTdEngineService;
import com.basiclab.iot.tdengine.api.constant.TdsConstants;
import com.basiclab.iot.tdengine.api.utils.TdsUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * -----------------------------------------------------------------------------
 * 文件名称: DeviceShadowServiceImpl.java
 * -----------------------------------------------------------------------------
 * 描述:
 * 设备影子业务层接口实现
 * -----------------------------------------------------------------------------
 *
 * @author BasicLab基础架构实验室
 * @version 1.0
 * -----------------------------------------------------------------------------
 * 修改历史:
 * 日期           作者          版本        描述
 * --------      --------     -------   --------------------
 * <p>
 * -----------------------------------------------------------------------------
 * @email andywebjava@163.com
 * @date 2023-10-12 19:49
 */
@Slf4j
@RequiredArgsConstructor
@Service
@Transactional(rollbackFor = Exception.class)
public class DeviceShadowServiceImpl implements DeviceShadowService {

    private final CacheDataHelper cacheDataHelper;

    @Resource
    private final RemoteTdEngineService tdsApi;


    /**
     * 查询设备影子信息
     *
     * @param deviceShadowPageQuery 查询参数
     * @return {@link ProductResultVO} 设备影子信息
     */
    @Override
    public ProductResultVO queryDeviceShadow(DeviceShadowPageQuery deviceShadowPageQuery) {
        return Optional.ofNullable(cacheDataHelper.getDeviceCacheVO(deviceShadowPageQuery.getDeviceIdentification()))
                .map(DeviceCacheVO::getProductCacheVO)
                .flatMap(productCacheVO -> buildProductResultVO(deviceShadowPageQuery, productCacheVO))
                .orElse(new ProductResultVO());
    }

    private Optional<ProductResultVO> buildProductResultVO(DeviceShadowPageQuery deviceShadowPageQuery, ProductCacheVO productCacheVO) {
        return Optional.ofNullable(cacheDataHelper.getProductModelCacheVO(productCacheVO.getProductIdentification()))
                .map(productModelCacheVO -> {
                    List<ProductServiceResultVO> serviceResultVOs = buildServiceResults(deviceShadowPageQuery, productCacheVO, productModelCacheVO);
                    ProductResultVO result = BeanPlusUtil.toBeanIgnoreError(productModelCacheVO, ProductResultVO.class);
                    result.setServices(serviceResultVOs);
                    return result;
                });
    }

    private List<ProductServiceResultVO> buildServiceResults(DeviceShadowPageQuery deviceShadowPageQuery, ProductCacheVO productCacheVO, ProductModelCacheVO productModelCacheVO) {
        return productModelCacheVO.getServices().stream()
                .map(service -> buildServiceResultVO(deviceShadowPageQuery, productCacheVO, BeanPlusUtil.toBeanIgnoreError(service, ProductServiceResultVO.class)))
                .collect(Collectors.toList());
    }

    private ProductServiceResultVO buildServiceResultVO(DeviceShadowPageQuery deviceShadowPageQuery, ProductCacheVO productCacheVO, ProductServiceResultVO service) {
        String stableName = TdsUtils.superTableName(ProductTypeEnum.valueOf(productCacheVO.getProductType()).getDesc(), productCacheVO.getProductIdentification(), service.getServiceCode());
        List<Map<String, Object>> dataList = fetchLastData(stableName, deviceShadowPageQuery);

        ProductServiceResultVO serviceResultVO = BeanPlusUtil.toBeanIgnoreError(service, ProductServiceResultVO.class);
        serviceResultVO.setProperties(buildPropertyResults(service, dataList));
        serviceResultVO.setEchoList(dataList);
        return serviceResultVO;
    }

    private List<Map<String, Object>> fetchLastData(String stableName, DeviceShadowPageQuery deviceShadowPageQuery) {
        return Optional.ofNullable(tdsApi.getDataInRangeOrLastRecord(stableName, deviceShadowPageQuery.getStartTime(), deviceShadowPageQuery.getEndTime()))
                .filter(r -> r.getCode() == 200)
                .map(R::getData)
                .orElse(Collections.emptyList());
    }

    private List<ProductPropertyResultVO> buildPropertyResults(ProductServiceResultVO productServiceResultVO, List<Map<String, Object>> dataList) {
        List<Map<String, Object>> firstDataList = Optional.ofNullable(dataList)
                .flatMap(list -> list.stream().findFirst())
                .map(Collections::singletonList)
                .orElse(Collections.singletonList(Collections.emptyMap()));

        return productServiceResultVO.getProperties().stream()
                .flatMap(property -> firstDataList.stream()
                        .map(data -> {
                            ProductPropertyResultVO resultVO = buildPropertyResultVO(property, data);
                            resultVO.setEchoMap(data);
                            return resultVO;
                        }))
                .collect(Collectors.toList());
    }

    private ProductPropertyResultVO buildPropertyResultVO(ProductPropertyResultVO propertyResultVO, Map<String, Object> data) {
        Optional.ofNullable(data.get(TdsConstants.TS))
                .map(ts -> {
                    try {
                        return DateUtils.date2LocalDateTime(DateUtils.parseDatetime(ts.toString()));
                    } catch (ParseException e) {
                        log.error("时间转换异常: {}", e.getMessage());
                        return null;
                    }
                })
                .ifPresent(propertyResultVO::setCreateTime);
        propertyResultVO.setPropertyValue(data.get(propertyResultVO.getPropertyCode()));
        return propertyResultVO;
    }


}
