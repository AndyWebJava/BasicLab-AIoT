

package com.basiclab.iot.link.api;

import com.basiclab.iot.common.core.constant.ServiceNameConstants;
import com.basiclab.iot.common.core.domain.R;
import com.basiclab.iot.link.api.factory.RemoteCacheOpenAnyFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 缓存开放服务
 *
 * @author BasicLab基础架构实验室
 */
@FeignClient(contextId = "remoteCacheOpenService", value = ServiceNameConstants.basiclabiot_LINK, fallbackFactory = RemoteCacheOpenAnyFallbackFactory.class, path = "/cache/open/any")
public interface RemoteCacheOpenAnyService {

    /**
     * Refreshes the cache for all devices within a tenant.
     *
     * @return Response indicating the operation was successful.
     */
    @GetMapping("/refreshAllDeviceCaches")
    R refreshAllDeviceCaches();

    /**
     * Refreshes the cache for sub devices within a tenant.
     *
     * @return Response indicating the operation was successful.
     */
    @GetMapping("/refreshAllDeviceInfoCaches")
    R refreshAllDeviceInfoCaches();

    /**
     * Refreshes the cache for all products within a tenant.
     *
     * @return Response indicating the operation was successful.
     */
    @GetMapping("/refreshAllProductCaches")
    R refreshAllProductCaches();

    /**
     * Refreshes the cache for all product models within a tenant.
     *
     * @return Response indicating the operation was successful.
     */
    @GetMapping("/refreshAllProductModelCaches")
    R refreshAllProductModelCaches();


}
