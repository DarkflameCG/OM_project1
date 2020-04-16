/*
 Navicat Premium Data Transfer

 Source Server         : rootuser
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : oldman

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 15/04/2020 21:48:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `card_numb` int(20) DEFAULT NULL,
  `balance` int(255) DEFAULT NULL,
  `oldman_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_oldman_account` (`oldman_id`),
  CONSTRAINT `fk_oldman_account` FOREIGN KEY (`oldman_id`) REFERENCES `old_man` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
BEGIN;
INSERT INTO `account` VALUES (1, 1001, 10000, 1);
INSERT INTO `account` VALUES (2, 1002, 10000, 2);
COMMIT;

-- ----------------------------
-- Table structure for base_user_info
-- ----------------------------
DROP TABLE IF EXISTS `base_user_info`;
CREATE TABLE `base_user_info` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_img` varchar(100) NOT NULL,
  `user_name` varchar(25) NOT NULL,
  `password` varchar(11) NOT NULL,
  `salary` double DEFAULT NULL,
  `work_time` varchar(20) NOT NULL,
  `title` varchar(20) DEFAULT NULL,
  `role_id` int(2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `power` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_user_info
-- ----------------------------
BEGIN;
INSERT INTO `base_user_info` VALUES (1, 'file/bed.html', 'bb', '123456', 3233, '2020-01-30', NULL, 1);
INSERT INTO `base_user_info` VALUES (2, 'file/bed.html', 'cc', '123456', 10000, '2020-01-31', NULL, 2);
INSERT INTO `base_user_info` VALUES (9, 'file/bed.html', 'dd', '123456', 5000, '2020-01-31', NULL, 2);
COMMIT;

-- ----------------------------
-- Table structure for cost
-- ----------------------------
DROP TABLE IF EXISTS `cost`;
CREATE TABLE `cost` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `money` double DEFAULT NULL,
  `pay_type` varchar(20) DEFAULT NULL,
  `index_id` int(3) NOT NULL,
  `oldMan_id` int(10) DEFAULT NULL,
  `pay_time` date DEFAULT NULL,
  `user_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_id` (`index_id`),
  CONSTRAINT `index_id` FOREIGN KEY (`index_id`) REFERENCES `index` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for family_members
-- ----------------------------
DROP TABLE IF EXISTS `family_members`;
CREATE TABLE `family_members` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `family_img` varchar(100) NOT NULL,
  `family_name` varchar(25) NOT NULL,
  `telphone` varchar(11) NOT NULL,
  `address` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of family_members
-- ----------------------------
BEGIN;
INSERT INTO `family_members` VALUES (1, 'file/bed.html', '王小弟', '19999999999', '山西省');
INSERT INTO `family_members` VALUES (2, 'file/bed.html', '李晓迪', '18888888888', '陕西省');
INSERT INTO `family_members` VALUES (3, 'file/bed.html', '王小妹', '13412312334', '山西省');
INSERT INTO `family_members` VALUES (4, 'file/bed.html', '李晓梅', '11233123123', '陕西省');
COMMIT;

-- ----------------------------
-- Table structure for index
-- ----------------------------
DROP TABLE IF EXISTS `index`;
CREATE TABLE `index` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `index_name` varchar(20) NOT NULL COMMENT '指标项',
  `amount_of_money` int(255) DEFAULT NULL,
  `unit` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of index
-- ----------------------------
BEGIN;
INSERT INTO `index` VALUES (1, '体检费', 1000, '人/次');
INSERT INTO `index` VALUES (2, '床位费', 3000, '人/张');
INSERT INTO `index` VALUES (3, '交通费', 30, '人/次');
INSERT INTO `index` VALUES (4, '护理费', 2400, '人/年');
INSERT INTO `index` VALUES (5, '伙食费', 10000, '人/年');
INSERT INTO `index` VALUES (6, '水电费', 3000, '人/年');
INSERT INTO `index` VALUES (7, '取暖费', 1200, '人/年');
COMMIT;

-- ----------------------------
-- Table structure for modular
-- ----------------------------
DROP TABLE IF EXISTS `modular`;
CREATE TABLE `modular` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for monitor
-- ----------------------------
DROP TABLE IF EXISTS `monitor`;
CREATE TABLE `monitor` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `description` varchar(100) NOT NULL,
  `level` int(3) unsigned zerofill NOT NULL,
  `old_man_id` int(7) DEFAULT NULL,
  `user_id` int(7) DEFAULT NULL,
  `index_id` int(7) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `old_man_id_m` (`old_man_id`),
  KEY `user_id_m` (`user_id`),
  KEY `index_id_m` (`index_id`),
  CONSTRAINT `index_id_m` FOREIGN KEY (`index_id`) REFERENCES `index` (`id`),
  CONSTRAINT `old_man_id_m` FOREIGN KEY (`old_man_id`) REFERENCES `old_man` (`id`),
  CONSTRAINT `user_id_m` FOREIGN KEY (`user_id`) REFERENCES `base_user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for old_man
-- ----------------------------
DROP TABLE IF EXISTS `old_man`;
CREATE TABLE `old_man` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `oldman_img` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `oldman_name` varchar(25) NOT NULL,
  `age` int(7) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `checkintime` date DEFAULT NULL,
  `telphone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `health` varchar(20) DEFAULT NULL,
  `family_members_id` int(7) DEFAULT NULL,
  `room_id` int(7) DEFAULT NULL,
  `user_id` int(7) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `family_members_id` (`family_members_id`),
  KEY `room_id` (`room_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `family_members_id` FOREIGN KEY (`family_members_id`) REFERENCES `family_members` (`id`),
  CONSTRAINT `room_id` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `base_user_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of old_man
-- ----------------------------
BEGIN;
INSERT INTO `old_man` VALUES (1, 'file/bed.htm', '张大爷', 60, '男', '1959-04-10', '2020-04-10', '13333333333', '偏差', 1, 1, 2);
INSERT INTO `old_man` VALUES (2, 'file/bed.html', '李大爷', 62, '男', '1957-04-10', '2020-04-10', '12222222222', '正常', 2, 3, 2);
INSERT INTO `old_man` VALUES (3, NULL, '王大爷和李大妈', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `old_man` VALUES (4, NULL, '王大爷哈哈', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `old_man` VALUES (5, NULL, '我就不信了', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `old_man` VALUES (6, NULL, '撒打算打算打算', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `old_man` VALUES (7, NULL, '撒打算打算打算', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `old_man` VALUES (8, NULL, '12345', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `old_man` VALUES (9, NULL, '12345', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `old_man` VALUES (11, NULL, '嘿嘿嘿', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `old_man` VALUES (12, NULL, '王大爷和李大妈', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `old_man` VALUES (13, NULL, '12345', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `old_man` VALUES (14, NULL, '12345', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `old_man` VALUES (15, NULL, '王大爷和李大妈', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for old_man_leave
-- ----------------------------
DROP TABLE IF EXISTS `old_man_leave`;
CREATE TABLE `old_man_leave` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `start_time` varchar(30) NOT NULL,
  `end_time` varchar(30) NOT NULL,
  `state` int(2) unsigned zerofill NOT NULL,
  `user_id` int(7) DEFAULT NULL,
  `user_manager_id` int(7) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id_u` (`user_id`),
  KEY `user_manager_id_u` (`user_manager_id`),
  CONSTRAINT `user_id_u` FOREIGN KEY (`user_id`) REFERENCES `base_user_info` (`id`),
  CONSTRAINT `user_manager_id_u` FOREIGN KEY (`user_manager_id`) REFERENCES `base_user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for power
-- ----------------------------
DROP TABLE IF EXISTS `power`;
CREATE TABLE `power` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `power` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power
-- ----------------------------
BEGIN;
INSERT INTO `power` VALUES (1, '管理员');
INSERT INTO `power` VALUES (2, '护工');
INSERT INTO `power` VALUES (3, '家属');
COMMIT;

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `room_numb_img` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `room_numb` varchar(15) NOT NULL,
  `room_state` int(2) unsigned zerofill NOT NULL DEFAULT '00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------
BEGIN;
INSERT INTO `room` VALUES (1, '', '101-1', 01);
INSERT INTO `room` VALUES (2, '', '101-2', 02);
INSERT INTO `room` VALUES (3, ' ', '102-1', 01);
INSERT INTO `room` VALUES (4, ' ', '102-2', 01);
INSERT INTO `room` VALUES (5, ' ', '103-1', 01);
INSERT INTO `room` VALUES (6, ' ', '103-2', 02);
INSERT INTO `room` VALUES (7, ' ', '104-1', 02);
INSERT INTO `room` VALUES (8, ' ', '104-2', 02);
INSERT INTO `room` VALUES (9, ' ', '105-1', 01);
INSERT INTO `room` VALUES (10, NULL, '105-2', 01);
INSERT INTO `room` VALUES (11, NULL, '106-1', 01);
INSERT INTO `room` VALUES (12, NULL, '106-1', 01);
INSERT INTO `room` VALUES (13, NULL, '107-2', 01);
INSERT INTO `room` VALUES (14, NULL, '107-1', 01);
INSERT INTO `room` VALUES (15, NULL, '108-1', 01);
INSERT INTO `room` VALUES (16, NULL, '108-2', 01);
INSERT INTO `room` VALUES (17, NULL, '109-1', 01);
INSERT INTO `room` VALUES (18, NULL, '109-2', 02);
INSERT INTO `room` VALUES (19, NULL, '110-1', 02);
INSERT INTO `room` VALUES (20, NULL, '110-2', 02);
INSERT INTO `room` VALUES (21, NULL, '201-1', 02);
INSERT INTO `room` VALUES (22, NULL, '201-2', 02);
INSERT INTO `room` VALUES (23, NULL, '202-1', 02);
INSERT INTO `room` VALUES (24, NULL, '202-2', 02);
INSERT INTO `room` VALUES (25, NULL, '203-1', 02);
INSERT INTO `room` VALUES (26, NULL, '203-2', 02);
INSERT INTO `room` VALUES (27, NULL, '204-1', 02);
INSERT INTO `room` VALUES (28, NULL, '204-2', 02);
INSERT INTO `room` VALUES (29, NULL, '205-1', 02);
INSERT INTO `room` VALUES (30, NULL, '205-2', 02);
INSERT INTO `room` VALUES (31, NULL, '206-1', 02);
INSERT INTO `room` VALUES (32, NULL, '206-2', 02);
INSERT INTO `room` VALUES (33, NULL, '207-1', 02);
INSERT INTO `room` VALUES (34, NULL, '207-2', 02);
INSERT INTO `room` VALUES (35, NULL, '208-1', 02);
INSERT INTO `room` VALUES (36, NULL, '208-2', 02);
INSERT INTO `room` VALUES (37, NULL, '209-1', 02);
INSERT INTO `room` VALUES (38, NULL, '209-2', 02);
INSERT INTO `room` VALUES (39, NULL, '210-1', 02);
INSERT INTO `room` VALUES (40, NULL, '210-2', 02);
INSERT INTO `room` VALUES (41, NULL, '301-1', 02);
INSERT INTO `room` VALUES (42, NULL, '301-2', 02);
INSERT INTO `room` VALUES (43, NULL, '302-1', 02);
INSERT INTO `room` VALUES (44, NULL, '302-2', 02);
INSERT INTO `room` VALUES (45, NULL, '303-1', 02);
INSERT INTO `room` VALUES (46, NULL, '303-2', 02);
INSERT INTO `room` VALUES (47, NULL, '304-1', 02);
INSERT INTO `room` VALUES (48, NULL, '304-2', 02);
INSERT INTO `room` VALUES (49, NULL, '305-1', 02);
INSERT INTO `room` VALUES (50, NULL, '305-2', 02);
INSERT INTO `room` VALUES (51, NULL, '306-1', 02);
INSERT INTO `room` VALUES (52, NULL, '306-2', 02);
INSERT INTO `room` VALUES (53, NULL, '307-1', 02);
INSERT INTO `room` VALUES (54, NULL, '307-2', 02);
INSERT INTO `room` VALUES (55, NULL, '308-1', 02);
INSERT INTO `room` VALUES (56, NULL, '308-2', 02);
INSERT INTO `room` VALUES (57, NULL, '309-1', 02);
INSERT INTO `room` VALUES (58, NULL, '309-2', 02);
INSERT INTO `room` VALUES (59, NULL, '310-1', 02);
INSERT INTO `room` VALUES (60, NULL, '310-2', 02);
COMMIT;

-- ----------------------------
-- Table structure for user_leave
-- ----------------------------
DROP TABLE IF EXISTS `user_leave`;
CREATE TABLE `user_leave` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `start_time` varchar(30) NOT NULL,
  `end_time` varchar(30) NOT NULL,
  `state` int(2) unsigned zerofill NOT NULL,
  `user_manager_id` int(7) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_manager_id` (`user_manager_id`),
  CONSTRAINT `user_manager_id` FOREIGN KEY (`user_manager_id`) REFERENCES `base_user_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
