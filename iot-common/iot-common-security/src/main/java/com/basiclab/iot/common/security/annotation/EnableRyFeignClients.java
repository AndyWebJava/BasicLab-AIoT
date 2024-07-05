package com.basiclab.iot.common.security.annotation;

import org.springframework.cloud.openfeign.EnableFeignClients;
import java.lang.annotation.*;

/**
 * 自定义feign注解
 * 添加basePackages路径
 * 
 * @author BasicLab基础架构实验室
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableFeignClients
public @interface EnableRyFeignClients
{
    String[] value() default {};

    String[] basePackages() default { "com.basiclab.iot" };

    Class<?>[] basePackageClasses() default {};

    Class<?>[] defaultConfiguration() default {};

    Class<?>[] clients() default {};
}
