package com.basiclab.iot.infra.dal.mysql.job;

import com.basiclab.iot.framework.common.pojo.PageResult;
import com.basiclab.iot.framework.mybatis.core.mapper.BaseMapperX;
import com.basiclab.iot.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.basiclab.iot.infra.controller.admin.job.vo.job.JobPageReqVO;
import com.basiclab.iot.infra.dal.dataobject.job.JobDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 定时任务 Mapper
 *
 * @author BasicLab源码
 */
@Mapper
public interface JobMapper extends BaseMapperX<JobDO> {

    default JobDO selectByHandlerName(String handlerName) {
        return selectOne(JobDO::getHandlerName, handlerName);
    }

    default PageResult<JobDO> selectPage(JobPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<JobDO>()
                .likeIfPresent(JobDO::getName, reqVO.getName())
                .eqIfPresent(JobDO::getStatus, reqVO.getStatus())
                .likeIfPresent(JobDO::getHandlerName, reqVO.getHandlerName())
        );
    }

}
