# XHttpApi

一个简单的spring boot搭建的api服务，为[XHttp](https://github.com/xuexiangjys/XHttp2)提供服务支持

## 内容

* 使用spring boot快速构建api服务。

* 使用阿里的druid数据库连接池和mybatis进行数据库的连接。

* 使用MySql作为数据库。

* 简单实现了数据库的增、删、改、查（分页）等功能。

* 使用了AOP对api请求进行动态日志记录。


## 搭建方法

1. clone项目到本地

```
git clone https://github.com/xuexiangjys/XHttpApi.git
```

2.使用IntelliJ IDEA 或者 MyEclipse导入该项目。

3.进行本地数据库的配置。

因为使用的是MySql数据库，如果你电脑上没有安装MySql的话，请先[点击安装](https://www.mysql.com/)。

* MySql安装完成后，请执行根目录下`sql`文件夹下的脚本，创建数据库表和内容。

* 配置`src/main/resources/application.yml`文件，包括服务端口、数据库配置、mybatis配置等。

* 如果你需要使用mybatis的自动生成代码脚本`generator`，请配置`src/main/resources/init.properties`文件。

4.直接运行`XHttpApiApplication`即可。