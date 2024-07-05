package com.basiclab.iot.broker.mqs.mqtt.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @program: basiclabiot
 * @description: 其他默认Topic处理器
 * @packagename: com.basiclab.basiclabiot.mqtt.handler
 * @author: BasiclabIoT
 * @e-mainl: andywebjava@163.com
 * @date: 2023-05-05 22:55
 **/
@Service
@Slf4j
public class DefaultHandler implements TopicHandler {

    /**
     * @param topic the MQTT topic the message was received on.
     * @param qos the quality of service level of the message.
     * @param body the payload of the message.
     */
    @Override
    public void handle(String topic, String qos, String body) {
        // 处理默认情况的逻辑
        log.info("处理默认情况的逻辑,topic:{},qos:{},body:{}", topic, qos, body);
    }
}
