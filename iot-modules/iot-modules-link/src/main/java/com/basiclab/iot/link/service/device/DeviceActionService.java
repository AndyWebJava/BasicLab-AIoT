package com.basiclab.iot.link.service.device;

import com.alibaba.fastjson.JSONObject;
import com.basiclab.iot.link.api.domain.device.entity.DeviceAction;

import java.util.List;

/**
 * @Description: 设备动作数据Service接口
 * @Author: BasiclabIoT
 * @E-mail: andywebjava@163.com
 * @Website: https://gitee.com/vegetable-chicken-blog/basiclab-iot
 * @CreateDate: 2021/12/26$ 0:27$
 * @UpdateUser: BasiclabIoT
 * @UpdateDate: 2021/12/26$ 0:27$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface DeviceActionService {


    int deleteByPrimaryKey(Long id);

    int insert(DeviceAction record);

    int insertOrUpdate(DeviceAction record);

    int insertOrUpdateSelective(DeviceAction record);

    int insertOrUpdateWithBLOBs(DeviceAction record);

    int insertSelective(DeviceAction record);

    DeviceAction selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DeviceAction record);

    int updateByPrimaryKeyWithBLOBs(DeviceAction record);

    int updateByPrimaryKey(DeviceAction record);

    int updateBatch(List<DeviceAction> list);

    int updateBatchSelective(List<DeviceAction> list);

    int batchInsert(List<DeviceAction> list);

    /**
     * 设备连接事件
     *
     * @param basiclabiotMessage
     */
    void connectEvent(JSONObject basiclabiotMessage);

    /**
     * 设备断开事件
     *
     * @param basiclabiotMessage
     */
    void closeEvent(JSONObject basiclabiotMessage);

    /**
     * 查询设备动作数据
     *
     * @param id 设备动作数据主键
     * @return 设备动作数据
     */
    public DeviceAction selectDeviceActionById(Long id);

    /**
     * 查询设备动作数据列表
     *
     * @param deviceAction 设备动作数据
     * @return 设备动作数据集合
     */
    public List<DeviceAction> selectDeviceActionList(DeviceAction deviceAction);

    /**
     * 新增设备动作数据
     *
     * @param deviceAction 设备动作数据
     * @return 结果
     */
    public int insertDeviceAction(DeviceAction deviceAction);

    /**
     * 修改设备动作数据
     *
     * @param deviceAction 设备动作数据
     * @return 结果
     */
    public int updateDeviceAction(DeviceAction deviceAction);

    /**
     * 批量删除设备动作数据
     *
     * @param ids 需要删除的设备动作数据主键集合
     * @return 结果
     */
    public int deleteDeviceActionByIds(Long[] ids);

    /**
     * 删除设备动作数据信息
     *
     * @param id 设备动作数据主键
     * @return 结果
     */
    public int deleteDeviceActionById(Long id);

    /**
     * 保存事件动作
     *
     * @param basiclabiotMessage
     */
    void insertEvent(JSONObject basiclabiotMessage);

    /**
     * 刷新设备缓存
     * @param basiclabiotMessage
     */
    void refreshDeviceCache(JSONObject basiclabiotMessage);
}


