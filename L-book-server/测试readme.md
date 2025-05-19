####目前仅实现了一个接口。

####即访问网址：http://localhost:1211/book/getBook，会返回数据库中ISBN为“1234567890”的book信息。

####测试方法：

（1）创建一个名为sdu_book的数据库

在application-dev.yml中增加（如果已经存在，则修改，其中url，username，password均为自己的数据库配置）

```yml
spring:
  datasource:
    username: root
    password: 123456
    url: jdbc:mysql://localhost:3306/sdu_book?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf8
    driver-class-name: com.mysql.cj.jdbc.Driver
```

（2）打开浏览器，输入http://localhost:1211/book/getBook

![image-20250519215234389](C:\Users\Pangxin6160618\AppData\Roaming\Typora\typora-user-images\image-20250519215234389.png)
与数据库中相同

![image-20250519215259585](C:\Users\Pangxin6160618\AppData\Roaming\Typora\typora-user-images\image-20250519215259585.png)

***

***

项目架构：

![image-20250519215949955](C:\Users\Pangxin6160618\AppData\Roaming\Typora\typora-user-images\image-20250519215949955.png)
