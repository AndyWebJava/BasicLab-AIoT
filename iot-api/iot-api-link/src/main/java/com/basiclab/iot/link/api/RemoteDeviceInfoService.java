package com.basiclab.iot.link.api;

import com.basiclab.iot.common.core.constant.ServiceNameConstants;
import com.basiclab.iot.common.core.web.domain.AjaxResult;
import com.basiclab.iot.link.api.factory.RemoteDeviceInfoFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 子设备管理服务
 *
 * @author BasicLab基础架构实验室
 */
@FeignClient(contextId = "remoteDeviceInfoService", value = ServiceNameConstants.basiclabiot_LINK, fallbackFactory = RemoteDeviceInfoFallbackFactory.class)
public interface RemoteDeviceInfoService {

    /**
     * 刷新子设备数据模型
     *
     * @param ids
     * @return
     */
    @GetMapping("/deviceInfo/refreshDeviceInfoDataModel")
    public AjaxResult refreshDeviceInfoDataModel(@RequestParam(name = "ids", required = false) Long[] ids);




}
