/*
 Navicat Premium Data Transfer

 Source Server         : LocalMySql
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 17/03/2023 18:55:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `student_id` bigint(0) NOT NULL COMMENT '老师ID',
  `student_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '老师姓名',
  `teacher_id` bigint(0) NULL DEFAULT NULL COMMENT '老师ID',
  `deleted_db` tinyint(1) NULL DEFAULT NULL COMMENT '逻辑删除',
  `create_by_db` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_by_db` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `create_time_db` datetime(3) NULL DEFAULT NULL COMMENT '创建日期',
  `update_time_db` datetime(3) NULL DEFAULT NULL COMMENT '更新日期、乐观锁',
  PRIMARY KEY (`student_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '张三', 1, 0, 'admin', 'admin', '2023-03-07 08:18:32.819', '2023-03-17 03:45:37.525');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `teacher_id` bigint(0) NOT NULL COMMENT '老师ID',
  `teacher_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '老师姓名',
  `deleted_db` tinyint(1) NULL DEFAULT NULL COMMENT '逻辑删除',
  `create_by_db` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_by_db` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `create_time_db` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `update_time_db` datetime(0) NULL DEFAULT NULL COMMENT '更新日期、乐观锁',
  PRIMARY KEY (`teacher_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, '李老师', 0, 'admin', 'admin', '2023-03-17 18:55:16', '2023-03-17 18:55:19');

SET FOREIGN_KEY_CHECKS = 1;
