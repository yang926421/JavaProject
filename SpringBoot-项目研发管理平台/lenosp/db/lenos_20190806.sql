/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50726
Source Host           : 127.0.0.1:3306
Source Database       : lenos

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-08-13 22:18:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for pdms_bug
-- ----------------------------
DROP TABLE IF EXISTS `pdms_bug`;
CREATE TABLE `pdms_bug` (
  `id` varchar(32) DEFAULT NULL,
  `project_id` varchar(32) DEFAULT NULL,
  `tenant_id` varchar(32) DEFAULT NULL,
  `requirement_id` varchar(32) DEFAULT NULL,
  `version_id` varchar(32) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `content` varchar(4000) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `finish_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user_id` varchar(32) DEFAULT NULL,
  `deal_user_id` varchar(32) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL COMMENT '0-新建 1-处理中 2-已完成'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pdms_bug
-- ----------------------------
INSERT INTO `pdms_bug` VALUES ('fd6f4b8fccd34416b908022278db5621', '038604f37ec7498b97663b898601b919', '63c7daa5195f4f5699f3d624bbef9b53', null, null, '234234', '232342342', '2019-08-11 13:48:27', '2019-08-11 13:48:27', 'acfc0e9232f54732a5d9ffe9071bf572', '63c7daa5195f4f5699f3d624bbef9b53', '2');
INSERT INTO `pdms_bug` VALUES ('deb4e737cb954394a2a4161e5ca8a291', '038604f37ec7498b97663b898601b919', '63c7daa5195f4f5699f3d624bbef9b53', null, 'a1b029f41a4c4f8aaf78efc4d67d7155', '123123123', '12', '2019-08-11 13:56:08', null, 'acfc0e9232f54732a5d9ffe9071bf572', '63c7daa5195f4f5699f3d624bbef9b53', '0');
INSERT INTO `pdms_bug` VALUES ('00b290c4217f486b966bb38e0a832fad', '038604f37ec7498b97663b898601b919', '63c7daa5195f4f5699f3d624bbef9b53', null, 'a1b029f41a4c4f8aaf78efc4d67d7155', 'reterte', 'rtertertertet', '2019-08-11 14:03:23', null, 'acfc0e9232f54732a5d9ffe9071bf572', '63c7daa5195f4f5699f3d624bbef9b53', '0');
INSERT INTO `pdms_bug` VALUES ('bda6c34e9eaa4418a2dc5d686eeabbc2', '038604f37ec7498b97663b898601b919', '63c7daa5195f4f5699f3d624bbef9b53', null, null, '发布3', '2', '2019-08-11 17:12:40', null, 'acfc0e9232f54732a5d9ffe9071bf572', null, '0');
INSERT INTO `pdms_bug` VALUES ('88bb0da826b04acfa8c9b32f31177f87', '038604f37ec7498b97663b898601b919', '63c7daa5195f4f5699f3d624bbef9b53', null, null, '发布3', '123', '2019-08-11 17:13:09', null, 'acfc0e9232f54732a5d9ffe9071bf572', null, '0');
INSERT INTO `pdms_bug` VALUES ('4ceb9c9a16b841ed8de6d5b35d5f1abe', '038604f37ec7498b97663b898601b919', '63c7daa5195f4f5699f3d624bbef9b53', null, '8fc0e01d06a4410cac1d89a11ca7f908', 'wqw', 'rewr', '2019-08-11 19:35:25', null, 'acfc0e9232f54732a5d9ffe9071bf572', '63c7daa5195f4f5699f3d624bbef9b53', '0');

-- ----------------------------
-- Table structure for pdms_iteration
-- ----------------------------
DROP TABLE IF EXISTS `pdms_iteration`;
CREATE TABLE `pdms_iteration` (
  `id` varchar(32) DEFAULT NULL,
  `project_id` varchar(32) DEFAULT NULL,
  `tenant_id` varchar(32) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `content` varchar(4000) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL COMMENT '0-新建 1-进行中 2-已完成'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pdms_iteration
-- ----------------------------
INSERT INTO `pdms_iteration` VALUES ('33e62225e15e47f38dcf9a4c43cda162', '038604f37ec7498b97663b898601b919', '63c7daa5195f4f5699f3d624bbef9b53', '123132', '1231232', '2019-08-11 00:00:00', '2019-08-15', '2019-08-22', '0');
INSERT INTO `pdms_iteration` VALUES ('9c12e1f4b510429789c9e14e3213c499', '038604f37ec7498b97663b898601b919', '63c7daa5195f4f5699f3d624bbef9b53', '3434', null, '2019-08-11 00:00:00', '2019-08-14', '2019-08-23', '0');
INSERT INTO `pdms_iteration` VALUES ('90d0c888cbb244ce9b1d08d55f824284', '038604f37ec7498b97663b898601b919', '63c7daa5195f4f5699f3d624bbef9b53', '234234', '234', '2019-08-11 14:41:05', '2019-08-08', '2019-08-22', '2');
INSERT INTO `pdms_iteration` VALUES ('6fc442e3f87c4eaea76f5a64974ae349', '038604f37ec7498b97663b898601b919', '63c7daa5195f4f5699f3d624bbef9b53', '7', null, '2019-08-11 19:35:06', '2019-08-14', '2019-08-30', '0');

-- ----------------------------
-- Table structure for pdms_iteration_issue
-- ----------------------------
DROP TABLE IF EXISTS `pdms_iteration_issue`;
CREATE TABLE `pdms_iteration_issue` (
  `id` varchar(32) DEFAULT NULL,
  `issue_id` varchar(32) DEFAULT NULL COMMENT '迭代关联问题（需求、BUG、任务）',
  `iteration_id` varchar(32) DEFAULT NULL,
  `issue_type` tinyint(4) DEFAULT NULL COMMENT '0-需求 1-缺陷 2-任务'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pdms_iteration_issue
-- ----------------------------
INSERT INTO `pdms_iteration_issue` VALUES ('903833f8aa8c47a89a7143b041a20f39', 'deb4e737cb954394a2a4161e5ca8a291', '90d0c888cbb244ce9b1d08d55f824284', '1');
INSERT INTO `pdms_iteration_issue` VALUES ('1a855e4003884ed9a8a51f5ae81b56e1', '2c0e1ac228dd497a9455b2271e307e90', '90d0c888cbb244ce9b1d08d55f824284', '2');
INSERT INTO `pdms_iteration_issue` VALUES ('94f2016c86164ccda1added8f9730e3f', 'bda6c34e9eaa4418a2dc5d686eeabbc2', '90d0c888cbb244ce9b1d08d55f824284', '1');
INSERT INTO `pdms_iteration_issue` VALUES ('74c5dc0706114cf885d3d1b3fea994e3', '6d4e7c8cf8df49a4b2dd7ca87cf32dfd', '90d0c888cbb244ce9b1d08d55f824284', '0');
INSERT INTO `pdms_iteration_issue` VALUES ('9943e2ce88d84831b54e2ff18dabf5ee', '1', '90d0c888cbb244ce9b1d08d55f824284', '0');

-- ----------------------------
-- Table structure for pdms_project
-- ----------------------------
DROP TABLE IF EXISTS `pdms_project`;
CREATE TABLE `pdms_project` (
  `id` varchar(50) NOT NULL,
  `tenant_id` varchar(50) DEFAULT NULL,
  `project_name` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_user_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pdms_project
-- ----------------------------
INSERT INTO `pdms_project` VALUES ('038604f37ec7498b97663b898601b919', '63c7daa5195f4f5699f3d624bbef9b53', 'ewewer', 'xe653;', '2019-08-10 10:19:15', 'acfc0e9232f54732a5d9ffe9071bf572');
INSERT INTO `pdms_project` VALUES ('0ff370d7117d49b8a96065f07e6fdb28', '63c7daa5195f4f5699f3d624bbef9b53', '测试i项目34', 'xe68e;', '2019-08-10 11:18:09', 'acfc0e9232f54732a5d9ffe9071bf572');
INSERT INTO `pdms_project` VALUES ('12345', null, '哈', 'xe702;', null, null);
INSERT INTO `pdms_project` VALUES ('12345789', null, '哈', 'xe702;', null, null);
INSERT INTO `pdms_project` VALUES ('123457890', null, '哈', 'xe702;', null, null);
INSERT INTO `pdms_project` VALUES ('123457890Q', null, '哈', 'xe702;', null, null);
INSERT INTO `pdms_project` VALUES ('123457890QH', null, '哈', 'xe702;', null, null);
INSERT INTO `pdms_project` VALUES ('12b601b6e44c47ffbd6a4ff6e40bd6ff', '63c7daa5195f4f5699f3d624bbef9b53', '测试项目', 'xe702;', '2019-08-10 11:16:50', 'acfc0e9232f54732a5d9ffe9071bf572');
INSERT INTO `pdms_project` VALUES ('1c22bdadd4644c4cabc2096e2f770376', null, '哈哈', 'xe702;', null, null);
INSERT INTO `pdms_project` VALUES ('2c574e7ec09f4b6c9d605caa8c57ce4a', '63c7daa5195f4f5699f3d624bbef9b53', '项目1', 'xe702;', '2019-08-10 10:09:18', 'acfc0e9232f54732a5d9ffe9071bf572');
INSERT INTO `pdms_project` VALUES ('329c8d4ba248461cb0add2c402d3686a', null, '哈哈', 'xe702;', null, null);
INSERT INTO `pdms_project` VALUES ('3826e56f2b5c48e9a281545cb531f18c', '63c7daa5195f4f5699f3d624bbef9b53', '测试项目5', 'xe68e;', '2019-08-11 19:36:33', 'acfc0e9232f54732a5d9ffe9071bf572');
INSERT INTO `pdms_project` VALUES ('4377b200fcfd49c28125ce51dbaff6cd', null, '哈哈', 'xe702;', null, null);
INSERT INTO `pdms_project` VALUES ('44b686a6a3844f74af6fab747456e5a5', '63c7daa5195f4f5699f3d624bbef9b53', 'wewer', 'xe702;', '2019-08-10 10:19:51', 'acfc0e9232f54732a5d9ffe9071bf572');
INSERT INTO `pdms_project` VALUES ('49bf420f74ad47db8c130fb2c1801727', '63c7daa5195f4f5699f3d624bbef9b53', '羡慕呃呃', 'xe702;', '2019-08-10 10:11:24', 'acfc0e9232f54732a5d9ffe9071bf572');
INSERT INTO `pdms_project` VALUES ('8339121c50314229831cd7c7da42c7d8', '63c7daa5195f4f5699f3d624bbef9b53', 'werer', 'xe702;', '2019-08-10 10:20:14', 'acfc0e9232f54732a5d9ffe9071bf572');
INSERT INTO `pdms_project` VALUES ('8b45b29c18e64f049140aaacc5b7dbda', '63c7daa5195f4f5699f3d624bbef9b53', '测试项目3', 'xe653;', '2019-08-11 19:36:16', 'acfc0e9232f54732a5d9ffe9071bf572');
INSERT INTO `pdms_project` VALUES ('94b7513acb5e4e1697f85fa3313372f8', null, '哈哈', 'xe702;', null, null);
INSERT INTO `pdms_project` VALUES ('9f975ba9b38c48c4bdeb60cc22ac9e81', null, '哈哈', 'xe702;', null, null);
INSERT INTO `pdms_project` VALUES ('b39c8464f8e548ffb2d2830226852ae8', '63c7daa5195f4f5699f3d624bbef9b53', 'sdf', 'xe702;', null, null);
INSERT INTO `pdms_project` VALUES ('b690085d79e943b7b91cdd1255b0252f', '63c7daa5195f4f5699f3d624bbef9b53', '测试项目333', 'xe68e;', '2019-08-10 11:17:50', 'acfc0e9232f54732a5d9ffe9071bf572');
INSERT INTO `pdms_project` VALUES ('c4320dfe2c1344cbb35bccc14dac99f2', null, '哈哈', 'xe702;', null, null);
INSERT INTO `pdms_project` VALUES ('c84269cefbd747f388c5d4e841086cc3', '63c7daa5195f4f5699f3d624bbef9b53', '二五', 'xe702;', '2019-08-10 10:10:05', 'acfc0e9232f54732a5d9ffe9071bf572');

-- ----------------------------
-- Table structure for pdms_project_online
-- ----------------------------
DROP TABLE IF EXISTS `pdms_project_online`;
CREATE TABLE `pdms_project_online` (
  `id` varchar(32) NOT NULL,
  `project_id` varchar(32) DEFAULT NULL,
  `tenant_id` varchar(32) DEFAULT NULL,
  `version_id` varchar(255) DEFAULT NULL,
  `iteration_id` varchar(32) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pdms_project_online
-- ----------------------------
INSERT INTO `pdms_project_online` VALUES ('051a73cccd584900983df3e6d33b595c', '038604f37ec7498b97663b898601b919', '63c7daa5195f4f5699f3d624bbef9b53', '8fc0e01d06a4410cac1d89a11ca7f908', '90d0c888cbb244ce9b1d08d55f824284', '455655345', null, '2019-08-11 17:20:21');
INSERT INTO `pdms_project_online` VALUES ('6a17cea8757047018144a8bd5593942a', '038604f37ec7498b97663b898601b919', '63c7daa5195f4f5699f3d624bbef9b53', '8fc0e01d06a4410cac1d89a11ca7f908', '6fc442e3f87c4eaea76f5a64974ae349', '233', '2232', '2019-08-11 19:35:33');
INSERT INTO `pdms_project_online` VALUES ('80a95b54c3024ee88572202f9bef6cf9', '038604f37ec7498b97663b898601b919', '63c7daa5195f4f5699f3d624bbef9b53', '8fc0e01d06a4410cac1d89a11ca7f908', '90d0c888cbb244ce9b1d08d55f824284', 'fwers', '<p>sdfsdfdfd</p><p>sd</p><p>fs</p><p>df</p><p>sdf</p><p>s</p><p>df</p>', '2019-08-11 17:20:30');
INSERT INTO `pdms_project_online` VALUES ('a1b029f41a4c4f8aaf78efc4d67d7155', '038604f37ec7498b97663b898601b919', '63c7daa5195f4f5699f3d624bbef9b53', null, null, 'v1.1.0', '新增', '2019-08-11 13:22:34');
INSERT INTO `pdms_project_online` VALUES ('e4f5eb15791e431ea24c8b7691504e88', '038604f37ec7498b97663b898601b919', '63c7daa5195f4f5699f3d624bbef9b53', null, '90d0c888cbb244ce9b1d08d55f824284', '999', '99999', '2019-08-11 17:16:21');

-- ----------------------------
-- Table structure for pdms_project_version
-- ----------------------------
DROP TABLE IF EXISTS `pdms_project_version`;
CREATE TABLE `pdms_project_version` (
  `id` varchar(32) NOT NULL,
  `project_id` varchar(32) DEFAULT NULL,
  `tenant_id` varchar(32) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pdms_project_version
-- ----------------------------
INSERT INTO `pdms_project_version` VALUES ('3cc35e18531f406cb50c092f034863cc', '038604f37ec7498b97663b898601b919', '63c7daa5195f4f5699f3d624bbef9b53', '123123', '123123123', '2019-08-11 14:31:13');
INSERT INTO `pdms_project_version` VALUES ('8fc0e01d06a4410cac1d89a11ca7f908', '038604f37ec7498b97663b898601b919', '63c7daa5195f4f5699f3d624bbef9b53', 'werwer', 'wer', '2019-08-11 14:36:38');
INSERT INTO `pdms_project_version` VALUES ('a1b029f41a4c4f8aaf78efc4d67d7155', '038604f37ec7498b97663b898601b919', '63c7daa5195f4f5699f3d624bbef9b53', 'v1.1.0', '新增', '2019-08-11 13:22:34');
INSERT INTO `pdms_project_version` VALUES ('a34500a0a03d4eab9e93692f48f45a13', '038604f37ec7498b97663b898601b919', '63c7daa5195f4f5699f3d624bbef9b53', 'erw', 'werwe', '2019-08-11 19:35:39');
INSERT INTO `pdms_project_version` VALUES ('e9c3c9eb4fed46a994bdf0ca0ff8e139', '038604f37ec7498b97663b898601b919', '63c7daa5195f4f5699f3d624bbef9b53', 'wer', null, '2019-08-11 14:36:05');

-- ----------------------------
-- Table structure for pdms_requirement
-- ----------------------------
DROP TABLE IF EXISTS `pdms_requirement`;
CREATE TABLE `pdms_requirement` (
  `id` varchar(32) DEFAULT NULL,
  `project_id` varchar(32) DEFAULT NULL,
  `tenant_id` varchar(32) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `content` varchar(4000) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `finish_date` datetime DEFAULT NULL,
  `create_user_id` varchar(32) DEFAULT NULL,
  `deal_user_id` varchar(32) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL COMMENT '0-新建 1-处理中 2-已完成'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pdms_requirement
-- ----------------------------
INSERT INTO `pdms_requirement` VALUES ('1', '038604f37ec7498b97663b898601b919', '63c7daa5195f4f5699f3d624bbef9b53', '需求1', '需求1', '2019-08-10 23:07:38', '2019-08-10 23:07:40', null, null, '1');
INSERT INTO `pdms_requirement` VALUES ('af8b064b145d4b8b88859ea2185a4e5d', '038604f37ec7498b97663b898601b919', '63c7daa5195f4f5699f3d624bbef9b53', 'tert', 'ertert', '2019-08-11 12:34:09', '2019-08-11 12:34:09', 'acfc0e9232f54732a5d9ffe9071bf572', null, '2');
INSERT INTO `pdms_requirement` VALUES ('6d4e7c8cf8df49a4b2dd7ca87cf32dfd', '038604f37ec7498b97663b898601b919', '63c7daa5195f4f5699f3d624bbef9b53', 'dsfsdfyyyy', '<p style=\"text-align: center;\"><b>sdfssfsdf0000<img src=\"http://localhost:8081/plugin/layui/images/face/15.gif\" alt=\"[生病]\"></b></p>', '2019-08-11 11:49:23', '2019-08-11 11:49:23', 'acfc0e9232f54732a5d9ffe9071bf572', null, '0');
INSERT INTO `pdms_requirement` VALUES ('3b7337d4dda947ad91da2aa0777effbd', '038604f37ec7498b97663b898601b919', '63c7daa5195f4f5699f3d624bbef9b53', '4343', '312323', '2019-08-11 12:34:00', '2019-08-11 12:34:00', 'acfc0e9232f54732a5d9ffe9071bf572', null, '2');
INSERT INTO `pdms_requirement` VALUES ('b3e34da0c59e4ad7868b20762d345604', '038604f37ec7498b97663b898601b919', '63c7daa5195f4f5699f3d624bbef9b53', '4234', '234243', '2019-08-11 12:32:17', '2019-08-11 12:32:17', 'acfc0e9232f54732a5d9ffe9071bf572', '63c7daa5195f4f5699f3d624bbef9b53', '1');
INSERT INTO `pdms_requirement` VALUES ('fd4fd8c49aca475d81b6f01c7aba7356', '038604f37ec7498b97663b898601b919', '63c7daa5195f4f5699f3d624bbef9b53', '34353', '434545', '2019-08-11 12:38:02', '2019-08-11 12:38:02', 'acfc0e9232f54732a5d9ffe9071bf572', '63c7daa5195f4f5699f3d624bbef9b53', '0');
INSERT INTO `pdms_requirement` VALUES ('41fff1e1464d4597b7aba99322636dcb', '038604f37ec7498b97663b898601b919', '63c7daa5195f4f5699f3d624bbef9b53', '需求2', 'dsfsdfsdf', '2019-08-11 12:40:15', '2019-08-11 12:43:43', 'acfc0e9232f54732a5d9ffe9071bf572', '63c7daa5195f4f5699f3d624bbef9b53', '1');
INSERT INTO `pdms_requirement` VALUES ('af16e5a63cbb407fb384cfa2ce5c141b', '038604f37ec7498b97663b898601b919', '63c7daa5195f4f5699f3d624bbef9b53', 'v1.1.0', '<p>本次发布内容：</p><p>新增：111</p><p>修改：222</p>', '2019-08-11 13:19:59', null, null, null, null);
INSERT INTO `pdms_requirement` VALUES ('a995b7783ee740b68bfba4acf2cff627', '038604f37ec7498b97663b898601b919', '63c7daa5195f4f5699f3d624bbef9b53', '88', null, '2019-08-11 19:35:00', null, 'acfc0e9232f54732a5d9ffe9071bf572', '63c7daa5195f4f5699f3d624bbef9b53', '0');

-- ----------------------------
-- Table structure for pdms_risk
-- ----------------------------
DROP TABLE IF EXISTS `pdms_risk`;
CREATE TABLE `pdms_risk` (
  `id` varchar(32) DEFAULT NULL,
  `project_id` varchar(32) DEFAULT NULL,
  `tenant_id` varchar(32) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `content` varchar(4000) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `finish_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user_id` varchar(32) DEFAULT NULL,
  `deal_user_id` varchar(32) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL COMMENT '0-新建 1-处理中 2-已解决'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pdms_risk
-- ----------------------------
INSERT INTO `pdms_risk` VALUES ('cd99809c669047b7b463ceeb5a111fd5', '038604f37ec7498b97663b898601b919', '63c7daa5195f4f5699f3d624bbef9b53', '323', '2312312313', '2019-08-11 13:32:54', '2019-08-11 13:32:54', 'acfc0e9232f54732a5d9ffe9071bf572', '63c7daa5195f4f5699f3d624bbef9b53', '0');
INSERT INTO `pdms_risk` VALUES ('b78b6a7b7e0b4f6ea9fad0cc7ed78fda', '038604f37ec7498b97663b898601b919', '63c7daa5195f4f5699f3d624bbef9b53', 'weewr', 'werwer', '2019-08-11 19:35:29', null, 'acfc0e9232f54732a5d9ffe9071bf572', '63c7daa5195f4f5699f3d624bbef9b53', '0');

-- ----------------------------
-- Table structure for pdms_task
-- ----------------------------
DROP TABLE IF EXISTS `pdms_task`;
CREATE TABLE `pdms_task` (
  `id` varchar(32) DEFAULT NULL,
  `project_id` varchar(32) DEFAULT NULL,
  `tenant_id` varchar(32) DEFAULT NULL,
  `requirement_id` varchar(32) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `content` varchar(4000) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `finish_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user_id` varchar(32) DEFAULT NULL,
  `deal_user_id` varchar(32) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL COMMENT '0-新建 1-处理中 2-已完成'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pdms_task
-- ----------------------------
INSERT INTO `pdms_task` VALUES ('2c0e1ac228dd497a9455b2271e307e90', '038604f37ec7498b97663b898601b919', '63c7daa5195f4f5699f3d624bbef9b53', null, '1231233434', '123123123', '2019-08-11 19:31:46', '2019-08-11 19:31:46', 'acfc0e9232f54732a5d9ffe9071bf572', '63c7daa5195f4f5699f3d624bbef9b53', '1');
INSERT INTO `pdms_task` VALUES ('4c6721c702044e95b89c813525e556a1', '038604f37ec7498b97663b898601b919', '63c7daa5195f4f5699f3d624bbef9b53', null, ' 师德师风', '发的古典风格&nbsp;', '2019-08-11 19:35:18', null, 'acfc0e9232f54732a5d9ffe9071bf572', '63c7daa5195f4f5699f3d624bbef9b53', '0');

-- ----------------------------
-- Table structure for pdms_tenant
-- ----------------------------
DROP TABLE IF EXISTS `pdms_tenant`;
CREATE TABLE `pdms_tenant` (
  `id` varchar(32) DEFAULT NULL,
  `tenant_name` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pdms_tenant
-- ----------------------------
INSERT INTO `pdms_tenant` VALUES ('63c7daa5195f4f5699f3d624bbef9b53', '99', '2019-08-08 21:57:05');
INSERT INTO `pdms_tenant` VALUES ('a297ebcc8b6146249bf526f84c37f742', '陕西XX科技有限责任公司', '2019-08-08 23:06:23');
INSERT INTO `pdms_tenant` VALUES ('b75e1a2e8c744130b3af48dc530c946d', '5353', '2019-08-13 22:15:18');
INSERT INTO `pdms_tenant` VALUES ('b815c4b0800c4f3ea375b2c0abdc1941', '5353', '2019-08-13 22:17:16');

-- ----------------------------
-- Table structure for pdms_tenant_user
-- ----------------------------
DROP TABLE IF EXISTS `pdms_tenant_user`;
CREATE TABLE `pdms_tenant_user` (
  `id` varchar(32) DEFAULT NULL,
  `tenant_id` varchar(32) DEFAULT NULL,
  `user_id` varchar(32) DEFAULT NULL,
  `is_admin` tinyint(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pdms_tenant_user
-- ----------------------------
INSERT INTO `pdms_tenant_user` VALUES ('21b6cc0d6c274cb982d344fe97563843', '63c7daa5195f4f5699f3d624bbef9b53', '63c7daa5195f4f5699f3d624bbef9b53', '1', '2019-08-08 21:57:05');
INSERT INTO `pdms_tenant_user` VALUES ('8a4063e015fb40279586bced2a96d80f', 'a297ebcc8b6146249bf526f84c37f742', 'a297ebcc8b6146249bf526f84c37f742', '1', '2019-08-08 23:06:23');
INSERT INTO `pdms_tenant_user` VALUES ('6e7cd4fa67a34612b2f7800ec7e911f7', 'a297ebcc8b6146249bf526f84c37f742', '712ce9e6862f41bd8936773dddec257d', '0', '2019-08-08 23:19:59');
INSERT INTO `pdms_tenant_user` VALUES ('4330128592414f70bfee3d5c1ac6a3db', '63c7daa5195f4f5699f3d624bbef9b53', '2211fec3e17c11e795ed201a068c6482', '0', '2019-08-10 12:49:34');
INSERT INTO `pdms_tenant_user` VALUES ('c0135b379dcf4c2582af6ad88b0cd6b3', 'a297ebcc8b6146249bf526f84c37f742', '2211fec3e17c11e795ed201a068c6482', '0', '2019-08-10 12:49:37');
INSERT INTO `pdms_tenant_user` VALUES ('4a5c92fed19b42f7af350097e9861bbd', 'b75e1a2e8c744130b3af48dc530c946d', 'b75e1a2e8c744130b3af48dc530c946d', '1', '2019-08-13 22:15:19');
INSERT INTO `pdms_tenant_user` VALUES ('50d0ff15fa694bd2bd082bc9b5cedcdd', 'b815c4b0800c4f3ea375b2c0abdc1941', 'b815c4b0800c4f3ea375b2c0abdc1941', '1', '2019-08-13 22:17:16');

-- ----------------------------
-- Table structure for sys_dict_item
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_item`;
CREATE TABLE `sys_dict_item` (
  `id` varchar(32) NOT NULL,
  `sequence` int(11) NOT NULL COMMENT '序号',
  `value` varchar(100) NOT NULL COMMENT '值',
  `description` varchar(100) NOT NULL COMMENT '描述',
  `type_id` varchar(32) NOT NULL COMMENT '字典id外检',
  `create_by` varchar(32) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(32) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dict_item
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type` (
  `id` varchar(32) NOT NULL,
  `code` varchar(255) NOT NULL COMMENT '编码',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标识',
  `text` varchar(255) NOT NULL COMMENT '字典名称',
  `create_by` varchar(32) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(32) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------

-- ----------------------------
-- Table structure for sys_job
-- ----------------------------
DROP TABLE IF EXISTS `sys_job`;
CREATE TABLE `sys_job` (
  `id` varchar(32) NOT NULL,
  `job_name` varchar(255) NOT NULL COMMENT '描述任务',
  `cron` varchar(255) NOT NULL COMMENT '任务表达式',
  `status` tinyint(1) NOT NULL COMMENT '状态:0未启动false/1启动true',
  `clazz_path` varchar(255) NOT NULL COMMENT '任务执行方法',
  `job_desc` varchar(255) DEFAULT NULL COMMENT '其他描述',
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_job
-- ----------------------------
INSERT INTO `sys_job` VALUES ('55147ebdf2f611e7a4fe201a068c6482', '测试定时demo1', '0/5 * * * * ?', '0', 'com.len.core.quartz.CustomQuartz.JobDemo1', '测试定时demo1', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-07 12:30:00', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-07-14 13:29:55');
INSERT INTO `sys_job` VALUES ('ab648a22f38d11e7aca0201a068c6482', '任务demo2', '0 0/1 * * * ?', '0', 'com.len.core.quartz.CustomQuartz.JobDemo2', '任务demo2', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-07 17:32:36', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-07-07 17:07:45');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `param` text,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('1', 'admin', '0:0:0:0:0:0:0:1', 'ATHOR', '添加用户', '[参数1:{\"age\":222,\"createBy\":\"acfc0e9232f54732a5d9ffe9071bf572\",\"createDate\":1534687227837,\"email\":\"\",\"id\":\"3c14c2f8316741e9aaeb29d78d03e958\",\"password\":\"2b8aae82f069cc838dfe8afc945f8045\",\"photo\":\"\",\"realName\":\"222\",\"username\":\"22222\"}][参数2:[\"dcb0f642fe9611e7b472201a068c6482\"]]', '2018-08-19 22:00:27');
INSERT INTO `sys_log` VALUES ('2', 'admin', '0:0:0:0:0:0:0:1', 'ATHOR', '更新角色', '[参数1:{\"id\":\"e346e96368484c8fa7f217ce550a0186\",\"remark\":\"副经理\",\"roleName\":\"DeputyManager\"}][参数2:[\"e06da471f90311e780aa201a068c6482\",\"4d603831fe9b11e7b472201a068c6482\",\"b7839f59fe8811e7b472201a068c6482\"]]', '2018-08-19 22:37:10');
INSERT INTO `sys_log` VALUES ('3', 'admin', '0:0:0:0:0:0:0:1', 'ATHOR', '添加用户', '[参数1:{\"age\":26,\"createBy\":\"acfc0e9232f54732a5d9ffe9071bf572\",\"createDate\":1534780367021,\"email\":\"\",\"id\":\"1ec421975ffe45229b48d4b9d712ff4f\",\"password\":\"533add1dc96c02469d50ca0ffdcb493a\",\"photo\":\"\",\"realName\":\"33\",\"username\":\"33333\"}][参数2:[\"dcb0f642fe9611e7b472201a068c6482\"]]', '2018-08-20 23:52:47');
INSERT INTO `sys_log` VALUES ('4', 'admin', '0:0:0:0:0:0:0:1', 'DEL', '删除用户', '[参数1:\"7c54823822f74db38076391b815e7f32\"][参数2:false]', '2018-09-09 10:45:05');
INSERT INTO `sys_log` VALUES ('5', 'admin', '0:0:0:0:0:0:0:1', 'DEL', '删除用户', '[参数1:\"7c9c4337873e4ffbb57052d6a852f78e\"][参数2:false]', '2018-09-09 10:45:08');
INSERT INTO `sys_log` VALUES ('6', 'admin', '0:0:0:0:0:0:0:1', 'DEL', '删除用户', '[参数1:\"95ba3ecf3f53478e8adc6f2b31b92636\"][参数2:false]', '2018-09-09 10:45:11');
INSERT INTO `sys_log` VALUES ('7', 'admin', '0:0:0:0:0:0:0:1', 'DEL', '删除用户', '[参数1:\"9e3dc630d2064a0084c8f43517f91520\"][参数2:false]', '2018-09-09 10:45:13');
INSERT INTO `sys_log` VALUES ('8', 'admin', '0:0:0:0:0:0:0:1', 'DEL', '删除用户', '[参数1:\"b74ffd759ff34222939bfafe33886461\"][参数2:false]', '2018-09-09 10:45:15');
INSERT INTO `sys_log` VALUES ('9', 'admin', '0:0:0:0:0:0:0:1', 'DEL', '删除用户', '[参数1:\"af36a0e897ab4a26b104b77427994e56\"][参数2:false]', '2018-09-09 10:45:17');
INSERT INTO `sys_log` VALUES ('10', 'admin', '0:0:0:0:0:0:0:1', 'DEL', '删除用户', '[参数1:\"c28be4153d1c4df7b955aa88b1f0cf9a\"][参数2:false]', '2018-09-09 10:45:19');
INSERT INTO `sys_log` VALUES ('11', 'admin', '0:0:0:0:0:0:0:1', 'DEL', '删除用户', '[参数1:\"eaca1d4854ba44228cc4c0ed38546b17\"][参数2:false]', '2018-09-09 10:45:21');
INSERT INTO `sys_log` VALUES ('12', 'admin', '0:0:0:0:0:0:0:1', 'DEL', '删除用户', '[参数1:\"0f3672f9dcb2408c87be10d9f1702c03\"][参数2:false]', '2018-09-09 10:45:23');
INSERT INTO `sys_log` VALUES ('13', 'admin', '0:0:0:0:0:0:0:1', 'DEL', '删除用户', '[参数1:\"237b2cf56a3248f9a43a4f2194ac3317\"][参数2:false]', '2018-09-09 10:45:25');
INSERT INTO `sys_log` VALUES ('14', 'admin', '0:0:0:0:0:0:0:1', 'DEL', '删除用户', '[参数1:\"2453ed0f16e6402b8acecd6b6dfac789\"][参数2:false]', '2018-09-09 10:45:27');
INSERT INTO `sys_log` VALUES ('15', 'admin', '0:0:0:0:0:0:0:1', 'ATHOR', '添加角色', '[参数1:{\"createBy\":\"acfc0e9232f54732a5d9ffe9071bf572\",\"createDate\":1538360470622,\"id\":\"4bb891d8caf84cc6ba27e515e80ac40d\",\"remark\":\"博客管理员\",\"roleName\":\"blogAdmin\"}][参数2:null]', '2018-10-01 10:21:10');
INSERT INTO `sys_log` VALUES ('16', 'admin', '0:0:0:0:0:0:0:1', 'UPDATE', '更新用户', '[参数1:{\"age\":24,\"email\":\"\",\"id\":\"acfc0e9232f54732a5d9ffe9071bf572\",\"photo\":\"2d4c37c3-c106-4288-9c0d-e7fe1b8adc72.jpeg\",\"realName\":\"管理员\"}][参数2:[\"4bb891d8caf84cc6ba27e515e80ac40d\",\"2619a672e53811e7b983201a068c6482\"]]', '2018-10-01 10:21:19');
INSERT INTO `sys_log` VALUES ('17', 'admin', '0:0:0:0:0:0:0:1', 'ATHOR', '更新角色', '[参数1:{\"id\":\"4bb891d8caf84cc6ba27e515e80ac40d\",\"remark\":\"博客管理员\",\"roleName\":\"blogAdmin\"}][参数2:null]', '2018-10-12 22:14:22');
INSERT INTO `sys_log` VALUES ('18', 'admin', '0:0:0:0:0:0:0:1', 'UPDATE', '更新用户', '[参数1:{\"age\":25,\"email\":\"1544040976@qq.com\",\"id\":\"a4a743bffe9711e7b472201a068c6482\",\"photo\":\"662d5a3b-56aa-4bbb-bd47-194e24db1d60.jpeg\",\"realName\":\"zxm\"}][参数2:[\"4bb891d8caf84cc6ba27e515e80ac40d\"]]', '2018-11-25 15:00:41');
INSERT INTO `sys_log` VALUES ('19', 'admin', '0:0:0:0:0:0:0:1', 'UPDATE', '修改密码', '[参数1:\"a4a743bffe9711e7b472201a068c6482\"][参数2:\"123456\"][参数3:\"123456\"]', '2018-11-25 15:01:03');
INSERT INTO `sys_log` VALUES ('26', 'admin', '0:0:0:0:0:0:0:1', 'ATHOR', '添加角色', '[参数1:{\"createBy\":\"acfc0e9232f54732a5d9ffe9071bf572\",\"createDate\":1544529759053,\"id\":\"35f7934d335e4641b7887e4b3b1885a5\",\"remark\":\"cs\",\"roleName\":\"cs\"}][参数2:[\"cfda8029dfb311e7b555201a068c6482\",\"3873ccc2dfda11e7b555201a068c6482\",\"18bf8d5df09511e78a57201a068c6482\"]]', '2018-12-11 20:02:39');
INSERT INTO `sys_log` VALUES ('27', 'admin', '0:0:0:0:0:0:0:1', 'DEL', '删除角色', '[参数1:\"35f7934d335e4641b7887e4b3b1885a5\"]', '2018-12-11 20:02:46');
INSERT INTO `sys_log` VALUES ('28', 'admin', '0:0:0:0:0:0:0:1', 'UPDATE', '添加菜单', '[参数1:{\"children\":[],\"createBy\":\"acfc0e9232f54732a5d9ffe9071bf572\",\"createDate\":1544538738063,\"icon\":\"\",\"id\":\"3fa6f0049d774882a91b176415fc56a8\",\"menuType\":0,\"name\":\"11\",\"num\":0,\"orderNum\":1,\"url\":\"11\"}][参数2:', '2018-12-11 22:32:18');
INSERT INTO `sys_log` VALUES ('29', 'admin', '0:0:0:0:0:0:0:1', 'ADD', '更新菜单', '[参数1:{\"children\":[],\"icon\":\"\",\"id\":\"3fa6f0049d774882a91b176415fc56a8\",\"name\":\"11\",\"num\":0,\"orderNum\":1,\"permission\":\"\",\"url\":\"11\"}]', '2018-12-11 22:32:22');
INSERT INTO `sys_log` VALUES ('30', 'admin', '0:0:0:0:0:0:0:1', 'DEL', '删除菜单', '[参数1:\"3fa6f0049d774882a91b176415fc56a8\"]', '2018-12-11 22:32:25');
INSERT INTO `sys_log` VALUES ('31', 'admin', '0:0:0:0:0:0:0:1', 'ATHOR', '添加用户', '[参数1:{\"age\":111,\"createBy\":\"acfc0e9232f54732a5d9ffe9071bf572\",\"createDate\":1544538762207,\"email\":\"\",\"id\":\"a07e4c55015147789d5e1e797b4af2ec\",\"password\":\"0a27dab34aa0db28fb5d04f62989cb04\",\"photo\":\"\",\"realName\":\"1111\",\"username\":\"1111\"}][参数2:[\"dcb0f642fe9611e7b472201a068c6482\"]]', '2018-12-11 22:32:42');
INSERT INTO `sys_log` VALUES ('32', 'admin', '0:0:0:0:0:0:0:1', 'UPDATE', '更新用户', '[参数1:{\"age\":111,\"email\":\"\",\"id\":\"a07e4c55015147789d5e1e797b4af2ec\",\"photo\":\"\",\"realName\":\"1111\"}][参数2:[\"dcb0f642fe9611e7b472201a068c6482\"]]', '2018-12-11 22:32:51');
INSERT INTO `sys_log` VALUES ('33', 'admin', '0:0:0:0:0:0:0:1', 'DEL', '删除用户', '[参数1:\"a07e4c55015147789d5e1e797b4af2ec\"][参数2:false]', '2018-12-11 22:32:57');
INSERT INTO `sys_log` VALUES ('34', 'admin', '0:0:0:0:0:0:0:1', 'UPDATE', '更新用户', '[参数1:{\"age\":111,\"email\":\"\",\"id\":\"a07e4c55015147789d5e1e797b4af2ec\",\"photo\":\"\",\"realName\":\"1111\"}][参数2:null]', '2018-12-11 22:33:04');
INSERT INTO `sys_log` VALUES ('35', 'admin', '0:0:0:0:0:0:0:1', 'DEL', '删除用户', '[参数1:\"a07e4c55015147789d5e1e797b4af2ec\"][参数2:false]', '2018-12-11 22:33:07');
INSERT INTO `sys_log` VALUES ('36', 'admin', '0:0:0:0:0:0:0:1', 'ATHOR', '更新角色', '[参数1:{\"id\":\"2619a672e53811e7b983201a068c6482\",\"remark\":\"管理员\",\"roleName\":\"admin\"}][参数2:[\"cfda8029dfb311e7b555201a068c6482\",\"3873ccc2dfda11e7b555201a068c6482\",\"18bf8d5df09511e78a57201a068c6482\",\"cfe54921dfb311e7b555201a068c6482\",\"433089a6eb0111e782d5201a068c6482\",\"cfe54921dfb311e7b555201a068c6483\",\"e3b11497eb9e11e7928d201a068c6482\",\"f23f6a6bf09511e78a57201a068c6482\",\"cff61424dfb311e7b555201a068c6482\",\"0e6c8d4cf09511e78a57201a068c6482\",\"2b56410cf09411e78a57201a068c6482\",\"88b8e5d1f38911e7aca0201a068c6482\",\"ff015ea5f09411e78a57201a068c6482\",\"a1ca6642ec5e11e7a472201a068c6482\",\"6dc13c6eec5f11e7a472201a068c6482\",\"7967e098ee0611e7a60d201a068c6482\",\"b441914cee0811e7a60d201a068c6482\",\"6931fd22f09611e78a57201a068c6482\",\"e9a13e55f35911e7aca0201a068c6482\",\"5ae3d4e9f38e11e7aca0201a068c6482\",\"6315968bf37111e7aca0201a068c6482\",\"69f3f59cf38e11e7aca0201a068c6482\",\"788d8e34f38e11e7aca0201a068c6482\",\"873f30b0f38e11e7aca0201a068c6482\",\"ecda560cf36f11e7aca0201a068c6482\",\"e06da471f90311e780aa201a068c6482\",\"28661300f9d411e7a009201a068c6482\",\"4d603831fe9b11e7b472201a068c6482\",\"63da4415fc6211e7a781201a068c6482\",\"b7839f59fe8811e7b472201a068c6482\"]]', '2018-12-11 22:33:30');
INSERT INTO `sys_log` VALUES ('37', 'admin', '0:0:0:0:0:0:0:1', 'UPDATE', '更新用户', '[参数1:{\"age\":26,\"email\":\"\",\"id\":\"1ec421975ffe45229b48d4b9d712ff4f\",\"photo\":\"\",\"realName\":\"33\"}][参数2:[\"dcb0f642fe9611e7b472201a068c6482\"]]', '2018-12-11 22:57:16');
INSERT INTO `sys_log` VALUES ('38', 'admin', '0:0:0:0:0:0:0:1', 'UPDATE', '添加菜单', '[参数1:{\"children\":[],\"createBy\":\"acfc0e9232f54732a5d9ffe9071bf572\",\"createDate\":1564967445355,\"icon\":\"\",\"id\":\"870fddcd000148cd826d2dbd741a86a0\",\"menuType\":0,\"name\":\"项目管理\",\"num\":0,\"orderNum\":4}][参数2:', '2019-08-05 09:10:45');
INSERT INTO `sys_log` VALUES ('39', 'admin', '0:0:0:0:0:0:0:1', 'ADD', '更新菜单', '[参数1:{\"children\":[],\"icon\":\"\",\"id\":\"870fddcd000148cd826d2dbd741a86a0\",\"name\":\"项目研发管理\",\"num\":0,\"orderNum\":4,\"permission\":\"\",\"url\":\"\"}]', '2019-08-05 09:11:45');
INSERT INTO `sys_log` VALUES ('40', 'admin', '0:0:0:0:0:0:0:1', 'UPDATE', '添加菜单', '[参数1:{\"children\":[],\"createBy\":\"acfc0e9232f54732a5d9ffe9071bf572\",\"createDate\":1564967553185,\"icon\":\"\",\"id\":\"54a2a6456ed54df4ab73d3a0010b2f5d\",\"menuType\":0,\"name\":\"项目管理\",\"num\":0,\"orderNum\":1,\"pId\":\"870fddcd000148cd826d2dbd741a86a0\",\"permission\":\"11\",\"url\":\"11\"}][参数2:', '2019-08-05 09:12:33');
INSERT INTO `sys_log` VALUES ('41', 'admin', '0:0:0:0:0:0:0:1', 'UPDATE', '添加菜单', '[参数1:{\"children\":[],\"createBy\":\"acfc0e9232f54732a5d9ffe9071bf572\",\"createDate\":1564967683679,\"icon\":\"\",\"id\":\"d085ccb1f3514674be8078e4ae90cc48\",\"menuType\":0,\"name\":\"需求管理\",\"num\":0,\"orderNum\":2,\"pId\":\"870fddcd000148cd826d2dbd741a86a0\",\"permission\":\"22\",\"url\":\"22\"}][参数2:', '2019-08-05 09:14:43');
INSERT INTO `sys_log` VALUES ('42', 'admin', '0:0:0:0:0:0:0:1', 'UPDATE', '添加菜单', '[参数1:{\"children\":[],\"createBy\":\"acfc0e9232f54732a5d9ffe9071bf572\",\"createDate\":1564967780613,\"icon\":\"\",\"id\":\"a49b0ada86214b8f888972500a405a9d\",\"menuType\":0,\"name\":\"迭代管理\",\"num\":0,\"orderNum\":3,\"pId\":\"870fddcd000148cd826d2dbd741a86a0\",\"permission\":\"33\",\"url\":\"33\"}][参数2:', '2019-08-05 09:16:20');
INSERT INTO `sys_log` VALUES ('43', 'admin', '0:0:0:0:0:0:0:1', 'UPDATE', '添加菜单', '[参数1:{\"children\":[],\"createBy\":\"acfc0e9232f54732a5d9ffe9071bf572\",\"createDate\":1564967814719,\"icon\":\"\",\"id\":\"b61c9257bb7a401b94d25b28c481c95d\",\"menuType\":0,\"name\":\"任务管理\",\"num\":0,\"orderNum\":4,\"pId\":\"870fddcd000148cd826d2dbd741a86a0\",\"permission\":\"11\",\"url\":\"11\"}][参数2:', '2019-08-05 09:16:54');
INSERT INTO `sys_log` VALUES ('44', 'admin', '0:0:0:0:0:0:0:1', 'UPDATE', '添加菜单', '[参数1:{\"children\":[],\"createBy\":\"acfc0e9232f54732a5d9ffe9071bf572\",\"createDate\":1564967864758,\"icon\":\"\",\"id\":\"05409cef2b4c4d9188071dc0d6f9f111\",\"menuType\":0,\"name\":\"缺陷管理\",\"num\":0,\"orderNum\":5,\"pId\":\"870fddcd000148cd826d2dbd741a86a0\",\"permission\":\"1\",\"url\":\"1\"}][参数2:', '2019-08-05 09:17:44');
INSERT INTO `sys_log` VALUES ('45', 'admin', '0:0:0:0:0:0:0:1', 'UPDATE', '添加菜单', '[参数1:{\"children\":[],\"createBy\":\"acfc0e9232f54732a5d9ffe9071bf572\",\"createDate\":1564967905514,\"icon\":\"\",\"id\":\"f5c2616c3f814e0abfa84df3598618a2\",\"menuType\":0,\"name\":\"风险管理\",\"num\":0,\"orderNum\":6,\"pId\":\"870fddcd000148cd826d2dbd741a86a0\",\"permission\":\"1\",\"url\":\"1\"}][参数2:', '2019-08-05 09:18:25');
INSERT INTO `sys_log` VALUES ('46', 'admin', '0:0:0:0:0:0:0:1', 'UPDATE', '添加菜单', '[参数1:{\"children\":[],\"createBy\":\"acfc0e9232f54732a5d9ffe9071bf572\",\"createDate\":1564967945461,\"icon\":\"\",\"id\":\"5c3f958cb1fd48219f0b8396819def14\",\"menuType\":0,\"name\":\"项目发布\",\"num\":0,\"orderNum\":6,\"pId\":\"870fddcd000148cd826d2dbd741a86a0\",\"permission\":\"6\",\"url\":\"336\"}][参数2:', '2019-08-05 09:19:05');
INSERT INTO `sys_log` VALUES ('47', 'admin', '0:0:0:0:0:0:0:1', 'UPDATE', '添加菜单', '[参数1:{\"children\":[],\"createBy\":\"acfc0e9232f54732a5d9ffe9071bf572\",\"createDate\":1564967974437,\"icon\":\"\",\"id\":\"a1b1cd2fc651445cb2c22ff85057c31f\",\"menuType\":0,\"name\":\"版本管理\",\"num\":0,\"orderNum\":8,\"pId\":\"870fddcd000148cd826d2dbd741a86a0\",\"permission\":\"8\",\"url\":\"8\"}][参数2:', '2019-08-05 09:19:34');
INSERT INTO `sys_log` VALUES ('48', 'admin', '0:0:0:0:0:0:0:1', 'ATHOR', '更新角色', '[参数1:{\"id\":\"2619a672e53811e7b983201a068c6482\",\"remark\":\"管理员\",\"roleName\":\"admin\"}][参数2:[\"cfda8029dfb311e7b555201a068c6482\",\"3873ccc2dfda11e7b555201a068c6482\",\"18bf8d5df09511e78a57201a068c6482\",\"cfe54921dfb311e7b555201a068c6482\",\"433089a6eb0111e782d5201a068c6482\",\"cfe54921dfb311e7b555201a068c6483\",\"e3b11497eb9e11e7928d201a068c6482\",\"f23f6a6bf09511e78a57201a068c6482\",\"cff61424dfb311e7b555201a068c6482\",\"0e6c8d4cf09511e78a57201a068c6482\",\"2b56410cf09411e78a57201a068c6482\",\"88b8e5d1f38911e7aca0201a068c6482\",\"ff015ea5f09411e78a57201a068c6482\",\"a1ca6642ec5e11e7a472201a068c6482\",\"6dc13c6eec5f11e7a472201a068c6482\",\"7967e098ee0611e7a60d201a068c6482\",\"b441914cee0811e7a60d201a068c6482\",\"6931fd22f09611e78a57201a068c6482\",\"e9a13e55f35911e7aca0201a068c6482\",\"5ae3d4e9f38e11e7aca0201a068c6482\",\"6315968bf37111e7aca0201a068c6482\",\"69f3f59cf38e11e7aca0201a068c6482\",\"788d8e34f38e11e7aca0201a068c6482\",\"873f30b0f38e11e7aca0201a068c6482\",\"ecda560cf36f11e7aca0201a068c6482\",\"e06da471f90311e780aa201a068c6482\",\"28661300f9d411e7a009201a068c6482\",\"4d603831fe9b11e7b472201a068c6482\",\"63da4415fc6211e7a781201a068c6482\",\"b7839f59fe8811e7b472201a068c6482\",\"870fddcd000148cd826d2dbd741a86a0\",\"05409cef2b4c4d9188071dc0d6f9f111\",\"54a2a6456ed54df4ab73d3a0010b2f5d\",\"5c3f958cb1fd48219f0b8396819def14\",\"a1b1cd2fc651445cb2c22ff85057c31f\",\"a49b0ada86214b8f888972500a405a9d\",\"b61c9257bb7a401b94d25b28c481c95d\",\"d085ccb1f3514674be8078e4ae90cc48\",\"f5c2616c3f814e0abfa84df3598618a2\"]]', '2019-08-05 09:20:06');
INSERT INTO `sys_log` VALUES ('49', 'admin', '0:0:0:0:0:0:0:1', 'ATHOR', '添加角色', '[参数1:{\"createBy\":\"acfc0e9232f54732a5d9ffe9071bf572\",\"createDate\":1565169483843,\"id\":\"a2cf96c879cb489a9f3064e51058cb7a\",\"remark\":\"333\",\"roleName\":\"333\"}][参数2:null]', '2019-08-07 17:18:04');
INSERT INTO `sys_log` VALUES ('50', 'admin', '0:0:0:0:0:0:0:1', 'ATHOR', '添加角色', '[参数1:{\"createDate\":1565188398765,\"id\":\"f40b1dcd1f93462e94fe03aa15878b44\",\"remark\":\"租户角色\",\"roleName\":\"租户角色\"}][参数2:[\"cfda8029dfb311e7b555201a068c6482\",\"cfe54921dfb311e7b555201a068c6482\",\"433089a6eb0111e782d5201a068c6482\",\"cfe54921dfb311e7b555201a068c6483\",\"e3b11497eb9e11e7928d201a068c6482\",\"f23f6a6bf09511e78a57201a068c6482\",\"cff61424dfb311e7b555201a068c6482\",\"0e6c8d4cf09511e78a57201a068c6482\",\"2b56410cf09411e78a57201a068c6482\",\"88b8e5d1f38911e7aca0201a068c6482\",\"ff015ea5f09411e78a57201a068c6482\",\"870fddcd000148cd826d2dbd741a86a0\",\"05409cef2b4c4d9188071dc0d6f9f111\",\"54a2a6456ed54df4ab73d3a0010b2f5d\",\"5c3f958cb1fd48219f0b8396819def14\",\"a1b1cd2fc651445cb2c22ff85057c31f\",\"a49b0ada86214b8f888972500a405a9d\",\"b61c9257bb7a401b94d25b28c481c95d\",\"d085ccb1f3514674be8078e4ae90cc48\",\"f5c2616c3f814e0abfa84df3598618a2\"]]', '2019-08-07 22:33:18');
INSERT INTO `sys_log` VALUES ('51', 'admin', '0:0:0:0:0:0:0:1', 'ATHOR', '更新角色', '[参数1:{\"id\":\"2619a672e53811e7b983201a068c6482\",\"remark\":\"管理员\",\"roleName\":\"admin\"}][参数2:[\"cfda8029dfb311e7b555201a068c6482\",\"3873ccc2dfda11e7b555201a068c6482\",\"18bf8d5df09511e78a57201a068c6482\",\"cfe54921dfb311e7b555201a068c6482\",\"433089a6eb0111e782d5201a068c6482\",\"cfe54921dfb311e7b555201a068c6483\",\"e3b11497eb9e11e7928d201a068c6482\",\"f23f6a6bf09511e78a57201a068c6482\",\"cff61424dfb311e7b555201a068c6482\",\"0e6c8d4cf09511e78a57201a068c6482\",\"2b56410cf09411e78a57201a068c6482\",\"88b8e5d1f38911e7aca0201a068c6482\",\"ff015ea5f09411e78a57201a068c6482\",\"870fddcd000148cd826d2dbd741a86a0\",\"05409cef2b4c4d9188071dc0d6f9f111\",\"54a2a6456ed54df4ab73d3a0010b2f5d\",\"5c3f958cb1fd48219f0b8396819def14\",\"a1b1cd2fc651445cb2c22ff85057c31f\",\"a49b0ada86214b8f888972500a405a9d\",\"b61c9257bb7a401b94d25b28c481c95d\",\"d085ccb1f3514674be8078e4ae90cc48\",\"f5c2616c3f814e0abfa84df3598618a2\"]]', '2019-08-08 22:02:49');
INSERT INTO `sys_log` VALUES ('52', 'admin', '0:0:0:0:0:0:0:1', 'ATHOR', '添加用户', '[参数1:{\"age\":12,\"email\":\"\",\"password\":\"123456\",\"photo\":\"\",\"realName\":\"34\",\"username\":\"123\"}][参数2:null]', '2019-08-08 22:42:12');
INSERT INTO `sys_log` VALUES ('53', 'admin', '0:0:0:0:0:0:0:1', 'ATHOR', '添加用户', '[参数1:{\"age\":12,\"createDate\":1565275349056,\"email\":\"\",\"id\":\"4d92633d44e242b286ba0dcc1c5c5691\",\"password\":\"aaaf34f1ec581c22451f7bd65377c208\",\"photo\":\"\",\"realName\":\"34\",\"username\":\"123\"}][参数2:[\"f40b1dcd1f93462e94fe03aa15878b44\"]]', '2019-08-08 22:42:29');
INSERT INTO `sys_log` VALUES ('54', 'admin', '0:0:0:0:0:0:0:1', 'ATHOR', '添加用户', '[参数1:{\"age\":22,\"createDate\":1565275516689,\"email\":\"\",\"id\":\"2b85d71a5c9540e8a52690ffafa9a855\",\"password\":\"5831c5445bf6b98430d199b0c3014bc5\",\"photo\":\"\",\"realName\":\"88\",\"username\":\"888888\"}][参数2:[\"f40b1dcd1f93462e94fe03aa15878b44\"]]', '2019-08-08 22:45:16');
INSERT INTO `sys_log` VALUES ('55', 'admin', '0:0:0:0:0:0:0:1', 'ATHOR', '添加用户', '[参数1:{\"age\":9,\"createDate\":1565275625671,\"email\":\"\",\"id\":\"90060ce771834f358cbde68bb719447c\",\"password\":\"b6e0c515d98512bbb7e246ecea692dfb\",\"photo\":\"\",\"realName\":\"9\",\"username\":\"999\"}][参数2:[\"f40b1dcd1f93462e94fe03aa15878b44\"]]', '2019-08-08 22:47:05');
INSERT INTO `sys_log` VALUES ('56', 'admin', '0:0:0:0:0:0:0:1', 'DEL', '删除菜单', '[参数1:\"6dc13c6eec5f11e7a472201a068c6482\"]', '2019-08-08 22:56:52');
INSERT INTO `sys_log` VALUES ('57', 'admin', '0:0:0:0:0:0:0:1', 'DEL', '删除菜单', '[参数1:\"6dc13c6eec5f11e7a472201a068c6482\"]', '2019-08-08 22:56:56');
INSERT INTO `sys_log` VALUES ('58', 'admin', '0:0:0:0:0:0:0:1', 'DEL', '删除菜单', '[参数1:\"6dc13c6eec5f11e7a472201a068c6482\"]', '2019-08-08 22:57:01');
INSERT INTO `sys_log` VALUES ('59', 'admin', '0:0:0:0:0:0:0:1', 'ATHOR', '添加角色', '[参数1:{\"createDate\":1565276416622,\"id\":\"86f96a8dd7de4a51ad818d8fdba96fc4\",\"remark\":\"11\",\"roleName\":\"角色11\",\"tenantId\":\"63c7daa5195f4f5699f3d624bbef9b53\"}][参数2:[\"870fddcd000148cd826d2dbd741a86a0\",\"05409cef2b4c4d9188071dc0d6f9f111\",\"54a2a6456ed54df4ab73d3a0010b2f5d\",\"5c3f958cb1fd48219f0b8396819def14\",\"a1b1cd2fc651445cb2c22ff85057c31f\",\"a49b0ada86214b8f888972500a405a9d\",\"b61c9257bb7a401b94d25b28c481c95d\",\"d085ccb1f3514674be8078e4ae90cc48\",\"f5c2616c3f814e0abfa84df3598618a2\"]]', '2019-08-08 23:00:16');
INSERT INTO `sys_log` VALUES ('60', 'cyb999', '0:0:0:0:0:0:0:1', 'ATHOR', '添加角色', '[参数1:{\"createDate\":1565277576290,\"id\":\"b72df24b2a7b42678d7a8c0b9121c103\",\"remark\":\"1\",\"roleName\":\"开发人员\",\"tenantId\":\"a297ebcc8b6146249bf526f84c37f742\"}][参数2:[\"870fddcd000148cd826d2dbd741a86a0\",\"05409cef2b4c4d9188071dc0d6f9f111\",\"b61c9257bb7a401b94d25b28c481c95d\"]]', '2019-08-08 23:19:36');
INSERT INTO `sys_log` VALUES ('61', 'cyb999', '0:0:0:0:0:0:0:1', 'ATHOR', '添加用户', '[参数1:{\"age\":11,\"createDate\":1565277599397,\"email\":\"\",\"id\":\"712ce9e6862f41bd8936773dddec257d\",\"password\":\"a07e4c18324811b0d0ec17a89e0f855b\",\"photo\":\"\",\"realName\":\"张三\",\"username\":\"zhangsan\"}][参数2:[\"b72df24b2a7b42678d7a8c0b9121c103\"]]', '2019-08-08 23:19:59');
INSERT INTO `sys_log` VALUES ('62', 'admin', '0:0:0:0:0:0:0:1', 'ATHOR', '添加用户', '[参数1:{\"age\":123,\"email\":\"\",\"password\":\"111111\",\"photo\":\"\",\"realName\":\"132\",\"username\":\"admin3333\"}][参数2:null]', '2019-08-10 13:01:25');
INSERT INTO `sys_log` VALUES ('63', 'admin', '0:0:0:0:0:0:0:1', 'ATHOR', '添加用户', '[参数1:{\"age\":123,\"createDate\":1565413287405,\"email\":\"\",\"id\":\"8cd4ba927a684150914ee63b450225aa\",\"password\":\"1405370bd387bfe68c80527ebd03e680\",\"photo\":\"\",\"realName\":\"132\",\"username\":\"admin3333\"}][参数2:[\"86f96a8dd7de4a51ad818d8fdba96fc4\"]]', '2019-08-10 13:01:27');
INSERT INTO `sys_log` VALUES ('66', 'admin', '0:0:0:0:0:0:0:1', 'DEL', '删除用户', '[参数1:\"8cd4ba927a684150914ee63b450225aa\"][参数2:true]', '2019-08-10 13:05:13');
INSERT INTO `sys_log` VALUES ('67', 'admin', '0:0:0:0:0:0:0:1', 'ATHOR', '添加用户', '[参数1:{\"age\":12,\"createDate\":1565413733155,\"email\":\"\",\"id\":\"bd06fa6e058249b5bc54231a41cf3e16\",\"password\":\"c97a54f90ec169d0a19d73f6fbb5e850\",\"photo\":\"\",\"realName\":\"123\",\"username\":\"1313123\"}][参数2:[\"86f96a8dd7de4a51ad818d8fdba96fc4\"]]', '2019-08-10 13:08:53');
INSERT INTO `sys_log` VALUES ('68', 'admin', '0:0:0:0:0:0:0:1', 'DEL', '删除用户', '[参数1:\"bd06fa6e058249b5bc54231a41cf3e16\"][参数2:false]', '2019-08-10 13:08:57');
INSERT INTO `sys_log` VALUES ('69', 'admin', '0:0:0:0:0:0:0:1', 'DEL', '删除菜单', '[参数1:\"54a2a6456ed54df4ab73d3a0010b2f5d\"]', '2019-08-10 13:30:33');
INSERT INTO `sys_log` VALUES ('70', 'admin', '0:0:0:0:0:0:0:1', 'DEL', '删除菜单', '[参数1:\"54a2a6456ed54df4ab73d3a0010b2f5d\"]', '2019-08-10 13:31:14');
INSERT INTO `sys_log` VALUES ('71', 'admin', '0:0:0:0:0:0:0:1', 'ADD', '更新菜单', '[参数1:{\"children\":[],\"icon\":\"\",\"id\":\"d085ccb1f3514674be8078e4ae90cc48\",\"name\":\"需求管理\",\"num\":0,\"orderNum\":2,\"permission\":\"22\",\"url\":\"ftl/pdms/requirement/requirementList.html\"}]', '2019-08-10 22:41:00');
INSERT INTO `sys_log` VALUES ('72', 'admin', '0:0:0:0:0:0:0:1', 'ADD', '更新菜单', '[参数1:{\"children\":[],\"icon\":\"\",\"id\":\"a1b1cd2fc651445cb2c22ff85057c31f\",\"name\":\"版本管理\",\"num\":0,\"orderNum\":8,\"permission\":\"8\",\"url\":\"ftl/pdms/requirement/versionList.html\"}]', '2019-08-11 13:13:38');
INSERT INTO `sys_log` VALUES ('73', 'admin', '0:0:0:0:0:0:0:1', 'ADD', '更新菜单', '[参数1:{\"children\":[],\"icon\":\"\",\"id\":\"a1b1cd2fc651445cb2c22ff85057c31f\",\"name\":\"版本管理\",\"num\":0,\"orderNum\":8,\"permission\":\"8\",\"url\":\"ftl/pdms/version/versionList.html\"}]', '2019-08-11 13:19:22');
INSERT INTO `sys_log` VALUES ('74', 'admin', '0:0:0:0:0:0:0:1', 'ADD', '更新菜单', '[参数1:{\"children\":[],\"icon\":\"\",\"id\":\"f5c2616c3f814e0abfa84df3598618a2\",\"name\":\"风险管理\",\"num\":0,\"orderNum\":6,\"permission\":\"1\",\"url\":\"ftl/pdms/risk/riskList.html\"}]', '2019-08-11 13:31:15');
INSERT INTO `sys_log` VALUES ('75', 'admin', '0:0:0:0:0:0:0:1', 'ADD', '更新菜单', '[参数1:{\"children\":[],\"icon\":\"\",\"id\":\"b61c9257bb7a401b94d25b28c481c95d\",\"name\":\"任务管理\",\"num\":0,\"orderNum\":4,\"permission\":\"11\",\"url\":\"ftl/pdms/task/taskList.html\"}]', '2019-08-11 13:39:38');
INSERT INTO `sys_log` VALUES ('76', 'admin', '0:0:0:0:0:0:0:1', 'ADD', '更新菜单', '[参数1:{\"children\":[],\"icon\":\"\",\"id\":\"05409cef2b4c4d9188071dc0d6f9f111\",\"name\":\"缺陷管理\",\"num\":0,\"orderNum\":5,\"permission\":\"1\",\"url\":\"ftl/pdms/bug/bugList.html\"}]', '2019-08-11 13:46:45');
INSERT INTO `sys_log` VALUES ('77', 'admin', '0:0:0:0:0:0:0:1', 'ADD', '更新菜单', '[参数1:{\"children\":[],\"icon\":\"\",\"id\":\"5c3f958cb1fd48219f0b8396819def14\",\"name\":\"项目发布\",\"num\":0,\"orderNum\":6,\"permission\":\"6\",\"url\":\"ftl/pdms/online/onlineList.html\"}]', '2019-08-11 14:15:17');
INSERT INTO `sys_log` VALUES ('78', 'admin', '0:0:0:0:0:0:0:1', 'ADD', '更新菜单', '[参数1:{\"children\":[],\"icon\":\"\",\"id\":\"a49b0ada86214b8f888972500a405a9d\",\"name\":\"迭代管理\",\"num\":0,\"orderNum\":3,\"permission\":\"33\",\"url\":\"ftl/pdms/iteration/iterationList.html\"}]', '2019-08-11 14:30:54');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` varchar(36) NOT NULL,
  `name` varchar(255) NOT NULL,
  `p_id` varchar(36) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `order_num` int(4) DEFAULT NULL COMMENT '排序字段',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `create_by` varchar(32) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(32) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL COMMENT '权限',
  `menu_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1栏目2菜单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('05409cef2b4c4d9188071dc0d6f9f111', '缺陷管理', '870fddcd000148cd826d2dbd741a86a0', 'ftl/pdms/bug/bugList.html', '5', null, 'acfc0e9232f54732a5d9ffe9071bf572', '2019-08-05 09:17:44', null, '2019-08-11 13:46:45', '1', '0');
INSERT INTO `sys_menu` VALUES ('0e6c8d4cf09511e78a57201a068c6482', '删除', 'cff61424dfb311e7b555201a068c6482', null, '3', '', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-03 22:47:44', null, null, 'role:del', '1');
INSERT INTO `sys_menu` VALUES ('18bf8d5df09511e78a57201a068c6482', '新增', '3873ccc2dfda11e7b555201a068c6482', null, '1', '', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-03 22:48:01', null, null, 'nemu:add', '1');
INSERT INTO `sys_menu` VALUES ('2b56410cf09411e78a57201a068c6482', '新增', 'cff61424dfb311e7b555201a068c6482', null, '1', '', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-03 22:41:23', null, null, 'role:add', '1');
INSERT INTO `sys_menu` VALUES ('3873ccc2dfda11e7b555201a068c6482', '菜单管理', 'cfda8029dfb311e7b555201a068c6482', 'menu/showMenu', '1', '', null, '2017-12-14 14:02:50', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-04-23 19:43:54', 'menu:show', '0');
INSERT INTO `sys_menu` VALUES ('433089a6eb0111e782d5201a068c6482', '编辑', 'cfe54921dfb311e7b555201a068c6482', '', null, '1', 'acfc0e9232f54732a5d9ffe9071bf572', '2017-12-27 20:27:11', null, null, 'user:update', '1');
INSERT INTO `sys_menu` VALUES ('4d603831fe9b11e7b472201a068c6482', '待办任务', 'e06da471f90311e780aa201a068c6482', '/leave/showTask', '5', '&#xe6af;', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-21 19:07:43', null, null, 'task:show', '0');
INSERT INTO `sys_menu` VALUES ('5ae3d4e9f38e11e7aca0201a068c6482', '新增', 'e9a13e55f35911e7aca0201a068c6482', null, '1', '', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-07 17:37:30', null, null, 'job:add', '1');
INSERT INTO `sys_menu` VALUES ('5c3f958cb1fd48219f0b8396819def14', '项目发布', '870fddcd000148cd826d2dbd741a86a0', 'ftl/pdms/online/onlineList.html', '6', null, 'acfc0e9232f54732a5d9ffe9071bf572', '2019-08-05 09:19:05', null, '2019-08-11 14:15:17', '6', '0');
INSERT INTO `sys_menu` VALUES ('6315968bf37111e7aca0201a068c6482', '停止', 'e9a13e55f35911e7aca0201a068c6482', null, '4', '', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-07 14:10:09', null, null, 'job:end', '1');
INSERT INTO `sys_menu` VALUES ('63da4415fc6211e7a781201a068c6482', '模型列表', 'e06da471f90311e780aa201a068c6482', '/act/goActModel', '3', '&#xe60a;', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-18 23:15:17', null, null, 'act', '0');
INSERT INTO `sys_menu` VALUES ('6931fd22f09611e78a57201a068c6482', '删除', 'b441914cee0811e7a60d201a068c6482', null, '1', '', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-03 22:57:26', null, null, 'control:del', '1');
INSERT INTO `sys_menu` VALUES ('69f3f59cf38e11e7aca0201a068c6482', '编辑', 'e9a13e55f35911e7aca0201a068c6482', null, '2', '', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-07 17:37:56', null, null, 'job:update', '1');
INSERT INTO `sys_menu` VALUES ('6dc13c6eec5f11e7a472201a068c6482', '系统日志', 'a1ca6642ec5e11e7a472201a068c6482', 'log/showLog', '1', '&#xe60a;', 'acfc0e9232f54732a5d9ffe9071bf572', '2017-12-29 14:43:46', null, '2017-12-29 14:43:46', 'log:show', '0');
INSERT INTO `sys_menu` VALUES ('788d8e34f38e11e7aca0201a068c6482', '删除', 'e9a13e55f35911e7aca0201a068c6482', null, '5', '', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-07 17:38:20', null, null, 'job:del', '1');
INSERT INTO `sys_menu` VALUES ('7967e098ee0611e7a60d201a068c6482', '接口api', 'a1ca6642ec5e11e7a472201a068c6482', 'swagger-ui.html', '2', '&#xe64e;', 'acfc0e9232f54732a5d9ffe9071bf572', '2017-12-31 16:42:04', null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('870fddcd000148cd826d2dbd741a86a0', '项目研发管理', null, null, '4', '', 'acfc0e9232f54732a5d9ffe9071bf572', '2019-08-05 09:10:45', 'acfc0e9232f54732a5d9ffe9071bf572', '2019-08-05 09:11:45', null, '0');
INSERT INTO `sys_menu` VALUES ('873f30b0f38e11e7aca0201a068c6482', '查看', 'e9a13e55f35911e7aca0201a068c6482', null, '6', '', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-07 17:38:45', null, null, 'job:select', '1');
INSERT INTO `sys_menu` VALUES ('88b8e5d1f38911e7aca0201a068c6482', '查看', 'cff61424dfb311e7b555201a068c6482', null, '4', '', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-07 17:03:00', null, null, 'role:select', '1');
INSERT INTO `sys_menu` VALUES ('8a6c8bfa7f804eac810c5790cad9a62a', '删除', '3873ccc2dfda11e7b555201a068c6482', null, '2', null, 'acfc0e9232f54732a5d9ffe9071bf572', '2018-06-20 21:55:55', null, null, 'menu:del', '1');
INSERT INTO `sys_menu` VALUES ('a1b1cd2fc651445cb2c22ff85057c31f', '版本管理', '870fddcd000148cd826d2dbd741a86a0', 'ftl/pdms/version/versionList.html', '8', null, 'acfc0e9232f54732a5d9ffe9071bf572', '2019-08-05 09:19:34', null, '2019-08-11 13:19:22', '8', '0');
INSERT INTO `sys_menu` VALUES ('a49b0ada86214b8f888972500a405a9d', '迭代管理', '870fddcd000148cd826d2dbd741a86a0', 'ftl/pdms/iteration/iterationList.html', '3', null, 'acfc0e9232f54732a5d9ffe9071bf572', '2019-08-05 09:16:20', null, '2019-08-11 14:30:54', '33', '0');
INSERT INTO `sys_menu` VALUES ('b61c9257bb7a401b94d25b28c481c95d', '任务管理', '870fddcd000148cd826d2dbd741a86a0', 'ftl/pdms/task/taskList.html', '4', null, 'acfc0e9232f54732a5d9ffe9071bf572', '2019-08-05 09:16:54', null, '2019-08-11 13:39:38', '11', '0');
INSERT INTO `sys_menu` VALUES ('b7839f59fe8811e7b472201a068c6482', '请假流程', 'e06da471f90311e780aa201a068c6482', '/leave/showLeave', '4', '&#xe650;', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-21 16:54:40', null, null, 'leave:show', '0');
INSERT INTO `sys_menu` VALUES ('cfda8029dfb311e7b555201a068c6482', '系统管理', null, null, '1', '&#xe614;', null, '2018-01-03 10:56:13', null, '2018-01-03 10:56:13', null, '0');
INSERT INTO `sys_menu` VALUES ('cfe54921dfb311e7b555201a068c6482', '用户管理', 'cfda8029dfb311e7b555201a068c6482', '/user/showUser', '2', '&#xe6af;', null, '2017-12-29 14:40:34', null, '2017-12-29 14:40:34', 'user:show', '0');
INSERT INTO `sys_menu` VALUES ('cfe54921dfb311e7b555201a068c6483', '增加', 'cfe54921dfb311e7b555201a068c6482', null, '1', null, null, null, null, null, 'user:select', '1');
INSERT INTO `sys_menu` VALUES ('cff61424dfb311e7b555201a068c6482', '角色管理', 'cfda8029dfb311e7b555201a068c6482', '/role/showRole', '3', '&#xe613;', null, '2017-12-29 14:40:36', null, '2017-12-29 14:40:36', 'role:show', '0');
INSERT INTO `sys_menu` VALUES ('d085ccb1f3514674be8078e4ae90cc48', '需求管理', '870fddcd000148cd826d2dbd741a86a0', 'ftl/pdms/requirement/requirementList.html', '2', null, 'acfc0e9232f54732a5d9ffe9071bf572', '2019-08-05 09:14:43', null, '2019-08-10 22:40:59', '22', '0');
INSERT INTO `sys_menu` VALUES ('e3b11497eb9e11e7928d201a068c6482', '删除', 'cfe54921dfb311e7b555201a068c6482', '', null, '', 'acfc0e9232f54732a5d9ffe9071bf572', '2017-12-28 15:17:07', null, '2017-12-28 15:17:07', 'user:del', '1');
INSERT INTO `sys_menu` VALUES ('e9a13e55f35911e7aca0201a068c6482', '定时任务', 'a1ca6642ec5e11e7a472201a068c6482', '/job/showJob', '3', '&#xe756;', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-07 11:22:06', null, null, 'job:show', '0');
INSERT INTO `sys_menu` VALUES ('ecda560cf36f11e7aca0201a068c6482', '启动', 'e9a13e55f35911e7aca0201a068c6482', null, '3', '', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-07 13:59:41', null, null, 'job:start', '1');
INSERT INTO `sys_menu` VALUES ('f23f6a6bf09511e78a57201a068c6482', '修改密码', 'cfe54921dfb311e7b555201a068c6482', null, '4', '', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-03 22:54:06', null, null, 'user:repass', '1');
INSERT INTO `sys_menu` VALUES ('f5c2616c3f814e0abfa84df3598618a2', '风险管理', '870fddcd000148cd826d2dbd741a86a0', 'ftl/pdms/risk/riskList.html', '6', null, 'acfc0e9232f54732a5d9ffe9071bf572', '2019-08-05 09:18:25', null, '2019-08-11 13:31:15', '1', '0');
INSERT INTO `sys_menu` VALUES ('ff015ea5f09411e78a57201a068c6482', '编辑', 'cff61424dfb311e7b555201a068c6482', null, '2', '', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-03 22:47:18', null, null, 'role:update', '1');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(32) NOT NULL,
  `tenant_id` varchar(32) DEFAULT NULL,
  `role_name` varchar(128) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `create_by` varchar(32) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(32) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('023366f3457511e8bcf1309c2315f9aa', null, 'hr', '人事', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-04-21 23:02:16', null, null);
INSERT INTO `sys_role` VALUES ('0ea934e5e55411e7b983201a068c6482', null, 'manage', '经理', 'acfc0e9232f54732a5d9ffe9071bf572', '2017-12-20 15:04:44', null, '2018-01-02 11:41:43');
INSERT INTO `sys_role` VALUES ('2619a672e53811e7b983201a068c6482', '0', 'admin', '管理员', 'acfc0e9232f54732a5d9ffe9071bf572', '2017-12-20 11:44:57', null, '2018-01-02 11:38:37');
INSERT INTO `sys_role` VALUES ('4bb891d8caf84cc6ba27e515e80ac40d', null, 'blogAdmin', '博客管理员', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-10-01 10:21:10', null, null);
INSERT INTO `sys_role` VALUES ('86f96a8dd7de4a51ad818d8fdba96fc4', '63c7daa5195f4f5699f3d624bbef9b53', '角色11', '11', null, '2019-08-08 23:00:16', null, null);
INSERT INTO `sys_role` VALUES ('a2cf96c879cb489a9f3064e51058cb7a', null, '333', '333', 'acfc0e9232f54732a5d9ffe9071bf572', '2019-08-07 17:18:03', null, null);
INSERT INTO `sys_role` VALUES ('b72df24b2a7b42678d7a8c0b9121c103', 'a297ebcc8b6146249bf526f84c37f742', '开发人员', '1', null, '2019-08-08 23:19:36', null, null);
INSERT INTO `sys_role` VALUES ('dcb0f642fe9611e7b472201a068c6482', null, 'dev', '开发', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-21 18:35:56', null, null);
INSERT INTO `sys_role` VALUES ('e346e96368484c8fa7f217ce550a0186', null, 'DeputyManager', '副经理', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-06-14 23:21:36', null, null);
INSERT INTO `sys_role` VALUES ('f40b1dcd1f93462e94fe03aa15878b44', '0', '租户角色', '租户角色', null, '2019-08-07 22:33:18', null, null);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` varchar(32) NOT NULL,
  `menu_id` varchar(32) NOT NULL,
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('023366f3457511e8bcf1309c2315f9aa', '433089a6eb0111e782d5201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('023366f3457511e8bcf1309c2315f9aa', '4d603831fe9b11e7b472201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('023366f3457511e8bcf1309c2315f9aa', 'b7839f59fe8811e7b472201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('023366f3457511e8bcf1309c2315f9aa', 'cfda8029dfb311e7b555201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('023366f3457511e8bcf1309c2315f9aa', 'cfe54921dfb311e7b555201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('023366f3457511e8bcf1309c2315f9aa', 'cfe54921dfb311e7b555201a068c6483');
INSERT INTO `sys_role_menu` VALUES ('023366f3457511e8bcf1309c2315f9aa', 'e06da471f90311e780aa201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('023366f3457511e8bcf1309c2315f9aa', 'e3b11497eb9e11e7928d201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('023366f3457511e8bcf1309c2315f9aa', 'f23f6a6bf09511e78a57201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('0ea934e5e55411e7b983201a068c6482', '433089a6eb0111e782d5201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('0ea934e5e55411e7b983201a068c6482', '4d603831fe9b11e7b472201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('0ea934e5e55411e7b983201a068c6482', '6931fd22f09611e78a57201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('0ea934e5e55411e7b983201a068c6482', '6dc13c6eec5f11e7a472201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('0ea934e5e55411e7b983201a068c6482', 'a1ca6642ec5e11e7a472201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('0ea934e5e55411e7b983201a068c6482', 'b7839f59fe8811e7b472201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('0ea934e5e55411e7b983201a068c6482', 'cfda8029dfb311e7b555201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('0ea934e5e55411e7b983201a068c6482', 'cfe54921dfb311e7b555201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('0ea934e5e55411e7b983201a068c6482', 'e06da471f90311e780aa201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', '05409cef2b4c4d9188071dc0d6f9f111');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', '0e6c8d4cf09511e78a57201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', '18bf8d5df09511e78a57201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', '2b56410cf09411e78a57201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', '3873ccc2dfda11e7b555201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', '433089a6eb0111e782d5201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', '54a2a6456ed54df4ab73d3a0010b2f5d');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', '5c3f958cb1fd48219f0b8396819def14');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', '870fddcd000148cd826d2dbd741a86a0');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', '88b8e5d1f38911e7aca0201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', 'a1b1cd2fc651445cb2c22ff85057c31f');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', 'a49b0ada86214b8f888972500a405a9d');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', 'b61c9257bb7a401b94d25b28c481c95d');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', 'cfda8029dfb311e7b555201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', 'cfe54921dfb311e7b555201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', 'cfe54921dfb311e7b555201a068c6483');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', 'cff61424dfb311e7b555201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', 'd085ccb1f3514674be8078e4ae90cc48');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', 'e3b11497eb9e11e7928d201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', 'f23f6a6bf09511e78a57201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', 'f5c2616c3f814e0abfa84df3598618a2');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', 'ff015ea5f09411e78a57201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('35f7934d335e4641b7887e4b3b1885a5', '18bf8d5df09511e78a57201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('35f7934d335e4641b7887e4b3b1885a5', '3873ccc2dfda11e7b555201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('35f7934d335e4641b7887e4b3b1885a5', 'cfda8029dfb311e7b555201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('86f96a8dd7de4a51ad818d8fdba96fc4', '05409cef2b4c4d9188071dc0d6f9f111');
INSERT INTO `sys_role_menu` VALUES ('86f96a8dd7de4a51ad818d8fdba96fc4', '54a2a6456ed54df4ab73d3a0010b2f5d');
INSERT INTO `sys_role_menu` VALUES ('86f96a8dd7de4a51ad818d8fdba96fc4', '5c3f958cb1fd48219f0b8396819def14');
INSERT INTO `sys_role_menu` VALUES ('86f96a8dd7de4a51ad818d8fdba96fc4', '870fddcd000148cd826d2dbd741a86a0');
INSERT INTO `sys_role_menu` VALUES ('86f96a8dd7de4a51ad818d8fdba96fc4', 'a1b1cd2fc651445cb2c22ff85057c31f');
INSERT INTO `sys_role_menu` VALUES ('86f96a8dd7de4a51ad818d8fdba96fc4', 'a49b0ada86214b8f888972500a405a9d');
INSERT INTO `sys_role_menu` VALUES ('86f96a8dd7de4a51ad818d8fdba96fc4', 'b61c9257bb7a401b94d25b28c481c95d');
INSERT INTO `sys_role_menu` VALUES ('86f96a8dd7de4a51ad818d8fdba96fc4', 'd085ccb1f3514674be8078e4ae90cc48');
INSERT INTO `sys_role_menu` VALUES ('86f96a8dd7de4a51ad818d8fdba96fc4', 'f5c2616c3f814e0abfa84df3598618a2');
INSERT INTO `sys_role_menu` VALUES ('a56219ffeb7d11e7928d201a068c6482', '433089a6eb0111e782d5201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('a56219ffeb7d11e7928d201a068c6482', 'cfda8029dfb311e7b555201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('a56219ffeb7d11e7928d201a068c6482', 'cfe54921dfb311e7b555201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('b72df24b2a7b42678d7a8c0b9121c103', '05409cef2b4c4d9188071dc0d6f9f111');
INSERT INTO `sys_role_menu` VALUES ('b72df24b2a7b42678d7a8c0b9121c103', '870fddcd000148cd826d2dbd741a86a0');
INSERT INTO `sys_role_menu` VALUES ('b72df24b2a7b42678d7a8c0b9121c103', 'b61c9257bb7a401b94d25b28c481c95d');
INSERT INTO `sys_role_menu` VALUES ('dcb0f642fe9611e7b472201a068c6482', '4d603831fe9b11e7b472201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('dcb0f642fe9611e7b472201a068c6482', '5ae3d4e9f38e11e7aca0201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('dcb0f642fe9611e7b472201a068c6482', '6315968bf37111e7aca0201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('dcb0f642fe9611e7b472201a068c6482', '69f3f59cf38e11e7aca0201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('dcb0f642fe9611e7b472201a068c6482', '788d8e34f38e11e7aca0201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('dcb0f642fe9611e7b472201a068c6482', '873f30b0f38e11e7aca0201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('dcb0f642fe9611e7b472201a068c6482', 'a1ca6642ec5e11e7a472201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('dcb0f642fe9611e7b472201a068c6482', 'b7839f59fe8811e7b472201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('dcb0f642fe9611e7b472201a068c6482', 'e06da471f90311e780aa201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('dcb0f642fe9611e7b472201a068c6482', 'e9a13e55f35911e7aca0201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('dcb0f642fe9611e7b472201a068c6482', 'ecda560cf36f11e7aca0201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('e346e96368484c8fa7f217ce550a0186', '4d603831fe9b11e7b472201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('e346e96368484c8fa7f217ce550a0186', 'b7839f59fe8811e7b472201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('e346e96368484c8fa7f217ce550a0186', 'e06da471f90311e780aa201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('f40b1dcd1f93462e94fe03aa15878b44', '05409cef2b4c4d9188071dc0d6f9f111');
INSERT INTO `sys_role_menu` VALUES ('f40b1dcd1f93462e94fe03aa15878b44', '0e6c8d4cf09511e78a57201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('f40b1dcd1f93462e94fe03aa15878b44', '2b56410cf09411e78a57201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('f40b1dcd1f93462e94fe03aa15878b44', '433089a6eb0111e782d5201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('f40b1dcd1f93462e94fe03aa15878b44', '54a2a6456ed54df4ab73d3a0010b2f5d');
INSERT INTO `sys_role_menu` VALUES ('f40b1dcd1f93462e94fe03aa15878b44', '5c3f958cb1fd48219f0b8396819def14');
INSERT INTO `sys_role_menu` VALUES ('f40b1dcd1f93462e94fe03aa15878b44', '870fddcd000148cd826d2dbd741a86a0');
INSERT INTO `sys_role_menu` VALUES ('f40b1dcd1f93462e94fe03aa15878b44', '88b8e5d1f38911e7aca0201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('f40b1dcd1f93462e94fe03aa15878b44', 'a1b1cd2fc651445cb2c22ff85057c31f');
INSERT INTO `sys_role_menu` VALUES ('f40b1dcd1f93462e94fe03aa15878b44', 'a49b0ada86214b8f888972500a405a9d');
INSERT INTO `sys_role_menu` VALUES ('f40b1dcd1f93462e94fe03aa15878b44', 'b61c9257bb7a401b94d25b28c481c95d');
INSERT INTO `sys_role_menu` VALUES ('f40b1dcd1f93462e94fe03aa15878b44', 'cfda8029dfb311e7b555201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('f40b1dcd1f93462e94fe03aa15878b44', 'cfe54921dfb311e7b555201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('f40b1dcd1f93462e94fe03aa15878b44', 'cfe54921dfb311e7b555201a068c6483');
INSERT INTO `sys_role_menu` VALUES ('f40b1dcd1f93462e94fe03aa15878b44', 'cff61424dfb311e7b555201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('f40b1dcd1f93462e94fe03aa15878b44', 'd085ccb1f3514674be8078e4ae90cc48');
INSERT INTO `sys_role_menu` VALUES ('f40b1dcd1f93462e94fe03aa15878b44', 'e3b11497eb9e11e7928d201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('f40b1dcd1f93462e94fe03aa15878b44', 'f23f6a6bf09511e78a57201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('f40b1dcd1f93462e94fe03aa15878b44', 'f5c2616c3f814e0abfa84df3598618a2');
INSERT INTO `sys_role_menu` VALUES ('f40b1dcd1f93462e94fe03aa15878b44', 'ff015ea5f09411e78a57201a068c6482');

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `user_id` varchar(32) NOT NULL,
  `role_id` varchar(32) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
INSERT INTO `sys_role_user` VALUES ('1ec421975ffe45229b48d4b9d712ff4f', 'dcb0f642fe9611e7b472201a068c6482');
INSERT INTO `sys_role_user` VALUES ('2211fec3e17c11e795ed201a068c6482', '0ea934e5e55411e7b983201a068c6482');
INSERT INTO `sys_role_user` VALUES ('2b85d71a5c9540e8a52690ffafa9a855', 'f40b1dcd1f93462e94fe03aa15878b44');
INSERT INTO `sys_role_user` VALUES ('3c14c2f8316741e9aaeb29d78d03e958', 'dcb0f642fe9611e7b472201a068c6482');
INSERT INTO `sys_role_user` VALUES ('4d92633d44e242b286ba0dcc1c5c5691', 'f40b1dcd1f93462e94fe03aa15878b44');
INSERT INTO `sys_role_user` VALUES ('63c7daa5195f4f5699f3d624bbef9b53', 'f40b1dcd1f93462e94fe03aa15878b44');
INSERT INTO `sys_role_user` VALUES ('712ce9e6862f41bd8936773dddec257d', 'b72df24b2a7b42678d7a8c0b9121c103');
INSERT INTO `sys_role_user` VALUES ('8cd4ba927a684150914ee63b450225aa', '86f96a8dd7de4a51ad818d8fdba96fc4');
INSERT INTO `sys_role_user` VALUES ('90060ce771834f358cbde68bb719447c', 'f40b1dcd1f93462e94fe03aa15878b44');
INSERT INTO `sys_role_user` VALUES ('a297ebcc8b6146249bf526f84c37f742', 'f40b1dcd1f93462e94fe03aa15878b44');
INSERT INTO `sys_role_user` VALUES ('a4a743bffe9711e7b472201a068c6482', '4bb891d8caf84cc6ba27e515e80ac40d');
INSERT INTO `sys_role_user` VALUES ('a609464439ac4518b70a892d4b62119a', 'f40b1dcd1f93462e94fe03aa15878b44');
INSERT INTO `sys_role_user` VALUES ('acfc0e9232f54732a5d9ffe9071bf572', '2619a672e53811e7b983201a068c6482');
INSERT INTO `sys_role_user` VALUES ('acfc0e9232f54732a5d9ffe9071bf572', '4bb891d8caf84cc6ba27e515e80ac40d');
INSERT INTO `sys_role_user` VALUES ('b75e1a2e8c744130b3af48dc530c946d', 'f40b1dcd1f93462e94fe03aa15878b44');
INSERT INTO `sys_role_user` VALUES ('b815c4b0800c4f3ea375b2c0abdc1941', 'f40b1dcd1f93462e94fe03aa15878b44');
INSERT INTO `sys_role_user` VALUES ('bd06fa6e058249b5bc54231a41cf3e16', '86f96a8dd7de4a51ad818d8fdba96fc4');
INSERT INTO `sys_role_user` VALUES ('d555ffd6b51f4df7a18e2ef4eece1bed', 'e346e96368484c8fa7f217ce550a0186');
INSERT INTO `sys_role_user` VALUES ('fb483b76457811e8bcf1309c2315f9aa', '023366f3457511e8bcf1309c2315f9aa');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(36) NOT NULL,
  `username` varchar(64) NOT NULL,
  `password` varchar(128) NOT NULL,
  `age` int(4) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `real_name` varchar(18) DEFAULT NULL,
  `create_by` varchar(32) DEFAULT NULL,
  `update_by` varchar(32) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `del_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0可用1封禁',
  `tenant_id` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1ec421975ffe45229b48d4b9d712ff4f', '33333', '533add1dc96c02469d50ca0ffdcb493a', '26', null, null, '33', 'acfc0e9232f54732a5d9ffe9071bf572', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-08-20 23:52:47', '2018-12-11 22:57:16', '0', null);
INSERT INTO `sys_user` VALUES ('2211fec3e17c11e795ed201a068c6482', 'tom', '11ac200620f90acd1fdae53716fd3de2', '41', '154040976@qq.com', 'bd214483-7c5e-49d6-862d-de97e9de50b5.jpeg', 'Tom Curise', null, 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-03 15:49:48', '2018-06-19 21:15:49', '0', null);
INSERT INTO `sys_user` VALUES ('2b85d71a5c9540e8a52690ffafa9a855', '888888', '5831c5445bf6b98430d199b0c3014bc5', '22', null, null, '88', null, null, '2019-08-08 22:45:16', null, '0', null);
INSERT INTO `sys_user` VALUES ('2bf2d2db774247b99f27efb1dda29c34', '12', '123456', '10', '2345', null, '123', null, null, null, null, '0', null);
INSERT INTO `sys_user` VALUES ('3c14c2f8316741e9aaeb29d78d03e958', '22222', '2b8aae82f069cc838dfe8afc945f8045', '222', null, null, '222', 'acfc0e9232f54732a5d9ffe9071bf572', null, '2018-08-19 22:00:27', null, '0', null);
INSERT INTO `sys_user` VALUES ('41faf1da90cc412196c5aef6e810c4e1', '公司1111', '891e88c5cb52b014309f4eec8c9969ef', null, null, null, '888', null, null, '2019-08-07 22:11:37', null, '0', null);
INSERT INTO `sys_user` VALUES ('4d92633d44e242b286ba0dcc1c5c5691', '123', 'aaaf34f1ec581c22451f7bd65377c208', '12', null, null, '34', null, null, '2019-08-08 22:42:29', null, '0', null);
INSERT INTO `sys_user` VALUES ('63c7daa5195f4f5699f3d624bbef9b53', '12', '641c97fe6986edd1a1611035f6657bd7', null, null, null, '9909', null, null, '2019-08-08 21:57:05', null, '0', null);
INSERT INTO `sys_user` VALUES ('712ce9e6862f41bd8936773dddec257d', 'zhangsan', 'a07e4c18324811b0d0ec17a89e0f855b', '11', null, null, '张三', null, null, '2019-08-08 23:19:59', null, '0', null);
INSERT INTO `sys_user` VALUES ('8cd4ba927a684150914ee63b450225aa', 'admin3333', '1405370bd387bfe68c80527ebd03e680', '123', null, null, '132', null, null, '2019-08-10 13:01:27', null, '0', null);
INSERT INTO `sys_user` VALUES ('90060ce771834f358cbde68bb719447c', '999', 'b6e0c515d98512bbb7e246ecea692dfb', '9', null, null, '9', null, null, '2019-08-08 22:47:05', null, '0', null);
INSERT INTO `sys_user` VALUES ('a297ebcc8b6146249bf526f84c37f742', 'cyb999', '2e540fdd8786fd640371b8d39eff2110', null, null, null, '87978', null, null, '2019-08-08 23:06:23', null, '0', null);
INSERT INTO `sys_user` VALUES ('a4a743bffe9711e7b472201a068c6482', 'zxm', 'f8880ebbdbc37a936245657fa9084198', '25', '1544040976@qq.com', '662d5a3b-56aa-4bbb-bd47-194e24db1d60.jpeg', 'zxm', 'acfc0e9232f54732a5d9ffe9071bf572', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-21 18:41:32', '2018-11-25 15:00:41', '0', null);
INSERT INTO `sys_user` VALUES ('a609464439ac4518b70a892d4b62119a', 'cyb6', '3996c846f38661b1f3f5ec127db1cc08', null, null, null, '789789', null, null, '2019-08-07 22:38:33', null, '0', null);
INSERT INTO `sys_user` VALUES ('acfc0e9232f54732a5d9ffe9071bf572', 'admin', 'e0b141de1c8091be350d3fc80de66528', '24', '', '2d4c37c3-c106-4288-9c0d-e7fe1b8adc72.jpeg', '管理员', null, 'acfc0e9232f54732a5d9ffe9071bf572', '2017-12-20 16:34:06', '2018-10-01 10:21:19', '0', null);
INSERT INTO `sys_user` VALUES ('b1a3f754da07438fb7e7a4598e27b5db', 'cyb', 'b5d14eb964e373355769c4ea9970ead0', null, null, null, '56757', null, null, '2019-08-07 22:19:09', null, '0', null);
INSERT INTO `sys_user` VALUES ('b50d049022124b04b73605caae5ecb3b', '12', '123456', '10', '2345', null, '123', null, null, null, null, '0', null);
INSERT INTO `sys_user` VALUES ('b75e1a2e8c744130b3af48dc530c946d', '345', '681ad4372b96f41eec20ba68633ad962', null, null, null, null, null, null, '2019-08-13 22:15:19', null, '0', null);
INSERT INTO `sys_user` VALUES ('b815c4b0800c4f3ea375b2c0abdc1941', '345', '681ad4372b96f41eec20ba68633ad962', null, null, null, null, null, null, '2019-08-13 22:17:16', null, '0', null);
INSERT INTO `sys_user` VALUES ('bd06fa6e058249b5bc54231a41cf3e16', '1313123', 'c97a54f90ec169d0a19d73f6fbb5e850', '12', null, null, '123', null, null, '2019-08-10 13:08:53', null, '0', null);
INSERT INTO `sys_user` VALUES ('c7f1a7d7018311e8a1a2201a068c6482', '666', 'c6953f608430df414ea52e8c01b81a45', '24', '', '', '666', 'acfc0e9232f54732a5d9ffe9071bf572', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-25 11:56:54', '2018-06-14 23:18:51', '1', null);
INSERT INTO `sys_user` VALUES ('ca38676528ce4de6b1f6499e1edd7462', 'cyb1', 'f8ddf7a7bcde8d3bd6c474077a615ab4', null, null, null, '789', null, null, '2019-08-07 22:21:38', null, '0', null);
INSERT INTO `sys_user` VALUES ('d0859440ecfc48329560a3af18f9f066', 'cyb3', '74a60e910e1cd0620cb9e52c3c0bbeb5', null, null, null, '67576', null, null, '2019-08-07 22:22:53', null, '0', null);
INSERT INTO `sys_user` VALUES ('d555ffd6b51f4df7a18e2ef4eece1bed', 'wangwu', 'b162011c014942eac61c478a7bfc386d', '25', '', '', '王五', 'acfc0e9232f54732a5d9ffe9071bf572', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-06-14 23:21:17', '2018-06-19 23:09:12', '0', null);
INSERT INTO `sys_user` VALUES ('fb483b76457811e8bcf1309c2315f9aa', 'lisi', 'f497935e5f47325399d595ef31b25e47', '20', '', '', '李四', 'acfc0e9232f54732a5d9ffe9071bf572', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-04-21 23:30:43', '2018-06-14 23:21:50', '0', null);
INSERT INTO `sys_user` VALUES ('fbb427b4e2764260a337f074744bc55a', '12', '123456', '10', '2345', null, '123', null, null, null, null, '0', null);
