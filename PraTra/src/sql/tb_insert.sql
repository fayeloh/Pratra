/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : db_pratra

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2015-08-30 18:20:21
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `tb_insert`
-- ----------------------------
DROP TABLE IF EXISTS `tb_insert`;
CREATE TABLE `tb_insert` (
  `iid` int(11) NOT NULL AUTO_INCREMENT,
  `copy_kind` varchar(20) NOT NULL,
  `copy_project` varchar(50) NOT NULL,
  `copy_period` varchar(50) NOT NULL,
  `price` int(11) NOT NULL,
  `explain` varchar(50) NOT NULL,
  `remark` varchar(50) NOT NULL,
  PRIMARY KEY (`iid`),
  KEY `copy_kind` (`copy_kind`),
  KEY `copy_project` (`copy_project`),
  KEY `copy_period` (`copy_period`),
  CONSTRAINT `copy_period` FOREIGN KEY (`copy_period`) REFERENCES `tb_copy` (`period`),
  CONSTRAINT `copy_kind` FOREIGN KEY (`copy_kind`) REFERENCES `tb_copy` (`kind`),
  CONSTRAINT `copy_project` FOREIGN KEY (`copy_project`) REFERENCES `tb_copy` (`projact`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tb_insert
-- ----------------------------
