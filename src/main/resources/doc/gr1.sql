/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 60010
Source Host           : localhost:3306
Source Database       : gr1

Target Server Type    : MYSQL
Target Server Version : 60010
File Encoding         : 65001

Date: 2015-09-18 11:19:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `checkbill`
-- ----------------------------
DROP TABLE IF EXISTS `checkbill`;
CREATE TABLE `checkbill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_node_id` int(11) DEFAULT NULL,
  `checkbill_template_id` int(11) DEFAULT NULL,
  `isqualified` tinyint(1) DEFAULT NULL COMMENT '是否合格',
  `check_item` varchar(50) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_checkbill_checkbill_template_id_fk` (`checkbill_template_id`),
  KEY `FK_checkbill_pro_node_id_fk` (`pro_node_id`),
  CONSTRAINT `FK_checkbill_checkbill_template_id_fk` FOREIGN KEY (`checkbill_template_id`) REFERENCES `checkbill_template` (`id`),
  CONSTRAINT `FK_checkbill_pro_node_id_fk` FOREIGN KEY (`pro_node_id`) REFERENCES `pro_node` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='检查单';

-- ----------------------------
-- Records of checkbill
-- ----------------------------

-- ----------------------------
-- Table structure for `checkbill_template`
-- ----------------------------
DROP TABLE IF EXISTS `checkbill_template`;
CREATE TABLE `checkbill_template` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `process_node_id` int(11) DEFAULT NULL,
  `check_item` varchar(20) DEFAULT NULL COMMENT '检查项',
  `check_item_property` enum('必须','建议','特殊增项') DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `isqualified` tinyint(1) DEFAULT NULL COMMENT '是否合格',
  `sort` tinyint(4) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_checkbill_template_process_node_id_fk` (`process_node_id`),
  CONSTRAINT `FK_checkbill_template_process_node_id_fk` FOREIGN KEY (`process_node_id`) REFERENCES `process_node` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='检查单';

-- ----------------------------
-- Records of checkbill_template
-- ----------------------------

-- ----------------------------
-- Table structure for `document`
-- ----------------------------
DROP TABLE IF EXISTS `document`;
CREATE TABLE `document` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `process_id` int(11) DEFAULT NULL,
  `project_id` int(11) DEFAULT NULL,
  `proc_node_id` int(11) DEFAULT NULL,
  `pro_node_id` int(11) DEFAULT NULL,
  `release_line` enum('大中华','欧美','韩国','自研','合作') DEFAULT NULL,
  `filename` varchar(50) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `upload_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `flag` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_document_project_id_fk` (`project_id`),
  KEY `FK_docuent_pro_node_id_fk` (`pro_node_id`),
  KEY `process_id` (`process_id`),
  KEY `proc_node_id` (`proc_node_id`),
  CONSTRAINT `document_ibfk_1` FOREIGN KEY (`process_id`) REFERENCES `process` (`id`),
  CONSTRAINT `document_ibfk_2` FOREIGN KEY (`proc_node_id`) REFERENCES `process_node` (`id`),
  CONSTRAINT `FK_docuent_pro_node_id_fk` FOREIGN KEY (`pro_node_id`) REFERENCES `pro_node` (`id`),
  CONSTRAINT `FK_document_project_id_fk` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of document
-- ----------------------------

