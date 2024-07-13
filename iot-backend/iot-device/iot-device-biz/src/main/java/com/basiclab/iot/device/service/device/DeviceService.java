package com.basiclab.iot.device.service.device;

import javax.validation.*;
import com.basiclab.iot.device.controller.admin.device.vo.*;
import com.basiclab.iot.device.dal.dataobject.device.DeviceDO;
import com.basiclab.iot.framework.common.pojo.PageResult;

/**
 * 设备 Service 接口
 *
 * @author 芋道源码
 */
public interface DeviceService {

    /**
     * 创建设备
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long create(@Valid DeviceSaveReqVO createReqVO);

    /**
     * 更新设备
     *
     * @param updateReqVO 更新信息
     */
    void update(@Valid DeviceSaveReqVO updateReqVO);

    /**
     * 删除设备
     *
     * @param id 编号
     */
    void delete(Long id);

    /**
     * 获得设备
     *
     * @param id 编号
     * @return 设备
     */
    DeviceDO get(Long id);

    /**
     * 获得设备分页
     *
     * @param pageReqVO 分页查询
     * @return 设备分页
     */
    PageResult<DeviceDO> getPage(DevicePageReqVO pageReqVO);

}