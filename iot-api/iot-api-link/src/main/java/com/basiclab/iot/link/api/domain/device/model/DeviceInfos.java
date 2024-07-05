package com.basiclab.iot.link.api.domain.device.model;

import lombok.Data;

/**
 * @Description:  边设备添加子设备详情数据模型
 * @Author: BasiclabIoT
 * @E-mail: andywebjava@163.com
 * @Website: https://gitee.com/vegetable-chicken-blog/basiclab-iot
 * @CreateDate: 2022/4/25$ 12:54$
 * @UpdateUser: BasiclabIoT
 * @UpdateDate: 2022/4/25$ 12:54$
 * @UpdateRemark: 修改内容
 * @Version: V1.0
 */
@Data
public class DeviceInfos {
    private static final long serialVersionUID = 1L;
    private String nodeId;
    private String name;
    private String description;
    private String manufacturerId;
    private String model;
}
