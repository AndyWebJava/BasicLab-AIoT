package com.basiclab.iot.link.api.domain.device.vo.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @Description: 查询设备信息数据模型
 * @Author: BasiclabIoT
 * @E-mail: andywebjava@163.com
 * @Website: https://gitee.com/vegetable-chicken-blog/basiclab-iot
 * @CreateDate: 2022/4/25$ 12:52$
 * @UpdateUser: BasiclabIoT
 * @UpdateDate: 2024/01/10$ 12:52$
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
@ApiModel(value = "TopoQueryDeviceParam", description = "查询设备信息数据模型")
public class TopoQueryDeviceParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备标识集合", notes = "设备标识集合")
    @NotNull(message = "设备标识集合不能为空")
    private List<String> deviceIds;
}
