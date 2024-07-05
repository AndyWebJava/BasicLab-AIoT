/**
  * Copyright 2021 json.cn
  */
package com.basiclab.iot.link.api.domain.product.model;
import lombok.Data;

import java.util.List;

/**
 * 产品模型对象 ProductModel
 *
 * @author BasicLab基础架构实验室
 * @date 2021-12-23
 */
@Data
@Deprecated
public class ProductModel {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String productName;
    private String productType;
    private String manufacturerId;
    private String manufacturerName;
    private String model;
    private String dataFormat;
    private String deviceType;
    private String protocolType;
    private String remark;
    private List<Services> services;
    private String appId;
    private String status;
}
