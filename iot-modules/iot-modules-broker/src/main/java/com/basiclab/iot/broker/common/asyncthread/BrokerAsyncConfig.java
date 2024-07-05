package com.basiclab.iot.broker.common.asyncthread;

import com.basiclab.iot.common.core.asyncthread.SuRejectHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * 异步@Async多线程配置
 * 使用原则：每一个业务场景使用独立的线程池，不要使用全局共享线程池
 *
 * @author BasicLab基础架构实验室
 */
@Configuration
@EnableAsync
public class BrokerAsyncConfig {

    /**
     * 核心线程数（默认线程数）
     */
    @Value("${threadBus.pool.core-pool-size}")
    private int corePoolSize = Runtime.getRuntime().availableProcessors();
    /**
     * 最大线程数
     */
    @Value("${threadBus.pool.max-pool-size}")
    private int maxPoolSize = Runtime.getRuntime().availableProcessors();
    /**
     * 允许线程空闲时间（单位：默认为秒）
     */
    @Value("${threadBus.pool.keep-alive-time}")
    private int keepAliveTime = 60;
    /**
     * 缓冲队列大小
     */
    @Value("${threadBus.pool.queue-capacity}")
    private int queueCapacity = 200;
    /**
     * 线程池名前缀
     */
    @Value("${threadBus.pool.thread-name-prefix}")
    private String threadNamePrefix = "basiclabiotAsync-";

    @Autowired
    private SuRejectHandle rejectHandle;

    /**
     * Broker服务全局共享异步线程池
     */
    @Bean("brokerAsync")
    public Executor brokerAsync() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);//核心线程数
        executor.setMaxPoolSize(maxPoolSize);//最大线程数  cpu核数/(1-0.8)//cup核数*2//cup核数+1
        //传参正值使用无界LinkedBlockingQueue
        //其他传参使用不缓存SynchronousQueue
        executor.setQueueCapacity(queueCapacity);//队列长度(超过队列长度无法存储,则开启最大线程数)
        executor.setKeepAliveSeconds(keepAliveTime);//空闲线程最大存活时间 默认60s
        executor.setThreadNamePrefix(threadNamePrefix + "brokerAsync-");//线程名前缀
        executor.setRejectedExecutionHandler(rejectHandle);// 自定义任务丢失处理策略   该策略输出由scheduling-1打印
        //设置线程池等待所有任务都完成再关闭
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(keepAliveTime);
        executor.initialize();
        return executor;
    }


    /**
     * MQTT设备消息消费异步线程池配置
     */
    @Bean("brokerAsync-mqttMsg")
    public Executor brokerAsyncMqttMsg() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);//核心线程数
        executor.setMaxPoolSize(maxPoolSize);//最大线程数    cpu核数/(1-0.8)//cup核数*2//cup核数+1
        //传参正值使用无界LinkedBlockingQueue
        //其他传参使用不缓存SynchronousQueue
        executor.setQueueCapacity(queueCapacity);//队列长度(超过队列长度无法存储,则开启最大线程数)
        executor.setKeepAliveSeconds(keepAliveTime);//空闲线程最大存活时间 默认60s
        executor.setThreadNamePrefix(threadNamePrefix + "brokerAsync-mqttMsg");//线程名前缀
        executor.setRejectedExecutionHandler(rejectHandle);//自定义任务丢失处理策略   该策略输出由scheduling-1打印
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(keepAliveTime);
        executor.initialize();
        return executor;
    }

    /**
     * HTTP设备消息消费异步线程池配置
     */
    @Bean("brokerAsync-httpMsg")
    public Executor mqsAsyncHttpMsg() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);//核心线程数
        executor.setMaxPoolSize(maxPoolSize);//最大线程数    cpu核数/(1-0.8)//cup核数*2//cup核数+1
        //传参正值使用无界LinkedBlockingQueue
        //其他传参使用不缓存SynchronousQueue
        executor.setQueueCapacity(queueCapacity);//队列长度(超过队列长度无法存储,则开启最大线程数)
        executor.setKeepAliveSeconds(keepAliveTime);//空闲线程最大存活时间 默认60s
        executor.setThreadNamePrefix(threadNamePrefix + "brokerAsync-httpMsg");//线程名前缀
        executor.setRejectedExecutionHandler(rejectHandle);//自定义任务丢失处理策略   该策略输出由scheduling-1打印
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(keepAliveTime);
        executor.initialize();
        return executor;
    }

    /**
     * webSocket设备消息消费异步线程池配置
     */
    @Bean("brokerAsync-webSocketMsg")
    public Executor brokerAsyncWebSocketMsg() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);//核心线程数
        executor.setMaxPoolSize(maxPoolSize);//最大线程数    cpu核数/(1-0.8)//cup核数*2//cup核数+1
        //传参正值使用无界LinkedBlockingQueue
        //其他传参使用不缓存SynchronousQueue
        executor.setQueueCapacity(queueCapacity);//队列长度(超过队列长度无法存储,则开启最大线程数)
        executor.setKeepAliveSeconds(keepAliveTime);//空闲线程最大存活时间 默认60s
        executor.setThreadNamePrefix(threadNamePrefix + "brokerAsync-webSocketMsg");//线程名前缀
        executor.setRejectedExecutionHandler(rejectHandle);//自定义任务丢失处理策略   该策略输出由scheduling-1打印
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(keepAliveTime);
        executor.initialize();
        return executor;
    }

    /**
     * TCP设备消息消费异步线程池配置
     */
    @Bean("brokerAsync-tcpMsg")
    public Executor brokerAsyncTcpMsg() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);//核心线程数
        executor.setMaxPoolSize(maxPoolSize);//最大线程数    cpu核数/(1-0.8)//cup核数*2//cup核数+1
        //传参正值使用无界LinkedBlockingQueue
        //其他传参使用不缓存SynchronousQueue
        executor.setQueueCapacity(queueCapacity);//队列长度(超过队列长度无法存储,则开启最大线程数)
        executor.setKeepAliveSeconds(keepAliveTime);//空闲线程最大存活时间 默认60s
        executor.setThreadNamePrefix(threadNamePrefix + "brokerAsync-tcpMsg");//线程名前缀
        executor.setRejectedExecutionHandler(rejectHandle);//自定义任务丢失处理策略   该策略输出由scheduling-1打印
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(keepAliveTime);
        executor.initialize();
        return executor;
    }


}
