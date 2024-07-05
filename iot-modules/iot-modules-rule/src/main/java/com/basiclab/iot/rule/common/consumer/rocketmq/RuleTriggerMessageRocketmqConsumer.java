package com.basiclab.iot.rule.common.consumer.rocketmq;

import com.alibaba.fastjson.JSONObject;
import com.basiclab.iot.common.core.mqs.ConsumerGroupConstant;
import com.basiclab.iot.common.core.mqs.ConsumerTopicConstant;
import com.basiclab.iot.rule.service.RuleDeviceLinkageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

/**
 * @Description: 规则引擎-触发器规则消息消费（Rocketmq模式）
 * @Author: BasiclabIoT
 * @E-mail: andywebjava@163.com
 * @Website: https://gitee.com/vegetable-chicken-blog/basiclab-iot
 * @CreateDate: 2022/10/28$ 16:11$
 * @UpdateUser: BasiclabIoT
 * @UpdateDate: 2022/10/28$ 16:11$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Slf4j
//@Component
@RocketMQMessageListener(consumerGroup = ConsumerGroupConstant.basiclabiot_GROUP, topic = ConsumerTopicConstant.Rule.basiclabiot_RULE_TRIGGER, messageModel = MessageModel.CLUSTERING)
public class RuleTriggerMessageRocketmqConsumer implements RocketMQListener {

    @Autowired
    private RuleDeviceLinkageService ruleDeviceLinkageService;

    @Async("ruleAsync")
    @Override
    public void onMessage(Object message) {
        assert message != null : "message cannot be empty";
        log.info("规则引擎-触发器规则数据消费-->Received message={}", message);
        try {
            JSONObject json = JSONObject.parseObject(String.valueOf(message));
            Boolean flag = ruleDeviceLinkageService.checkRuleConditions(json.getString("msg"));
            log.info("规则匹配结果:{}", flag);

            // 触发器规则匹配成功，执行动作
            if (flag) {
                //TODO 触发器规则匹配成功，执行动作 业务逻辑 自行补充
//                ruleDeviceLinkageService.executeRuleAction(json.getString("msg"));
            }
        } catch (Exception e) {
            log.error("规则引擎-触发器规则数据消费-->消费失败，失败原因：{}", e.getMessage());
        }
    }
}
