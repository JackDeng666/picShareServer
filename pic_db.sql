/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : pic_db

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 10/12/2020 23:11:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `category_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '分类id，自动增值',
  `category_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '分类名',
  `sign_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '标志图相对地址',
  `creation_time` datetime(0) NOT NULL COMMENT '记录创建时间',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 105 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (101, '美女', 'images/2020/12/06/thumbnail/78116b2724.jpg', '2020-12-08 15:53:06');
INSERT INTO `category` VALUES (103, '二次元', 'images/2020/12/08/thumbnail/9c1c3cdaa5.jpg', '2020-12-08 15:52:58');
INSERT INTO `category` VALUES (104, '原神', 'images/2020/12/10/thumbnail/bd95bc1a30.jpg', '2020-11-19 22:15:12');

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect`  (
  `user_id` int(0) NOT NULL COMMENT '用户ID',
  `oject_id` int(0) NOT NULL COMMENT '图片或图集ID',
  `object_type` int(0) NOT NULL COMMENT '收藏对象类型，1图片，2图集',
  `is_cancel` int(0) NOT NULL COMMENT '是否取消收藏，0否，1是',
  `creation_time` datetime(0) NOT NULL COMMENT '记录创建时间'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES (1, 17, 1, 0, '2020-12-09 21:06:31');
INSERT INTO `collect` VALUES (1, 8, 1, 0, '2020-12-09 21:07:20');
INSERT INTO `collect` VALUES (2, 8, 1, 0, '2020-12-09 21:08:42');
INSERT INTO `collect` VALUES (2, 11, 1, 0, '2020-12-09 21:13:45');
INSERT INTO `collect` VALUES (2, 21, 1, 0, '2020-12-10 13:40:15');

-- ----------------------------
-- Table structure for pic_list
-- ----------------------------
DROP TABLE IF EXISTS `pic_list`;
CREATE TABLE `pic_list`  (
  `pic_list_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '图集id，自动增值',
  `user_id` int(0) NOT NULL COMMENT '用户ID',
  `pic_list_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '图集名称',
  `intro` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '图集简介',
  `collect_num` int(0) NOT NULL DEFAULT 0 COMMENT '收藏数',
  `heat` int(0) NOT NULL COMMENT '热度',
  `enable` int(0) NOT NULL COMMENT '是否未被封禁，0否，1是',
  `creation_time` datetime(0) NOT NULL COMMENT '记录创建时间',
  PRIMARY KEY (`pic_list_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pic_list
-- ----------------------------
INSERT INTO `pic_list` VALUES (13, 1, '测试图集1', '', 0, 5, 0, '2020-12-07 21:13:36');
INSERT INTO `pic_list` VALUES (14, 1, '电脑壁纸（1）', '', 0, 1, 0, '2020-12-08 17:59:34');
INSERT INTO `pic_list` VALUES (15, 1, '壁纸2', '', 0, 1, 0, '2020-12-09 21:06:22');
INSERT INTO `pic_list` VALUES (16, 2, '原神1', '', 0, 2, 0, '2020-12-10 13:01:00');
INSERT INTO `pic_list` VALUES (21, 2, '阿三打撒', '', 0, 0, 0, '2020-12-10 13:17:08');
INSERT INTO `pic_list` VALUES (22, 2, '打赏', '', 0, 0, 0, '2020-12-10 13:19:03');
INSERT INTO `pic_list` VALUES (23, 2, '大撒大撒', '', 0, 0, 0, '2020-12-10 13:25:28');

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture`  (
  `picture_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '图片id，自动增值',
  `pic_list_id` int(0) NOT NULL COMMENT '外键图集ID',
  `user_id` int(0) NOT NULL COMMENT '外键用户ID',
  `thumbnail_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '缩略图相对地址',
  `od_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '原图相对地址',
  `praise_num` int(0) NOT NULL DEFAULT 0 COMMENT '点赞数',
  `collect_num` int(0) NOT NULL DEFAULT 0 COMMENT '收藏数',
  `enable` int(0) NOT NULL COMMENT '是否未被封禁，0否，1是',
  `creation_time` datetime(0) NOT NULL COMMENT '记录创建时间',
  `heat` int(0) NOT NULL COMMENT '热度',
  PRIMARY KEY (`picture_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of picture
-- ----------------------------
INSERT INTO `picture` VALUES (7, 13, 1, 'images/2020/12/06/thumbnail/8435f3435f.jpg', 'images/2020/12/06/original/8435f3435f.jpg', 1, 0, 0, '2020-12-06 18:40:56', 1);
INSERT INTO `picture` VALUES (8, 13, 1, 'images/2020/12/06/thumbnail/78116b2724.jpg', 'images/2020/12/06/original/78116b2724.jpg', 2, 2, 0, '2020-12-09 21:08:42', 12);
INSERT INTO `picture` VALUES (9, 13, 1, 'images/2020/12/06/thumbnail/ea16d9dff5.jpg', 'images/2020/12/06/original/ea16d9dff5.jpg', 1, 0, 0, '2020-12-06 18:40:56', 1);
INSERT INTO `picture` VALUES (10, 13, 1, 'images/2020/12/06/thumbnail/f4cdd37ca2.jpg', 'images/2020/12/06/original/f4cdd37ca2.jpg', 1, 0, 0, '2020-12-06 18:40:56', 1);
INSERT INTO `picture` VALUES (11, 13, 1, 'images/2020/12/06/thumbnail/97fb681e43.jpg', 'images/2020/12/06/original/97fb681e43.jpg', 0, 1, 0, '2020-12-09 21:13:45', 5);
INSERT INTO `picture` VALUES (12, 13, 1, 'images/2020/12/06/thumbnail/34a384ab6d.jpg', 'images/2020/12/06/original/34a384ab6d.jpg', 0, 0, 0, '2020-12-06 18:40:57', 0);
INSERT INTO `picture` VALUES (13, 0, 1, 'images/2020/12/06/thumbnail/0e1fc6972e.jpg', 'images/2020/12/06/original/0e1fc6972e.jpg', 0, 0, 0, '2020-12-06 19:29:04', 0);
INSERT INTO `picture` VALUES (14, 14, 1, 'images/2020/12/08/thumbnail/a55799391a.jpg', 'images/2020/12/08/original/a55799391a.jpg', 1, 0, 0, '2020-12-08 18:00:10', 1);
INSERT INTO `picture` VALUES (15, 14, 1, 'images/2020/12/08/thumbnail/2b2cdf684a.jpg', 'images/2020/12/08/original/2b2cdf684a.jpg', 0, 0, 0, '2020-12-08 18:00:10', 0);
INSERT INTO `picture` VALUES (16, 14, 1, 'images/2020/12/08/thumbnail/ea1495f7ae.jpg', 'images/2020/12/08/original/ea1495f7ae.jpg', 0, 0, 0, '2020-12-08 18:00:10', 0);
INSERT INTO `picture` VALUES (17, 15, 1, 'images/2020/12/08/thumbnail/9c1c3cdaa5.jpg', 'images/2020/12/08/original/9c1c3cdaa5.jpg', 1, 1, 0, '2020-12-09 21:06:31', 6);
INSERT INTO `picture` VALUES (18, 16, 2, 'images/2020/12/10/thumbnail/ea58867980.jpg', 'images/2020/12/10/original/ea58867980.jpeg', 0, 0, 0, '2020-12-10 13:01:32', 0);
INSERT INTO `picture` VALUES (19, 16, 2, 'images/2020/12/10/thumbnail/d52eff909a.jpg', 'images/2020/12/10/original/d52eff909a.jpeg', 1, 0, 0, '2020-12-10 13:01:32', 1);
INSERT INTO `picture` VALUES (20, 16, 2, 'images/2020/12/10/thumbnail/e2bfb6ec5a.jpg', 'images/2020/12/10/original/e2bfb6ec5a.jpeg', 0, 0, 0, '2020-12-10 13:01:33', 0);
INSERT INTO `picture` VALUES (21, 16, 2, 'images/2020/12/10/thumbnail/bd95bc1a30.jpg', 'images/2020/12/10/original/bd95bc1a30.jpeg', 1, 1, 0, '2020-12-10 13:01:33', 6);

-- ----------------------------
-- Table structure for praise
-- ----------------------------
DROP TABLE IF EXISTS `praise`;
CREATE TABLE `praise`  (
  `user_id` int(0) NOT NULL COMMENT '用户ID',
  `picture_id` int(0) NOT NULL COMMENT '	图片ID',
  `is_cancel` int(0) NOT NULL COMMENT '是否取消收藏，0否，1是',
  `creation_time` datetime(0) NOT NULL COMMENT '	记录创建时间'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of praise
-- ----------------------------
INSERT INTO `praise` VALUES (1, 17, 0, '2020-12-09 21:06:22');
INSERT INTO `praise` VALUES (1, 8, 0, '2020-12-09 21:07:19');
INSERT INTO `praise` VALUES (2, 8, 0, '2020-12-09 21:08:40');
INSERT INTO `praise` VALUES (2, 11, 1, '2020-12-09 21:13:36');
INSERT INTO `praise` VALUES (2, 7, 0, '2020-12-09 22:16:53');
INSERT INTO `praise` VALUES (2, 14, 0, '2020-12-10 12:51:22');
INSERT INTO `praise` VALUES (2, 19, 0, '2020-12-10 13:40:04');
INSERT INTO `praise` VALUES (2, 21, 0, '2020-12-10 13:40:11');
INSERT INTO `praise` VALUES (2, 9, 0, '2020-12-10 16:25:31');
INSERT INTO `praise` VALUES (2, 10, 0, '2020-12-10 16:27:02');

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `tag_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `category_id` int(0) NOT NULL COMMENT '分类id',
  `object_id` int(0) NOT NULL COMMENT '对象id',
  `object_type` int(0) NOT NULL COMMENT '对象类型，0图片，1图包',
  PRIMARY KEY (`tag_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES (1, 101, 13, 1);
INSERT INTO `tag` VALUES (2, 101, 7, 0);
INSERT INTO `tag` VALUES (3, 101, 8, 0);
INSERT INTO `tag` VALUES (4, 101, 9, 0);
INSERT INTO `tag` VALUES (5, 101, 10, 0);
INSERT INTO `tag` VALUES (6, 101, 11, 0);
INSERT INTO `tag` VALUES (7, 101, 12, 0);
INSERT INTO `tag` VALUES (8, 101, 13, 0);
INSERT INTO `tag` VALUES (9, 103, 13, 0);
INSERT INTO `tag` VALUES (10, 101, 14, 1);
INSERT INTO `tag` VALUES (11, 103, 14, 1);
INSERT INTO `tag` VALUES (12, 101, 14, 0);
INSERT INTO `tag` VALUES (13, 103, 14, 0);
INSERT INTO `tag` VALUES (14, 101, 15, 0);
INSERT INTO `tag` VALUES (15, 103, 15, 0);
INSERT INTO `tag` VALUES (16, 101, 16, 0);
INSERT INTO `tag` VALUES (17, 103, 16, 0);
INSERT INTO `tag` VALUES (18, 101, 15, 1);
INSERT INTO `tag` VALUES (19, 103, 15, 1);
INSERT INTO `tag` VALUES (20, 101, 17, 0);
INSERT INTO `tag` VALUES (21, 103, 17, 0);
INSERT INTO `tag` VALUES (22, 104, 16, 1);
INSERT INTO `tag` VALUES (23, 104, 18, 0);
INSERT INTO `tag` VALUES (24, 104, 19, 0);
INSERT INTO `tag` VALUES (25, 104, 20, 0);
INSERT INTO `tag` VALUES (26, 104, 21, 0);
INSERT INTO `tag` VALUES (27, 103, 17, 1);
INSERT INTO `tag` VALUES (28, 104, 17, 1);
INSERT INTO `tag` VALUES (29, 101, 18, 1);
INSERT INTO `tag` VALUES (30, 101, 19, 1);
INSERT INTO `tag` VALUES (31, 104, 19, 1);
INSERT INTO `tag` VALUES (32, 103, 20, 1);
INSERT INTO `tag` VALUES (33, 101, 21, 1);
INSERT INTO `tag` VALUES (34, 103, 21, 1);
INSERT INTO `tag` VALUES (35, 103, 22, 1);
INSERT INTO `tag` VALUES (36, 103, 23, 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户id，自动增值',
  `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户密码',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户邮箱',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户头像，填相对地址',
  `role` int(0) NOT NULL DEFAULT 2 COMMENT '用户权限，0超级管理员，1管理员，2普通用户',
  `enable` int(0) NOT NULL COMMENT '是否未被封禁，0否，1是',
  `creation_time` datetime(0) NOT NULL COMMENT '记录创建时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '1556393081', '0CF5D3C34145110C2C709D7D6CDB5CF0', '1556393081@qq.com', NULL, NULL, 2, 1, '2020-12-05 20:57:56');
INSERT INTO `user` VALUES (2, '757738398', '0CF5D3C34145110C2C709D7D6CDB5CF0', '757738398@qq.com', NULL, NULL, 2, 1, '2020-12-09 21:08:08');

SET FOREIGN_KEY_CHECKS = 1;
