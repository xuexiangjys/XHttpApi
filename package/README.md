## 服务器搭建注意事项

* 首先要确保电脑上已经安装了MySql,建议下载的MySql版本是5.7。

* 如果想要使用已打包好的`xhttpapi-1.0.0.jar`运行服务器，需要确保安装的数据库配置如下:

```
username: root                                                     
password: 123456
```

* 确保执行了`sql`包下的sql脚本创建数据库表。

* 在package目录下, 输入如下命令，运行服务器:

```
java -jar xhttpapi-1.0.0.jar

```