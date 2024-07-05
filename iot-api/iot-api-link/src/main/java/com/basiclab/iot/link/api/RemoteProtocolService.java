package com.basiclab.iot.link.api;

import com.basiclab.iot.common.core.constant.ServiceNameConstants;
import com.basiclab.iot.common.core.web.domain.AjaxResult;
import com.basiclab.iot.link.api.factory.RemoteProtocolFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: basiclabiot
 * @description: 协议管理服务
 * @packagename: com.basiclab.iot.link.api
 * @author: BasiclabIoT
 * @e-mainl: andywebjava@163.com
 * @date: 2022-07-11 15:15
 **/
@FeignClient(contextId = "remoteProtocolService", value = ServiceNameConstants.basiclabiot_LINK, fallbackFactory = RemoteProtocolFallbackFactory.class)
public interface RemoteProtocolService {

    /**
     * 刷新协议脚本缓存
     * @return
     */
    @GetMapping("/protocol/protocolScriptCacheRefresh")
    public AjaxResult protocolScriptCacheRefresh();
}
