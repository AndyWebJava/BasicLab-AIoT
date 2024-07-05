package com.basiclab.iot.rule.api.factory;

import com.basiclab.iot.common.core.domain.R;
import com.basiclab.iot.rule.api.RemoteRuleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassDescription: 规则服务降级处理
 * @ClassName: RemoteRuleFallbackFactory
 * @Author: basiclabiot
 * @Date: 2021-12-31 11:00:59
 * @Version 1.0
 */
@Component
public class RemoteRuleFallbackFactory implements FallbackFactory<RemoteRuleService> {

    private static final Logger log = LoggerFactory.getLogger(RemoteRuleFallbackFactory.class);

    @Override
    public RemoteRuleService create(Throwable throwable) {
        log.error("Rule服务调用失败:{}", throwable.getMessage());
        return new RemoteRuleService()
        {
            @Override
            public R<?> triggerDeviceLinkage(String ruleIdentification) {
                return R.fail("调用规则触发器失败",throwable.getMessage());
            }

            @Override
            public R<?> actionCommandsByRuleIdentification(String ruleIdentification) {
                return R.fail("调用规则触发器失败",throwable.getMessage());
            }

        };
    }
}
