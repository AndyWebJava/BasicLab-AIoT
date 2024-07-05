package com.basiclab.iot.tdengine.service;


import com.basiclab.iot.tdengine.api.domain.Weather;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: BasiclabIoT
 * @E-mail: andywebjava@163.com
 * @Website: https://gitee.com/vegetable-chicken-blog/basiclab-iot
 * @CreateDate: 2021/12/26$ 21:52$
 * @UpdateUser: BasiclabIoT
 * @UpdateDate: 2021/12/26$ 21:52$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface WeatherService {

    int init();

    int count();

    List<Weather> query(Long limit, Long offset);

    int save(float temperature, float humidity);

    List<String> getSubTables();

    List<Weather> avg();

    Weather lastOne();
}
