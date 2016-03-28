/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50538
Source Host           : localhost:3306
Source Database       : qxjs

Target Server Type    : MYSQL
Target Server Version : 50538
File Encoding         : 65001

Date: 2016-03-28 19:40:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `activityId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `time` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` varchar(3000) NOT NULL,
  `imgs` varchar(500) NOT NULL,
  `state` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`activityId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `categoryId` int(11) NOT NULL AUTO_INCREMENT,
  `categoryCname` varchar(50) NOT NULL,
  `categoryEname` varchar(20) NOT NULL,
  `level` int(11) NOT NULL,
  `enable` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`categoryId`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '沙发', 'sofa', '1', '1');
INSERT INTO `category` VALUES ('2', '茶几', 'teatable', '2', '1');
INSERT INTO `category` VALUES ('3', '窗帘', 'curtain', '3', '1');
INSERT INTO `category` VALUES ('4', '墙面', 'wall', '4', '1');
INSERT INTO `category` VALUES ('5', '地板', 'floor', '5', '1');
INSERT INTO `category` VALUES ('6', '地毯', 'carpet', '6', '1');

-- ----------------------------
-- Table structure for custom
-- ----------------------------
DROP TABLE IF EXISTS `custom`;
CREATE TABLE `custom` (
  `customId` int(11) NOT NULL AUTO_INCREMENT,
  `storeId` int(11) NOT NULL,
  `customName` varchar(20) NOT NULL,
  `sex` int(11) NOT NULL,
  `age` int(11) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `address` varchar(100) NOT NULL,
  PRIMARY KEY (`customId`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of custom
-- ----------------------------
INSERT INTO `custom` VALUES ('1', '1', '11', '1', '1', '1', '1');
INSERT INTO `custom` VALUES ('2', '2', '21', '2', '2', '2', '2');
INSERT INTO `custom` VALUES ('3', '3', '32', '3', '3', '3', '3');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `newsId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `time` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` varchar(3000) NOT NULL,
  `imgs` varchar(500) NOT NULL,
  `state` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`newsId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------

