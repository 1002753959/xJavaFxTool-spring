**Gidee address：**[xJavaFxTool-spring](https://gitee.com/xwintop/xJavaFxTool-spring) 

**GitHub address：**[xJavaFxTool-spring](https://github.com/864381832/xJavaFxTool-spring)

**Tencent Cloud Development Platform Address：**[xJavaFxTool-spring](https://dev.tencent.com/u/xwintop/p/xJavaFxTool-spring)

<p align="center">
	<a target="_blank" href="https://www.apache.org/licenses/LICENSE-2.0.html">
		<img src="https://img.shields.io/:license-apache-blue.svg" ></img>
	</a>
	<a target="_blank" href="https://www.oracle.com/technetwork/java/javase/downloads/index.html">
		<img src="https://img.shields.io/badge/JDK-1.8+-green.svg" ></img>
	</a>
	<a target="_blank" href="https://gitee.com/xwintop/xJavaFxTool-spring/stargazers">
		<img src='https://gitee.com/xwintop/xJavaFxTool-spring/badge/star.svg?theme=dark' alt='gitee star'></img>
	</a>
	<a target="_blank" href='https://github.com/864381832/xJavaFxTool-spring'>
		<img src="https://img.shields.io/github/stars/864381832/xJavaFxTool-spring.svg?style=social" alt="github star"></img>
	</a>
</p>

[中文说明/Chinese Documentation](README.md)

**xJavaFxTool exchange QQ group：== [387473650](https://jq.qq.com/?_wv=1027&k=59UDEAD) ==**

#### Project Description:
xJavaFxTool is a practical gadget set developed by javaFx. It uses some time to summarize some problems encountered in the work, packaged into a small tool set for your reference and use. It contains some examples of javaFx functions, such as layout, Internationalization, third-party UI library ( [controlsfx](http://fxexperience.com/controlsfx/) , [JFoenix](http://www.jfoenix.com/), etc.), external jar package loading (plug-in mechanism) and other common functions, students who want to learn javaFx can refer to the reference, learn javaFx data reference [www.javafxchina.net](http://www.javafxchina.net/main/)

Due to the hot SpringBoot, the project has been released SpringBoot-javafx version, [xJavaFxTool-spring](https://gitee.com/xwintop/xJavaFxTool-spring) welcome reference, thank you.

#### Download trial address：
- Jar package that can be run directly (local need to have jdk1.8 environment)[xJavaFxTool-spring-0.1.4.jar](https://dev.tencent.com/s/4b3eee09-482c-4269-83e9-fc9c1068baf5)
- Windows x86 installation package (compatible with xp, windows7, 8, 10, etc.) [xJavaFxTool-spring-0.1.4-windows-x86.exe](https://dev.tencent.com/s/c3537a14-5528-4d6c-a605-2375e1810d3a)
- Windows x64 installation package (compatible with xp, windows7, 8, 10, etc.)[xJavaFxTool-spring-0.1.4-windows-x64.exe](https://dev.tencent.com/s/d0ee7c9f-8611-432c-b445-b61fc6aad5f1)
- Linux x64 [xJavaFxTool-spring-0.1.4-linux-x64.zip](https://dev.tencent.com/s/6100efc7-fd3f-404c-a528-fed3d32b016c) (Linux platform 64-bit running compression package, decompression can run)
- Mac OS X x64 [xJavaFxTool-spring-0.1.4-macosx-x64.dmg](https://dev.tencent.com/s/b566b428-da9c-4cab-972a-35831cace479)
- Mac OS X x64 [xJavaFxTool-spring-0.1.4-macosx-x64.pkg](https://dev.tencent.com/s/68633719-cf9b-41f0-b3e0-7a7ec9d51d01)
#### If the above link fails, use the download link below:
- Baidu cloud link: [https://pan.baidu.com/s/1RjlR58eu_GZC4iy46eGKLw](https://pan.baidu.com/s/1RjlR58eu_GZC4iy46eGKLw)  extraction code: zerc
- Tencent micro cloud link: [https://share.weiyun.com/57irGHJ](https://share.weiyun.com/57irGHJ) extraction code: java

Support plug-in development, the plug-in jar package can be automatically loaded under the root directory libs (see the open source project [xJavaFxPlugIn](https://gitee.com/xwintop/xJavaFxPlugIn) for plug-in development examples , and the next step is to split the gadget into each plug-in and load it as needed. Currently, the plug-in function is not perfect, follow-up Split each function into modules and load them as needed to reduce the size of the jar package);

#### Environmental construction instructions:
- The development environment is jdk1.8, based on maven build
- Developed with eclipase or Intellij Idea (Recommended to use [Intellij Idea](https://www.jetbrains.com/idea/) )
- This project uses [lombok](https://projectlombok.org/) . If you have not downloaded the lombok plugin when viewing this project, please install it first, otherwise you can't find the get/set method.
- The dependent [xcore](https://gitee.com/xwintop/xcore) package has been uploaded to the git-hosted maven platform. The git hosting maven can refer to the tutorial (if you can't download it, please pull the project to compile it yourself ). Tutorial address: Click to enter
- Package using the [javafx-maven-plugin](https://github.com/javafx-maven-plugin/javafx-maven-plugin) (can be packaged for windows, Linux, Mac installation packages)
- Use [exe4j](https://www.ej-technologies.com/download/exe4j/files) to convert the jar package into an exe executable file (for reference only, you can use other programs to package)
- Use [InnoSetup](http://www.jrsoftware.org/) to make windows installation packages

#### The currently integrated gadgets are:
1. FileCopy: File Copy (supports automatic scheduled copy function) (using the [quartz](https://www.quartz-scheduler.org/) tool)
2. CronExpBuilder: Cron Expression Builder
3. CharacterConverter: code conversion
4. EncryptAndDecrypt: Encryption and decryption (Ascii, Hex, Base64, Base32, URL, MD5, SHA, AES, DES, file encryption DM5, file encryption SHA1, Morse password, Druid encryption) (using the [commons-codec](http://commons.apache.org/codec/) tool)
5. TimeTool: Time conversion (common format conversion (including time zone), calculation time difference, time superposition calculation)
6. LinuxPathToWindowsPath: path conversion (using the [oshi](https://github.com/oshi/oshi) tool)
7. QRCodeBuilder: QR code generation tool (automatically generate, add logo, screenshot recognition, custom format) (using [google.zxing](https://github.com/zxing/zxing) , [jkeymaster](https://github.com/tulskiy/jkeymaster), etc.)
8. IdCardGenerator: ID Generator
9. RegexTester: Regular Expression Generation Tool
10. ShortURL: URL shortening (currently support Baidu, Sina, shrink me and other short URL shortening)
11. EscapeCharacter: escape characters (supports Html, XML, Java, JavaScript, CSV, Sql) (using the [commons-lang3](https://commons.apache.org/lang) tool)
12. ZHConverter: string conversion (using [hanlp](http://hanlp.com/) open source tools, to achieve pinyin, simplified - traditional, simplified - Taiwanese body, simplified - Hong Kong traditional, traditional - Taiwanese body, traditional - Hong Kong traditional, Hong Kong traditional - Taiwanese body, digital amount - capital amount, etc. Direct conversion)
13. ActiveMqTool: Mq debugging tool (currently only supports [ActiveMq](http://activemq.apache.org) )
14. HttpTool: Http debugging tool (supports custom send data, header and cookie) (using [okhttp](https://square.github.io/okhttp/) )
15. jsonEditor: json format editing tool
16. IconTool: Icon Generation Tool (using the [thumbnailator](https://github.com/coobird/thumbnailator) tool)
17. RedisTool: Redis connection tool (using the [jedis](https://github.com/xetorthio/jedis) tool)
18. WebSourcesTool: web source download tool
19. SwitchHostsTool: Switch the Hosts tool (using the [richtextfx](https://github.com/FXMisc/RichTextFX) tool)
20. FtpServer: Ftp server (quickly build local Ftp service) (based on [apache.ftpserver](https://mina.apache.org/ftpserver-project) )
21. CmdTool: Cmd debugging tool
22. FtpClientTool: Ftp(s)/Sftp client debugging tool (batch upload, download, delete files and folders) (implicit/explicit SSL/TLS) (using [jsch](http://www.jcraft.com/jsch) , [commons-io](http://commons.apache.org/io/), etc.)
23. PdfConvertTool: Pdf conversion tool (currently only supports pdf to image, pdf to text function) (using [pdfbox](https://pdfbox.apache.org/) tool)
24. DirectoryTreeTool: File List Generator
25. ImageTool: Image compression tool (bulk compression, resizing, conversion format)
26. AsciiPicTool: Image transcoding tool (including image generation banner code, picture to Base64 code, picture to Excel table)
27. KafkaTool: Kafka debugging tool (not perfect) (using [kafka-clients](http://kafka.apache.org/) )
28. EmailTool: Email bulk tool (supports custom bulk template) (using the [commons-email](https://commons.apache.org/email) tool)
29. ColorCodeConverterTool: color code conversion tool (including conversion between hexadecimal, RGB, ARGB, RGBA, HSL, HSV, etc.)
30. SmsTool: SMS group sending tool (currently supports China Mobile, China Telecom, Tencent Cloud, Alibaba Cloud, Monternet Cloud Communication and other platforms)
31. ScriptEngineTool: script engine debugging tool (currently supports scripts such as JavaScript, Groovy, Python, Lua, etc.) (using tools such as [groovy](http://groovy-lang.org),[jython](https://jython.org),[luaj](http://www.luaj.org/luaj.html), etc.)
32. FileRenameTool: File Rename Tool
33. JsonConvertTool: Json conversion tool (currently supports Json to Xml, Json to Java entity class, Json to C# entity class, Json to Excel, Json to Yaml, Properties to Yaml, Yaml to Properties) (using [fastjson](https://github.com/alibaba/fastjson), [snakeyaml](https://bitbucket.org/asomov/snakeyaml), [dom4j](https://dom4j.github.io), etc.)
34. WechatJumpGameTool: WeChat Jumping Assistant
35. TextToSpeechTool: Voice Conversion Tool (call [Baidu Voice Conversion](https://ai.baidu.com/tech/speech/tts) API)
36. 2048: Small game 2048
37. SocketTool: Socket debugging tool (using [Apache Mina](http://mina.apache.org) to implement Tcp, Udp server and client)
38. ImageAnalysisTool: Image parsing tool (1. Atlas file anti-parsing 2, image quick split tool)
39. DecompilerWxApkgTool: WeChat applet decompilation tool (one-click decompilation WeChat small package)
40. ZooKeeperTool: Zookeeper Tool (a convenient operation for ZooKeeper, including adding, modifying, deleting (including subfiles), renaming, copying, adding change notifications) (using the [zkclient](https://github.com/sgroschupf/zkclient) tool)
41. ExcelSplitTool: Excel split tool (supports splitting xls, xlsx, csv and files) (using the [commons-csv](http://commons.apache.org/csv) tool)
42. PathWatchTool: Folder Monitoring Tool
43. CharsetDetectTool: File Encoding Detection Tool (using the [juniversalchardet](https://github.com/albfernandez/juniversalchardet) tool)
44. TransferTool: Transfer tool (integrated with various transport protocols, using custom timing tasks (simple mode, cron expression mode), divided into Receiver receiver, Filter processor, Sender transmitter)
45. ScanPortTool: Port Scanning Tool
46. FileMergeTool: File Merge Tool (supports merging xls, xlsx, csv, and files) (using the [apache.poi](http://poi.apache.org/) tool)
47. SedentaryReminderTool: Sedentary Reminder Tool
48. RandomGeneratorTool: random number generation tool (using [hutool](https://hutool.cn) tool)
49. ClipboardHistoryTool: Clipboard History Tool

##### The transfer tools currently support the following features:
###### Receiver:

| title | Configuration class name | Description |
| ------------- | ------------- | ------------- |
| Fs            | ReceiverConfigFs      | Read a message from a disk file    |
| Ftp           | ReceiverConfigFtp     | Receive messages using the Ftp/Ftps protocol    |
| Http          | ReceiverConfigHttp    | Receive messages using the http/https protocol (supports pull mode and provides the Restfull interface mode) |
| Ftp           | ReceiverConfigFtp     | Receive messages using the Ftp/Ftps protocol   |
| SFtp          | ReceiverConfigSftp    | Receive messages using the SFtp protocol       |
| Email         | ReceiverConfigEmail   | Receive messages using the Email protocol          |
| Jms           | ReceiverConfigJms     | Receive messages using the Jms protocol   |
| Kafka         | ReceiverConfigKafka   | Receive messages using the Kafka protocol     |
| IbmMq         | ReceiverConfigIbmMq   | Receive messages using the IbmMq protocol     |
| RabbitMq      | ReceiverConfigRabbitMq| Receive messages using the RabbitMq protocol     |
| RocketMq      | ReceiverConfigRocketMq| Receive messages using the RocketMq protocol     |
| ActiveMq      | ReceiverConfigActiveMq| Receive messages using the ActiveMq protocol     |
| Hdfs          | ReceiverConfigHdfs    | Receive messages using the HDFS protocol     |

Filter：

| title | Configuration class name | Description |
| --------      | -----                    | :----  |
| Backup        | FilterConfigBackup        | Back up messages to the file system   |
| Compress      | FilterConfigCompress      | Compress the message  |
| Decompress    | FilterConfigDecompress    | Decompress the message  |
| EncryptDecrypt| FilterConfigEncryptDecrypt| Encrypt and decrypt the message   |
| OracleSqlldr  | FilterConfigOracleSqlldr  | Save the message to the Oracle database   |
| GroovyScript  | FilterConfigGroovyScript  | Will execute the Groovy script    |
| PythonScript  | FilterConfigPythonScript  | Will execute Python script         |
| JavaScript    | FilterConfigJavaScript    | Will execute a JavaScript script   |
| LuaScript     | FilterConfigLuaScript     | Will execute the Lua script        |
| UnicodeTransformation     | FilterConfigUnicodeTransformation     | Encode the message for conversion   |

Sender：

| title | Configuration class name | Description |
| --------      | -----                | :----  |
| Fs            | SenderConfigFs      | Read a message from a disk file  |
| Ftp           | SenderConfigFtp     | Send messages using the Ftp/Ftps protocol   |
| Http          | SenderConfigHttp    | Send a message using the http/https protocol  |
| Ftp           | SenderConfigFtp     | Send messages using the Ftp/Ftps protocol |
| SFtp          | SenderConfigSftp    | Send messages using the SFtp protocol |
| Email         | SenderConfigEmail   | Send a message using Email    |
| Jms           | SenderConfigJms     | Send messages using the Jms protocol |
| Kafka         | SenderConfigKafka   | Send messages using the Kafka protocol   |
| IbmMq         | SenderConfigIbmMq   | Send messages using the IbmMq protocol   |
| RabbitMq      | SenderConfigRabbitMq| Send messages using the RabbitMq protocol   |
| RocketMq      | SenderConfigRocketMq| Send messages using the RocketMq protocol   |
| ActiveMq      | SenderConfigActiveMq| Send messages using the ActiveMq protocol   |
| Hdfs          | SenderConfigHdfs    | Send messages using the HDFS protocol  |

#### In the development of the project, new tools will be added in the future. Welcome everyone to participate and give more comments, thank you.
#### Plan to add features:
- [ ] Monitoring function (folder depth, number of Ftp/Ftps/sftp files, mq depth)
- [ ] Convert excel to sql insert statement
- [ ] Record keyboard usage gadget
- [ ] Random file generator (with template engine)
 
#### Project structure

```
xJavaFxTool 
├─ project ImagesRF Royalty Free Screenshot 
├─ external storage jar package lib reference 
├─ libs plugin jar package store 
├─ pom.xml maven profile 
├─ README.md documentation 
├─ src 
│ ├─ main 
│ │ ├─ the Java 
│ │ │ └ com 
│ │ │  └ ─ xwintop 
│ │ │   └ ─ ─ xJavaFxTool 
│ │ │   ├─ common third-party tools 
│ │ │   ├─ config springBoot configuration class 
│ │ │   ├─ controller javafx control layer 
│ │ │   │ ├─ assistTools Auxiliary Tool Control Layer 
│ │ │   │ ├ ─ codeTools Code Tool Control Layer 
│ │ │   │ ├─ debugTools Debug Tool Control Layer 
│ │ │   │ ├─ developTools Development Tool Control Layer 
│ │ │   │ ├─ epmsTools epms Tool Control Layer 
│ │ │   │ ├─ javaFxTools javaFx tool control layer 
│ │ │   │ ├─ littleTools gadget control layer
│ │ │   │ └ ─ webTools html tool control layer 
│ │ │   ├─ job timed task processing job 
│ │ │   ├─ main main function package 
│ │ │   ├─ manager management 
│ │ │   ├─ model basic bean class layer 
│ │ │   ├─ services tool service layer 
│ │ │   │ ├─ assistTools auxiliary tool service layer 
│ │ │   │ ├─ codeTools Code tool service layer 
│ │ │   │ ├─ debugTools debugging tool service layer 
│ │ │   │ ├─ developTools development tool service layer 
│ │ │   │ ├─ epmsTools epms tool service layer 
│ │ │   │ ├─ javaFxTools javaFx tool service layer 
│ │ │   │ ├─ littleTools gadgets service layer 
│ │ │   │ └─ webTools html tool service layer 
│ │ │   ├─ Utils system tools class 
│ │ │   ├─ view javafx view layer 
│ │ │   │ ├─ assistTools auxiliary tool view layer 
│ │ │   │ ├─ codeTools Code tool view layer
│ │ │   │ ├─ debugTools debugging tool View layer 
│ │ │   │ ├─ developTools development tools view layer 
│ │ │   │ ├─ javaFxTools javaFx tool view layer 
│ │ │   │ ├─ littleTools widget view layer 
│ │ │   │ └─ webTools html tool view layer 
│ │ │   └ ─ web web control view layer 
│ │ └ ─ resources 
│ │     ├ com 
│ │     │ └ ─ xwintop 
│ │     │  └─ xJavaFxTool 
│ │     │   └─ fxmlView .fxml file
│ │     ├─ Config configuration file 
│ │     │ └─ toolFxmlLoaderConfiguration.xml system menu loading configuration file 
│ │     ├─ css style resource 
│ │     ├─ data data resource 
│ │     ├─ images image resource 
│ │     ├─ locale internationalization 
│ │     ├─ web html tools 
│ │     ├─ application.yaml SpringBoot configuration file 
│ │     ├─ banner.txt start banner pictures
│ │     └─ logback.xml logback log configuration file 
│ └─ test test class 
│   ├─ java 
│   └─ resources 
├─ xJavaFxTool.jar run the package directly

```

#### Special thanks to
When a person is still young, I feel that I should start to do something that is meaningful to society, just like open source. At this point, thanks to the following contributors (in no particular order):
+ [Li Zhu](https://gitee.com/loyalty521)
+ [luming](https://gitee.com/jeeweb)
+ [Code](https://gitee.com/dazer1992)
+ Your goddess

#### Follow-up plan
From time to time, add the pain points tool that summarizes the requirements in the development process. Everyone has a pain point at work and can enter the group discussion. Later, there may be corresponding tool solutions. Thank you for your support.

#### The project screenshot is as follows:

![输入图片说明](images/传输工具.gif "传输工具.gif")
![输入图片说明](images/邮件发送工具.gif "邮件发送工具.png")
![输入图片说明](images/Cron表达式生成器.gif "Cron表达式生成器.gif")
![输入图片说明](images/加密解密.gif "加密解密.png")
![输入图片说明](images/正则表达式生成工具.gif "正则表达式生成工具.png")
![输入图片说明](images/二维码生成工具.gif "二维码生成工具.png")
![输入图片说明](images/Socket调试工具.gif "Socket调试工具.png")
![输入图片说明](images/json格式化编辑工具.gif "json格式化编辑工具.png")
![输入图片说明](images/Http调试工具.gif "Http调试工具.png")
![输入图片说明](images/随机数生成工具.gif "随机数生成工具.png")
![输入图片说明](images/字符串转换.gif "字符串转换.png")
![输入图片说明](images/Redis连接工具.gif "Redis连接工具.png")
![输入图片说明](images/Mq调试工具.gif "Mq调试工具.png")
![输入图片说明](images/zookeeper工具.png "zookeeper工具.png")
![输入图片说明](images/编码转换.png "编码转换.png")
![输入图片说明](images/转义字符.gif "转义字符.png")
![输入图片说明](images/文件列表生成器.gif "文件列表生成器.png")
![输入图片说明](images/文件复制.png "文件复制.png")
![输入图片说明](images/Time转换.gif "Time转换.gif")
![输入图片说明](images/图标生成工具.gif "图标生成工具.png")
![输入图片说明](images/Ftp服务器.gif "Ftp服务器.png")
![输入图片说明](images/图片压缩工具.gif "图片压缩工具.png")
![输入图片说明](images/Ftp客户端调试工具.gif "Ftp客户端调试工具.png")
![输入图片说明](images/Pdf转换工具.gif "Pdf转换工具.png")
![输入图片说明](images/图片转码工具.gif "图片转码工具.png")
![输入图片说明](images/Cmd调试工具.png "Cmd调试工具.png")
![输入图片说明](images/短信群发工具.gif "短信群发工具.png")
![输入图片说明](images/文件重命名工具.gif "文件重命名工具.png")
![输入图片说明](images/Json转换工具.gif "Json转换工具.png")
![输入图片说明](images/系统信息.gif "系统信息.gif")
![输入图片说明](images/Excel拆分工具.gif "Excel拆分工具.png")
![输入图片说明](images/文件编码检测工具.gif "文件编码检测工具.png")
![输入图片说明](images/端口扫描工具.gif "端口扫描工具.png")