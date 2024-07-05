package com.basiclab.iot.broker.mqs.mqtt.event.listener;

import com.basiclab.iot.broker.mqs.mqtt.event.MqttPingEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @program: basiclabiot
 * @description: MQTT PING事件监听器
 * @packagename: com.basiclab.iot.mqtt.listener
 * @author: BasiclabIoT
 * @e-mainl: andywebjava@163.com
 * @date: 2023-04-28 00:48
 **/
@Component
@Slf4j
public class MqttPingEventListener {

    /**
     * 发布MQTT PING事件
     *
     * @param event 事件消息
     */
    @EventListener
    @Async("brokerAsync-mqttMsg")
    public void publishMqttPingEvent(MqttPingEvent event) {
        log.info("Publishing MQTT PING event: message={}", event.getMessage());
        // TODO: 处理MQTT PING事件
    }
}
