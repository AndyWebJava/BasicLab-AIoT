package com.basiclab.iot.rule.service;

import java.util.List;

import com.basiclab.iot.rule.api.domain.RuleConditions;
import com.basiclab.iot.rule.api.domain.model.RuleConditionsModel;

/**
 * @program: basiclabiot
 * @description: ${description}
 * @packagename: com.basiclab.basiclabiot.rule.service
 * @author: BasiclabIoT
 * @e-mainl: andywebjava@163.com
 * @date: 2022-07-21 18:47
 **/
public interface RuleConditionsService {


    int deleteByPrimaryKey(Long id);

    int insert(RuleConditions record);

    int insertOrUpdate(RuleConditions record);

    int insertOrUpdateSelective(RuleConditions record);

    int insertSelective(RuleConditions record);

    RuleConditions selectByPrimaryKey(Long id);

    List<RuleConditions> selectByRuleId(Long ruleId);

    int updateByPrimaryKeySelective(RuleConditions record);

    int updateByPrimaryKey(RuleConditions record);

    int updateBatch(List<RuleConditions> list);

    int updateBatchSelective(List<RuleConditions> list);

    List<RuleConditions> batchInsert(List<RuleConditions> list);

    int deleteBatchByIds(Long[] ids);

    List<RuleConditionsModel> ruleConditionsListToRuleConditionsModelList(List<RuleConditions> ruleConditionsList);
}

