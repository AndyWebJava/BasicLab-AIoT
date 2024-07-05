package com.basiclab.iot.link.api.factory;

import com.basiclab.iot.common.core.domain.R;
import com.basiclab.iot.link.api.RemoteDeviceService;
import com.basiclab.iot.link.api.domain.device.entity.Device;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * 设备管理服务降级处理
 *
 * @author shisen
 */
@Component
public class RemoteDeviceFallbackFactory implements FallbackFactory<RemoteDeviceService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteDeviceFallbackFactory.class);

    @Override
    public RemoteDeviceService create(Throwable throwable) {
        log.error("设备管理服务调用失败:{}", throwable.getMessage());
        return new RemoteDeviceService() {
            @Override
            public R updateConnectStatusByClientId(Device device) {
                return R.fail("更新设备在线状态失败:" + throwable.getMessage());
            }

            @Override
            public R<Boolean> clientAuthentication(@RequestBody Map<String, Object> params) {
                return R.fail("客户端身份认证失败:" + throwable.getMessage());
            }

            @Override
            public R<?> selectByProductIdentification(String productIdentification) {
                return R.fail("查询产品下的设备标识失败:" + throwable.getMessage());
            }

            @Override
            public R<Device> selectByProductIdentificationAndDeviceIdentification(String productIdentification, String deviceIdentification) {
                return R.fail("查询产品的设备标识失败:" + throwable.getMessage());
            }

            /**
             * 根据客户端标识获取设备信息
             *
             * @param clientId
             * @return
             */
            @Override
            public R<Device> findOneByClientId(String clientId) {
                return R.fail("查询产品下的设备标识失败:" + throwable.getMessage());
            }

            /**
             *根据产品标识获取产品所有关联设备
             * @param productIdentification
             * @return
             */
            @Override
            public R<?> selectAllByProductIdentification(String productIdentification) {
                return R.fail("查询产品下的设备:" + throwable.getMessage());
            }

            @Override
            public R<?> selectDeviceByDeviceIdentificationList(List<String> deviceIdentificationList) {
                return R.fail("根据设备标识列表查询设备失败:" + throwable.getMessage());
            }

        };
    }
}
