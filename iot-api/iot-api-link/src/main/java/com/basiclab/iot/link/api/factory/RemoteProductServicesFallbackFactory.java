package com.basiclab.iot.link.api.factory;

import com.basiclab.iot.common.core.domain.R;
import com.basiclab.iot.link.api.RemoteProductServicesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * @program: basiclabiot
 * @description: 产品服务管理服务降级处理
 * @packagename: com.basiclab.basiclabiot.link.api.factory
 * @author: kk
 * @date: 2022-11-19
 **/
@Component
public class RemoteProductServicesFallbackFactory implements FallbackFactory<RemoteProductServicesService> {

    private static final Logger log = LoggerFactory.getLogger(RemoteProductServicesFallbackFactory.class);

    @Override
    public RemoteProductServicesService create(Throwable throwable) {
        log.error("产品服务管理服务调用失败:{}", throwable.getMessage());
        return new RemoteProductServicesService() {
            @Override
            public R<?> selectAllByProductIdentificationAndStatus( String productIdentification, String status) {
                return R.fail("查询产品服务失败", throwable.getMessage());
            }

            @Override
            public R<?> selectProductServicesByIdList(List<Long> serviceIdList){
                return R.fail("根据服务id列表查询服务失败", throwable.getMessage());
            }

        };
    }

}
