/*
Navicat MySQL Data Transfer

Source Server         : db
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : uh_202048

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2023-02-26 23:32:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tbl_tiket`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_tiket`;
CREATE TABLE `tbl_tiket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(55) NOT NULL,
  `tujuan` char(35) NOT NULL,
  `jumlah` int(15) NOT NULL,
  `member` enum('Tidak','Ya') DEFAULT NULL,
  `harga` int(11) NOT NULL,
  `sub_total` int(11) NOT NULL,
  `diskon` double NOT NULL,
  `totalbayar` int(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tbl_tiket
-- ----------------------------
INSERT INTO `tbl_tiket` VALUES ('1', 'Bintang Kun', 'Bali', '5', 'Tidak', '1000000', '4000000', '0', '5000000');
