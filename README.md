# BasicLab-IoT物联网平台
<div align="center">
    <img src=".image/BasicLabLogo.png" width="50%" height="50%" alt="BasicLabLogo">
</div>

<div align="center">
    <img src="https://gitee.com/vegetable-chicken-blog/basiclab-iot/badge/star.svg" alt="GitEE stars">
    <img src="https://gitee.com/vegetable-chicken-blog/basiclab-iot/badge/fork.svg" alt="GitEE forks">
    <img src="https://img.shields.io/badge/version-v1.0-brightgreen.svg" alt="GitEE version">
    <img src="https://img.shields.io/badge/License-AGPL%203.0-blue.svg" alt="GitEE license">
</div>

## PRO版本演示地址（开源版本不提供演示）
演示环境：http://pro.basiclab.top:8888/

## PRO与开源版本区别
| 开源版本   |              开源版本               |                                                                                                                 PRO版本                                                                                                                  |
|:------:|:-------------------------------:|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
|  许可协议 |            AGPL3.0协议            |                                                                                                                  永久授权                                                                                                                  |
|  系统用途   |        非商业用途，仅用于个人学习和使用         |                                                                                                             商业用途，提供所有源码和文档                                                                                                             |
|  系统功能 | 权限管理、系统监控、物模型管理、产品管理、设备管理、硬件SDK | 权限管理、系统监控、物模型管理、产品管理、设备管理、硬件SDK、设备告警、场景联动、分屏监控、摄像头点播、设备录像、云端录像、云台控制、拉流管理、节点管理、多租户、大屏展示、数据可视化平台、移动端（安卓 / 苹果 / 微信小程序）、Netty-mqtt、Emqx的扩展支持、Modbus设备接入、TCP设备接入、开发中功能 ... |
|  授权费用 |             免费，不能商用             |                                                                                                            5万元，提供发票/合同/授权书                                                                                                             |
|  相关服务 |              定期更新               |                                                                                                          加入商业版私有仓库，赠送一年的订阅更新                                                                                                           |
|  技术支持 |              微信群交流              |                                                                                                            企业用户群交流，提供必要技术支持                                                                                                            |
|  代码更新 |               Gitee、Github更新                |                                                                                                                Git私服更新                                                                                                                 |


| 其他服务   |             价格             |                   说明                   |
|:------:|:--------------------------:|:--------------------------------------:|
|  定制开发 |        1000-3000元/日        |          服务端、前端、移动端、硬件端、UI设计           |
|  技术支持   |         200-500元/时         |          设备接入、项目部署、移动端发布和上架等           |
|  订阅更新 | 一年1.8w，两年1.68w/年，三年1.56w/年 |                    老用户订阅到期，增量功能可以补差价                    |

## BasicLab的产品体系规划
BasicLab产品体系规划包含以下内容：
<div align="left">
    <img src=".image/BasicLab产品体系规划.png" width="70%" height="70%" alt="产品体系规划">
</div>

## BasicLab-IoT物联网平台
BasicLab-IoT物联网平台作为BasicLab基础架构实验室众多产品中的物联网平台，它是一个基于SpringBoot与SpringCloud构建的开源物联网云平台，旨在为设备连接、数据采集、处理与分析提供一站式解决方案。本项目采用PostgreSQL作为关系型数据库存储核心数据，并遵循Apache 2.0许可协议，鼓励社区贡献与商业友好使用。

### BasicLab-IoT物联网平台架构图
![BasicLab-IoT平台架构.jpg](.image/BasicLabIoT物联网平台架构.jpg)
![BasicLab-IoT平台设备接入流程.jpg](.image/BasicLabIoT物联网平台设备接入流程.jpg)

### BasicLab全产品体系层次架构图
![BasicLab全产品体系层次架构图.jpg](.image/BasicLab全产品体系层次架构图.jpg)

## 技术栈
1、采用前后端分离的模式，前端框架VUE。

2、后端采用Spring Boot、Spring Cloud & Alibaba。

3、设备网关基于Emqx、Netty、Reactor3、Reactor-netty。

4、注册中心、配置中心选型Nacos，权限认证使用Redis。

5、流量控制框架选型Sentinel，分布式事务选型Seata。

6、时序数据库采用TDengine开源、高效的物联网大数据平台、处理物联网海量数据写入与负载查询。

## 功能列表

1、系统管理：用户管理、角色管理、菜单管理、部门管理、岗位管理、字典管理、参数设置、通知公告、日志管理

2、系统监控：在线用户、定时任务、Sentinel控制台、Nacos控制台、Admin控制台、任务调度管理

3、系统工具：表单构建、代码生成、系统接口

4、设备集成：设备管理、子设备管理、产品管理、协议管理、规则引擎、物模型

5、规则引擎消息转发：支持KAFKA节点、HTTP节点、PREDICATE节点、ROCKET_MQ节点、RABBIT_MQ节点、MYSQL节点、MQTT节点、TOPIC节点、LOG节点

## 技术栈

- 后端：SpringBoot, SpringCloud
- 数据库：PostgreSQL
- 协议：HTTP/HTTPS
- 许可证：Apache License 2.0

## 环境需求
- Java 8+
- Maven 3.6+
- PostgreSQL 13+

## 系统截图
<div align="left">
    <img src=".image/banner/banner1.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner2.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner28.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner14.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner16.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner17.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner18.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner19.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner20.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner32.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner34.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner33.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner31.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner8.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner9.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner10.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner21.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner22.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner23.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner24.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner25.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner26.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner12.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner13.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner27.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner29.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner30.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner3.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner4.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner5.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner6.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner7.png" width="100%" height="100%" alt="">
</div>

## 联系方式
如需交流更多关于BasicLab-IoT物联网平台内容，或者想要了解全套BasicLab基础架构产品，可以通过微信入群：
<div align="left">
    <img src=".image/wechart.jpg" width="70%" height="70%" alt="wechart">
</div>

## issues(欢迎大家提出宝贵意见)

[issues](https://github.com/AndyWebJava/basiclab-iot/issues)

## 欢迎提交 pr

[pr->feat/contrbute](https://github.com/AndyWebJava/basiclab-iot/pulls)

## License(开源协议)

[Apache License, Version 2.0](LICENSE)

## 版权使用说明

BasicLab-IoT平台遵循 [Apache License, Version 2.0](LICENSE) 协议。 允许商业使用，但务必保留类作者、Copyright 信息。