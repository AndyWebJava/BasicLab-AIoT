package com.basiclab.iot.link.api;


import com.basiclab.iot.common.core.constant.ServiceNameConstants;
import com.basiclab.iot.common.core.domain.R;
import com.basiclab.iot.link.api.factory.RemoteProductCommandsRequestsFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(contextId = "remoteProductCommandsService", value = ServiceNameConstants.basiclabiot_LINK, fallbackFactory = RemoteProductCommandsRequestsFallbackFactory.class)
public interface RemoteProductCommandsRequestsService {

    @GetMapping("/productProperties/selectAllCommandsRequestsByCommandId/{commandId}")
    R<?> selectAllRequestsByCommandId(@RequestParam("commandId") Long commandId);

}
