package com.basiclab.iot.broker.mqs.mqtt.handler;

import com.alibaba.fastjson.JSON;
import com.basiclab.iot.broker.mqs.mqtt.handler.factory.AbstractMessageHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.basiclab.iot.protocol.factory.ProtocolMessageAdapter;
import com.basiclab.iot.protocol.model.EncryptionDetailsDTO;
import com.basiclab.iot.protocol.model.ProtocolDataMessageDTO;
import com.basiclab.iot.broker.api.RemoteMqttBrokerOpenApi;
import com.basiclab.iot.common.core.domain.R;
import com.basiclab.iot.common.redis.service.RedisService;
import com.basiclab.iot.link.api.RemoteDeviceOpenAnyService;
import com.basiclab.iot.link.api.domain.cache.device.DeviceCacheVO;
import com.basiclab.iot.link.api.domain.device.vo.param.TopoUpdateSubDeviceStatusParam;
import com.basiclab.iot.link.api.domain.device.vo.result.TopoDeviceOperationResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @program: basiclabiot
 * @description: 处理UPDATE_SUB_DEVICE主题
 * @packagename: com.basiclab.iot.mqtt.handler
 * @author: BasiclabIoT
 * @e-mainl: andywebjava@163.com
 * @date: 2023-05-05 23:00
 **/
@Slf4j
@Service
public class UpdateSubDeviceHandler extends AbstractMessageHandler implements TopicHandler {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public UpdateSubDeviceHandler(RedisService redisService,
                                  RemoteDeviceOpenAnyService remoteDeviceOpenAnyService,
                                  RemoteMqttBrokerOpenApi remoteMqttBrokerOpenApi,
                                  ProtocolMessageAdapter protocolMessageAdapter) {
        super(redisService, remoteDeviceOpenAnyService, remoteMqttBrokerOpenApi, protocolMessageAdapter);
    }

    /**
     * @param topic the MQTT topic the message was received on.
     * @param qos   the quality of service level of the message.
     * @param body  the payload of the message.
     */
    @Override
    public void handle(String topic, String qos, String body) {
        if (!protocolMessageAdapter.validateProtocolData(body)) {
            log.warn("The protocol format is incorrect");
            return;
        }

        // Extract variables from the topic
        Map<String, String> stringStringMap = protocolMessageAdapter.extractVariables(topic);
        String version = stringStringMap.get("version");
        String deviceId = stringStringMap.get("deviceId");

        DeviceCacheVO deviceCacheVO = getDeviceCacheVO(deviceId);
        if (deviceCacheVO == null) {
            return;
        }

        try {
            ProtocolDataMessageDTO protocolDataMessageDTO = protocolMessageAdapter.parseProtocolDataMessage(body);
            // 构造 EncryptionDetails 对象
            EncryptionDetailsDTO encryptionDetailsDTO = EncryptionDetailsDTO.builder()
                    .signKey(deviceCacheVO.getSignKey())
                    .encryptKey(deviceCacheVO.getEncryptKey())
                    .encryptVector(deviceCacheVO.getEncryptVector())
                    .build();
            String dataBody = protocolMessageAdapter.decryptMessage(body, encryptionDetailsDTO);

            // Parse body
            TopoUpdateSubDeviceStatusParam topoUpdateSubDeviceStatusParam = JSON.toJavaObject(JSON.parseObject(dataBody), TopoUpdateSubDeviceStatusParam.class);
            topoUpdateSubDeviceStatusParam.setGatewayIdentification(deviceId);
            String resultDataBody = processingTopicMessage(topoUpdateSubDeviceStatusParam);

            // Handle result
            ProtocolDataMessageDTO handleResult = protocolMessageAdapter.buildResponse(protocolDataMessageDTO, resultDataBody, encryptionDetailsDTO);

            // Determine response topic based on request topic
            String responseTopic = "/topo/updateResponse";
            // Generate response topic string
            String responseTopicStr = generateResponseTopic(version, deviceId, responseTopic);

            // 序列化 handleResult 对象为 JSON 字符串
            String resultData = objectMapper.writeValueAsString(handleResult);
            // Push message to MQTT to notify device of successful/failed sub-device update
            sendMessage(responseTopicStr, qos, resultData, String.valueOf(deviceCacheVO.getAppId()));
        } catch (Exception e) {
            log.error("Failed to decrypt the message", e);
        }
    }

    /**
     * Process /topo/update Topic for gateway device to update sub-device
     *
     * @param topoUpdateSubDeviceParam update device data
     * @return Processing result json
     */
    @Override
    protected String processingTopicMessage(Object topoUpdateSubDeviceParam) throws Exception {
        R<TopoDeviceOperationResultVO> topoDeviceOperationResultVOR =
                remoteDeviceOpenAnyService.updateSubDeviceConnectStatusByMqtt((TopoUpdateSubDeviceStatusParam) topoUpdateSubDeviceParam);
        log.info("processingTopoUpdateTopic Processing result:{}", JSON.toJSONString(topoDeviceOperationResultVOR));
        return JSON.toJSONString(topoDeviceOperationResultVOR.getData());
    }
}