-- ----------------------------
-- Table structure for param
-- ----------------------------
DROP TABLE IF EXISTS `param`;
CREATE TABLE `param` (
  `paramId` int(11) NOT NULL AUTO_INCREMENT,
  `categoryId` int(11) NOT NULL,
  `cname` varchar(20) NOT NULL,
  `ename` varchar(20) NOT NULL,
  `level` int(11) NOT NULL,
  PRIMARY KEY (`paramId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of param
-- ----------------------------

-- ----------------------------
-- Table structure for photo
-- ----------------------------
DROP TABLE IF EXISTS `photo`;
CREATE TABLE `photo` (
  `photoId` int(11) NOT NULL AUTO_INCREMENT,
  `productId` int(11) DEFAULT NULL,
  `userId` int(11) NOT NULL,
  `type` int(11) NOT NULL DEFAULT '0',
  `path` varchar(100) NOT NULL,
  `comment` varchar(200) NOT NULL,
  `enable` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`photoId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of photo
-- ----------------------------

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `productId` int(11) NOT NULL,
  `groupId` int(11) DEFAULT NULL,
  `categoryId` int(11) NOT NULL,
  `productname` varchar(50) NOT NULL,
  `productCd` varchar(20) NOT NULL,
  `imgPath` varchar(100) NOT NULL,
  `paramJson` varchar(2000) NOT NULL,
  `comment` varchar(500) NOT NULL,
  `enable` int(11) NOT NULL DEFAULT '1'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------

-- ----------------------------
-- Table structure for province
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province` (
  `provinceId` int(11) NOT NULL AUTO_INCREMENT,
  `provinceName` varchar(30) NOT NULL,
  PRIMARY KEY (`provinceId`)
) ENGINE=MyISAM AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of province
-- ----------------------------
INSERT INTO `province` VALUES ('1', '河北');
INSERT INTO `province` VALUES ('2', '山西');
INSERT INTO `province` VALUES ('3', '辽宁');
INSERT INTO `province` VALUES ('4', '吉林');
INSERT INTO `province` VALUES ('5', '黑龙江');
INSERT INTO `province` VALUES ('6', '江苏');
INSERT INTO `province` VALUES ('7', '浙江');
INSERT INTO `province` VALUES ('8', '安徽');
INSERT INTO `province` VALUES ('9', '福建');
INSERT INTO `province` VALUES ('10', '台湾');
INSERT INTO `province` VALUES ('11', '江西');
INSERT INTO `province` VALUES ('12', '山东');
INSERT INTO `province` VALUES ('13', '河南');
INSERT INTO `province` VALUES ('14', '湖北');
INSERT INTO `province` VALUES ('15', '湖南');
INSERT INTO `province` VALUES ('16', '广东');
INSERT INTO `province` VALUES ('17', '海南');
INSERT INTO `province` VALUES ('18', '四川');
INSERT INTO `province` VALUES ('19', '贵州');
INSERT INTO `province` VALUES ('20', '云南');
INSERT INTO `province` VALUES ('21', '陕西');
INSERT INTO `province` VALUES ('22', '甘肃');
INSERT INTO `province` VALUES ('23', '青海');
INSERT INTO `province` VALUES ('24', '内蒙古');
INSERT INTO `province` VALUES ('25', '广西');
INSERT INTO `province` VALUES ('26', '西藏');
INSERT INTO `province` VALUES ('27', '宁夏');
INSERT INTO `province` VALUES ('28', '新疆');
INSERT INTO `province` VALUES ('29', '香港');
INSERT INTO `province` VALUES ('30', '澳门');
INSERT INTO `province` VALUES ('31', '北京');
INSERT INTO `province` VALUES ('32', '天津');
INSERT INTO `province` VALUES ('33', '上海');
INSERT INTO `province` VALUES ('34', '重庆');

-- ----------------------------
-- Table structure for series
-- ----------------------------
DROP TABLE IF EXISTS `series`;
CREATE TABLE `series` (
  `seriesId` int(11) NOT NULL AUTO_INCREMENT,
  `seriesname` varchar(20) NOT NULL,
  `coment` varchar(500) NOT NULL,
  `enable` int(11) NOT NULL,
  PRIMARY KEY (`seriesId`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of series
-- ----------------------------
INSERT INTO `series` VALUES ('1', '千禧系列', '', '1');
INSERT INTO `series` VALUES ('2', '依卡诺系列', '', '1');
INSERT INTO `series` VALUES ('3', '佰客系列', '', '1');
INSERT INTO `series` VALUES ('4', '诺爱系列', '', '1');
INSERT INTO `series` VALUES ('5', '跃动系列', '', '1');
INSERT INTO `series` VALUES ('6', '组合系列', '', '1');

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `storeId` int(11) NOT NULL AUTO_INCREMENT,
  `provinceId` int(11) NOT NULL,
  `storeName` varchar(100) NOT NULL,
  `address` varchar(500) NOT NULL,
  `phone` varchar(40) NOT NULL,
  `img` varchar(100) NOT NULL,
  PRIMARY KEY (`storeId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of store
-- ----------------------------

-- ----------------------------
-- Table structure for t_group
-- ----------------------------
DROP TABLE IF EXISTS `t_group`;
CREATE TABLE `t_group` (
  `groupId` int(11) NOT NULL AUTO_INCREMENT,
  `groupCd` varchar(20) NOT NULL,
  `seriesId` int(11) NOT NULL,
  `comment` varchar(200) NOT NULL,
  PRIMARY KEY (`groupId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_group
-- ----------------------------

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `customId` int(11) NOT NULL,
  `time` int(11) NOT NULL,
  `address` varchar(200) NOT NULL,
  `content` varchar(500) NOT NULL,
  `comment` varchar(500) NOT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('1', '1', '1', '1', '11', '1');
INSERT INTO `t_order` VALUES ('2', '2', '2', '2', '21', '2');
INSERT INTO `t_order` VALUES ('3', '2', '3', '3', '31', '3');
INSERT INTO `t_order` VALUES ('4', '3', '4', '4', '4', '4');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `storeId` int(11) NOT NULL,
  `role` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`userId`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('9', '22', '333', '5', '4');
INSERT INTO `user` VALUES ('10', '111', '111', '111', '1');
INSERT INTO `user` VALUES ('11', '111', '111', '111', '1');
INSERT INTO `user` VALUES ('12', '111', '111', '111', '1');
INSERT INTO `user` VALUES ('13', '111', '111', '111', '1');
