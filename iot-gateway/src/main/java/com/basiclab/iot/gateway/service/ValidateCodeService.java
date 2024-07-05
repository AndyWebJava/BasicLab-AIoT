package com.basiclab.iot.gateway.service;

import com.basiclab.iot.common.core.exception.CaptchaException;
import com.basiclab.iot.common.core.web.domain.AjaxResult;

import java.io.IOException;

/**
 * 验证码处理
 * 
 * @author BasicLab基础架构实验室
 */
public interface ValidateCodeService
{
    /**
     * 生成验证码
     */
    public AjaxResult createCapcha() throws IOException, CaptchaException;

    /**
     * 校验验证码
     */
    public void checkCapcha(String key, String value) throws CaptchaException;
}
