package com.basiclab.iot.device.service.product_properties;

import javax.validation.*;
import com.basiclab.iot.device.controller.admin.product_properties.vo.*;
import com.basiclab.iot.device.dal.dataobject.product_properties.ProductPropertiesDO;
import com.basiclab.iot.framework.common.pojo.PageResult;

/**
 * 产品模型属性 Service 接口
 *
 * @author 芋道源码
 */
public interface ProductPropertiesService {

    /**
     * 创建产品模型属性
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createProperties(@Valid ProductPropertiesSaveReqVO createReqVO);

    /**
     * 更新产品模型属性
     *
     * @param updateReqVO 更新信息
     */
    void updateProperties(@Valid ProductPropertiesSaveReqVO updateReqVO);

    /**
     * 删除产品模型属性
     *
     * @param id 编号
     */
    void deleteProperties(Long id);

    /**
     * 获得产品模型属性
     *
     * @param id 编号
     * @return 产品模型属性
     */
    ProductPropertiesDO getProperties(Long id);

    /**
     * 获得产品模型属性分页
     *
     * @param pageReqVO 分页查询
     * @return 产品模型属性分页
     */
    PageResult<ProductPropertiesDO> getPropertiesPage(ProductPropertiesPageReqVO pageReqVO);

}