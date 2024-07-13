package com.basiclab.iot.device.service.device;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import com.basiclab.iot.device.controller.admin.device.vo.*;
import com.basiclab.iot.device.dal.dataobject.device.DeviceDO;
import com.basiclab.iot.framework.common.pojo.PageResult;
import com.basiclab.iot.framework.common.util.object.BeanUtils;

import com.basiclab.iot.device.dal.mysql.device.DeviceMapper;

import static com.basiclab.iot.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.basiclab.iot.device.enums.ErrorCodeConstants.*;

/**
 * 设备 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class DeviceServiceImpl implements DeviceService {

    @Resource
    private DeviceMapper deviceMapper;

    @Override
    public Long create(DeviceSaveReqVO createReqVO) {
        // 插入
        DeviceDO deviceDO = BeanUtils.toBean(createReqVO, DeviceDO.class);
        deviceMapper.insert(deviceDO);
        // 返回
        return deviceDO.getId();
    }

    @Override
    public void update(DeviceSaveReqVO updateReqVO) {
        // 校验存在
        validateExists(updateReqVO.getId());
        // 更新
        DeviceDO updateObj = BeanUtils.toBean(updateReqVO, DeviceDO.class);
        deviceMapper.updateById(updateObj);
    }

    @Override
    public void delete(Long id) {
        // 校验存在
        validateExists(id);
        // 删除
        deviceMapper.deleteById(id);
    }

    private void validateExists(Long id) {
        if (deviceMapper.selectById(id) == null) {
            throw exception(DEVICE_NOT_EXISTS);
        }
    }

    @Override
    public DeviceDO get(Long id) {
        return deviceMapper.selectById(id);
    }

    @Override
    public PageResult<DeviceDO> getPage(DevicePageReqVO pageReqVO) {
        return deviceMapper.selectPage(pageReqVO);
    }

}