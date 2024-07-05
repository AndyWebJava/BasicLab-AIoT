package com.basiclab.iot.link.api.domain.protocol;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @program: basiclabiot
 * @description: 动态编译参数
 * @packagename: com.basiclab.basiclabiot.link.api.domain.protocol
 * @author: BasiclabIoT
 * @e-mainl: andywebjava@163.com
 * @date: 2022-08-07 23:45
 **/
@Data
public class CompileXcodeParams implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 方法块
     */
    @NotBlank(message = "脚本方法块不能为空")
    private String code;
    /**
     * 方法块入参
     */
    @NotBlank(message = "脚本方法块入参不能为空")
    private String inparam;
}
