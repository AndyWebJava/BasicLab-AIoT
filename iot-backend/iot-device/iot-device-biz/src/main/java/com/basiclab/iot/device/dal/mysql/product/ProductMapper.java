package com.basiclab.iot.device.dal.mysql.product;

import com.basiclab.iot.framework.common.pojo.PageResult;
import com.basiclab.iot.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.basiclab.iot.framework.mybatis.core.mapper.BaseMapperX;
import com.basiclab.iot.device.dal.dataobject.product.ProductDO;
import com.basiclab.iot.device.controller.admin.product.vo.*;
import org.apache.ibatis.annotations.Mapper;

/**
 * 产品 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ProductMapper extends BaseMapperX<ProductDO> {

    default PageResult<ProductDO> selectPage(ProductPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ProductDO>()
                .eqIfPresent(ProductDO::getTemplateCode, reqVO.getTemplateCode())
                .likeIfPresent(ProductDO::getName, reqVO.getName())
                .eqIfPresent(ProductDO::getPid, reqVO.getPid())
                .likeIfPresent(ProductDO::getManufacturerName, reqVO.getManufacturerName())
                .eqIfPresent(ProductDO::getModel, reqVO.getModel())
                .eqIfPresent(ProductDO::getDataFormat, reqVO.getDataFormat())
                .eqIfPresent(ProductDO::getProtocolType, reqVO.getProtocolType())
                .eqIfPresent(ProductDO::getEnabledStatus, reqVO.getEnabledStatus())
                .eqIfPresent(ProductDO::getRemark, reqVO.getRemark())
                .eqIfPresent(ProductDO::getCreateBy, reqVO.getCreateBy())
                .betweenIfPresent(ProductDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ProductDO::getUpdateBy, reqVO.getUpdateBy())
                .eqIfPresent(ProductDO::getAuthMode, reqVO.getAuthMode())
                .likeIfPresent(ProductDO::getUserName, reqVO.getUserName())
                .eqIfPresent(ProductDO::getPassword, reqVO.getPassword())
                .eqIfPresent(ProductDO::getConnector, reqVO.getConnector())
                .eqIfPresent(ProductDO::getSignKey, reqVO.getSignKey())
                .eqIfPresent(ProductDO::getEncryptMethod, reqVO.getEncryptMethod())
                .eqIfPresent(ProductDO::getEncryptKey, reqVO.getEncryptKey())
                .eqIfPresent(ProductDO::getEncryptVector, reqVO.getEncryptVector())
                .eqIfPresent(ProductDO::getProductTypeId, reqVO.getProductTypeId())
                .likeIfPresent(ProductDO::getProductTypeName, reqVO.getProductTypeName())
                .eqIfPresent(ProductDO::getManufacturerCode, reqVO.getManufacturerCode())
                .orderByDesc(ProductDO::getId));
    }

}