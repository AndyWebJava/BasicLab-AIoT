package com.basiclab.iot.common.core.exception.user;

/**
 * 验证码失效异常类
 * 
 * @author BasicLab基础架构实验室
 */
public class CaptchaExpireException extends UserException
{
    private static final long serialVersionUID = 1L;

    public CaptchaExpireException()
    {
        super("user.jcaptcha.expire", null);
    }
}
