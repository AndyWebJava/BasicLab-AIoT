package com.basiclab.iot.framework.websocket.core.sender.local;

import com.basiclab.iot.framework.websocket.core.sender.AbstractWebSocketMessageSender;
import com.basiclab.iot.framework.websocket.core.sender.WebSocketMessageSender;
import com.basiclab.iot.framework.websocket.core.session.WebSocketSessionManager;

/**
 * 本地的 {@link WebSocketMessageSender} 实现类
 *
 * 注意：仅仅适合单机场景！！！
 *
 * @author BasicLab源码
 */
public class LocalWebSocketMessageSender extends AbstractWebSocketMessageSender {

    public LocalWebSocketMessageSender(WebSocketSessionManager sessionManager) {
        super(sessionManager);
    }

}
