package com.basiclab.iot.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description: 产品协议类型
 * @Author: BasiclabIoT
 * @E-mail: andywebjava@163.com
 * @CreateDate: 2021/10/25$ 15:57$
 * @UpdateUser: BasiclabIoT
 * @UpdateDate: 2021/10/25$ 15:57$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Getter
@AllArgsConstructor
public enum ProtocolType {

    /**
     * MQTT协议
     */
    MQTT("MQTT","MQTT"),


    /**
     * COAP协议
     */
    COAP("COAP","COAP"),

    /**
     * MODBUS协议
     */
    MODBUS("MODBUS","MODBUS"),

    /**
     * HTTP协议
     */
    HTTP("HTTP","HTTP");

    private  String key;
    private  String value;
}
