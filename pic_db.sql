/*
 Navicat Premium Data Transfer

 Source Server         : 本地MySQL
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : pic_db

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 04/12/2020 19:41:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `category_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类id，自动增值',
  `category_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '分类名',
  `sign_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '标志图相对地址',
  `creation_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '记录创建时间',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 105 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (101, '美女', NULL, '2020-11-19 22:14:14');
INSERT INTO `category` VALUES (102, '美男', NULL, '2020-11-19 22:14:27');
INSERT INTO `category` VALUES (103, '二次元', NULL, '2020-11-19 22:14:55');
INSERT INTO `category` VALUES (104, '原神', NULL, '2020-11-19 22:15:12');

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect`  (
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `oject_id` int(11) NOT NULL COMMENT '图片或图集ID',
  `object_type` int(1) NOT NULL COMMENT '收藏对象类型，1图片，2图集',
  `is_cancel` int(1) NOT NULL COMMENT '是否取消收藏，0否，1是',
  `creation_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '记录创建时间'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pic_list
-- ----------------------------
DROP TABLE IF EXISTS `pic_list`;
CREATE TABLE `pic_list`  (
  `pic_list_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图集id，自动增值',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `category_id` int(11) NOT NULL COMMENT '分类ID',
  `pic_list_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '图集名称',
  `intro` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '图集简介',
  `collect_num` int(10) NOT NULL DEFAULT 0 COMMENT '收藏数',
  `heat` int(10) NOT NULL COMMENT '热度',
  `enable` int(1) NOT NULL COMMENT '是否未被封禁，0否，1是',
  `creation_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '记录创建时间',
  PRIMARY KEY (`pic_list_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture`  (
  `picture_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图片id，自动增值',
  `pic_list_id` int(11) NOT NULL COMMENT '外键图集ID',
  `category_id` int(11) NOT NULL COMMENT '外键分类ID',
  `user_id` int(11) NOT NULL COMMENT '外键用户ID',
  `thumbnail_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '缩略图相对地址',
  `od_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '原图相对地址',
  `praise_num` int(10) NOT NULL DEFAULT 0 COMMENT '点赞数',
  `collect_num` int(10) NOT NULL DEFAULT 0 COMMENT '收藏数',
  `enable` int(1) NOT NULL COMMENT '是否未被封禁，0否，1是',
  `creation_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '记录创建时间',
  `heat` int(10) NOT NULL COMMENT '热度',
  PRIMARY KEY (`picture_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for praise
-- ----------------------------
DROP TABLE IF EXISTS `praise`;
CREATE TABLE `praise`  (
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `picture_id` int(11) NOT NULL COMMENT '	图片ID',
  `is_cancel` int(1) NOT NULL COMMENT '是否取消收藏，0否，1是',
  `creation_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '	记录创建时间'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id，自动增值',
  `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户密码',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户邮箱',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户昵称',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户头像，填相对地址',
  `role` int(1) NOT NULL DEFAULT 2 COMMENT '用户权限，0超级管理员，1管理员，2普通用户',
  `enable` int(1) NOT NULL COMMENT '是否未被封禁，0否，1是',
  `creation_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '记录创建时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