-- ----------------------------
-- Table structure for `fee`
-- ----------------------------
DROP TABLE IF EXISTS `fee`;
CREATE TABLE `fee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_node_id` int(11) DEFAULT NULL,
  `fee_template_id` int(11) DEFAULT NULL,
  `money` decimal(10,2) DEFAULT NULL,
  `display` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_fee_fee_template_id_fk` (`fee_template_id`),
  KEY `FK_fee_pro_node_id_fk` (`pro_node_id`),
  CONSTRAINT `FK_fee_fee_template_id_fk` FOREIGN KEY (`fee_template_id`) REFERENCES `fee_template` (`id`),
  CONSTRAINT `FK_fee_pro_node_id_fk` FOREIGN KEY (`pro_node_id`) REFERENCES `pro_node` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fee
-- ----------------------------

-- ----------------------------
-- Table structure for `fee_template`
-- ----------------------------
DROP TABLE IF EXISTS `fee_template`;
CREATE TABLE `fee_template` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `process_node_id` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sort` tinyint(4) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_fee_template_process_node_id_fk` (`process_node_id`),
  CONSTRAINT `FK_fee_template_process_node_id_fk` FOREIGN KEY (`process_node_id`) REFERENCES `process_node` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fee_template
-- ----------------------------

-- ----------------------------
-- Table structure for `manpower`
-- ----------------------------
DROP TABLE IF EXISTS `manpower`;
CREATE TABLE `manpower` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '人力',
  `pro_node_id` int(11) DEFAULT NULL,
  `manpower_template_id` int(11) DEFAULT NULL,
  `core_man` decimal(5,1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_manpower_pro_node_id_fk` (`pro_node_id`),
  KEY `FK_manpower_manpower_template_id_fk` (`manpower_template_id`),
  CONSTRAINT `FK_manpower_manpower_template_id_fk` FOREIGN KEY (`manpower_template_id`) REFERENCES `manpower_template` (`id`),
  CONSTRAINT `FK_manpower_pro_node_id_fk` FOREIGN KEY (`pro_node_id`) REFERENCES `pro_node` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manpower
-- ----------------------------

-- ----------------------------
-- Table structure for `manpower_template`
-- ----------------------------
DROP TABLE IF EXISTS `manpower_template`;
CREATE TABLE `manpower_template` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '人力',
  `process_node_id` int(11) DEFAULT NULL,
  `project_team` varchar(50) DEFAULT NULL,
  `standard_model` decimal(5,1) DEFAULT NULL,
  `sort` tinyint(4) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_manpower_template_process_node_id_fk` (`process_node_id`),
  CONSTRAINT `FK_manpower_template_process_node_id_fk` FOREIGN KEY (`process_node_id`) REFERENCES `process_node` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manpower_template
-- ----------------------------

-- ----------------------------
-- Table structure for `process`
-- ----------------------------
DROP TABLE IF EXISTS `process`;
CREATE TABLE `process` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL COMMENT '流程名称',
  `sort` int(11) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of process
-- ----------------------------

-- ----------------------------
-- Table structure for `process_node`
-- ----------------------------
DROP TABLE IF EXISTS `process_node`;
CREATE TABLE `process_node` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `process_id` int(11) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `process_type` enum('GR','CR','MR','TR','CB&OB') DEFAULT NULL COMMENT '流程类型',
  `end_type` enum('手动完结','邮件完结') DEFAULT NULL COMMENT '完结类型',
  `time_type` enum('时间段','时间点') DEFAULT NULL,
  `flag` tinyint(1) DEFAULT NULL,
  `has_fee` tinyint(1) DEFAULT NULL,
  `has_manPower` tinyint(1) DEFAULT NULL,
  `has_taskBook` tinyint(1) DEFAULT NULL,
  `has_checkBill` tinyint(1) DEFAULT NULL,
  `has_document` tinyint(1) DEFAULT NULL,
  `nodes_overview` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_process_node_process_id_fk` (`process_id`),
  CONSTRAINT `FK_process_node_process_id_fk` FOREIGN KEY (`process_id`) REFERENCES `process` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流程节点表';

-- ----------------------------
-- Records of process_node
-- ----------------------------

