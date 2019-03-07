/*
 Navicat Premium Data Transfer

 Source Server         : dev
 Source Server Type    : MySQL
 Source Server Version : 50640
 Source Host           : xxx:3306
 Source Schema         : mymis

 Target Server Type    : MySQL
 Target Server Version : 50640
 File Encoding         : 65001

 Date: 07/03/2019 21:05:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) UNSIGNED NOT NULL,
  `role_id` bigint(20) UNSIGNED NOT NULL,
  `gmt_created` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk1`(`admin_id`) USING BTREE,
  INDEX `fk2`(`role_id`) USING BTREE,
  CONSTRAINT `fk1` FOREIGN KEY (`admin_id`) REFERENCES `admin_sys` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk2` FOREIGN KEY (`role_id`) REFERENCES `role_sys` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员-角色关联表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin_role
-- ----------------------------
INSERT INTO `admin_role` VALUES (1, 1, 1, '2019-01-17 11:39:46');
INSERT INTO `admin_role` VALUES (2, 1, 3, '2019-01-17 11:39:57');
INSERT INTO `admin_role` VALUES (3, 2, 4, '2019-01-29 19:33:30');
INSERT INTO `admin_role` VALUES (4, 2, 3, '2019-03-07 20:53:35');
INSERT INTO `admin_role` VALUES (5, 3, 4, '2019-03-07 20:53:52');

-- ----------------------------
-- Table structure for admin_sys
-- ----------------------------
DROP TABLE IF EXISTS `admin_sys`;
CREATE TABLE `admin_sys`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
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

-- ----------------------------
-- Records of admin_sys
-- ----------------------------
INSERT INTO `admin_sys` VALUES (1, 'admin', '$2a$10$hvYRxeRfJRG1hp2NP9tc/.BublYUy.2sGNLTn3.lNyNFFpgKxZP62', '系统管理员', '010-1122334', '北京', 1, 'http://bpic.588ku.com/element_pic/01/40/00/64573ce2edc0728.jpg', '2019-01-15 10:44:53', NULL);
INSERT INTO `admin_sys` VALUES (2, 'test1', '$2a$10$hvYRxeRfJRG1hp2NP9tc/.BublYUy.2sGNLTn3.lNyNFFpgKxZP62', '系统测试员1', '010-1100334', '上海', 1, 'http://bpic.588ku.com/element_pic/01/40/00/64573ce2edc0728.jpg', '2019-01-15 10:47:39', NULL);
INSERT INTO `admin_sys` VALUES (3, 'test2', '$2a$10$hvYRxeRfJRG1hp2NP9tc/.BublYUy.2sGNLTn3.lNyNFFpgKxZP62', '系统测试员2', '010-1122334', '广州', 1, 'http://bpic.588ku.com/element_pic/01/40/00/64573ce2edc0728.jpg', '2019-01-15 10:47:39', NULL);
INSERT INTO `admin_sys` VALUES (4, 'developer', '$2a$10$hvYRxeRfJRG1hp2NP9tc/.BublYUy.2sGNLTn3.lNyNFFpgKxZP62', '开发主管', '010-3344556', '深圳', 1, 'http://bpic.588ku.com/element_pic/01/40/00/64573ce2edc0728.jpg', '2019-01-15 10:47:39', NULL);

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `gender` enum('男','女') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `birthday` date NULL DEFAULT NULL COMMENT '出生日期',
  `id_card` char(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `marriage` enum('已婚','未婚','离异') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '婚姻状况',
  `nation_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '民族',
  `native_place` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '籍贯',
  `politic_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '政治面貌',
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系地址',
  `organization_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '所属组织',
  `joblevel_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '职称ID',
  `position_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '职位ID',
  `degree` enum('博士','硕士','本科','大专','高中','初中','小学','其他') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历',
  `specialty` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属专业',
  `school` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '毕业院校',
  `begin_date` date NULL DEFAULT NULL COMMENT '入职日期',
  `work_state` enum('在职','离职') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '在职' COMMENT '在职状态',
  `work_id` char(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工号',
  `gmt_created` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `employee_fk1`(`nation_id`) USING BTREE,
  INDEX `employee_fk2`(`politic_id`) USING BTREE,
  INDEX `employee_fk3`(`organization_id`) USING BTREE,
  INDEX `employee_fk4`(`joblevel_id`) USING BTREE,
  INDEX `employee_fk5`(`position_id`) USING BTREE,
  CONSTRAINT `employee_fk1` FOREIGN KEY (`nation_id`) REFERENCES `nation_dic` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `employee_fk2` FOREIGN KEY (`politic_id`) REFERENCES `politicalstatus_dic` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `employee_fk3` FOREIGN KEY (`organization_id`) REFERENCES `organization` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `employee_fk4` FOREIGN KEY (`joblevel_id`) REFERENCES `joblevel_dic` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `employee_fk5` FOREIGN KEY (`position_id`) REFERENCES `position_dic` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1539 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, '王叮叮', '女', '2005-11-01', '010000000000001', '未婚', 1, '北京', 3, 'test@163.com', '13000000001', '海淀', 3, 2, 2, '本科', '计算机', '北京大学', '2019-01-01', '在职', '10000001', '2019-01-29 19:55:33', NULL);

-- ----------------------------
-- Table structure for joblevel_dic
-- ----------------------------
DROP TABLE IF EXISTS `joblevel_dic`;
CREATE TABLE `joblevel_dic`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `titlelevel` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gmt_created` datetime(0) NOT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `is_enabled` tinyint(1) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典表，职级' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of joblevel_dic
-- ----------------------------
INSERT INTO `joblevel_dic` VALUES (1, '初级工程师', '初级', '2019-01-16 20:39:47', NULL, 1);
INSERT INTO `joblevel_dic` VALUES (2, '工程师', '中级', '2019-01-16 20:40:07', NULL, 1);
INSERT INTO `joblevel_dic` VALUES (3, '高级工程师', '高级', '2019-01-16 20:40:23', NULL, 1);

-- ----------------------------
-- Table structure for nation_dic
-- ----------------------------
DROP TABLE IF EXISTS `nation_dic`;
CREATE TABLE `nation_dic`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gmt_created` datetime(0) NOT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 77 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of nation_dic
-- ----------------------------
INSERT INTO `nation_dic` VALUES (1, '汉族', '2019-01-16 20:23:04', NULL);
INSERT INTO `nation_dic` VALUES (2, '蒙古族', '2019-01-16 20:23:04', NULL);
INSERT INTO `nation_dic` VALUES (3, '回族', '2019-01-16 20:23:04', NULL);
INSERT INTO `nation_dic` VALUES (4, '藏族', '2019-01-16 20:23:04', NULL);
INSERT INTO `nation_dic` VALUES (5, '维吾尔族', '2019-01-16 20:23:04', NULL);
INSERT INTO `nation_dic` VALUES (6, '苗族', '2019-01-16 20:23:04', NULL);
INSERT INTO `nation_dic` VALUES (7, '彝族', '2019-01-16 20:23:04', NULL);
INSERT INTO `nation_dic` VALUES (8, '壮族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (9, '布依族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (10, '朝鲜族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (11, '满族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (12, '侗族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (13, '瑶族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (14, '白族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (15, '土家族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (16, '哈尼族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (17, '哈萨克族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (18, '傣族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (19, '黎族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (20, '傈僳族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (21, '佤族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (22, '畲族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (23, '高山族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (24, '拉祜族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (25, '水族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (26, '东乡族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (27, '纳西族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (28, '景颇族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (29, '柯尔克孜族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (30, '土族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (31, '达斡尔族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (32, '仫佬族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (33, '羌族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (34, '布朗族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (35, '撒拉族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (36, '毛难族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (37, '仡佬族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (38, '锡伯族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (39, '阿昌族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (40, '普米族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (41, '塔吉克族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (42, '怒族', '2019-01-16 20:23:05', NULL);
INSERT INTO `nation_dic` VALUES (43, '乌孜别克族', '2019-01-16 20:23:06', NULL);
INSERT INTO `nation_dic` VALUES (44, '俄罗斯族', '2019-01-16 20:23:06', NULL);
INSERT INTO `nation_dic` VALUES (45, '鄂温克族', '2019-01-16 20:23:06', NULL);
INSERT INTO `nation_dic` VALUES (46, '崩龙族', '2019-01-16 20:23:06', NULL);
INSERT INTO `nation_dic` VALUES (47, '保安族', '2019-01-16 20:23:06', NULL);
INSERT INTO `nation_dic` VALUES (48, '裕固族', '2019-01-16 20:23:06', NULL);
INSERT INTO `nation_dic` VALUES (49, '京族', '2019-01-16 20:23:06', NULL);
INSERT INTO `nation_dic` VALUES (50, '塔塔尔族', '2019-01-16 20:23:06', NULL);
INSERT INTO `nation_dic` VALUES (51, '独龙族', '2019-01-16 20:23:06', NULL);
INSERT INTO `nation_dic` VALUES (52, '鄂伦春族', '2019-01-16 20:23:06', NULL);
INSERT INTO `nation_dic` VALUES (53, '赫哲族', '2019-01-16 20:23:06', NULL);
INSERT INTO `nation_dic` VALUES (54, '门巴族', '2019-01-16 20:23:06', NULL);
INSERT INTO `nation_dic` VALUES (55, '珞巴族', '2019-01-16 20:23:06', NULL);
INSERT INTO `nation_dic` VALUES (56, '基诺族', '2019-01-16 20:23:06', NULL);

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
INSERT INTO `organization` VALUES (1, '董事会', -1, 1, 1, '2019-01-16 20:54:36', NULL);
INSERT INTO `organization` VALUES (2, '华东区', 1, 1, 1, '2019-01-16 20:55:00', NULL);
INSERT INTO `organization` VALUES (3, '华南区', 1, 1, 0, '2019-01-16 20:55:26', NULL);
INSERT INTO `organization` VALUES (4, '华西区', 1, 1, 0, '2019-01-16 20:55:47', NULL);
INSERT INTO `organization` VALUES (5, '华中区', 1, 1, 0, '2019-01-16 20:56:04', NULL);
INSERT INTO `organization` VALUES (6, '开发部', 2, 1, 0, '2019-01-16 20:56:26', NULL);
INSERT INTO `organization` VALUES (7, '行政部', 2, 1, 0, '2019-01-16 20:56:41', NULL);
INSERT INTO `organization` VALUES (8, '财务部', 2, 1, 0, '2019-01-16 20:56:55', NULL);

-- ----------------------------
-- Table structure for politicalstatus_dic
-- ----------------------------
DROP TABLE IF EXISTS `politicalstatus_dic`;
CREATE TABLE `politicalstatus_dic`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gmt_created` datetime(0) NOT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典表，政治面貌\r\n' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of politicalstatus_dic
-- ----------------------------
INSERT INTO `politicalstatus_dic` VALUES (1, '中共党员', '2019-01-16 20:35:00', NULL);
INSERT INTO `politicalstatus_dic` VALUES (2, '共青团员', '2019-01-29 18:57:55', NULL);
INSERT INTO `politicalstatus_dic` VALUES (3, '群众', '2019-01-29 18:58:11', NULL);
INSERT INTO `politicalstatus_dic` VALUES (4, 'test1', '2019-02-27 03:22:48', '2019-02-27 03:22:48');
INSERT INTO `politicalstatus_dic` VALUES (5, 'test2', '2019-02-27 03:22:48', '2019-02-27 03:22:48');

-- ----------------------------
-- Table structure for position_dic
-- ----------------------------
DROP TABLE IF EXISTS `position_dic`;
CREATE TABLE `position_dic`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gmt_created` datetime(0) NOT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典表，职位\r\n' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of position_dic
-- ----------------------------
INSERT INTO `position_dic` VALUES (1, '董事长', '2019-01-16 20:27:25', NULL);
INSERT INTO `position_dic` VALUES (2, '总经理', '2019-01-16 20:27:38', NULL);
INSERT INTO `position_dic` VALUES (3, '技术总监', '2019-01-16 20:27:59', NULL);
INSERT INTO `position_dic` VALUES (4, '市场总监', '2019-01-16 20:28:09', NULL);
INSERT INTO `position_dic` VALUES (5, '运营总监', '2019-01-16 20:28:23', NULL);
INSERT INTO `position_dic` VALUES (6, '研发工程师', '2019-01-16 20:28:39', NULL);
INSERT INTO `position_dic` VALUES (7, '测试工程师', '2019-01-16 20:28:48', NULL);
INSERT INTO `position_dic` VALUES (8, '运维工程师', '2019-01-16 20:28:59', NULL);
INSERT INTO `position_dic` VALUES (9, '行政人员', '2019-01-16 20:29:10', NULL);
INSERT INTO `position_dic` VALUES (10, '财务人员', '2019-01-16 20:29:18', NULL);

-- ----------------------------
-- Table structure for resource_sys
-- ----------------------------
DROP TABLE IF EXISTS `resource_sys`;
CREATE TABLE `resource_sys`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源名称',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源的url',
  `is_enabled` tinyint(1) NOT NULL COMMENT '资源是否有效，1-有效，0-无效',
  `icon_string` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源对应的awesome font图标字符串',
  `gmt_created` datetime(0) NOT NULL COMMENT '资源的创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '资源的修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of resource_sys
-- ----------------------------
INSERT INTO `resource_sys` VALUES (1, '管理员资源', '/sys/admin', 1, NULL, '2019-01-29 19:30:49', NULL);
INSERT INTO `resource_sys` VALUES (2, '角色资源', '/sys/role', 1, NULL, '2019-01-29 19:31:08', NULL);
INSERT INTO `resource_sys` VALUES (3, '员工资源', '/data/employee', 1, NULL, '2019-01-29 19:31:28', NULL);
INSERT INTO `resource_sys` VALUES (4, '组织资源', '/data/orgnization', 1, NULL, '2019-01-29 19:31:51', NULL);
INSERT INTO `resource_sys` VALUES (5, '工资资源', '/data/salary', 1, NULL, '2019-01-29 19:32:14', NULL);
INSERT INTO `resource_sys` VALUES (20, '测试admin', '/test/admin', 1, NULL, '2019-03-07 20:54:21', NULL);
INSERT INTO `resource_sys` VALUES (21, '测试manager', '/test/manager', 1, NULL, '2019-03-07 20:54:42', NULL);
INSERT INTO `resource_sys` VALUES (22, '测试personnel', '/test/personnel', 1, NULL, '2019-03-07 20:55:04', NULL);

-- ----------------------------
-- Table structure for role_resource
-- ----------------------------
DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_id` bigint(20) UNSIGNED NOT NULL COMMENT '外键，role的id',
  `resource_id` bigint(20) UNSIGNED NOT NULL COMMENT '外键，resource的id',
  `gmt_created` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `role_id_fk`(`role_id`) USING BTREE,
  INDEX `resource_id_fk`(`resource_id`) USING BTREE,
  CONSTRAINT `resource_id_fk` FOREIGN KEY (`resource_id`) REFERENCES `resource_sys` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `role_id_fk` FOREIGN KEY (`role_id`) REFERENCES `role_sys` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role_resource
-- ----------------------------
INSERT INTO `role_resource` VALUES (1, 1, 1, '2019-01-29 19:32:34');
INSERT INTO `role_resource` VALUES (2, 3, 2, '2019-01-29 19:32:45');
INSERT INTO `role_resource` VALUES (3, 4, 3, '2019-01-29 19:32:56');
INSERT INTO `role_resource` VALUES (4, 4, 4, '2019-01-29 19:33:08');
INSERT INTO `role_resource` VALUES (5, 1, 2, '2019-03-06 22:05:52');
INSERT INTO `role_resource` VALUES (6, 1, 3, '2019-03-06 22:06:01');
INSERT INTO `role_resource` VALUES (7, 1, 20, '2019-03-07 20:55:58');
INSERT INTO `role_resource` VALUES (8, 3, 21, '2019-03-07 20:56:12');
INSERT INTO `role_resource` VALUES (9, 4, 22, '2019-03-07 20:56:20');

-- ----------------------------
-- Table structure for role_sys
-- ----------------------------
DROP TABLE IF EXISTS `role_sys`;
CREATE TABLE `role_sys`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称,以ROLE_开头',
  `name_ch` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色中文名称',
  `gmt_created` datetime(0) NOT NULL COMMENT '角色创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '角色修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表存储了系统中的角色，角色是权限的一种表示方法，它代表了一组系统权限，拥有某个角色的管理员可以访问（获修改）某些资源。\r\n它和菜单表menu、管理员表admin联合起来完成系统的权限控制。' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role_sys
-- ----------------------------
INSERT INTO `role_sys` VALUES (1, 'ROLE_admin', '系统管理员', '2019-01-15 10:15:01', NULL);
INSERT INTO `role_sys` VALUES (3, 'ROLE_manager', '部门经理', '2019-01-15 10:17:57', NULL);
INSERT INTO `role_sys` VALUES (4, 'ROLE_personnel', '人事专员', '2019-01-15 10:17:57', NULL);
INSERT INTO `role_sys` VALUES (5, 'ROLE_recruiter', '招聘主管', '2019-01-15 10:17:57', NULL);
INSERT INTO `role_sys` VALUES (6, 'ROLE_performance', '薪酬绩效主管', '2019-01-15 10:17:57', NULL);

-- ----------------------------
-- Table structure for salary
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账目名称',
  `basic` int(11) NULL DEFAULT NULL COMMENT '基本工资',
  `bonus` int(11) NULL DEFAULT NULL COMMENT '奖金',
  `lunch_allowance` int(11) NULL DEFAULT NULL COMMENT '午餐补助',
  `traffic_allowance` int(11) NULL DEFAULT NULL COMMENT '交通补助',
  `all_salary` int(11) NULL DEFAULT NULL COMMENT '应发工资',
  `pension_base` int(11) NULL DEFAULT NULL COMMENT '养老金基数',
  `pension_per` decimal(10, 0) NULL DEFAULT NULL COMMENT '养老金比率',
  `medical_base` int(11) NULL DEFAULT NULL COMMENT '医疗基数',
  `medical_per` decimal(10, 0) NULL DEFAULT NULL COMMENT '医疗保险比率',
  `housing_fund_base` int(11) NULL DEFAULT NULL COMMENT '住房公积金基数',
  `housing_fund_per` decimal(10, 0) NULL DEFAULT NULL COMMENT '住房公积金比率',
  `gmt_created` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of salary
-- ----------------------------
INSERT INTO `salary` VALUES (1, '普通员工账套', 3000, 2000, 500, 500, NULL, 2000, 0, 1000, 0, 2000, 0, '2019-01-29 20:07:39', NULL);

SET FOREIGN_KEY_CHECKS = 1;
