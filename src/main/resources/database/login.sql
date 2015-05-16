/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50527
Source Host           : 127.0.0.1:3306
Source Database       : project_management

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2015-05-16 16:37:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `id` varchar(128) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(64) NOT NULL,
  `userName` varchar(32) NOT NULL,
  `sessionId` varchar(128) NOT NULL,
  `createTimestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `lastLoginIp` varchar(32) NOT NULL DEFAULT '',
  `lastLoginTimestamp` timestamp NOT NULL DEFAULT '2015-01-01 00:00:00',
  `level` int(11) NOT NULL DEFAULT '0',
  `isActive` tinyint(4) NOT NULL DEFAULT '0',
  `activeCode` varchar(128) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_unique_index` (`email`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
