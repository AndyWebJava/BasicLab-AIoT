package com.basiclab.iot.tdengine.api.domain.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @program: basiclabiot
 * @description: 标签查询模型
 * @packagename: com.basiclab.basiclabiot.tdengine.api.domain.rule
 * @author: BasiclabIoT
 * @e-mainl: andywebjava@163.com
 * @date: 2022-07-27 18:40
 **/
@Data
public class TagsSelectDTO {

    private String dataBaseName;

    @NotBlank(message = "invalid operation: stableName can not be empty")
    private String stableName;

    @NotBlank(message = "invalid operation: tagsName can not be empty")
    private String tagsName;

    private Long startTime;

    private Long endTime;

}
