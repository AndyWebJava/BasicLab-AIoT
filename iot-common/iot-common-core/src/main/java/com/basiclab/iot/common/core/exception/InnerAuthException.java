package com.basiclab.iot.common.core.exception;

/**
 * 内部认证异常
 * 
 * @author BasicLab基础架构实验室
 */
public class InnerAuthException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public InnerAuthException(String message)
    {
        super(message);
    }
}
