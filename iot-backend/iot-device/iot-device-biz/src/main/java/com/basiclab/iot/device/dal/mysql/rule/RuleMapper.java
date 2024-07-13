package com.basiclab.iot.device.dal.mysql.rule;

import java.util.*;

import com.basiclab.iot.framework.common.pojo.PageResult;
import com.basiclab.iot.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.basiclab.iot.framework.mybatis.core.mapper.BaseMapperX;
import com.basiclab.iot.device.dal.dataobject.rule.RuleDO;
import org.apache.ibatis.annotations.Mapper;
import com.basiclab.iot.device.controller.admin.rule.vo.*;

/**
 * 规则信息 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface RuleMapper extends BaseMapperX<RuleDO> {

    default PageResult<RuleDO> selectPage(RulePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<RuleDO>()
                .eqIfPresent(RuleDO::getAppId, reqVO.getAppId())
                .eqIfPresent(RuleDO::getRuleCode, reqVO.getRuleCode())
                .likeIfPresent(RuleDO::getRuleName, reqVO.getRuleName())
                .eqIfPresent(RuleDO::getJobCode, reqVO.getJobCode())
                .eqIfPresent(RuleDO::getStatus, reqVO.getStatus())
                .eqIfPresent(RuleDO::getTriggering, reqVO.getTriggering())
                .eqIfPresent(RuleDO::getRemark, reqVO.getRemark())
                .eqIfPresent(RuleDO::getCreateBy, reqVO.getCreateBy())
                .betweenIfPresent(RuleDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(RuleDO::getUpdateBy, reqVO.getUpdateBy())
                .orderByDesc(RuleDO::getId));
    }

}