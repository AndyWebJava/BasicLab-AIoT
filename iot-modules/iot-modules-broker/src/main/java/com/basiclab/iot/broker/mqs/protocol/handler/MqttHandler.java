package com.basiclab.iot.broker.mqs.protocol.handler;

import com.basiclab.iot.broker.mqs.protocol.event.publisher.ProtocolMessageEventPublisher;
import com.basiclab.iot.link.api.domain.product.enumeration.ProtocolTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * -----------------------------------------------------------------------------
 * File Name: MqttHandler
 * -----------------------------------------------------------------------------
 * Description:
 * MQTT协议处理器
 * -----------------------------------------------------------------------------
 *
 * @author xiaonannet
 * @version 1.0
 * -----------------------------------------------------------------------------
 * Revision History:
 * Date         Author          Version     Description
 * --------      --------     -------   --------------------
 * 2024/3/11       xiaonannet        1.0        Initial creation
 * -----------------------------------------------------------------------------
 * @email andywebjava@163.com
 * @date 2024/3/11 14:57
 */
@Component
@Slf4j
public class MqttHandler implements ProtocolHandler {

    @Autowired
    private ProtocolMessageEventPublisher eventPublisher;

    @Override
    public void processMessage(String message) {
        // MQTT协议特定的预处理逻辑
        log.info("处理MQTT协议消息: {}", message);
        eventPublisher.publishEvent(getProtocolTypeEnum(), message);
    }


    /**
     * 获取协议类型枚举
     *
     * @return 协议类型
     */
    @Override
    public ProtocolTypeEnum getProtocolTypeEnum() {
        return ProtocolTypeEnum.MQTT;
    }

}
