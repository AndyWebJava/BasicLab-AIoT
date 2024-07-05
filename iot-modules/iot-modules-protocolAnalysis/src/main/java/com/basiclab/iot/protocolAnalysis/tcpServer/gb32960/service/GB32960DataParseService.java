package com.basiclab.iot.protocolAnalysis.tcpServer.gb32960.service;

import io.netty.channel.ChannelHandlerContext;

/**
 * @Description: gb32960实时数据解析接口
 * @Author: BasiclabIoT
 * @E-mail: andywebjava@163.com
 * @Website: https://gitee.com/vegetable-chicken-blog/basiclab-iot
 * @CreateDate: 2021/11/15$ 18:30$
 * @UpdateUser: BasiclabIoT
 * @UpdateDate: 2021/11/15$ 18:30$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */

public interface GB32960DataParseService {

    /**
     * 实时数据解析并返回数据
     *
     * @param readDatas
     */
    String realTimeDataParseAndPushData(ChannelHandlerContext ctx, String readDatas) throws Exception;
}
