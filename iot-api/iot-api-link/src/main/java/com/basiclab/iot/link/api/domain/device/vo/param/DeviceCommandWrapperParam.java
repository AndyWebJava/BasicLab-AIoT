package com.basiclab.iot.link.api.domain.device.vo.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * -----------------------------------------------------------------------------
 * File Name: DeviceCommandWrapperParam.java
 * -----------------------------------------------------------------------------
 * Description:
 * Device Command Request Wrapper Data Structure
 * -----------------------------------------------------------------------------
 *
 * @author BasicLab基础架构实验室
 * @version 1.0
 * -----------------------------------------------------------------------------
 * Revision History:
 * Date         Author          Version     Description
 * --------      --------     -------   --------------------
 * <p>
 * -----------------------------------------------------------------------------
 * @email andywebjava@163.com
 * @date 2023-11-11 14:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Builder
@ApiModel(value = "DeviceCommandWrapperParam", description = "Device Command Request Wrapper Data Structure")
public class DeviceCommandWrapperParam implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "List of serial command requests", notes = "List of serial command requests")
    private List<CommandIssueRequestParam> serial;

    @ApiModelProperty(value = "List of parallel command requests", notes = "List of parallel command requests")
    private List<CommandIssueRequestParam> parallel;
}
