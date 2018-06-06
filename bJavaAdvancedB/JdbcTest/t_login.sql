/*
 Navicat Premium Data Transfer

 Source Server         : mysql57
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : testdb

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 28/05/2018 22:17:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_login
-- ----------------------------
DROP TABLE IF EXISTS `t_login`;
CREATE TABLE `t_login`  (
  `login_id` int(11) NOT NULL AUTO_INCREMENT,
  `login_account` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `login_pass` char(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`login_id`) USING BTREE,
  UNIQUE INDEX `login_account`(`login_account`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_login
-- ----------------------------
INSERT INTO `t_login` VALUES (1, 'admin', '1234');
INSERT INTO `t_login` VALUES (2, 'admin123', '1234');

SET FOREIGN_KEY_CHECKS = 1;
