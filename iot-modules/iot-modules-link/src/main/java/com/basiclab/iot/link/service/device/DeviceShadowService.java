package com.basiclab.iot.link.service.device;


import com.basiclab.iot.link.api.domain.device.vo.query.DeviceShadowPageQuery;
import com.basiclab.iot.link.api.domain.product.vo.result.ProductResultVO;

/**
 * -----------------------------------------------------------------------------
 * 文件名称: DeviceShadowService.java
 * -----------------------------------------------------------------------------
 * 描述:
 * 设备影子业务接口
 * -----------------------------------------------------------------------------
 *
 * @author BasicLab基础架构实验室
 * @version 1.0
 * -----------------------------------------------------------------------------
 * 修改历史:
 * 日期           作者          版本        描述
 * --------      --------     -------   --------------------
 * <p>
 * -----------------------------------------------------------------------------
 * @email andywebjava@163.com
 * @date 2023-10-12 19:49
 */
public interface DeviceShadowService {

    /**
     * 查询设备影子信息
     *
     * @param deviceShadowPageQuery 查询参数
     * @return {@link ProductResultVO} 设备影子信息
     */
    ProductResultVO queryDeviceShadow(DeviceShadowPageQuery deviceShadowPageQuery);
}
