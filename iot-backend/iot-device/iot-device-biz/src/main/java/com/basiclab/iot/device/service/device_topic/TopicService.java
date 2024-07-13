package com.basiclab.iot.device.service.device_topic;

import javax.validation.*;
import com.basiclab.iot.device.controller.admin.device_topic.vo.*;
import com.basiclab.iot.framework.common.pojo.PageResult;

/**
 * 设备Topic数据 Service 接口
 *
 * @author 芋道源码
 */
public interface TopicService {

    /**
     * 创建设备Topic数据
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createTopic(@Valid DeviceTopicSaveReqVO createReqVO);

    /**
     * 更新设备Topic数据
     *
     * @param updateReqVO 更新信息
     */
    void updateTopic(@Valid DeviceTopicSaveReqVO updateReqVO);

    /**
     * 删除设备Topic数据
     *
     * @param id 编号
     */
    void deleteTopic(Long id);

    /**
     * 获得设备Topic数据
     *
     * @param id 编号
     * @return 设备Topic数据
     */
    com.basiclab.iot.device.dal.dataobject.device.topic.DeviceTopicDO getTopic(Long id);

    /**
     * 获得设备Topic数据分页
     *
     * @param pageReqVO 分页查询
     * @return 设备Topic数据分页
     */
    PageResult<com.basiclab.iot.device.dal.dataobject.device.topic.DeviceTopicDO> getTopicPage(DeviceTopicPageReqVO pageReqVO);

}