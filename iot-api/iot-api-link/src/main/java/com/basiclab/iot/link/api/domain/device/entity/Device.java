package com.basiclab.iot.link.api.domain.device.entity;

import com.basiclab.iot.common.core.annotation.Excel;
import com.basiclab.iot.common.core.web.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.*;
import lombok.experimental.Accessors;

/**

* @Description:    设备管理
* @Author:         BasiclabIoT
* @E-mail:         andywebjava@163.com
* @Website:        https://gitee.com/vegetable-chicken-blog/basiclab-iot
* @CreateDate:     2021/12/26$ 1:42$
* @UpdateUser:     BasiclabIoT
* @UpdateDate:     2021/12/26$ 1:42$
* @UpdateRemark:   修改内容
* @Version:        1.0

*/

/**
 * 设备管理
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "设备管理")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Accessors(chain = true)
@Builder
public class Device  extends BaseEntity implements Serializable{
    /**
     * id
     */
    @Excel(name = "id", cellType = Excel.ColumnType.NUMERIC, prompt = "id")
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 客户端标识
     */
    @Excel(name = "客户端标识")
    @ApiModelProperty(value = "客户端标识")
    private String clientId;

    /**
     * 用户名
     */
    @Excel(name = "用户名")
    @ApiModelProperty(value = "用户名")
    private String userName;

    /**
     * 密码
     */
    @Excel(name = "密码")
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 应用ID
     */
    @Excel(name = "应用ID")
    @ApiModelProperty(value = "应用ID")
    private String appId;

    /**
     * 认证方式
     */
    @Excel(name = "认证方式")
    @ApiModelProperty(value = "认证方式")
    private String authMode;

    /**
     * 设备标识
     */
    @Excel(name = "设备标识")
    @ApiModelProperty(value = "设备标识")
    private String deviceIdentification;

    /**
     * 设备名称
     */
    @Excel(name = "设备名称")
    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    /**
     * 连接实例
     */
    @Excel(name = "连接实例")
    @ApiModelProperty(value = "连接实例")
    private String connector;

    /**
     * 设备描述
     */
    @Excel(name = "设备描述")
    @ApiModelProperty(value = "设备描述")
    private String deviceDescription;

    /**
     * 设备状态： 启用 || 禁用
     */
    @Excel(name = "设备状态")
    @ApiModelProperty(value = "设备状态： 启用 || 禁用")
    private String deviceStatus;

    /**
     * 连接状态 : 在线：ONLINE || 离线：OFFLINE || 未连接：INIT
     */
    @Excel(name = "连接状态")
    @ApiModelProperty(value = "连接状态 : 在线：ONLINE || 离线：OFFLINE || 未连接：INIT,")
    private String connectStatus;

    /**
     * 是否遗言
     */
    @Excel(name = "是否遗言")
    @ApiModelProperty(value = "是否遗言")
    private String isWill;

    /**
     * 设备标签
     */
    @Excel(name = "设备标签")
    @ApiModelProperty(value = "设备标签")
    private String deviceTags;

    /**
     * 产品标识
     */
    @Excel(name = "产品标识")
    @ApiModelProperty(value = "产品标识")
    private String productIdentification;


    /**
     * 协议类型 ：mqtt || coap || modbus || http
     */
    @Excel(name = "协议类型")
    @ApiModelProperty(value = "协议类型 ：mqtt || coap || modbus || http")
    private String protocolType;

    /**
     * 设备类型
     */
    @Excel(name = "设备类型")
    @ApiModelProperty(value = "设备类型")
    private String deviceType;

    /**
     * 加密密钥
     */
    @Excel(name = "加密密钥")
    @ApiModelProperty(value = "加密密钥")
    private String encryptKey;
    /**
     * 加密向量
     */
    @Excel(name = "加密向量")
    @ApiModelProperty(value = "加密向量")
    private String encryptVector;
    /**
     * 签名密钥
     */
    @Excel(name = "签名密钥")
    @ApiModelProperty(value = "签名密钥")
    private String signKey;
    /**
     * 传输协议的加密方式：0-明文传输、1-SM4、2-AES
     */
    @Excel(name = "传输协议的加密方式")
    @ApiModelProperty(value = "传输协议的加密方式：0-明文传输、1-SM4、2-AES ")
    private String encryptMethod;

    /**
     * 软件版本
     */
    @Excel(name = "软件版本")
    @ApiModelProperty(value = "软件版本")
    private String swVersion;
    /**
     * 固件版本
     */
    @Excel(name = "固件版本")
    @ApiModelProperty(value = "固件版本")
    private String fwVersion;
    /**
     * sdk版本
     */
    @Excel(name = "sdk版本")
    @ApiModelProperty(value = "sdk版本" ,example = "v1",notes = "sdk版本,如v1,v2,v3等")
    private String deviceSdkVersion;


    private static final long serialVersionUID = 1L;
}