-- ----------------------------
-- Table structure for `project`
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '项目名称',
  `process_id` int(11) DEFAULT NULL,
  `release_line` enum('大中华','欧美','韩国','自研','合作') DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_project_process_id_fk` (`process_id`),
  CONSTRAINT `FK_project_process_id_fk` FOREIGN KEY (`process_id`) REFERENCES `process` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目表';

-- ----------------------------
-- Records of project
-- ----------------------------

-- ----------------------------
-- Table structure for `pro_node`
-- ----------------------------
DROP TABLE IF EXISTS `pro_node`;
CREATE TABLE `pro_node` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) DEFAULT NULL,
  `process_node_id` int(11) DEFAULT NULL,
  `status` enum('未开启','进行中','未通过','已完成','跳过') DEFAULT NULL COMMENT '项目状态',
  `start_time` timestamp NULL DEFAULT NULL,
  `end_time` timestamp NULL DEFAULT NULL,
  `review_time` timestamp NULL DEFAULT NULL,
  `is_normal` enum('正常','异常') DEFAULT NULL,
  `current_progress_desc` varchar(255) DEFAULT NULL COMMENT '当前进展概述',
  `additional_desc` varchar(255) DEFAULT NULL COMMENT '额外说明',
  PRIMARY KEY (`id`),
  KEY `FK_pro_node_process_node_id_fk` (`process_node_id`),
  KEY `FK_pro_node_project_id_fk` (`project_id`),
  CONSTRAINT `FK_pro_node_process_node_id_fk` FOREIGN KEY (`process_node_id`) REFERENCES `process_node` (`id`),
  CONSTRAINT `FK_pro_node_project_id_fk` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pro_node
-- ----------------------------

-- ----------------------------
-- Table structure for `quota`
-- ----------------------------
DROP TABLE IF EXISTS `quota`;
CREATE TABLE `quota` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `type` enum('辅助参考','关键指标') DEFAULT NULL COMMENT '指标标注',
  `sort` int(11) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of quota
-- ----------------------------

-- ----------------------------
-- Table structure for `task_book`
-- ----------------------------
DROP TABLE IF EXISTS `task_book`;
CREATE TABLE `task_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_node_id` int(11) DEFAULT NULL,
  `task_book_template_id` int(11) DEFAULT NULL,
  `quota_num` decimal(5,4) DEFAULT NULL,
  `quota_num_real` decimal(5,4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_task_book_pro_node_id_fk` (`pro_node_id`),
  KEY `FK_task_book_task_book_template_id_fk` (`task_book_template_id`),
  CONSTRAINT `FK_task_book_pro_node_id_fk` FOREIGN KEY (`pro_node_id`) REFERENCES `pro_node` (`id`),
  CONSTRAINT `FK_task_book_task_book_template_id_fk` FOREIGN KEY (`task_book_template_id`) REFERENCES `task_book_template` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task_book
-- ----------------------------

-- ----------------------------
-- Table structure for `task_book_template`
-- ----------------------------
DROP TABLE IF EXISTS `task_book_template`;
CREATE TABLE `task_book_template` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `process_node_id` int(11) DEFAULT NULL,
  `quota_name` varchar(20) DEFAULT NULL,
  `quota_type` enum('辅助参考','关键指标') DEFAULT NULL,
  `sort` tinyint(4) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_task_book_template_process_node_id_fk` (`process_node_id`),
  CONSTRAINT `FK_task_book_template_process_node_id_fk` FOREIGN KEY (`process_node_id`) REFERENCES `process_node` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task_book_template
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `type` enum('管理员','普通用户') DEFAULT NULL,
  `flag` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'wff@cy', 'b95c1fe28f928406bdf54235a8cdab51', '管理员', '1');
INSERT INTO `user` VALUES ('2', 'a@cy', '123456', '普通用户', '0');
INSERT INTO `user` VALUES ('3', 'lwj@cy', '123456', '普通用户', '0');

-- ----------------------------
-- Table structure for `user2project`
-- ----------------------------
DROP TABLE IF EXISTS `user2project`;
CREATE TABLE `user2project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `project_id` int(11) DEFAULT NULL,
  `is_view` tinyint(1) DEFAULT NULL,
  `is_edit` tinyint(1) DEFAULT NULL,
  `flag` tinyint(1) DEFAULT NULL,
  `user_type` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user2project_project_id_fk` (`project_id`),
  KEY `FK_user2project_user_id_fk` (`user_id`),
  CONSTRAINT `FK_user2project_project_id_fk` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  CONSTRAINT `FK_user2project_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户项目表';

-- ----------------------------
-- Records of user2project
-- ----------------------------
