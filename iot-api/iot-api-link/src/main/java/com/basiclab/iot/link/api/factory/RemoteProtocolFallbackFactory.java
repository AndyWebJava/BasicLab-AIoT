package com.basiclab.iot.link.api.factory;

import com.basiclab.iot.common.core.web.domain.AjaxResult;
import com.basiclab.iot.link.api.RemoteProtocolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @program: basiclabiot
 * @description: 协议管理服务降级处理
 * @packagename: com.basiclab.iot.link.api.factory
 * @author: BasiclabIoT
 * @e-mainl: andywebjava@163.com
 * @date: 2022-07-11 15:17
 **/
@Component
public class RemoteProtocolFallbackFactory implements FallbackFactory<RemoteProtocolService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteProtocolFallbackFactory.class);


    @Override
    public RemoteProtocolService create(Throwable throwable) {
        log.error("协议管理服务调用失败:{}", throwable.getMessage());
        return new RemoteProtocolService() {
            @Override
            public AjaxResult protocolScriptCacheRefresh() {
                return AjaxResult.error("协议脚本缓存刷新失败:" + throwable.getMessage());
            }
        };
    }

}
