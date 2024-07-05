package com.basiclab.iot.link.api;


import com.basiclab.iot.common.core.constant.ServiceNameConstants;
import com.basiclab.iot.common.core.domain.R;
import com.basiclab.iot.link.api.factory.RemoteProductCommandsFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@FeignClient(contextId = "remoteProductCommandsService", value = ServiceNameConstants.basiclabiot_LINK, fallbackFactory = RemoteProductCommandsFallbackFactory.class)
public interface RemoteProductCommandsService {

    @PostMapping ("/productCommands/selectProductCommandsByIdList")
    R<?> selectProductCommandsByIdList(@RequestBody List<Long> commandIdList);

    @GetMapping("/productCommands/selectAllCommandsByServiceId/{serviceId}")
    R<?> selectAllByServiceId(@RequestParam("serviceId") Long serviceId);

}
