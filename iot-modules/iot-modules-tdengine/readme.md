## TDengine SpringBoot + Mybatis Demo  
## 超级表设计概念：每个设备一张表,每类设备一个超级表 ;
## 超级表命名规则 : 产品类型_产品标识_服务名称
## 子表命名规则 : 产品类型_产品标识_服务名称_设备标识（设备唯一标识）


## TDengine 服务端版本及搭建
### 推荐版本  tdengine/tdengine:3.0.0.0
### TDengine官方搭建教程：https://www.taosdata.com/docs/cn/v3.0/getting-started/docker

# #### 安装TDengine
# 1. 拉取镜像文件
docker pull tdengine/tdengine:3.0.0.0
# 2. 创建运行容器
docker run -d --name iot-tdengine  -v /home/taos/log:/var/log/taos -v /home/taos/data:/var/lib/taos  -p 6030-6049:6030-6049 -p 6030-6049:6030-6049/udp tdengine/tdengine:3.0.0.0
# 3. 指定basiclabiot库生成一亿条测试数据
taosBenchmark -d basiclabiot -y -M -S 600000
# 4.客户端连接工具
TDengineGUI

### 配置 application.properties
```properties
# datasource config
spring.datasource.driver-class-name=com.taosdata.jdbc.TSDBDriver
spring.datasource.url=jdbc:TAOS://127.0.0.1:6030/basiclabiot
spring.datasource.username=root
spring.datasource.password=taosdata

spring.datasource.druid.initial-size=5
spring.datasource.druid.min-idle=5
spring.datasource.druid.max-active=5
# max wait time for get connection, ms
spring.datasource.druid.max-wait=60000

spring.datasource.druid.validation-query=select server_status();
spring.datasource.druid.validation-query-timeout=5000
spring.datasource.druid.iot-on-borrow=false
spring.datasource.druid.iot-on-return=false
spring.datasource.druid.iot-while-idle=true
spring.datasource.druid.time-between-eviction-runs-millis=60000
spring.datasource.druid.min-evictable-idle-time-millis=600000
spring.datasource.druid.max-evictable-idle-time-millis=900000

# mybatis
mybatis.mapper-locations=classpath:mapper/*.xml

# log 
logging.level.com.taosdata.jdbc.springbootdemo.dao=debug
```

### 主要功能

* 创建数据库和表
```xml
<!-- weatherMapper.xml -->
 <update id="createDB" >
        create database if not exists basiclabiot;
    </update>

    <update id="createTable" >
        create table if not exists basiclabiot.weather(ts timestamp, temperature int, humidity float);
    </update>
```

* 插入单条记录
```xml
<!-- weatherMapper.xml -->
    <insert id="insert" parameterType="Weather" >
        insert into basiclabiot.weather (ts, temperature, humidity) values (now, #{temperature,jdbcType=INTEGER}, #{humidity,jdbcType=FLOAT})
    </insert>
```
* 插入多条记录
```xml
<!-- weatherMapper.xml -->
<insert id="batchInsert" parameterType="java.util.List" >
    insert into basiclabiot.weather (ts, temperature, humidity) values
    <foreach separator=" " collection="list" item="weather" index="index" >
        (now + #{index}a, #{weather.temperature}, #{weather.humidity})
    </foreach>
</insert>
```
* 分页查询
```xml
<!-- weatherMapper.xml -->
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="WeatherMapper">

    <resultMap id="BaseResultMap" type="Weather">
        <id column="ts" jdbcType="TIMESTAMP" property="ts" />
        <result column="temperature" jdbcType="INTEGER" property="temperature" />
        <result column="humidity" jdbcType="FLOAT" property="humidity" />
    </resultMap>

    <sql id="Base_Column_List">
        ts, temperature, humidity
    </sql>

    <select id="select" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List" />
        from basiclabiot.weather
        order by ts desc
        <if test="limit != null">
            limit #{limit,jdbcType=BIGINT}
        </if>
        <if test="offset != null">
            offset #{offset,jdbcType=BIGINT}
        </if>
    </select>
</mapper>
```

