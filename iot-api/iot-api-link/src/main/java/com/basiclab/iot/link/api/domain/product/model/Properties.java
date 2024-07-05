/**
  * Copyright 2021 json.cn
  */
package com.basiclab.iot.link.api.domain.product.model;

import lombok.Data;

/**
 * 产品模型服务属性详情对象 Properties
 *
 * @author BasicLab基础架构实验室
 * @date 2021-12-23
 */
@Data
public class Properties{
    private static final long serialVersionUID = 1L;
    private Long id;
    private String datatype;
    private String description;
    private String enumlist;
    private Integer max;
    private Integer maxlength;
    private String method;
    private Integer min;
    private String propertyCode;
    private String propertyName;
    private Integer required;
    private Integer step;
    private String unit;
}
