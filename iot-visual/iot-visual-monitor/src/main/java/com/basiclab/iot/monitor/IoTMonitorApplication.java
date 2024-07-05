package com.basiclab.iot.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@EnableAdminServer
@SpringBootApplication
public class IoTMonitorApplication {
    public static void main(String[] args) {
        SpringApplication.run(IoTMonitorApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  监控中心服务启动成功   ლ(´ڡ`ლ)ﾞ  ");
    }

}
