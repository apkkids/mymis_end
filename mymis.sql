/*
 Navicat Premium Data Transfer

 Source Server         : dev
 Source Server Type    : MySQL
 Source Server Version : 50640
 Source Host           : 47.104.133.105:3306
 Source Schema         : mymis

 Target Server Type    : MySQL
 Target Server Version : 50640
 File Encoding         : 65001

 Date: 15/01/2019 10:18:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称,以ROLE_开头',
  `name_ch` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色中文名称',
  `gmt_created` datetime(0) NOT NULL COMMENT '角色创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '角色修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表存储了系统中的角色，角色是权限的一种表示方法，它代表了一组系统权限，拥有某个角色的管理员可以访问（获修改）某些资源。\r\n它和菜单表menu、管理员表admin联合起来完成系统的权限控制。' ROW_FORMAT = Compact;

INSERT into role (name,name_ch,gmt_created)  VALUES ('ROLE_admin','系统管理员',now());
INSERT into role (name,name_ch,gmt_created)  VALUES ('ROLE_manager','部门经理',now());
INSERT into role (name,name_ch,gmt_created)  VALUES ('ROLE_personnel','人事专员',now());
INSERT into role (name,name_ch,gmt_created)  VALUES ('ROLE_recruiter','招聘主管',now());
INSERT into role (name,name_ch,gmt_created)  VALUES ('ROLE_performance','薪酬绩效主管',now());


-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员登录名称',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员登录密码，该密码是加密过的',
  `name_ch` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员中文名称',
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `is_enabled` tinyint(1) NOT NULL COMMENT '1表示是，0表示否',
  `userface` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像，是一个图片的url地址',
  `gmt_created` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员表，存储了系统中所有的管理员信息。管理员拥有一个或者多个role表中的角色，可以访问系统中的资源。\r\n这个表与role、menu以及admin_role等表一起构建系统的权限管理功能。' ROW_FORMAT = Compact;

--注意这里的密码是pwd的加密
INSERT INTO admin ( username, password, name_ch, telephone, address, is_enabled, userface, gmt_created ) VALUES	( 'admin', '$10$9SIFu8l8asZUKxtwqrJM5ujhWarz/PMnTX44wXNsBHfpJMakWw3M6', '系统管理员', '010-1122334','北京', 1, 'http://bpic.588ku.com/element_pic/01/40/00/64573ce2edc0728.jpg', now( ) );
INSERT INTO admin ( username, password, name_ch, telephone, address, is_enabled, userface, gmt_created ) VALUES	( 'test1', '$10$9SIFu8l8asZUKxtwqrJM5ujhWarz/PMnTX44wXNsBHfpJMakWw3M6', '系统测试员1', '010-1100334','上海', 1, 'http://bpic.588ku.com/element_pic/01/40/00/64573ce2edc0728.jpg', now( ) );
INSERT INTO admin ( username, password, name_ch, telephone, address, is_enabled, userface, gmt_created ) VALUES	( 'test2', '$10$9SIFu8l8asZUKxtwqrJM5ujhWarz/PMnTX44wXNsBHfpJMakWw3M6', '系统测试员2', '010-1122334','广州', 1, 'http://bpic.588ku.com/element_pic/01/40/00/64573ce2edc0728.jpg', now( ) );
INSERT INTO admin ( username, password, name_ch, telephone, address, is_enabled, userface, gmt_created ) VALUES	( 'developer', '$10$9SIFu8l8asZUKxtwqrJM5ujhWarz/PMnTX44wXNsBHfpJMakWw3M6', '开发主管', '010-3344556','深圳', 1, 'http://bpic.588ku.com/element_pic/01/40/00/64573ce2edc0728.jpg', now( ) );

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称（可以是中文）',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '匹配的url',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对应的路径',
  `component` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对应的前端控件名称，这里指Vue控件',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父菜单，表明自己是子菜单。为null则表明自己没有父亲。',
  `icon_class` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对应的图标，使用font-awesome的字符串表示',
  `is_enabled` tinyint(1) UNSIGNED NOT NULL COMMENT '1表示有效，0表示无效',
  `gmt_created` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单实际上控制着系统中的资源访问，一个菜单掌握的资源是指前端页面，这里存储的是前端控件的地址。\r\n一个角色role可以访问多个菜单，一个管理员admin可以拥有多个角色，因此这个管理员就可以通过角色、菜单的关联，来访问对应的页面。他也就拥有了资源的访问权限。\r\n菜单是多级关联的，上级菜单的resource为空，下级菜单则通过parent_id指明自己的父亲。\r\n\r\n' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '所有', '/', NULL, NULL, NULL, NULL, 1, now( ) , NULL);
INSERT INTO `menu` VALUES (2, '员工资料', '/', '/home', 'Home', 1, 'fa fa-user-circle-o', 1, now( ) , NULL);
INSERT INTO `menu` VALUES (3, '薪资管理', '/', '/home', 'Home', 1, 'fa fa-money', 1, now( ) , NULL);
INSERT INTO `menu` VALUES (4, '基本资料', '/employee/basic/**', '/emp/basic', 'EmpBasic', 2, NULL, 1,now( ) , NULL);
INSERT INTO `menu` VALUES (5, '高级资料', '/employee/advanced/**', '/emp/adv', 'EmpAdv', 2, NULL, 1, now( ) , NULL);
INSERT INTO `menu` VALUES (6, '工资账套管理', '/salary/sob/**', '/sal/sob', 'SalSob', 3, NULL, 1, now( ) , NULL);
INSERT INTO `menu` VALUES (7, '员工账套设置', '/salary/sobcfg/**', '/sal/sobcfg', 'SalSobCfg', 3, NULL, 1, now( ) , NULL);


-- ----------------------------
-- Table structure for nation
-- ----------------------------
DROP TABLE IF EXISTS `nation`;
CREATE TABLE `nation`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gmt_created` datetime(0) NOT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

INSERT INTO `nation` (name,gmt_created) VALUES ('汉族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ('蒙古族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ('回族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ('藏族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ('维吾尔族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ('苗族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ('彝族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ('壮族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ('布依族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '朝鲜族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '满族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '侗族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '瑶族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '白族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '土家族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '哈尼族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '哈萨克族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '傣族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '黎族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '傈僳族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '佤族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '畲族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '高山族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '拉祜族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '水族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '东乡族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '纳西族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '景颇族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '柯尔克孜族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '土族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '达斡尔族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '仫佬族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '羌族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '布朗族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '撒拉族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '毛难族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '仡佬族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '锡伯族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '阿昌族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '普米族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '塔吉克族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '怒族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '乌孜别克族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '俄罗斯族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '鄂温克族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '崩龙族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '保安族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '裕固族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '京族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '塔塔尔族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '独龙族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '鄂伦春族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '赫哲族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '门巴族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '珞巴族', now() );
INSERT INTO `nation` (name,gmt_created) VALUES ( '基诺族', now() );

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gmt_created` datetime(0) NOT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典表，职位\r\n' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES (1, '董事长', now(), NULL);
INSERT INTO `position` VALUES (2, '总经理', now(), NULL);
INSERT INTO `position` VALUES (3, '技术总监', now(), NULL);
INSERT INTO `position` VALUES (4, '市场总监', now(), NULL);
INSERT INTO `position` VALUES (5, '运营总监', now(), NULL);
INSERT INTO `position` VALUES (6, '研发工程师', now(), NULL);
INSERT INTO `position` VALUES (7, '测试工程师', now(), NULL);
INSERT INTO `position` VALUES (8, '运维工程师',now(), NULL);
INSERT INTO `position` VALUES (9, '行政人员', now(), NULL);
INSERT INTO `position` VALUES (10, '财务人员',now(), NULL);

-- ----------------------------
-- Table structure for political_status
-- ----------------------------
DROP TABLE IF EXISTS `political_status`;
CREATE TABLE `political_status`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gmt_created` datetime(0) NOT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典表，政治面貌\r\n' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of political_status
-- ----------------------------
INSERT INTO `political_status` VALUES (1, '中共党员', now() , NULL);
INSERT INTO `political_status` VALUES (2, '中共预备党员', now() , NULL);
INSERT INTO `political_status` VALUES (3, '共青团员', now() , NULL);
INSERT INTO `political_status` VALUES (4, '民革党员', now() , NULL);
INSERT INTO `political_status` VALUES (5, '民盟盟员', now() , NULL);
INSERT INTO `political_status` VALUES (6, '无党派民主人士', now() , NULL);
INSERT INTO `political_status` VALUES (7, '普通公民', now() , NULL);

-- ----------------------------
-- Table structure for job_level
-- ----------------------------
DROP TABLE IF EXISTS `job_level`;
CREATE TABLE `job_level`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `titlelevel` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gmt_created` datetime(0) NOT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `is_enabled` tinyint(1) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典表，职级' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of job_level
-- ----------------------------
INSERT INTO `job_level` VALUES (1, '初级工程师', '初级', now() , NULL, 1);
INSERT INTO `job_level` VALUES (2, '工程师', '中级',  now(), NULL, 1);
INSERT INTO `job_level` VALUES (3, '高级工程师', '高级',  now(), NULL, 1);

-- ----------------------------
-- Table structure for organization
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `parent_id` bigint(20) NOT NULL COMMENT '-1表示自己是根',
  `is_enabled` tinyint(1) NOT NULL,
  `is_parent` tinyint(1) NOT NULL COMMENT '1表示自己是parent,0表示自己是叶子组织',
  `gmt_created` datetime(0) NOT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '组织架构表，代表了一个组织的层级结构\r\n' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of organization
-- ----------------------------
INSERT INTO `organization` VALUES (1, '董事会', -1, 1, 1,now(), NULL);
INSERT INTO `organization` VALUES (2, '华东区', 1, 1, 1, now(), NULL);
INSERT INTO `organization` VALUES (3, '华南区', 1, 1, 0, now(), NULL);
INSERT INTO `organization` VALUES (4, '华西区', 1, 1, 0, now(), NULL);
INSERT INTO `organization` VALUES (5, '华中区', 1, 1, 0, now(), NULL);
INSERT INTO `organization` VALUES (6, '开发部', 2, 1, 0, now(), NULL);
INSERT INTO `organization` VALUES (7, '行政部', 2, 1, 0, now(), NULL);
INSERT INTO `organization` VALUES (8, '财务部', 2, 1, 0, now(), NULL);

SET FOREIGN_KEY_CHECKS = 1;
