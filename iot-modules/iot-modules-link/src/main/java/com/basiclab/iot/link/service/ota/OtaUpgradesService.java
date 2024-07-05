package com.basiclab.iot.link.service.ota;

import com.basiclab.iot.common.core.exception.ArgumentException;
import com.basiclab.iot.link.api.domain.ota.vo.save.OtaUpgradesSaveVO;
import com.basiclab.iot.link.api.domain.ota.vo.update.OtaUpgradesUpdateVO;

public interface OtaUpgradesService {
    /**
     * Save OTA Upgrade Package
     *
     * @param saveVO 保存参数
     * @return {@link OtaUpgradesSaveVO} 返回结果
     */
    OtaUpgradesSaveVO saveUpgradePackage(OtaUpgradesSaveVO saveVO);

    /**
     * Update OTA Upgrade Package
     *
     * @param updateVO 更新参数
     * @return {@link OtaUpgradesUpdateVO} 返回结果
     */
    OtaUpgradesUpdateVO updateUpgradePackage(OtaUpgradesUpdateVO updateVO);

    /**
     * Update OTA Upgrade Package Status
     *
     * @param id     主键
     * @param status 状态
     * @return {@link Boolean} 返回结果
     */
    Boolean updateOtaUpgradeStatus(Long id, Integer status) throws ArgumentException;

    Boolean deleteOtaUpgrade(Long id) throws ArgumentException;
}
