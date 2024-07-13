package com.basiclab.iot.device.dal.mysql.product_properties;

import com.basiclab.iot.framework.common.pojo.PageResult;
import com.basiclab.iot.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.basiclab.iot.framework.mybatis.core.mapper.BaseMapperX;
import com.basiclab.iot.device.dal.dataobject.product_properties.ProductPropertiesDO;
import org.apache.ibatis.annotations.Mapper;
import com.basiclab.iot.device.controller.admin.product_properties.vo.*;

/**
 * 产品模型属性 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ProductPropertiesMapper extends BaseMapperX<ProductPropertiesDO> {

    default PageResult<ProductPropertiesDO> selectPage(ProductPropertiesPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ProductPropertiesDO>()
                .likeIfPresent(ProductPropertiesDO::getPropertyName, reqVO.getPropertyName())
                .eqIfPresent(ProductPropertiesDO::getPropertyCode, reqVO.getPropertyCode())
                .eqIfPresent(ProductPropertiesDO::getDatatype, reqVO.getDatatype())
                .eqIfPresent(ProductPropertiesDO::getDescription, reqVO.getDescription())
                .eqIfPresent(ProductPropertiesDO::getEnumlist, reqVO.getEnumlist())
                .eqIfPresent(ProductPropertiesDO::getMax, reqVO.getMax())
                .eqIfPresent(ProductPropertiesDO::getMaxlength, reqVO.getMaxlength())
                .eqIfPresent(ProductPropertiesDO::getMethod, reqVO.getMethod())
                .eqIfPresent(ProductPropertiesDO::getMin, reqVO.getMin())
                .eqIfPresent(ProductPropertiesDO::getRequired, reqVO.getRequired())
                .eqIfPresent(ProductPropertiesDO::getStep, reqVO.getStep())
                .eqIfPresent(ProductPropertiesDO::getUnit, reqVO.getUnit())
                .eqIfPresent(ProductPropertiesDO::getCreateBy, reqVO.getCreateBy())
                .betweenIfPresent(ProductPropertiesDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ProductPropertiesDO::getUpdateBy, reqVO.getUpdateBy())
                .eqIfPresent(ProductPropertiesDO::getTemplateCode, reqVO.getTemplateCode())
                .eqIfPresent(ProductPropertiesDO::getPid, reqVO.getPid())
                .orderByDesc(ProductPropertiesDO::getId));
    }

}