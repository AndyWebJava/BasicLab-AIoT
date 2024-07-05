package com.basiclab.iot.common.core.exception.user;

import com.basiclab.iot.common.core.exception.base.BaseException;

/**
 * 用户信息异常类
 * 
 * @author BasicLab基础架构实验室
 */
public class UserException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}
