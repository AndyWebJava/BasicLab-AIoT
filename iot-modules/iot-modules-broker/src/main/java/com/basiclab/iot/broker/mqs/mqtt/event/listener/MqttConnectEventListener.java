package com.basiclab.iot.broker.mqs.mqtt.event.listener;

import com.basiclab.iot.broker.mqs.mqtt.service.MqttEventActionService;
import com.google.gson.Gson;
import com.basiclab.iot.broker.mqs.mqtt.event.MqttConnectEvent;
import com.basiclab.iot.common.core.constant.CacheConstants;
import com.basiclab.iot.common.core.domain.R;
import com.basiclab.iot.common.core.enums.DeviceConnectStatusEnum;
import com.basiclab.iot.common.core.enums.ResultEnum;
import com.basiclab.iot.common.redis.service.RedisService;
import com.basiclab.iot.link.api.RemoteDeviceService;
import com.basiclab.iot.link.api.domain.cache.device.DeviceCacheVO;
import com.basiclab.iot.link.api.domain.device.entity.Device;
import com.basiclab.iot.link.api.domain.device.enumeration.DeviceActionTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @program: basiclabiot
 * @description: MQTT CONNECT事件监听器
 * @packagename: com.basiclab.iot.mqtt.listener
 * @author: BasiclabIoT
 * @e-mainl: andywebjava@163.com
 * @date: 2023-04-28 00:36
 **/
@Component
@Slf4j
public class MqttConnectEventListener {

    @Resource
    private RemoteDeviceService remoteDeviceService;

    @Autowired
    private MqttEventActionService mqttEventActionService;

    @Autowired
    private RedisService redisService;


    /**
     * 发布MQTT CONNECT事件
     *
     * @param event 事件消息
     */
    @EventListener
    @Async("brokerAsync-mqttMsg")
    public void publishMqttCloseEvent(MqttConnectEvent event) {
        log.info("Publishing MQTT CONNECT event: message={}", event.getMessage());
        Gson gson = new Gson();
        Map<Object, Object> map = new HashMap<>();
        map = gson.fromJson(event.getMessage(), map.getClass());
        String clientId = String.valueOf(map.get("clientId"));

        DeviceCacheVO deviceCacheVO = redisService.getCacheObject(CacheConstants.DEF_DEVICE + clientId);
        if (deviceCacheVO == null) {
            log.warn("processingDeviceDataTopic Device not found clientId:{}", clientId);
            return;
        }


        // 构造设备对象并设置客户端ID和连接状态
        Device deviceToUpdate = new Device()
                .setClientId(clientId)
                .setConnectStatus(DeviceConnectStatusEnum.ONLINE.getKey());

        // 更新设备连接状态
        R updateDeviceConnectionStatus = remoteDeviceService.updateConnectStatusByClientId(deviceToUpdate);

        // 检查更新操作的结果
        if (ResultEnum.SUCCESS.getCode() != updateDeviceConnectionStatus.getCode()) {
            log.error("Failed to update the device connection status to OFFLINE, clientId={}", clientId);
            return;
        }


        String describable = Optional.ofNullable(DeviceConnectStatusEnum.ONLINE.getKey())
                .flatMap(DeviceConnectStatusEnum::fromValue)
                .map(DeviceConnectStatusEnum::getKey)
                .map(desc -> "The device connection status is updated to " + desc)
                .orElse("The device connection status is updated to ONLINE");

        mqttEventActionService.saveMqttEventAction(deviceCacheVO.getDeviceIdentification(), event.getMessage(), DeviceActionTypeEnum.CONNECT, describable);
    }
}
