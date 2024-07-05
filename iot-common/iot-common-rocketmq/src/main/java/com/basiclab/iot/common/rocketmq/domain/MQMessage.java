package com.basiclab.iot.common.rocketmq.domain;

import lombok.Data;

/**
 * @Description: MQ消息
 * @Author: BasiclabIoT
 * @E-mail: andywebjava@163.com
 * @Website: https://gitee.com/vegetable-chicken-blog/basiclab-iot
 * @CreateDate: 2022/4/15$ 16:15$
 * @UpdateUser: BasiclabIoT
 * @UpdateDate: 2022/4/15$ 16:15$
 * @UpdateRemark: 修改内容
 * @Version: V1.0
 */
@Data
public class MQMessage {
    private static final long serialVersionUID = 1L;

    /**
     * 主题
     */
    private String topic;

    /**
     * 消息
     */
    private String message;
}
