package com.basiclab.iot.link.api;


import com.basiclab.iot.common.core.constant.ServiceNameConstants;
import com.basiclab.iot.common.core.domain.R;
import com.basiclab.iot.link.api.factory.RemoteProductServicesFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(contextId = "remoteProductServicesService", value = ServiceNameConstants.basiclabiot_LINK, fallbackFactory = RemoteProductServicesFallbackFactory.class)
public interface RemoteProductServicesService {



    @GetMapping("/productServices/selectAllByProductIdentificationAndStatus")
    R<?> selectAllByProductIdentificationAndStatus(@RequestParam("productIdentification") String productIdentification,@RequestParam("status") String status);

    @PostMapping ("/productServices/selectProductServicesByIdList")
    R<?> selectProductServicesByIdList(@RequestBody List<Long> serviceIdList);
}
