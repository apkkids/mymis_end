# The server side of mymis system.

>代码更新中

## 内容提要
如何运行代码：

1.创建mysql数据库**mymis**；

2.运行mymis.sql脚本，建立系统所需的表格，并导入数据；

3.

## 系统设计规范
参考《阿里巴巴Java开发手册》https://juejin.im/entry/589c173b8d6d81006c7e9f70
【强制】表必备三字段：id, gmt_create, gmt_modified。 说明：其中id必为主键，类型为unsigned bigint、单表时自增、步长为1。gmt_create, gmt_modified的类型均为date_time类型。

## 系统设计
1.设计MySql数据库，简要的参考教程在：
https://www.liaoxuefeng.com/wiki/001508284671805d39d23243d884b8b99f440bfae87b0f4000

2.数据库设计原则，表分为三类：用来进行系统管理和权限控制的系统表；用来存储字典的字典表；用来存储用户数据的数据表。

系统表：role（角色）、menu(菜单)、menu_role、admin（管理员）、admin_role

字典表：nation（国家）、position（职位）、joblevel（职级）、pliticstatus（政治身份）

数据表：employee（职员）、organization（组织，代表一个公司内部的多层组织架构）







