package com.basiclab.iot.rule.api;

import com.basiclab.iot.common.core.constant.ServiceNameConstants;
import com.basiclab.iot.common.core.domain.R;
import com.basiclab.iot.rule.api.factory.RemoteRuleFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @InterfaceDescription: 规则服务
 * @InterfaceName: RemoteRuleService
 * @Author: basiclabiot
 * @Date: 2021-12-31 10:57:16
 * @Version 1.0
 */

@FeignClient(contextId = "remoteRuleService", value = ServiceNameConstants.basiclabiot_RULE, fallbackFactory = RemoteRuleFallbackFactory.class)
public interface RemoteRuleService {

    @GetMapping("/ruleDeviceLinkage/triggerDeviceLinkage/{ruleIdentification}")
    public R<?> triggerDeviceLinkage(@PathVariable("ruleIdentification") String ruleIdentification);

    /**
     * 通过标识查询产品
     *
     * @param ruleIdentification
     * @return
     */
    @GetMapping("/ruleDeviceLinkage/actionCommandsByRuleIdentification/{ruleIdentification}")
    public R<?> actionCommandsByRuleIdentification(@PathVariable("ruleIdentification") String ruleIdentification);

}
