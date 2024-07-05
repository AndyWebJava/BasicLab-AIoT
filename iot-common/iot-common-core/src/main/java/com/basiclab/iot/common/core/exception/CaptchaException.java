package com.basiclab.iot.common.core.exception;

/**
 * 验证码错误异常类
 * 
 * @author BasicLab基础架构实验室
 */
public class CaptchaException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public CaptchaException(String msg)
    {
        super(msg);
    }
}
