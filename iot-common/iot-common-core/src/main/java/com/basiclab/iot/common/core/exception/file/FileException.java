package com.basiclab.iot.common.core.exception.file;

import com.basiclab.iot.common.core.exception.base.BaseException;

/**
 * 文件信息异常类
 * 
 * @author BasicLab基础架构实验室
 */
public class FileException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args)
    {
        super("file", code, args, null);
    }

}
