package com.basiclab.iot.broker.api.domain.protocol;

/**
 * -----------------------------------------------------------------------------
 * File Name: WebSocketEvent
 * -----------------------------------------------------------------------------
 * Description:
 * WebSocket事件
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
 * @date 2024/3/11 15:06
 */
public class WebSocketEvent extends ProtocolEvent {
    public WebSocketEvent(Object source, String message) {
        super(source, message);
    }
}
