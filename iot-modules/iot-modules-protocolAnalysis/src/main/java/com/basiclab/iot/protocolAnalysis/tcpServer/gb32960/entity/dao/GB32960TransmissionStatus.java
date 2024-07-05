package com.basiclab.iot.protocolAnalysis.tcpServer.gb32960.entity.dao;

import lombok.Data;

/**
 * @Description:
 * @Author: BasiclabIoT
 * @E-mail: andywebjava@163.com
 * @CreateDate: 2021/11/5$ 16:33$
 * @UpdateUser: BasiclabIoT
 * @UpdateDate: 2021/11/5$ 16:33$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Data
public class GB32960TransmissionStatus {

    /**
     * 档位
     */
    private Integer gear;

    private boolean hasDriverForce;
    private boolean hasBrakingForce;

}