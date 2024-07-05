package com.basiclab.iot.link.api.domain.product.vo.result;

import cn.hutool.core.map.MapUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Map;

/**
 * <p>
 * 表单查询方法返回值VO
 * 产品模型设备响应服务命令属性表
 * </p>
 *
 * @author mqttsnet
 * @date 2023-03-14 19:39:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "ProductCommandResponseResultVO", description = "产品模型设备响应服务命令属性表")
public class ProductCommandResponseResultVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<String, Object> echoMap = MapUtil.newHashMap();

    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 命令ID
     */
    @ApiModelProperty(value = "命令ID")
    private Long commandId;
    /**
     * 服务ID
     */
    @ApiModelProperty(value = "服务ID")
    private Long serviceId;
    /**
     * 指示数据类型。取值范围：string、int、decimal
     */
    @ApiModelProperty(value = "指示数据类型。取值范围：string、int、decimal")
    private String datatype;
    /**
     * 指示枚举值。如开关状态status可有如下取值enumList : [OPEN,CLOSE]目前本字段是非功能性字段，仅起到描述作用。建议准确定义。
     */
    @ApiModelProperty(value = "指示枚举值。如开关状态status可有如下取值enumList : [OPEN,CLOSE]目前本字段是非功能性字段，仅起到描述作用。建议准确定义。")
    private String enumlist;
    /**
     * 指示最大值。仅当dataType为int、decimal时生效，逻辑小于等于。
     */
    @ApiModelProperty(value = "指示最大值。仅当dataType为int、decimal时生效，逻辑小于等于。")
    private String max;
    /**
     * 指示字符串长度。仅当dataType为string时生效。
     */
    @ApiModelProperty(value = "指示字符串长度。仅当dataType为string时生效。")
    private String maxlength;
    /**
     * 指示最小值。仅当dataType为int、decimal时生效，逻辑大于等于。
     */
    @ApiModelProperty(value = "指示最小值。仅当dataType为int、decimal时生效，逻辑大于等于。")
    private String min;
    /**
     * 命令中参数的描述，不影响实际功能，可配置为空字符串。
     */
    @ApiModelProperty(value = "命令中参数的描述，不影响实际功能，可配置为空字符串。")
    private String parameterDescription;
    /**
     * 参数编码
     */
    @ApiModelProperty(value = "参数编码")
    private String parameterCode;
    /**
     * 命令中参数的名字。
     */
    @ApiModelProperty(value = "命令中参数的名字。")
    private String parameterName;
    /**
     * 指示本条属性是否必填，取值为0或1，默认取值1（必填）。目前本字段是非功能性字段，仅起到描述作用。
     */
    @ApiModelProperty(value = "指示本条属性是否必填，取值为0或1，默认取值1（必填）。目前本字段是非功能性字段，仅起到描述作用。")
    private String required;
    /**
     * 指示步长。
     */
    @ApiModelProperty(value = "指示步长。")
    private String step;
    /**
     * 指示单位。取值根据参数确定，如：•温度单位：“C”或“K”•百分比单位：“%”•压强单位：“Pa”或“kPa”
     */
    @ApiModelProperty(value = "指示单位。取值根据参数确定，如：•温度单位：“C”或“K”•百分比单位：“%”•压强单位：“Pa”或“kPa”")
    private String unit;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;
    /**
     * 创建人组织
     */
    @ApiModelProperty(value = "创建人组织")
    private Long createdOrgId;


}
