package com.basiclab.iot.device.dal.mysql.device_topic;

import com.basiclab.iot.framework.common.pojo.PageResult;
import com.basiclab.iot.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.basiclab.iot.framework.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;
import com.basiclab.iot.device.controller.admin.device_topic.vo.*;

/**
 * 设备Topic数据 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface DeviceTopicMapper extends BaseMapperX<com.basiclab.iot.device.dal.dataobject.device.topic.DeviceTopicDO> {

    default PageResult<com.basiclab.iot.device.dal.dataobject.device.topic.DeviceTopicDO> selectPage(DeviceTopicPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<com.basiclab.iot.device.dal.dataobject.device.topic.DeviceTopicDO>()
                .eqIfPresent(com.basiclab.iot.device.dal.dataobject.device.topic.DeviceTopicDO::getDid, reqVO.getDid())
                .eqIfPresent(com.basiclab.iot.device.dal.dataobject.device.topic.DeviceTopicDO::getType, reqVO.getType())
                .eqIfPresent(com.basiclab.iot.device.dal.dataobject.device.topic.DeviceTopicDO::getTopic, reqVO.getTopic())
                .eqIfPresent(com.basiclab.iot.device.dal.dataobject.device.topic.DeviceTopicDO::getPublisher, reqVO.getPublisher())
                .eqIfPresent(com.basiclab.iot.device.dal.dataobject.device.topic.DeviceTopicDO::getSubscriber, reqVO.getSubscriber())
                .eqIfPresent(com.basiclab.iot.device.dal.dataobject.device.topic.DeviceTopicDO::getCreateBy, reqVO.getCreateBy())
                .betweenIfPresent(com.basiclab.iot.device.dal.dataobject.device.topic.DeviceTopicDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(com.basiclab.iot.device.dal.dataobject.device.topic.DeviceTopicDO::getUpdateBy, reqVO.getUpdateBy())
                .eqIfPresent(com.basiclab.iot.device.dal.dataobject.device.topic.DeviceTopicDO::getRemark, reqVO.getRemark())
                .orderByDesc(com.basiclab.iot.device.dal.dataobject.device.topic.DeviceTopicDO::getId));
    }

}