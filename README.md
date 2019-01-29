# The server side of mymis system.

>代码更新中
系列说明文章见：

1.技术架构：https://zhuanlan.zhihu.com/p/55213181

2.后端架构搭建：https://zhuanlan.zhihu.com/p/55292903

## 内容提要
如何运行代码：

1.连接你的MySql服务器，运行mymis.sql脚本，创建mysql数据库**mymis**，同时它会建立系统所需的表格，并导入数据；


## 系统设计规范
参考《阿里巴巴Java开发手册》https://juejin.im/entry/589c173b8d6d81006c7e9f70
【强制】表必备三字段：id, gmt_create, gmt_modified。 说明：其中id必为主键，类型为unsigned bigint、单表时自增、步长为1。gmt_create, gmt_modified的类型均为date_time类型。

## 系统设计








