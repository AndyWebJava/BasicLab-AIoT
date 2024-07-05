package com.basiclab.iot.link.api;

import com.basiclab.iot.common.core.constant.ServiceNameConstants;
import com.basiclab.iot.common.core.domain.R;
import com.basiclab.iot.link.api.domain.product.entity.Product;
import com.basiclab.iot.link.api.domain.product.entity.ProductProperties;
import com.basiclab.iot.link.api.domain.product.entity.ProductServices;
import com.basiclab.iot.link.api.factory.RemoteProductFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: basiclabiot
 * @description: 产品管理服务
 * @packagename: com.basiclab.basiclabiot.link.api
 * @author: shisen
 * @date: 2022-07-26
 **/
@FeignClient(contextId = "remoteProductService", value = ServiceNameConstants.basiclabiot_LINK, fallbackFactory = RemoteProductFallbackFactory.class)
public interface RemoteProductService {

    /**
     * 通过标识查询产品
     *
     * @param productIdentification
     * @return
     */
    @GetMapping("/product/selectByProductIdentification/{productIdentification}")
    public R<Product> selectByProductIdentification(@PathVariable("productIdentification") String productIdentification);

    /**
     * 查询服务信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/productServices/selectProductServicesById/{id}")
    public R<ProductServices> selectProductServicesById(@PathVariable("id") Long id);


    /**
     * 查询属性信息
     *
     * @return
     */
    @GetMapping("/productProperties/selectByIdProperties/{id}")
    public R<ProductProperties> selectByIdProperties(@PathVariable("id") Long id);

    @GetMapping("/product/selectAllProduct/{status}")
    public R<List<Product>> selectAllProduct(@PathVariable("status") String status);

    @PostMapping("/product/selectProductByProductIdentificationList")
    public R<?> selectProductByProductIdentificationList(@RequestBody List<String> productIdentificationList);

}
