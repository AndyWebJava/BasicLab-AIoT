package com.basiclab.iot.framework.dict.config;

import com.basiclab.iot.system.api.dict.DictDataApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 字典用到 Feign 的配置项
 *
 * @author BasicLab源码
 */
@AutoConfiguration
@EnableFeignClients(clients = DictDataApi.class) // 主要是引入相关的 API 服务
public class YudaoDictRpcAutoConfiguration {
}
