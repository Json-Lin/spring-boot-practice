/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : db_order

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2018-08-01 19:00:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for order_item
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `_order` varchar(20) NOT NULL COMMENT '订单号',
  `product_sale` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '商品id',
  `purchase_quantity` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '购买数量',
  `list_price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '码洋',
  `sale_price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '实洋',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
