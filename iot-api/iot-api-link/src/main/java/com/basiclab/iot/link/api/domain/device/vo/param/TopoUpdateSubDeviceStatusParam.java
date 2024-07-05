package com.basiclab.iot.link.api.domain.device.vo.param;

import com.basiclab.iot.common.core.enums.DeviceConnectStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * @Description: 网关设备更新子设备状态数据模型
 * @Author: BasiclabIoT
 * @E-mail: andywebjava@163.com
 * @Website: https://gitee.com/vegetable-chicken-blog/basiclab-iot
 * @CreateDate: 2022/4/25$ 12:52$
 * @UpdateUser: BasiclabIoT
 * @UpdateDate: 2022/4/25$ 12:52$
 * @UpdateRemark: 修改内容
 * @Version: V1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Accessors(chain = true)
@EqualsAndHashCode
@Builder
@ApiModel(value = "TopoUpdateSubDeviceStatusParam", description = "子设备状态更新数据模型")
public class TopoUpdateSubDeviceStatusParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "网关设备标识", notes = "网关设备自身的唯一标识")
    @NotEmpty(message = "网关设备标识不能为空")
    private String gatewayIdentification;

    @ApiModelProperty(value = "子设备状态列表", notes = "子设备状态列表，列表大小 1~100")
    @NotNull(message = "子设备状态列表不能为空")
    @Size(min = 1, max = 100, message = "子设备状态列表大小必须在1到100之间")
    private List<DeviceStatus> deviceStatuses;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Accessors(chain = true)
    @ApiModel(value = "DeviceStatus", description = "子设备状态数据模型")
    public static class DeviceStatus implements Serializable {
        private static final long serialVersionUID = 1L;

        @ApiModelProperty(value = "子设备唯一标识", notes = "平台生成的子设备唯一标识")
        @NotEmpty(message = "子设备唯一标识不能为空")
        private String deviceId;

        @ApiModelProperty(value = "子设备状态", notes = "子设备状态：OFFLINE：设备离线；ONLINE：设备上线；")
        @NotNull(message = "子设备状态不能为空")
        private DeviceConnectStatusEnum status;
    }
}
