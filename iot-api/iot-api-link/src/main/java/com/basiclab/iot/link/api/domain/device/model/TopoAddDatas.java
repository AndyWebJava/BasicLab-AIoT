package com.basiclab.iot.link.api.domain.device.model;

import lombok.Data;

import java.util.List;

/**
 * @Description: 边设备添加子设备数据模型
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
public class TopoAddDatas {
    private static final long serialVersionUID = 1L;
    private Integer mid;
    private List<DeviceInfos> deviceInfos;
}
