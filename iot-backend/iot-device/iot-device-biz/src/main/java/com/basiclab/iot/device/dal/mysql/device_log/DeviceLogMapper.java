package com.basiclab.iot.device.dal.mysql.device_log;

import com.basiclab.iot.framework.common.pojo.PageResult;
import com.basiclab.iot.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.basiclab.iot.framework.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;
import com.basiclab.iot.device.controller.admin.device_log.vo.*;

/**
 * 设备日志 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface DeviceLogMapper extends BaseMapperX<com.basiclab.iot.device.dal.dataobject.device.log.DeviceLogDO> {

    default PageResult<com.basiclab.iot.device.dal.dataobject.device.log.DeviceLogDO> selectPage(DeviceLogPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<com.basiclab.iot.device.dal.dataobject.device.log.DeviceLogDO>()
                .eqIfPresent(com.basiclab.iot.device.dal.dataobject.device.log.DeviceLogDO::getDid, reqVO.getDid())
                .eqIfPresent(com.basiclab.iot.device.dal.dataobject.device.log.DeviceLogDO::getFileUrl, reqVO.getFileUrl())
                .betweenIfPresent(com.basiclab.iot.device.dal.dataobject.device.log.DeviceLogDO::getUploadTime, reqVO.getUploadTime())
                .likeIfPresent(com.basiclab.iot.device.dal.dataobject.device.log.DeviceLogDO::getFileName, reqVO.getFileName())
                .eqIfPresent(com.basiclab.iot.device.dal.dataobject.device.log.DeviceLogDO::getFileSize, reqVO.getFileSize())
                .eqIfPresent(com.basiclab.iot.device.dal.dataobject.device.log.DeviceLogDO::getRemark, reqVO.getRemark())
                .eqIfPresent(com.basiclab.iot.device.dal.dataobject.device.log.DeviceLogDO::getStatus, reqVO.getStatus())
                .eqIfPresent(com.basiclab.iot.device.dal.dataobject.device.log.DeviceLogDO::getCreatedBy, reqVO.getCreatedBy())
                .betweenIfPresent(com.basiclab.iot.device.dal.dataobject.device.log.DeviceLogDO::getCreatedTime, reqVO.getCreatedTime())
                .eqIfPresent(com.basiclab.iot.device.dal.dataobject.device.log.DeviceLogDO::getUpdatedBy, reqVO.getUpdatedBy())
                .betweenIfPresent(com.basiclab.iot.device.dal.dataobject.device.log.DeviceLogDO::getUpdatedTime, reqVO.getUpdatedTime())
                .orderByDesc(com.basiclab.iot.device.dal.dataobject.device.log.DeviceLogDO::getId));
    }

}