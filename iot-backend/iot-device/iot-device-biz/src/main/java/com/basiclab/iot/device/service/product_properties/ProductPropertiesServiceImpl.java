package com.basiclab.iot.device.service.product_properties;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import com.basiclab.iot.device.controller.admin.product_properties.vo.*;
import com.basiclab.iot.device.dal.dataobject.product_properties.ProductPropertiesDO;
import com.basiclab.iot.framework.common.pojo.PageResult;
import com.basiclab.iot.framework.common.util.object.BeanUtils;

import com.basiclab.iot.device.dal.mysql.product_properties.ProductPropertiesMapper;

import static com.basiclab.iot.device.enums.ErrorCodeConstants.PRODUCT_PROPERTIES_NOT_EXISTS;
import static com.basiclab.iot.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 产品模型属性 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ProductPropertiesServiceImpl implements ProductPropertiesService {

    @Resource
    private ProductPropertiesMapper propertiesMapper;

    @Override
    public Long createProperties(ProductPropertiesSaveReqVO createReqVO) {
        // 插入
        ProductPropertiesDO properties = BeanUtils.toBean(createReqVO, ProductPropertiesDO.class);
        propertiesMapper.insert(properties);
        // 返回
        return properties.getId();
    }

    @Override
    public void updateProperties(ProductPropertiesSaveReqVO updateReqVO) {
        // 校验存在
        validatePropertiesExists(updateReqVO.getId());
        // 更新
        ProductPropertiesDO updateObj = BeanUtils.toBean(updateReqVO, ProductPropertiesDO.class);
        propertiesMapper.updateById(updateObj);
    }

    @Override
    public void deleteProperties(Long id) {
        // 校验存在
        validatePropertiesExists(id);
        // 删除
        propertiesMapper.deleteById(id);
    }

    private void validatePropertiesExists(Long id) {
        if (propertiesMapper.selectById(id) == null) {
            throw exception(PRODUCT_PROPERTIES_NOT_EXISTS);
        }
    }

    @Override
    public ProductPropertiesDO getProperties(Long id) {
        return propertiesMapper.selectById(id);
    }

    @Override
    public PageResult<ProductPropertiesDO> getPropertiesPage(ProductPropertiesPageReqVO pageReqVO) {
        return propertiesMapper.selectPage(pageReqVO);
    }

}