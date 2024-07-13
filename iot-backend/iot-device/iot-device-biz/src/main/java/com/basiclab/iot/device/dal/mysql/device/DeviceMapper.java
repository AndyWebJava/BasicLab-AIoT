package com.basiclab.iot.device.dal.mysql.device;

import com.basiclab.iot.framework.common.pojo.PageResult;
import com.basiclab.iot.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.basiclab.iot.framework.mybatis.core.mapper.BaseMapperX;
import com.basiclab.iot.device.dal.dataobject.device.DeviceDO;
import com.basiclab.iot.device.controller.admin.device.vo.*;
import org.apache.ibatis.annotations.Mapper;

/**
 * 设备 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface DeviceMapper extends BaseMapperX<DeviceDO> {

    default PageResult<DeviceDO> selectPage(DevicePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<DeviceDO>()
                .eqIfPresent(DeviceDO::getDid, reqVO.getDid())
                .likeIfPresent(DeviceDO::getName, reqVO.getName())
                .eqIfPresent(DeviceDO::getDescription, reqVO.getDescription())
                .eqIfPresent(DeviceDO::getEnabledStatus, reqVO.getEnabledStatus())
                .eqIfPresent(DeviceDO::getConnectStatus, reqVO.getConnectStatus())
                .eqIfPresent(DeviceDO::getPid, reqVO.getPid())
                .eqIfPresent(DeviceDO::getCreateBy, reqVO.getCreateBy())
                .betweenIfPresent(DeviceDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(DeviceDO::getUpdateBy, reqVO.getUpdateBy())
                .eqIfPresent(DeviceDO::getRemark, reqVO.getRemark())
                .eqIfPresent(DeviceDO::getDeviceVersion, reqVO.getDeviceVersion())
                .eqIfPresent(DeviceDO::getDeviceSn, reqVO.getDeviceSn())
                .eqIfPresent(DeviceDO::getIpAddress, reqVO.getIpAddress())
                .eqIfPresent(DeviceDO::getMacAddress, reqVO.getMacAddress())
                .eqIfPresent(DeviceDO::getActiveStatus, reqVO.getActiveStatus())
                .eqIfPresent(DeviceDO::getExtension, reqVO.getExtension())
                .betweenIfPresent(DeviceDO::getActivatedTime, reqVO.getActivatedTime())
                .betweenIfPresent(DeviceDO::getLastOnlineTime, reqVO.getLastOnlineTime())
                .eqIfPresent(DeviceDO::getParentDid, reqVO.getParentDid())
                .eqIfPresent(DeviceDO::getDeviceType, reqVO.getDeviceType())
                .eqIfPresent(DeviceDO::getLatitude, reqVO.getLatitude())
                .eqIfPresent(DeviceDO::getLongitude, reqVO.getLongitude())
                .likeIfPresent(DeviceDO::getLocationName, reqVO.getLocationName())
                .eqIfPresent(DeviceDO::getProvinceCode, reqVO.getProvinceCode())
                .eqIfPresent(DeviceDO::getCityCode, reqVO.getCityCode())
                .eqIfPresent(DeviceDO::getRegionCode, reqVO.getRegionCode())
                .likeIfPresent(DeviceDO::getProductName, reqVO.getProductName())
                .eqIfPresent(DeviceDO::getIsShadow, reqVO.getIsShadow())
                .eqIfPresent(DeviceDO::getThingsModelValue, reqVO.getThingsModelValue())
                .eqIfPresent(DeviceDO::getProductTypeId, reqVO.getProductTypeId())
                .likeIfPresent(DeviceDO::getProductTypeName, reqVO.getProductTypeName())
                .eqIfPresent(DeviceDO::getGroupId, reqVO.getGroupId())
                .orderByDesc(DeviceDO::getId));
    }

}