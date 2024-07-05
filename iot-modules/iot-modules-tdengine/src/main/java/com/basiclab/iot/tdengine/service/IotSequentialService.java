package com.basiclab.iot.tdengine.service;

import com.basiclab.iot.tdengine.api.domain.IotSequential;

import java.util.List;

/**
 * @program: basiclabiot
 * @description:
 * @packagename: com.basiclab.basiclabiot.tdengine.service.impl
 * @author: BasiclabIoT
 * @e-mainl: andywebjava@163.com
 * @date: 2022-11-04 10:50
 **/
public interface IotSequentialService {

    public IotSequential selectByTime(String startTime);

    public List<IotSequential> getList(IotSequential iotSequential);


    public int save(IotSequential iotSequential);
}
