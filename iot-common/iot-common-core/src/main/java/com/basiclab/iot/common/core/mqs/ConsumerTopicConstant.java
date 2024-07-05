package com.basiclab.iot.common.core.mqs;

/**
 * @Description: 消费者主题常量（队列）
 * @Author: BasiclabIoT
 * @E-mail: andywebjava@163.com
 * @Website: https://gitee.com/vegetable-chicken-blog/basiclab-iot
 * @CreateDate: 2022/4/15$ 15:53$
 * @UpdateUser: BasiclabIoT
 * @UpdateDate: 2022/4/15$ 15:53$
 * @UpdateRemark: 修改内容
 * @Version: V1.0
 */
public interface ConsumerTopicConstant {

    /**
     * MQTT Broker 监听主题
     */
    interface Mqtt {
        /**
         * MQTT设备消息监听主题——》MQTT消息——》MQS
         */
        String basiclabiot_MQS_MQTT_MSG = "iot-pro-mqs-mqttMsg";

        /**
         * 设备上线
         */
        String basiclabiot_MQTT_CLIENT_CONNECTED_TOPIC = "mqtt.client.connected.topic";

        /**
         * 客户端设备离线
         */
        String basiclabiot_MQTT_CLIENT_DISCONNECTED_TOPIC = "mqtt.client.disconnect.topic";

        /**
         * 服务端主动断开了与客户端的连接
         */
        String basiclabiot_MQTT_SERVER_CONNECTED_TOPIC = "mqtt.server.disconnect.topic";

        /**
         * 设备离线
         */
        String basiclabiot_MQTT_DEVICE_KICKED_TOPIC = "mqtt.device.kicked.topic";

        /**
         * 消息订阅
         */
        String basiclabiot_MQTT_SUBSCRIPTION_ACKED_TOPIC = "mqtt.subscription.acked.topic";

        /**
         * 取消订阅
         */
        String basiclabiot_MQTT_UNSUBSCRIPTION_ACKED_TOPIC = "mqtt.unsubscription.acked.topic";

        /**
         * 消息分发错误
         */
        String basiclabiot_MQTT_DISTRIBUTION_ERROR_TOPIC = "mqtt.distribution.error.topic";

        /**
         * 消息分发
         */
        String basiclabiot_MQTT_DISTRIBUTION_COMPLETED_TOPIC = "mqtt.distribution.completed.topic";


        /**
         * PING 请求
         */
        String basiclabiot_MQTT_PING_REQ_TOPIC = "mqtt.ping.req.topic";

    }

    interface Link {

        /**
         * 产品服务
         */
        String basiclabiot_PRO_PRODUCT_SERVICE_MSG = "iot-pro-product-service-msg";

        /**
         * 产品服务属性
         */
        String basiclabiot_PRO_PRODUCT_PROPERTY_MSG = "iot-pro-product-property-msg";
    }

    interface Rule {

        /**
         * 规则引擎触发器规则动作监听主题
         */
        String basiclabiot_RULE_TRIGGER = "basiclabiot_rule_trigger";
    }

    interface Tdengine {

        /**
         * TDengine超级表创键修改动作监听主题
         */
        String PRODUCTSUPERTABLE_CREATEORUPDATE = "productSuperTable-createOrUpdate";
    }

}
