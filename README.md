# BasicLab AIoT Smart Vision IoT Cloud Platform
<div align="center">
    <img src=".image/BasicLabLogo.png" width="50%" height="50%" alt="BasicLabLogo">
</div>

<div align="center">
    <img src="https://gitee.com/vegetable-chicken-blog/basiclab-iot/badge/star.svg" alt="GitEE stars">
    <img src="https://gitee.com/vegetable-chicken-blog/basiclab-iot/badge/fork.svg" alt="GitEE forks">
    <img src="https://img.shields.io/badge/version-v1.0-brightgreen.svg" alt="GitEE version">
    <img src="https://img.shields.io/badge/License-AGPL3.0-blue.svg" alt="GitEE license">
</div>

# Pioneering open source across the entire network: an integrated solution based on video, IoT, and AI services
#### BasicLab AIoT leads the innovation of intelligent visual IoT cloud platform, seamlessly integrating IoT technology, real-time transmission of streaming media cameras, and AI analysis, ushering in a new era of intelligent monitoring and data analysis.

#### We have not only achieved interconnectivity of devices, but also added intelligent eyes to camera monitoring through deep integration of high-definition streaming video streams and cutting-edge AI algorithms - precise execution of face and behavior recognition, behavior analysis, risk personnel screening, and regional intrusion detection, redefining the standards of security monitoring, intelligent manufacturing, and smart city management.

#### This initiative not only improves the real-time and accuracy of data processing, but also greatly expands the boundaries of IoT applications, allowing the ability to "see" and "understand" to spread throughout every IoT node, truly practicing the seamless integration of IoT+streaming media+AI, and promoting digital transformation towards deeper and broader fields.

![BasicLab-IoT平台架构.jpg](.image/BasicLabIoT物联网平台架构.jpg)

## Demo
Address: http://pro.basiclab.top:8888/
Account: admin
Password: admin123

## Application scenarios
#### Suitable for smart campuses, smart cities, smart security, smart agriculture, smart medicine, smart industry, smart energy, construction site safety, public place security, smart parking lots, and smart communities
![赋能行业.jpg](.image/赋能行业.jpg)

## Contact Information
#### QQ communication group: 🚀 913496130

## Gitee synchronized repository
https://gitee.com/vegetable-chicken-blog/BasicLab-AIoT

## Screenshot
<div align="left">
    <img src=".image/banner/banner1.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner14.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner16.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner34.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner33.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner31.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner8.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner9.png" width="100%" height="100%" alt="">
    <img src=".image/banner/banner10.png" width="100%" height="100%" alt="">
</div>

