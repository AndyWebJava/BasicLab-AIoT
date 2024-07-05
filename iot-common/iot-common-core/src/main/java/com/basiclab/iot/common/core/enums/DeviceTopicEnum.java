package com.basiclab.iot.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program: basiclabiot
 * @description: 设备Topic枚举
 * @packagename: com.basiclab.iot.common.core.enums
 * @author: BasiclabIoT
 * @e-mainl: andywebjava@163.com
 * @date: 2022-08-26 10:49
 **/
@Getter
@AllArgsConstructor
public enum DeviceTopicEnum {
    /**
     * 基础Topic
     */
    BASIS("0","基础Topic"),

    /**
     * 自定义Topic
     */
    CUSTOM("1","自定义Topic");

    private  String key;
    private  String value;
}
