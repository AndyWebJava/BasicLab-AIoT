package com.basiclab.iot.broker.mqs.consumer.rocketmq;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.basiclab.iot.broker.api.domain.enumeration.MqttEventEnum;
import com.basiclab.iot.broker.mqs.mqtt.event.publisher.MqttEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.scheduling.annotation.Async;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @Description: Mqtt Message Rocketmq模式 消费者
 * @ClassName: MqttMessageRocketmqConsumerHandler
 * @Date: 2023/04/28$ 16:11$
 * @author: BasiclabIoT
 */
@Slf4j
//@Component
//@RocketMQMessageListener(consumerGroup = ConsumerGroupConstant.basiclabiot_GROUP, topic = ConsumerTopicConstant.Mqtt.basiclabiot_MQS_MQTT_MSG, messageModel = MessageModel.CLUSTERING)
public class MqttMessageRocketmqConsumerHandler implements RocketMQListener {

    @Resource
    private MqttEventPublisher eventPublisher;

    @Async("mqsAsync-mqttMsg")
    @Override
    public void onMessage(Object message) {
        if (null == message) {
            log.warn("message cannot be empty {}", message);
            return;
        }
        log.info("basiclabiot物联网平台数据消费-->Received message={}", message);
        try {
            JSONObject basiclabiotMessage = JSON.parseObject(String.valueOf(message));
            String eventStr = Optional.ofNullable(basiclabiotMessage.getString("event"))
                    .orElse("");
            Long tenantId = Optional.ofNullable(basiclabiotMessage.getString("tenantId"))
                    .filter(StringUtils::isNotBlank)
                    .map(Long::valueOf)
                    .orElse(null);
            if (StringUtils.isEmpty(eventStr) || tenantId == null) {
                log.warn("event or tenantId cannot be empty {}", eventStr);
                return;
            }
            Optional<MqttEventEnum> optionalEvent = MqttEventEnum.getMqttEventEnum(basiclabiotMessage.get("event").toString());
            optionalEvent.ifPresent(event -> {
                switch (event) {
                    case CONNECT:
                        eventPublisher.publishMqttConnectEvent(MqttEventEnum.CONNECT, basiclabiotMessage.toJSONString());
                        break;
                    case CLOSE:
                        eventPublisher.publishMqttCloseEvent(MqttEventEnum.CLOSE, basiclabiotMessage.toJSONString());
                        break;
                    case DISCONNECT:
                        eventPublisher.publishMqttDisconnectEvent(MqttEventEnum.DISCONNECT, basiclabiotMessage.toJSONString());
                        break;
                    case PUBLISH:
                        eventPublisher.publishMqttPublishEvent(MqttEventEnum.PUBLISH, basiclabiotMessage.toJSONString());
                        break;
                    case SUBSCRIBE:
                        eventPublisher.publishMqttSubscribeEvent(MqttEventEnum.SUBSCRIBE, basiclabiotMessage.toJSONString());
                        break;
                    case UNSUBSCRIBE:
                        eventPublisher.publishMqttUnsubscribeEvent(MqttEventEnum.UNSUBSCRIBE, basiclabiotMessage.toJSONString());
                        break;
                    case PING:
                        eventPublisher.publishMqttPingEvent(MqttEventEnum.PING, basiclabiotMessage.toJSONString());
                        break;
                    default:
                        break;
                }
            });
        } catch (Exception e) {
            log.error("basiclabiot物联网平台数据消费-->消费失败，失败原因：{}", e.getMessage());
        }
    }
}
