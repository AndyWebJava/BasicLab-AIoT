package com.basiclab.iot.tdengine.api.domain;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @ClassDescription: 创建超级表需要的入参的实体类
 * @ClassName: SuperTableDto
 * @Author: basiclabiot
 * @Date: 2021-12-28 15:03:45
 * @Version 1.0
 */
@Data
public class SuperTableDto extends BaseEntity {

    /**
     * 超级表的表结构（业务相关）
     * 第一个字段的数据类型必须为timestamp
     * 字符相关数据类型必须指定大小
     * 字段名称和字段数据类型不能为空
     */
    @NotEmpty(message = "invalid operation: schemaFields can not be empty")
    private List<Fields> schemaFields;

    /**
     * 超级表的标签字段，可以作为子表在超级表里的标识
     * 字符相关数据类型必须指定大小
     * 字段名称和字段数据类型不能为空
     */
    @NotEmpty(message = "invalid operation: tagsFields can not be empty")
    private List<Fields> tagsFields;

    /**
     * 字段信息对象，超级表添加列时使用该属性
     */
    private Fields fields;
}
