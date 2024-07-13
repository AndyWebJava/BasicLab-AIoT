package com.basiclab.iot.device.service.device_log;

import com.basiclab.iot.device.dal.mysql.device_log.DeviceLogMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import com.basiclab.iot.device.controller.admin.device_log.vo.*;
import com.basiclab.iot.framework.common.pojo.PageResult;
import com.basiclab.iot.framework.common.util.object.BeanUtils;

import static com.basiclab.iot.device.enums.ErrorCodeConstants.DEVICE_LOG_NOT_EXISTS;
import static com.basiclab.iot.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * 设备日志 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class DeviceLogServiceImpl implements DeviceLogService {

    @Resource
    private DeviceLogMapper deviceLogMapper;

    @Override
    public Long createLog(DeviceLogSaveReqVO createReqVO) {
        // 插入
        com.basiclab.iot.device.dal.dataobject.device.log.DeviceLogDO log = BeanUtils.toBean(createReqVO, com.basiclab.iot.device.dal.dataobject.device.log.DeviceLogDO.class);
        deviceLogMapper.insert(log);
        // 返回
        return log.getId();
    }

    @Override
    public void updateLog(DeviceLogSaveReqVO updateReqVO) {
        // 校验存在
        validateLogExists(updateReqVO.getId());
        // 更新
        com.basiclab.iot.device.dal.dataobject.device.log.DeviceLogDO updateObj = BeanUtils.toBean(updateReqVO, com.basiclab.iot.device.dal.dataobject.device.log.DeviceLogDO.class);
        deviceLogMapper.updateById(updateObj);
    }

    @Override
    public void deleteLog(Long id) {
        // 校验存在
        validateLogExists(id);
        // 删除
        deviceLogMapper.deleteById(id);
    }

    private void validateLogExists(Long id) {
        if (deviceLogMapper.selectById(id) == null) {
            throw exception(DEVICE_LOG_NOT_EXISTS);
        }
    }

    @Override
    public com.basiclab.iot.device.dal.dataobject.device.log.DeviceLogDO getLog(Long id) {
        return deviceLogMapper.selectById(id);
    }

    @Override
    public PageResult<com.basiclab.iot.device.dal.dataobject.device.log.DeviceLogDO> getLogPage(DeviceLogPageReqVO pageReqVO) {
        return deviceLogMapper.selectPage(pageReqVO);
    }

}