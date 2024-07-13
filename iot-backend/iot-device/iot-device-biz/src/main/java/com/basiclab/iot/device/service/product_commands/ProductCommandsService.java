package com.basiclab.iot.device.service.product_commands;

import javax.validation.*;
import com.basiclab.iot.device.controller.admin.product_commands.vo.*;
import com.basiclab.iot.device.dal.dataobject.product_commands.ProductCommandsDO;
import com.basiclab.iot.framework.common.pojo.PageResult;

/**
 * 产品模型设备服务命令 Service 接口
 *
 * @author 芋道源码
 */
public interface ProductCommandsService {

    /**
     * 创建产品模型设备服务命令
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createCommands(@Valid ProductCommandsSaveReqVO createReqVO);

    /**
     * 更新产品模型设备服务命令
     *
     * @param updateReqVO 更新信息
     */
    void updateCommands(@Valid ProductCommandsSaveReqVO updateReqVO);

    /**
     * 删除产品模型设备服务命令
     *
     * @param id 编号
     */
    void deleteCommands(Long id);

    /**
     * 获得产品模型设备服务命令
     *
     * @param id 编号
     * @return 产品模型设备服务命令
     */
    ProductCommandsDO getCommands(Long id);

    /**
     * 获得产品模型设备服务命令分页
     *
     * @param pageReqVO 分页查询
     * @return 产品模型设备服务命令分页
     */
    PageResult<ProductCommandsDO> getCommandsPage(ProductCommandsPageReqVO pageReqVO);

}