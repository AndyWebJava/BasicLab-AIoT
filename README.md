# BasicLab-IoT Platform
<div align="center">
    <img src=".image/BasicLabLogo.png" width="50%" height="50%" alt="BasicLabLogo">
</div>

<div align="center">
    <img src="https://gitee.com/vegetable-chicken-blog/basiclab-iot/badge/star.svg" alt="GitEE stars">
    <img src="https://gitee.com/vegetable-chicken-blog/basiclab-iot/badge/fork.svg" alt="GitEE forks">
    <img src="https://img.shields.io/badge/version-v1.0-brightgreen.svg" alt="GitEE version">
    <img src="https://img.shields.io/badge/License-AGPL%203.0-blue.svg" alt="GitEE license">
</div>

## Demo address (account/password in the communication group)
http://pro.basiclab.top:8888/

## The goal of BasicLab
The original intention of BasicLab was to enable traditional enterprises to complete the most cutting-edge digital upgrading and transformation in the shortest time, lowest cost, and fastest speed after integrating into the BasicLab full product ecosystem, which can help traditional enterprises complete digital industry upgrading.

## The Origin of BasicLab
BasicLab is guided by the National 2035 Vision Policy and was conceived three years ago. The entire product system will use seven development languages and is operated by individuals in their spare time. Its purpose is to help traditional enterprises complete the upgrading and transformation of the National 2035 digital industry at a lower cost, and achieve social goals.

## Open source of BasicLab
The BasicLab IoT platform is one of the many IoT platforms in the BasicLab infrastructure laboratory. It is an open-source IoT cloud platform built on SpringBoot and SpringCloud, aiming to provide a one-stop solution for device connection, data collection, processing, and analysis. This project uses PostgreSQL as a relational database to store core data and follows the Apache 2.0 license agreement, encouraging community contribution and business friendly use.

## Product System Planning for BasicLab
The BasicLab product system plan includes the following content:
<div align="left">
    <img src=".image/Basi[README.zh_CN.md](README.zh_CN.md)cLab产品体系规划.png" width="70%" height="70%" alt="产品体系规划">
</div>

## BasicLab-IoT Internet of Things Platform
The BasicLab-IoT platform, as one of the many products in the BasicLab infrastructure laboratory, is an open-source IoT cloud platform built on SpringBoot and SpringCloud, aimed at providing a one-stop solution for device connectivity, data collection, processing, and analysis. This project uses PostgreSQL as a relational database to store core data and follows the Apache 2.0 license agreement, encouraging community contribution and business friendly use.

### BasicLab-IoT architecture diagram
![BasicLabIoT物联网平台架构.jpg](.image/BasicLabIoT物联网平台架构.jpg)
![BasicLabIoT物联网平台设备接入流程.jpg](.image/BasicLabIoT物联网平台设备接入流程.jpg)

### BasicLab full product system hierarchical architecture diagram
![BasicLab全产品体系层次架构图.jpg](.image/BasicLab全产品体系层次架构图.jpg)

## Introduction

BasicLab-IoT Platform is one of the many products in the BasicLab Infrastructure Laboratory. It is an open-source IoT cloud platform built on SpringBoot and SpringCloud, aiming to provide a one-stop solution for device connectivity, data collection, processing, and analysis. This project uses PostgreSQL as a relational database to store core data and follows the Apache 2.0 license agreement, encouraging community contribution and business friendly use.

## Technology stack
-- Adopting a front-end and back-end separation mode, the front-end framework VUE.
-- The backend adopts Spring Boot Spring Cloud & Alibaba。
-- The device gateway is based on Emqx Netty、Reactor3、Reactor-netty。
-- Choose Nacos for registration center and configuration center, and use Redis for permission authentication.
-- Select Sentinel for flow control framework and Seata for distributed transactions.
-- The temporal database adopts TDengine's open-source and efficient IoT big data platform to handle massive IoT data writing and load queries.

## Function List
-- System management: user management, role management, menu management, department management, position management, dictionary management, parameter setting, notification and announcement, log management
-- System monitoring: online users, scheduled tasks, Sentinel console, Nacos console, Admin console, task scheduling management
-- System tools: form construction, code generation, system interfaces
-- Device integration: device management, sub device management, product management, protocol management, rule engine, object model
-- Rule engine message forwarding: supports KAFKA nodes, HTTP nodes, PREDICATE nodes, ROCKET-MQ nodes, RABBIT-MQ nodes, MYSQL nodes, MQTT nodes, TOPIC nodes, and LOG nodes (added to knowledge planet acquisition)

## Technology stack
- Backend: SpringBoot, SpringCloud
- Database: PostgreSQL
- Protocol: HTTP/HTTPS/MQTT/ModBus/SIP
- License: Apache License 2.0

## Environmental requirements
- Java 8+
- Maven 3.6+
- PostgreSQL 13+

## System screenshot
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

## Contact information(The SQL script for BasicLab IoT IoT platform is in the group, and it is not easy for individuals to open source. Please click on STAR. Thank you.)
If you need to communicate more about the BasicLab IoT open source platform content, or if you want to learn about the full set of BasicLab infrastructure products, you can join the group through WeChat:
<div align="left">
    <img src=".image/wechart.jpg" width="70%" height="70%" alt="wechart">
</div>

## Documents and Support
The Knowledge Planet documentation includes detailed development guides, API documentation, and deployment tutorials. If needed, you can join the planet yourself (the documentation can be purchased if needed, treat the author to a meal)
![img.png](.image/知识星球.png)

## issues(Welcome everyone to provide valuable feedback)
[issues](https://github.com/AndyWebJava/basiclab-iot/issues)

## Welcome to submit PR
[pr->feat/contrbute](https://github.com/AndyWebJava/basiclab-iot/pulls)

## License (Open Source Protocol)
[Apache License, Version 2.0](LICENSE)

## Copyright usage instructions
The BasicLab-IoT platform follows the Apache License, Version 2.0 (LICENSE) protocol. Commercial use is allowed, but class author and copyright information must be retained.