package com.basiclab.iot.link.api;

import com.basiclab.iot.common.core.constant.ServiceNameConstants;
import com.basiclab.iot.common.core.domain.R;
import com.basiclab.iot.link.api.domain.device.entity.DeviceDatas;
import com.basiclab.iot.link.api.factory.RemoteDeviceDatasFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 设备消息服务
 *
 * @author shisen
 */
@FeignClient(contextId = "remoteDeviceDatasService", value = ServiceNameConstants.basiclabiot_LINK, fallbackFactory = RemoteDeviceDatasFallbackFactory.class)
public interface RemoteDeviceDatasService {

    /**
     * 新增设备消息
     */
    @PostMapping("/device/datas/add")
    public R add(@RequestBody DeviceDatas mqttsDeviceDatas);

}
