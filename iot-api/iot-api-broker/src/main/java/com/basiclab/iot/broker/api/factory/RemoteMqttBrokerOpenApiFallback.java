package com.basiclab.iot.broker.api.factory;

import com.basiclab.iot.broker.api.RemoteMqttBrokerOpenApi;
import com.basiclab.iot.broker.api.domain.vo.PublishMessageRequestVO;
import com.basiclab.iot.common.core.domain.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description: MqttBroker-开放接口API 熔断
 * @Author: BasiclabIoT
 * @E-mail: andywebjava@163.com
 * @Website: https://gitee.com/vegetable-chicken-blog/basiclab-iot
 * @CreateDate: 2022/1/14$ 16:49$
 * @UpdateUser: BasiclabIoT
 * @UpdateDate: 2023/1/14$ 16:49$
 * @UpdateRemark: 修改内容
 * @Version: V2.0
 */
@Component
public class RemoteMqttBrokerOpenApiFallback implements FallbackFactory<RemoteMqttBrokerOpenApi> {
    private static final Logger log = LoggerFactory.getLogger(RemoteMqttBrokerOpenApiFallback.class);

    @Override
    public RemoteMqttBrokerOpenApi create(Throwable throwable) {
        log.error("Broker推送设备消息服务调用失败:{}", throwable.getMessage());
        return new RemoteMqttBrokerOpenApi() {


            /**
             * MQTT推送消息接口
             *
             * @param publishMessageRequestVO 推送消息请求参数
             * @return {@link R} 结果
             */
            @Override
            public R<?> sendMessage(PublishMessageRequestVO publishMessageRequestVO) {
                return R.fail("remoteMqttBrokerOpenApi.sendMessage() Service call failure e:{}", throwable.getMessage());
            }

            /**
             * 关闭客户端连接
             *
             * @param clientIdentifiers 客户端标识集合
             * @return {@link R} 结果
             */
            @Override
            public R closeConnection(List<String> clientIdentifiers) {
                return R.fail("remoteMqttBrokerOpenApi.closeConnection() Service call failure e:{}", throwable.getMessage());
            }
        };
    }
}
