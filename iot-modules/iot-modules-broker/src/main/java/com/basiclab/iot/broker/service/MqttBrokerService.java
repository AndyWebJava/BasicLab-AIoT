package com.basiclab.iot.broker.service;

import com.basiclab.iot.broker.api.domain.vo.PublishMessageRequestVO;
import com.basiclab.iot.common.core.exception.base.BaseException;

/**
 * -----------------------------------------------------------------------------
 * File Name: MqttBrokerService.java
 * -----------------------------------------------------------------------------
 * Description:
 * MqttBroker API
 * -----------------------------------------------------------------------------
 *
 * @author BasicLab基础架构实验室
 * @version 1.0
 * -----------------------------------------------------------------------------
 * Revision History:
 * Date         Author          Version     Description
 * --------      --------     -------   --------------------
 * <p>
 * -----------------------------------------------------------------------------
 * @email andywebjava@163.com
 * @date 2023-10-31 19:43
 */
public interface MqttBrokerService {


    /**
     * Publishes a message to a specified topic and returns the content if successful.
     *
     * @param publishMessageRequestVO Object containing the required parameters for publishing.
     * @return The content of the published message.
     * @throws BaseException If the publishing fails.
     */
    String publishMessage(PublishMessageRequestVO publishMessageRequestVO);
}
