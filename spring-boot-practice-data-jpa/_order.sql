/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : db_order

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2018-08-01 19:01:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for _order
-- ----------------------------
DROP TABLE IF EXISTS `_order`;
CREATE TABLE `_order` (
  `id` varchar(20) NOT NULL,
  `total_list_price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '总码洋',
  `total_sale_price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '总实洋',
  `purchase_quantity` int(11) NOT NULL DEFAULT '0' COMMENT '购买数量',
  `purchase_kinds` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '品种数',
  `customer` varchar(255) NOT NULL COMMENT '客户(正常情况下是客户ID)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
