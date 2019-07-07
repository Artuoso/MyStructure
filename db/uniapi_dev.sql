/*
Navicat MySQL Data Transfer

Source Server         : localdev
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : uniapi_dev

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-07-06 10:57:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for demo_user
-- ----------------------------
DROP TABLE IF EXISTS `demo_user`;
CREATE TABLE `demo_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(32) NOT NULL COMMENT '姓名',
  `is_have_sect` char(1) NOT NULL COMMENT '有无门派标识（0-无；1-有；）',
  `sect_name` varchar(64) DEFAULT NULL COMMENT '门派名称',
  `round_count` int(10) unsigned NOT NULL COMMENT '通过关卡数',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
