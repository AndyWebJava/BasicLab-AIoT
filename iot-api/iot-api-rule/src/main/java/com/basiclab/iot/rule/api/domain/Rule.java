package com.basiclab.iot.rule.api.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @program: basiclabiot
 * @description: ${description}
 * @packagename: com.basiclab.iot.rule.api.domain
 * @author: BasiclabIoT
 * @e-mainl: andywebjava@163.com
 * @date: 2022-11-18 20:39
 **/

/**
 * 规则信息表
 */
@ApiModel(value = "规则信息表")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rule implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 应用ID
     */
    @ApiModelProperty(value = "应用ID")
    private String appId;

    /**
     * 规则标识
     */
    @ApiModelProperty(value = "规则标识")
    private String ruleIdentification;

    /**
     * 规则名称
     */
    @ApiModelProperty(value = "规则名称")
    private String ruleName;

    /**
     * 任务标识
     */
    @ApiModelProperty(value = "任务标识")
    private String jobIdentification;

    /**
     * 状态(字典值：0启用  1停用)
     */
    @ApiModelProperty(value = "状态(字典值：0启用  1停用)")
    private String status;

    /**
     * 触发机制（0:全部，1:任意一个）
     */
    @ApiModelProperty(value = "触发机制（0:全部，1:任意一个）")
    private Short triggering;

    /**
     * 规则描述，可以为空
     */
    @ApiModelProperty(value = "规则描述，可以为空")
    private String remark;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String createBy;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    @ApiModelProperty(value = "更新人")
    private String updateBy;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}