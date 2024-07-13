package com.basiclab.iot.device.dal.mysql.device_group;

import com.basiclab.iot.framework.common.pojo.PageResult;
import com.basiclab.iot.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.basiclab.iot.framework.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;
import com.basiclab.iot.device.controller.admin.device_group.vo.*;

/**
 * 设备分组 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface DeviceGroupMapper extends BaseMapperX<com.basiclab.iot.device.dal.dataobject.device.group.DeviceGroupDO> {

    default PageResult<com.basiclab.iot.device.dal.dataobject.device.group.DeviceGroupDO> selectPage(DeviceGroupPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<com.basiclab.iot.device.dal.dataobject.device.group.DeviceGroupDO>()
                .likeIfPresent(com.basiclab.iot.device.dal.dataobject.device.group.DeviceGroupDO::getGroupName, reqVO.getGroupName())
                .eqIfPresent(com.basiclab.iot.device.dal.dataobject.device.group.DeviceGroupDO::getCreateBy, reqVO.getCreateBy())
                .betweenIfPresent(com.basiclab.iot.device.dal.dataobject.device.group.DeviceGroupDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(com.basiclab.iot.device.dal.dataobject.device.group.DeviceGroupDO::getUpdateBy, reqVO.getUpdateBy())
                .orderByDesc(com.basiclab.iot.device.dal.dataobject.device.group.DeviceGroupDO::getId));
    }

}