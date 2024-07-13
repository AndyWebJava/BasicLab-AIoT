package com.basiclab.iot.device.service.device_group;

import javax.validation.*;
import com.basiclab.iot.device.controller.admin.device_group.vo.*;
import com.basiclab.iot.framework.common.pojo.PageResult;

/**
 * 设备分组 Service 接口
 *
 * @author 芋道源码
 */
public interface DeviceGroupService {

    /**
     * 创建设备分组
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createGroup(@Valid DeviceGroupSaveReqVO createReqVO);

    /**
     * 更新设备分组
     *
     * @param updateReqVO 更新信息
     */
    void updateGroup(@Valid DeviceGroupSaveReqVO updateReqVO);

    /**
     * 删除设备分组
     *
     * @param id 编号
     */
    void deleteGroup(Long id);

    /**
     * 获得设备分组
     *
     * @param id 编号
     * @return 设备分组
     */
    com.basiclab.iot.device.dal.dataobject.device.group.DeviceGroupDO getGroup(Long id);

    /**
     * 获得设备分组分页
     *
     * @param pageReqVO 分页查询
     * @return 设备分组分页
     */
    PageResult<com.basiclab.iot.device.dal.dataobject.device.group.DeviceGroupDO> getGroupPage(DeviceGroupPageReqVO pageReqVO);

}