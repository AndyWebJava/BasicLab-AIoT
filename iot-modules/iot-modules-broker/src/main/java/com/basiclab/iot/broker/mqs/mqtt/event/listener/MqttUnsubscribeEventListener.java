package com.basiclab.iot.broker.mqs.mqtt.event.listener;

import com.basiclab.iot.broker.mqs.mqtt.service.MqttEventActionService;
import com.google.gson.Gson;
import com.basiclab.iot.broker.mqs.mqtt.event.MqttUnsubscribeEvent;
import com.basiclab.iot.common.core.constant.CacheConstants;
import com.basiclab.iot.common.redis.service.RedisService;
import com.basiclab.iot.link.api.domain.cache.device.DeviceCacheVO;
import com.basiclab.iot.link.api.domain.device.enumeration.DeviceActionTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: basiclabiot
 * @description: MQTT UNSUBSCRIBE事件监听器
 * @packagename: com.basiclab.basiclabiot.mqtt.listener
 * @author: BasiclabIoT
 * @e-mainl: andywebjava@163.com
 * @date: 2023-04-28 00:48
 **/
@Component
@Slf4j
public class MqttUnsubscribeEventListener {

    @Autowired
    private MqttEventActionService mqttEventActionService;

    @Autowired
    private RedisService redisService;

    /**
     * 发布MQTT UNSUBSCRIBE事件
     *
     * @param event 事件消息
     */
    @EventListener
    @Async("brokerAsync-mqttMsg")
    public void publishMqttUnsubscribeEvent(MqttUnsubscribeEvent event) {
        log.info("Publishing MQTT UNSUBSCRIBE event: message={}", event.getMessage());
        Gson gson = new Gson();
        Map<Object, Object> map = new HashMap<>();
        map = gson.fromJson(event.getMessage(), map.getClass());
        String clientId = String.valueOf(map.get("clientId"));

        DeviceCacheVO deviceCacheVO = redisService.getCacheObject(CacheConstants.DEF_DEVICE + clientId);
        if (deviceCacheVO == null) {
            log.warn("processingDeviceDataTopic Device not found clientId:{}", clientId);
            return;
        }

        mqttEventActionService.saveMqttEventAction(deviceCacheVO.getDeviceIdentification(), event.getMessage(), DeviceActionTypeEnum.UNSUBSCRIBE, DeviceActionTypeEnum.UNSUBSCRIBE.getDescription());
    }
}
