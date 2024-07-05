package com.basiclab.iot.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Description: 设备类型
 * @Author: BasiclabIoT
 * @E-mail: andywebjava@163.com
 * @CreateDate: 2021/10/25$ 16:19$
 * @UpdateUser: BasiclabIoT
 * @UpdateDate: 2021/10/25$ 16:19$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Getter
@AllArgsConstructor
public enum DeviceType {

    /**
     * 普通设备（无子设备也无父设备）
     */
    COMMON("COMMON", "COMMON"),

    /**
     * 网关设备(可挂载子设备)
     */
    GATEWAY("GATEWAY", "GATEWAY"),

    /**
     * 子设备(归属于某个网关设备)
     */
    SUBSET("SUBSET", "SUBSET");

    private String key;
    private String value;
}
