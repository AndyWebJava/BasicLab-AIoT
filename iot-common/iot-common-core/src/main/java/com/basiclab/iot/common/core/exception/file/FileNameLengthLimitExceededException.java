package com.basiclab.iot.common.core.exception.file;

/**
 * 文件名称超长限制异常类
 * 
 * @author BasicLab基础架构实验室
 */
public class FileNameLengthLimitExceededException extends FileException
{
    private static final long serialVersionUID = 1L;

    public FileNameLengthLimitExceededException(int defaultFileNameLength)
    {
        super("upload.filename.exceed.length", new Object[] { defaultFileNameLength });
    }
}
