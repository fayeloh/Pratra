/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : db_pratra

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2015-08-30 23:00:42
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `tb_write`
-- ----------------------------
DROP TABLE IF EXISTS `tb_write`;
CREATE TABLE `tb_write` (
  `id` varchar(50) NOT NULL,
  `state` varchar(50) NOT NULL,
  `place` varchar(200) NOT NULL,
  `no` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `kind` varchar(100) NOT NULL,
  `stara` varchar(51) NOT NULL,
  `inspa` varchar(51) NOT NULL,
  `diar` varchar(51) NOT NULL,
  `rent` varchar(50) NOT NULL,
  `cono` varchar(100) NOT NULL,
  `cost` varchar(100) NOT NULL,
  `cofi` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`),
  KEY `place` (`place`),
  KEY `no` (`no`),
  KEY `place_2` (`place`),
  KEY `no_2` (`no`),
  KEY `state` (`state`),
  KEY `state_2` (`state`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tb_write
-- ----------------------------
INSERT INTO tb_write VALUES ('1', '已入住', '茂南区官渡二路石化小区', '001', '李白', '办公室', '13000', '12000', '12000', '1300', '001', '2015-08-25', '2015-11-12', '0660-001');
INSERT INTO tb_write VALUES ('10', '未入住', '茂南区官渡二路石化小区', '010', '李四', '住房', '1200', '1000', '100', '500', '010', '2015-08-28', '2015-08-28', '0660-010');
INSERT INTO tb_write VALUES ('11', '已审核', '茂南区官渡二路石化小区', '011', '奥黛丽赫本', '住房', '13000', '12000', '12000', '1200', '011', '2015-08-28', '2015-08-28', '0660-011');
INSERT INTO tb_write VALUES ('12', '已审核', '茂南区官渡二路石化小区', '012', '王五', '住房', '13000', '12000', '1200', '1200', '012', '2015-08-28', '2015-08-28', '0660-012');
INSERT INTO tb_write VALUES ('13', '已审核', '茂南区官渡二路石化小区', '013', '小明', '住房', '13000', '12000', '1200', '12000', '013', '2015-08-28', '2015-08-28', '0660-013');
INSERT INTO tb_write VALUES ('14', '已审核', '茂南区官渡二路石化小区', '014', '薛凯琪', '住房', '15000', '13000', '1300', '1300', '014', '2015-08-28', '2015-08-28', '0660-014');
INSERT INTO tb_write VALUES ('15', '未审核', '茂南区官渡二路石化小区', '015', '刘德华', '住房', '15000', '13000', '1300', '1300', '015', '2015-08-28', '2015-08-28', '0660-015');
INSERT INTO tb_write VALUES ('16', '未审核', '茂南区官渡二路石化小区', '016', '陈欧', '住房', '15000', '13000', '1300', '1300', '016', '2015-08-28', '2015-08-28', '0660-016');
INSERT INTO tb_write VALUES ('17', '未审核', '茂南区官渡二路石化小区', '017', '薛之谦', '地下室', '15000', '13000', '1300', '1300', '017', '2015-08-28', '2015-08-28', '0660-017');
INSERT INTO tb_write VALUES ('18', '未审核', '茂南区官渡二路', '018', '陈奕迅', '住房', '13000', '12000', '12000', '1300', '018', '2015-08-30', '2015-09-30', '0660-018');
INSERT INTO tb_write VALUES ('2', '已入住', '茂南区官渡二路石化小区', '002', '张三', '住房', '12000', '10000', '1000', '1000', '002', '2015-08-25', '2015-11-11', '0660-002');
INSERT INTO tb_write VALUES ('3', '已入住', '茂南区官渡二路石化小区', '003', '蔡依林', '住房', '15000', '13000', '1300', '1300', '003', '2015-08-25', '2015-11-21', '0660-003');
INSERT INTO tb_write VALUES ('4', '已入住', '茂南区官渡二路石化小区', '004', '周杰伦', '住房', '15000', '13000', '1300', '1300', '004', '2015-08-26', '2015-10-22', '0660-004');
INSERT INTO tb_write VALUES ('5', '已入住', '茂南区官渡二路石化小区', '005', 'bigbang', '地下室', '15000', '13000', '1300', '1300', '005', '2015-08-26', '2015-09-22', '0660-005');
INSERT INTO tb_write VALUES ('6', '未入住', '茂南区官渡二路石化小区', '006', '黄家驹', '住房', '15000', '13000', '1300', '1300', '006', '2015-08-27', '2015-09-28', '0660-006');
INSERT INTO tb_write VALUES ('7', '未入住', '茂南区官渡二路石化小区', '007', '杜甫', '住房', '15000', '13000', '1300', '1300', '007', '2015-08-27', '2015-09-28', '0660-007');
INSERT INTO tb_write VALUES ('8', '未入住', '茂南区官渡二路石化小区', '008', '贝克汉姆', '健身房', '15000', '13000', '1300', '1300', '008', '2015-08-28', '2015-08-28', '0660-008');
INSERT INTO tb_write VALUES ('9', '未入住', '茂南区官渡二路石化小区', '009', '小红', '住房', '15000', '13000', '1300', '1300', '009', '2015-08-28', '2015-08-28', '0660-009');
