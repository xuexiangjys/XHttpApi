# XHttpApi

一个简单的spring boot搭建的api服务，为[XHttp](https://github.com/xuexiangjys/XHttp2)提供服务支持

## 内容

* 使用spring boot快速构建api服务。

* 使用阿里的druid数据库连接池和mybatis进行数据库的连接。

* 使用MySql作为数据库。

* 简单实现了数据库的增、删、改、查（分页）等功能。

* 使用了AOP对api请求进行动态日志记录。

* 全局异常捕获处理，返回统一API结果。

* 增加全局权限验证拦截器。

* 实现通用的文件上传（包括多文件上传）和下载功能。

## 搭建方法

1. clone项目到本地

```
git clone https://github.com/xuexiangjys/XHttpApi.git
```

2.使用IntelliJ IDEA 或者 MyEclipse导入该项目。

3.进行本地数据库的配置。

因为使用的是MySql数据库，如果你电脑上没有安装MySql的话，请先[点击安装](https://www.mysql.com/)。你可以安装`MySQL Community Server`和`MySQL Workbench`,建议下载的MySql版本是5.7。

* MySql安装完成后，请执行根目录下`sql`文件夹下的脚本，创建数据库表和内容。

* 配置`src/main/resources/application.yml`文件，包括服务端口、数据库配置、mybatis配置、文件上传配置等。

* 如果你需要使用mybatis的自动生成代码脚本`generator`，请配置`src/main/resources/init.properties`文件。

4.直接运行`XHttpApiApplication`即可。

----------------

## API构成

### 用户API

#### 1.添加用户

* 请求类型: post
* url : /user/addUser
* 参数 :
```
{
    "request":{
        "name":"wjjcanblwhbu",
        "gender":1,
        "age":20,
        "phone":"63993652063"
    }
}
```
* 响应 :
```
{
    "Code":0,
    "Msg":"",
    "Data":true
}
```

#### 2.删除用户

* 请求类型: post【form-data】
* url : /user/deleteUser
* 参数 :
```
userId=28
```
* 响应 :
```
{
    "Code":0,
    "Msg":"",
    "Data":true
}
```

#### 3.获取所有用户信息:

* 请求类型: get
* url : /user/getAllUser
* 响应 :
```
{
    "Code":0,
    "Msg":"",
    "Data":[
        {   
            "userId":1,
            "name":"薛翔",
            "gender":1,
            "age":24,
            "phone":"13813823453"
        },
        {
            "userId":3,
            "name":"美雪",
            "gender":2,
            "age":20,
            "phone":"13817834234"
        },
        {
            "userId":4,
            "name":"王小丫",
            "gender":2,
            "age":45,
            "phone":"17482954839"
        }
    ]
}
```

#### 4.更新用户信息

* 请求类型: post
* url : /user/updateUser
* 参数 :
```
{
    "age":99,
    "gender":2,
    "name":"jijzeyxz",
    "phone":"36027362539",
    "userId":14
}
```
* 响应 :
```
{
    "Code":0,
    "Msg":"",
    "Data":true
}
```

### 图书API

#### 1.获取所有图书信息

* 请求类型: get
* url : /book/getAllBook
* 响应 :
```
{
    "Code":0,
    "Msg":"",
    "Data":[
        {
            "bookId":1,
            "name":"第一行代码:Android(第2版)",
            "price":53.8,
            "author":"郭霖",
            "salesVolume":2,
            "score":4,
            "mark":56,
            "description":"本书被Android开发者誉为Android学习经典。",
            "picture":"Android第一行代码.jpg"
        },
        {
            "bookId":2,
            "name":"Android编程权威指南(第3版)",
            "price":101.7,
            "author":"比尔·菲利普斯 (Bill Phillips)",
            "salesVolume":2,
            "score":5,
            "mark":145,
            "description":"本书主要以其Android训练营教学课程为基础，融合了几位作者多年的心得体会，是一本完全面向实战的Android编程权 威指南。全书共36章，详细介绍了8个Android应用的开发过程。通过这些精心设计的应用，读者可掌握很多重要的理论知识和开发技巧，获得宝贵的开发经验。",
            "picture":"2018-06-04 19:50:12.jpg"
        }
    ]
}


```

#### 2.更新图书信息

* 请求类型: post
* url : /book/updateBook
* 参数 :
```
{
    "author":"郭霖",
    "bookId":1,
    "description":"本书被Android开发者誉为Android学习经典。",
    "mark":56,
    "name":"第一行代码:Android(第2版)",
    "picture":"Android第一行代码.jpg",
    "price":53.8,
    "salesVolume":2,
    "score":4
}
```
* 响应 :
```
{
    "Code":0,
    "Msg":"",
    "Data":true
}
```

#### 3.上传图书封面图片
* 请求类型: post【multipart/form-data】
* url : /book/uploadBookPicture
* 参数 :
```
file=[文件]
bookId=4
```
* 响应 :
```
{
    "Code":0,
    "Msg":"",
    "Data":true
}
```

#### 4.图书封面图片下载
* 请求类型: get
* url : /file/downloadFile/{fileName:.+}
* 响应 : 文件流