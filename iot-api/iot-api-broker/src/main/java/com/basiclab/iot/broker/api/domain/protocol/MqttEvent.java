package com.basiclab.iot.broker.api.domain.protocol;

/**
 * -----------------------------------------------------------------------------
 * File Name: MqttEvent
 * -----------------------------------------------------------------------------
 * Description:
 * MQTT事件
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
 * @date 2024/3/11 15:05
 */
public class MqttEvent extends ProtocolEvent {
    public MqttEvent(Object source, String message) {
        super(source, message);
    }
}
