package com.basiclab.iot.broker.api.domain.entity;


import com.basiclab.iot.broker.api.domain.enumeration.MqttEventEnum;

/**
 * @program: iot-cloud-pro-datasource-column
 * @description: MQTT协议事件类
 * @packagename: com.basiclab.iot.mqtt.entity
 * @author: BasiclabIoT
 * @e-mainl: andywebjava@163.com
 * @date: 2023-04-28 00:10
 **/
public class MqttProtocolEvent {
    private final MqttEventEnum eventEnum;
    private final String message;

    public MqttProtocolEvent(MqttEventEnum eventEnum, String message) {
        this.eventEnum = eventEnum;
        this.message = message;
    }

    public MqttEventEnum getEventEnum() {
        return eventEnum;
    }

    public String getMessage() {
        return message;
    }
}
