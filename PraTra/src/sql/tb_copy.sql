/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : db_pratra

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2015-08-30 18:20:28
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `tb_copy`
-- ----------------------------
DROP TABLE IF EXISTS `tb_copy`;
CREATE TABLE `tb_copy` (
  `id` varchar(30) NOT NULL,
  `write_place` varchar(200) NOT NULL,
  `write_no` varchar(50) DEFAULT NULL,
  `write_name` varchar(50) DEFAULT NULL,
  `kind` varchar(100) DEFAULT NULL,
  `projact` varchar(100) DEFAULT NULL,
  `period` varchar(50) DEFAULT NULL,
  `stdt` varchar(50) DEFAULT NULL,
  `stnum` varchar(255) DEFAULT NULL,
  `fidt` varchar(255) DEFAULT NULL,
  `finum` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `write_name` (`write_name`),
  KEY `write_place` (`write_place`),
  KEY `write_no` (`write_no`),
  KEY `kind` (`kind`),
  KEY `projact` (`projact`),
  KEY `period` (`period`),
  KEY `kind_2` (`kind`),
  KEY `projact_2` (`projact`),
  KEY `period_2` (`period`),
  KEY `period_3` (`period`),
  CONSTRAINT `write_name` FOREIGN KEY (`write_name`) REFERENCES `tb_write` (`name`),
  CONSTRAINT `write_no` FOREIGN KEY (`write_no`) REFERENCES `tb_write` (`no`),
  CONSTRAINT `write_place` FOREIGN KEY (`write_place`) REFERENCES `tb_write` (`place`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tb_copy
-- ----------------------------
