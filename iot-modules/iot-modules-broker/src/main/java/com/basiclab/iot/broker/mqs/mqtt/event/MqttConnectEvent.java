package com.basiclab.iot.broker.mqs.mqtt.event;

import com.basiclab.iot.broker.api.domain.enumeration.MqttEventEnum;
import org.springframework.context.ApplicationEvent;

/**
 * @program: basiclabiot
 * @description:
 * @packagename: com.basiclab.basiclabiot.mqtt.event
 * @author: BasiclabIoT
 * @e-mainl: andywebjava@163.com
 * @date: 2023-04-28 01:15
 **/
public class MqttConnectEvent extends ApplicationEvent {
    private String message;
    private MqttEventEnum eventType;

    public MqttConnectEvent(Object source, MqttEventEnum eventType, String message) {
        super(source);
        this.message = message;
        this.eventType = eventType;
    }

    public String getMessage() {
        return message;
    }

    public MqttEventEnum getEventType() {
        return eventType;
    }
}