package com.basiclab.iot.link.service.device;

import com.basiclab.iot.link.api.domain.device.entity.DeviceLocation;
import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: BasiclabIoT
 * @E-mail: andywebjava@163.com
 * @Website: https://gitee.com/vegetable-chicken-blog/basiclab-iot
 * @CreateDate: 2021/12/26$ 0:27$
 * @UpdateUser: BasiclabIoT
 * @UpdateDate: 2021/12/26$ 0:27$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface DeviceLocationService {


    int deleteByPrimaryKey(Long id);

    int insert(DeviceLocation record);

    int insertOrUpdate(DeviceLocation record);

    int insertOrUpdateSelective(DeviceLocation record);

    int insertSelective(DeviceLocation record);

    DeviceLocation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DeviceLocation record);

    int updateByPrimaryKey(DeviceLocation record);

    int updateBatch(List<DeviceLocation> list);

    int updateBatchSelective(List<DeviceLocation> list);

    int batchInsert(List<DeviceLocation> list);

    /**
     * 查询设备位置
     *
     * @param id 设备位置主键
     * @return 设备位置
     */
    public DeviceLocation selectDeviceLocationById(Long id);

    /**
     * 查询设备位置列表
     *
     * @param deviceLocation 设备位置
     * @return 设备位置集合
     */
    public List<DeviceLocation> selectDeviceLocationList(DeviceLocation deviceLocation);

    /**
     * 新增设备位置
     *
     * @param deviceLocation 设备位置
     * @return 结果
     */
    public int insertDeviceLocation(DeviceLocation deviceLocation);

    /**
     * 修改设备位置
     *
     * @param deviceLocation 设备位置
     * @return 结果
     */
    public int updateDeviceLocation(DeviceLocation deviceLocation);

    /**
     * 批量删除设备位置
     *
     * @param ids 需要删除的设备位置主键集合
     * @return 结果
     */
    public int deleteDeviceLocationByIds(Long[] ids);



	DeviceLocation findOneByDeviceIdentification(String deviceIdentification);

}


