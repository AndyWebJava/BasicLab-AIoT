package com.basiclab.iot.system.api;

import com.basiclab.iot.common.core.constant.SecurityConstants;
import com.basiclab.iot.common.core.constant.ServiceNameConstants;
import com.basiclab.iot.common.core.domain.R;
import com.basiclab.iot.system.api.domain.SysLogininfor;
import com.basiclab.iot.system.api.factory.RemoteLogFallbackFactory;
import com.basiclab.iot.system.api.domain.SysOperLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
/**
 * 日志服务
 * 
 * @author BasicLab基础架构实验室
 */
@FeignClient(contextId = "remoteLogService", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RemoteLogFallbackFactory.class)
public interface RemoteLogService
{
    /**
     * 保存系统日志
     *
     * @param sysOperLog 日志实体
     * @param source 请求来源
     * @return 结果
     */
    @PostMapping("/operlog")
    public R<Boolean> saveLog(@RequestBody SysOperLog sysOperLog, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    /**
     * 保存访问记录
     *
     * @param sysLogininfor 访问实体
     * @param source 请求来源
     * @return 结果
     */
    @PostMapping("/logininfor")
    public R<Boolean> saveLogininfor(@RequestBody SysLogininfor sysLogininfor, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);
}
