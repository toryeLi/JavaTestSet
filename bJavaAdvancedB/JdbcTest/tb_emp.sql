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

 Date: 28/05/2018 22:17:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_emp
-- ----------------------------
DROP TABLE IF EXISTS `tb_emp`;
CREATE TABLE `tb_emp`  (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `emp_sex` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dept_id` int(11) NULL DEFAULT NULL,
  `salary` double(12, 1) NULL DEFAULT 4000.0,
  `emp_mail` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'default@mail.com',
  PRIMARY KEY (`emp_id`) USING BTREE,
  INDEX `dept_id`(`dept_id`) USING BTREE,
  CONSTRAINT `tb_emp_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `t_dept` (`dept_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 22767171 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `tb_emp` VALUES (2, '信誉昂', '男', 1, 9000.0, 'xinyang@hp.com');
INSERT INTO `tb_emp` VALUES (3, '张三', '女', 2, 8000.0, 'zhangsan@hp.com');
INSERT INTO `tb_emp` VALUES (10001, '小乔', '女', 1, 7800.0, 'xiaoqiao@hp.com');
INSERT INTO `tb_emp` VALUES (10002, '大乔', '女', 2, 6500.0, 'daqiao@hp.com');
INSERT INTO `tb_emp` VALUES (10003, '赵柳', '男', 2, 6700.0, 'zhangsan@hp.com');
INSERT INTO `tb_emp` VALUES (10004, '阳阳', '女', 1, 8000.0, 'zhangsan@hp.com');
INSERT INTO `tb_emp` VALUES (10005, '信誉昂', '男', 3, 4000.0, 'xinyang@hp.com');
INSERT INTO `tb_emp` VALUES (10006, '赵柳', '男', 2, 5000.0, 'zhangsan@hp.com');
INSERT INTO `tb_emp` VALUES (10007, '阳阳', '女', 2, 6000.0, 'zhangsan@hp.com');
INSERT INTO `tb_emp` VALUES (10008, '赵柳', '男', 2, 5000.0, 'zhangsan@hp.com');
INSERT INTO `tb_emp` VALUES (10009, '阳XXX阳', '女', 3, 6000.0, 'zhangsan@hp.com');
INSERT INTO `tb_emp` VALUES (10014, '赵柳', '男', 3, 5000.0, 'zhangsan@hp.com');
INSERT INTO `tb_emp` VALUES (10015, '阳xxx阳', '男', 2, 6000.0, 'zhangsan@hp.com');
INSERT INTO `tb_emp` VALUES (10016, '赵柳', '男', 2, 5000.0, 'zhangsan@hp.com');
INSERT INTO `tb_emp` VALUES (10017, '阳阳', '女', 3, 6000.0, 'zhangsan@hp.com');
INSERT INTO `tb_emp` VALUES (200001, '新员工', '女', 3, 4000.0, 'default@mail.com');
INSERT INTO `tb_emp` VALUES (200002, 'admin', '女', 3, 4000.0, NULL);
INSERT INTO `tb_emp` VALUES (200003, '关羽', '男', NULL, 8000.0, 'guanyu@hp.com');