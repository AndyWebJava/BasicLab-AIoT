package com.basiclab.iot.link.api;


import com.basiclab.iot.common.core.constant.ServiceNameConstants;
import com.basiclab.iot.common.core.domain.R;
import com.basiclab.iot.link.api.factory.RemoteProductPropertiesFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(contextId = "RemoteProductPropertiesService", value = ServiceNameConstants.basiclabiot_LINK, fallbackFactory = RemoteProductPropertiesFallbackFactory.class)
public interface RemoteProductPropertiesService {

    @GetMapping("/productProperties/selectAllPropertiesByServiceId/{serviceId}")
    R<?> selectAllByServiceId(@RequestParam("serviceId") Long serviceId);

    @PostMapping("/productProperties/selectPropertiesByPropertiesIdList")
    R<?> selectPropertiesByPropertiesIdList(@RequestBody List<Long> propertiesIdList);
}
