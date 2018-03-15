/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : db_pratra

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2015-08-30 18:20:14
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `tb_stat`
-- ----------------------------
DROP TABLE IF EXISTS `tb_stat`;
CREATE TABLE `tb_stat` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `write_state` varchar(50) NOT NULL,
  `prono` int(11) NOT NULL,
  PRIMARY KEY (`sid`),
  KEY `write_state` (`write_state`),
  CONSTRAINT `write_state` FOREIGN KEY (`write_state`) REFERENCES `tb_write` (`state`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tb_stat
-- ----------------------------
