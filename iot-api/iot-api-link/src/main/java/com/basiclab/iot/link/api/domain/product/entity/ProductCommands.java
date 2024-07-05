package com.basiclab.iot.link.api.domain.product.entity;

import com.basiclab.iot.common.core.web.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.*;
import lombok.experimental.Accessors;

/**

* @Description:    java类作用描述
* @Author:         BasiclabIoT
* @E-mail:         andywebjava@163.com
* @Website:        https://gitee.com/vegetable-chicken-blog/basiclab-iot
* @CreateDate:     2021/12/25$ 23:52$
* @UpdateUser:     BasiclabIoT
* @UpdateDate:     2021/12/25$ 23:52$
* @UpdateRemark:   修改内容
* @Version:        1.0

*/
/**
    * 产品模型设备服务命令表
    */
@ApiModel(value="产品模型设备服务命令表")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Accessors(chain = true)
@Builder
public class ProductCommands extends BaseEntity implements Serializable {
    /**
    * 命令id
    */
    @ApiModelProperty(value="命令id")
    private Long id;

    /**
    * 服务ID
    */
    @ApiModelProperty(value="服务ID")
    private Long serviceId;

    /**
    * 指示命令的名字，如门磁的LOCK命令、摄像头的VIDEO_RECORD命令，命令名与参数共同构成一个完整的命令。
支持英文大小写、数字及下划线，长度[2,50]。

    */
    @ApiModelProperty(value="指示命令的名字，如门磁的LOCK命令、摄像头的VIDEO_RECORD命令，命令名与参数共同构成一个完整的命令。,支持英文大小写、数字及下划线，长度[2,50]。,")
    private String name;

    /**
    * 命令描述。
    */
    @ApiModelProperty(value="命令描述。")
    private String description;


    private static final long serialVersionUID = 1L;
}