package com.basiclab.iot.link.api;

import com.basiclab.iot.common.core.constant.ServiceNameConstants;
import com.basiclab.iot.common.core.domain.R;
import com.basiclab.iot.link.api.domain.device.entity.DeviceAction;
import com.basiclab.iot.link.api.factory.RemoteDeviceActionFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 设备动作服务
 *
 * @author BasicLab基础架构实验室
 */
@FeignClient(contextId = "remoteDeviceActionService", value = ServiceNameConstants.basiclabiot_LINK, fallbackFactory = RemoteDeviceActionFallbackFactory.class)
public interface RemoteDeviceActionService {

    /**
     * 新增设备动作
     *
     * @param mqttsDeviceAction
     * @return
     */
    @PostMapping("/action")
    public R add(@RequestBody DeviceAction mqttsDeviceAction);
}