## Function List
- [x] AI Algorithm Services
  - [x] AI video suspicious personnel detection (by analyzing video surveillance footage, automatically identifying individuals who do not conform to conventional behavior patterns, improving security monitoring efficiency)
  - [x] AI suspicious personnel retrieval (quickly searching for specific individuals in a large amount of video materials to assist in security investigations and case solving)
  - [x] AI face retrieval and matching (using face recognition technology to compare face images in a database for identity verification, security monitoring, etc.)
  - [x] AI suspicious behavior recognition (automatically identifying behaviors such as fighting, debris detection, abnormal gathering, crossing fences, entering restricted areas, etc., to prevent security incidents from occurring)
  - [x] AI license plate recognition and tracking (automatically recognizing vehicle license plate information and tracking vehicle travel trajectories, applied in traffic management, parking lot management, and other scenarios)
  - [x] AI crop pest and disease detection (using image recognition technology to identify early signs of pests and diseases on crops, assist in precise pesticide application, and reduce losses)
  - [x] AI natural disaster monitoring (analyzing satellite or ground observation data, early warning of natural disasters such as floods, fires, earthquakes, etc., ensuring the safety of people's lives and property)
  - [ ] In the development of other AI algorithms
- [x] Device access service
  - [x] Video surveillance equipment
  - [x] MQTT protocol
  - [x] TCP protocol
  - [x] UDP protocol
  - [x] HTTP protocol
  - [x] Modubus TCP protocol
  - [x] Modebus RTP protocol
  - [x] OPC UA protocol
  - [x] Copa protocol
  - [x] NB-IOT protocol
  - [x] ZigBee protocol
  - [x] LoRA protocol
- [x] Device Management
  - [x] physical model
  - [x] Product classification
  - [x] Product Template
  - [x] Product Management
  - [x] Protocol management
  - [x] Equipment grouping
  - [x] Equipment List
  - [x] Device details
  - [x] Running status
  - [x] Device logs
  - [x] Device Services
  - [x] Device events
  - [x] Equipment alarm
  - [x] Equipment control
  - [x] Real time monitoring
  - [x] Equipment debugging
  - [x] Data collection
  - [x] Equipment Empowerment
  - [x] Device on-demand
  - [x] Equipment recording
  - [x] Cloud based recording
  - [x] Equipment channel
  - [x] Equipment Batch
  - [x] Device Sharing
  - [x] Equipment distribution network
  - [x] Device Template
  - [x] Edge end mapping
  - [x] Equipment diagnosis
  - [x] Equipment functions
- [x] Rule Engine
  - [x] Event monitoring (real-time monitoring of specific events generated by systems or devices, laying the foundation for automated response)
  - [x] Data filtering (selecting valuable information from received data based on preset conditions to improve processing efficiency)
  - [x] Message storage (securely storing relevant message records triggered by events for subsequent analysis and auditing)
  - [x] Data forwarding (forwarding filtered data or instructions to other systems or devices in real-time to promote collaboration between systems)
  - [x] Data storage (long-term storage of critical data, supporting data analysis and business optimization, providing a basis for intelligent decision-making)
  - [x] KAFKA node: Implement high-throughput real-time streaming data processing.
  - [x] HTTP node: Easily interact with web services and make API calls.
  - [x] Predicate node: Determine the direction of data flow based on specific conditions.
  - [x] ROCKET-MQ node, RABBIT_SQ node: Supports mainstream message queue protocols to achieve asynchronous message passing.
   -MYSQL nodes and POSTGRESQL nodes: directly interact with relational databases to perform data read and write operations.
  - [x] INFLUXDB node, TDENGINE node: A database interface designed specifically for time-series data, suitable for storing time-series data such as sensors.
   -MQTT node: a lightweight messaging protocol suitable for the Internet of Things, especially for resource constrained devices.
   -TOPIC node: A logical entity used in a messaging system to organize and filter messages.
  - [x] LOG node: Record important events or data flow logs for debugging and auditing purposes.
  - [x] DEBUG node: Provides debugging information for developers to accelerate problem localization.
- [x] Scene linkage
  - [x] Rule orchestration (allowing users to customize the logical relationships between devices and achieve intelligent home or office environments)
  - [x] Device trigger (automatically activates the preset scene when the specified device status changes, such as turning on the light when opening the door)
  - [x] Manual triggering (users can actively activate scene mode through the app or panel to adapt to real-time demand changes)
  - [x] Timed trigger (automatically execute scene changes according to the user's set schedule, such as morning mode)
  - [x] Trigger conditions (supporting multi-dimensional setting conditions such as time and environmental parameters to accurately control scene switching)
  - [x] Action choreography (flexibly combining multiple operations to form a coherent action sequence, enhancing the richness of automation scenarios)
  - [x] Alarm orchestration (automatically triggering warning notifications under specific conditions, such as sending SMS reminders when smoke detectors alarm)
  - [x] Device linkage (realizing intelligent collaboration between devices, such as temperature and humidity sensors linked to air conditioning to regulate indoor environment)
  - [x] Scene customization (users can customize exclusive scene modes according to their lifestyle habits)
  - [x] Home leaving mode (one click start of home safety protection and energy-saving settings, such as turning off non essential appliances and turning on security monitoring)
  - [x] Home mode (automatically prepares for welcoming home scenes, such as turning on lights and adjusting the appropriate room temperature)
  - [x] Weather control (automatically adjusts home environment based on weather forecast, such as automatically closing windows on rainy days)
  - [x] Intelligent control (comprehensively utilizing the above characteristics to achieve comprehensive automation of smart homes or office spaces)
- [x] Video Center
  - [x] Integrated Web Console (providing an intuitive user interface, simplifying device management and system configuration processes)
  - [x] Wide compatibility and stability (ensuring seamless integration with multiple types of devices, maintaining efficient and stable system operation)
  - [x] Flexible device access management (supporting access to any number of devices, limited only by server performance, to achieve maximum resource utilization)
  - [x] High definition video preview and stream control (easy switching between main/sub streams to adapt to different monitoring scenarios)
  - [x] Free control of pan tilt zoom (all-round control of camera rotation and zoom, achieving fine monitoring)
  - [x] Video playback and intelligent retrieval (convenient query and playback of videos, with on-demand and download functions)
  - [x] Intelligent traffic saving mechanism (automatically reduces bandwidth consumption and optimizes resource utilization when no one is watching)
  - [x] Real time device information update (ensuring synchronization between video device information and status, improving monitoring efficiency)
  - [x] 24/7 monitoring system (supporting offline and online status monitoring of devices to ensure monitoring continuity)
  - [x] Multi protocol stream output capability (directly providing multiple stream protocol addresses for quick access and viewing)
  - [x] Plug and play experience (no need for additional login or interface calls, one click access to monitoring screen)
  - [x] Dual guarantee of national standard communication and streaming transmission (fully compatible with UDP/TCP national standard, strengthening system interoperability)
  - [x] Fine search and categorized browsing (providing channel filtering and sub directory query tools for more efficient management)
  - [x] Pure audio-visual experience (effectively filtering out background noise to ensure viewing quality)
  - [x] Accurate time synchronization (ensuring consistency of device time across the entire network and enhancing system collaboration capabilities)
  - [x] Advanced video encoding support (smooth playback of H264 and H265 encoded videos, optimized storage and transmission efficiency)
  - [x] Efficient linkage of alarm system (real-time processing of alarm information, seamless push to the front-end, ensuring quick response)
  - [x] Bidirectional voice communication (integrating voice intercom function to enhance on-site interaction and command scheduling)
  - [x] Event notification and subscription service (flexible configuration of alarm event subscription and notification strategies, customized monitoring experience)
  - [x] Enhance security measures (support device independent password and permission management, strengthen system security defense)
  - [x] National standard cascading expansion (realizing multi-level monitoring network interconnection and building large-scale monitoring system)
  - [x] Registration and heartbeat mechanism (ensuring continuous device online and improving system availability)
  - [x] Channel management optimization (simple channel selection and push function, improving operational convenience)
  - [x] Adaptive streaming media configuration (automatically optimizing ZLM media service configuration to reduce configuration difficulties)
  - [x] Intelligent load balancing (multi node automatic load allocation to ensure efficient and stable streaming media services)
  - [x] UDP performance enhancement (enabling multi port mode to significantly improve UDP transmission efficiency)
  - [x] Flexible deployment options (supporting deployment in public network environments and adapting to diverse network architectures)
  - [x] Strict flow and interface permission control (implementing push flow and interface authentication, strengthening data security)
  - [x] Cloud based video storage (flexible recording and archiving, supporting remote preview and download)
  - [x] Diverse deployment forms (supporting jar/war package deployment, adaptable to cloud native and traditional environments)
  - [x] Cross domain resource access (seamless support for front-end and back-end separation deployment, enhancing development flexibility)
  - [x] Monitoring equipment inspection (one click determination of the cause of cluster failures in monitoring equipment)
- [x] Data visualization
  - [x] Large screen display
  - [x] Data analysis
  - [x] Layer Management
  - [x] Basic components
  - [x] Decorative components
  - [x] Bar Chart Component
  - [x] Bar Chart Component
  - [x] Line Chart Component
  - [x] Area chart component
  - [x] Pie Chart Component
  - [x] Progress Chart Component
  - [x] Scatter plot component
  - [x] Rose diagram component
  - [x] Map component
  - [x] Custom Components
  - [x] Configuration Management
  - [x] Configuration Arrangement
  - [x] Configuration Library
  - [x] Configuration Chart
  - [x] Configuration component
  - [x] Configuration Model
- [x] Mobile end
  - [x] Real time monitoring of devices (displaying the current status of all connected devices, including device operation, key indicators, and sensor data)
  - [x] Device Control Panel (allows users to remotely control devices, such as switches, parameter adjustments, etc.)
  - [x] Alarm and Notification (Real time reception of device abnormalities or warning notifications, and quick viewing of alarm details and historical records)
  - [x] Device management (including functions such as device addition, deletion, group management, and device details viewing)
  - [x] Data visualization (visually displaying device data in chart form, supporting custom views and tracking of key indicators)
  - [x] Geographic positioning and map view (displaying the actual geographic location of the device for easy tracking and management of mobile or distributed devices)
  - [x] Scene automation (configuring and triggering preset scene modes, such as "home mode" or "energy-saving mode")
  - [x] Energy management (monitoring and managing equipment energy consumption, supporting energy analysis reports)
  - [x] Historical data query (provides query function for device operation logs and data records, supports filtering by time period)
  - [x] Firmware upgrade and maintenance (remote push firmware updates, manage device maintenance plans)
  - [x] User permission management (supports multi-user access, can assign different permission levels)
  - [x] Offline operation and synchronization (can still operate without network, and then automatically synchronize data)
  - [x] Voice control integration (integrated with intelligent voice assistants to achieve voice control of devices)
  - [x] API and third-party integration (supports API integration with other systems or applications, extends platform functionality)
- [x] System Management
  - [x] User Management
  - [x] Role management
  - [x] Menu management
  - [x] Department management
  - [x] Job management
  - [x] Dictionary management
  - [x] Parameter settings
  - [x] Notice Announcement
  - [x] Log management
  - [x] System monitoring
  - [x] Online users
  - [x] Scheduled tasks
  - [x] Data monitoring
  - [x] Service monitoring
  - [x] Cache monitoring
- [x] System Tools
  - [x] Form construction
  - [x] Code generation
  - [x] System interface
- [] In development features...

## Commercial Authorization
The project adopts AGPL3 protocol, which can be used for personal learning and use. Commercial use requires sponsorship of the project, authorization, and provision of commercial version source code. Sponsored users are requested to download the commercial version source code.
The second open source project also complies with the AGPL3.0 protocol and can apply for authorization from the original author. If a commercial project wants to switch to closed source, it can apply for or purchase closed source authorization from the original author