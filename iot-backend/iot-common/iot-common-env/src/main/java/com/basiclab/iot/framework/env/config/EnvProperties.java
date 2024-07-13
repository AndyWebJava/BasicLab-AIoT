package com.basiclab.iot.framework.env.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 环境配置
 *
 * @author BasicLab源码
 */
@ConfigurationProperties(prefix = "iot.env")
@Data
public class EnvProperties {

    public static final String TAG_KEY = "iot.env.tag";

    /**
     * 环境标签
     */
    private String tag;

}
