package com.basiclab.iot.device.dal.mysql.product_type;

import com.basiclab.iot.framework.common.pojo.PageResult;
import com.basiclab.iot.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.basiclab.iot.framework.mybatis.core.mapper.BaseMapperX;
import com.basiclab.iot.device.dal.dataobject.product_type.ProductTypeDO;
import org.apache.ibatis.annotations.Mapper;
import com.basiclab.iot.device.controller.admin.product_type.vo.*;

/**
 * 产品分类 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ProductTypeMapper extends BaseMapperX<ProductTypeDO> {

    default PageResult<ProductTypeDO> selectPage(ProductTypePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ProductTypeDO>()
                .likeIfPresent(ProductTypeDO::getName, reqVO.getName())
                .eqIfPresent(ProductTypeDO::getSort, reqVO.getSort())
                .eqIfPresent(ProductTypeDO::getParentId, reqVO.getParentId())
                .eqIfPresent(ProductTypeDO::getCreateBy, reqVO.getCreateBy())
                .betweenIfPresent(ProductTypeDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ProductTypeDO::getUpdateBy, reqVO.getUpdateBy())
                .orderByDesc(ProductTypeDO::getId));
    }

}