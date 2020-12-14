/*
 Navicat Premium Data Transfer

 Source Server         : 47.112.217.206_3306
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : 47.112.217.206:3306
 Source Schema         : pic_db

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 14/12/2020 21:25:34
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
  `creation_time` datetime(0) NOT NULL COMMENT '记录创建时间',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 107 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (101, '美女', 'images/2020/12/11/thumbnail/46eb97e778.jpg', '2020-12-08 15:53:06');
INSERT INTO `category` VALUES (103, '二次元', 'images/2020/12/11/thumbnail/36a359f6f7.jpg', '2020-12-08 15:52:58');
INSERT INTO `category` VALUES (104, '原神', 'images/2020/12/11/thumbnail/36a359f6f7.jpg', '2020-11-19 22:15:12');
INSERT INTO `category` VALUES (105, '帅男', 'images/2020/12/11/thumbnail/51872754d8.jpg', '2020-12-11 14:06:31');
INSERT INTO `category` VALUES (106, '广青', 'images/2020/12/14/thumbnail/39ce102508.jpg', '2020-12-11 14:06:44');

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect`  (
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `oject_id` int(11) NOT NULL COMMENT '图片或图集ID',
  `object_type` int(11) NOT NULL COMMENT '收藏对象类型，1图片，2图集',
  `is_cancel` int(11) NOT NULL COMMENT '是否取消收藏，0否，1是',
  `creation_time` datetime(0) NOT NULL COMMENT '记录创建时间'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES (101, 100026, 1, 0, '2020-12-14 15:14:41');

-- ----------------------------
-- Table structure for pic_list
-- ----------------------------
DROP TABLE IF EXISTS `pic_list`;
CREATE TABLE `pic_list`  (
  `pic_list_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图集id，自动增值',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `pic_list_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '图集名称',
  `intro` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '图集简介',
  `collect_num` int(11) NOT NULL DEFAULT 0 COMMENT '收藏数',
  `heat` int(11) NOT NULL COMMENT '热度',
  `enable` int(11) NOT NULL COMMENT '是否未被封禁，0否，1是',
  `creation_time` datetime(0) NOT NULL COMMENT '记录创建时间',
  PRIMARY KEY (`pic_list_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10005 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pic_list
-- ----------------------------
INSERT INTO `pic_list` VALUES (10001, 101, '嘤嘤嘤（1）', '', 0, 0, 0, '2020-12-11 15:22:14');
INSERT INTO `pic_list` VALUES (10002, 101, '原神（1）', '', 0, 1, 0, '2020-12-11 16:11:10');
INSERT INTO `pic_list` VALUES (10003, 101, '电脑壁纸', '', 0, 0, 0, '2020-12-11 16:13:41');
INSERT INTO `pic_list` VALUES (10004, 101, '永远的班长', 'ddddd', 0, 2, 0, '2020-12-11 19:35:18');

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture`  (
  `picture_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图片id，自动增值',
  `pic_list_id` int(11) NOT NULL COMMENT '外键图集ID',
  `user_id` int(11) NOT NULL COMMENT '外键用户ID',
  `thumbnail_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '缩略图相对地址',
  `od_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '原图相对地址',
  `praise_num` int(11) NOT NULL DEFAULT 0 COMMENT '点赞数',
  `collect_num` int(11) NOT NULL DEFAULT 0 COMMENT '收藏数',
  `enable` int(11) NOT NULL COMMENT '是否未被封禁，0否，1是',
  `creation_time` datetime(0) NOT NULL COMMENT '记录创建时间',
  `heat` int(11) NOT NULL COMMENT '热度',
  PRIMARY KEY (`picture_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100027 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of picture
-- ----------------------------
INSERT INTO `picture` VALUES (100001, 10001, 101, 'images/2020/12/11/thumbnail/757e5fd578.jpg', 'images/2020/12/11/original/757e5fd578.jpg', 0, 0, 0, '2020-12-11 15:58:35', 0);
INSERT INTO `picture` VALUES (100002, 10001, 101, 'images/2020/12/11/thumbnail/46eb97e778.jpg', 'images/2020/12/11/original/46eb97e778.jpg', 0, 0, 0, '2020-12-11 15:58:35', 0);
INSERT INTO `picture` VALUES (100003, 10001, 101, 'images/2020/12/11/thumbnail/993c2a4b06.jpg', 'images/2020/12/11/original/993c2a4b06.jpg', 0, 0, 0, '2020-12-11 15:58:36', 0);
INSERT INTO `picture` VALUES (100004, 10001, 101, 'images/2020/12/11/thumbnail/f6120a8c82.jpg', 'images/2020/12/11/original/f6120a8c82.jpg', 0, 0, 0, '2020-12-11 15:58:37', 0);
INSERT INTO `picture` VALUES (100005, 10001, 101, 'images/2020/12/11/thumbnail/baab4e953e.jpg', 'images/2020/12/11/original/baab4e953e.jpg', 0, 0, 0, '2020-12-11 15:58:38', 0);
INSERT INTO `picture` VALUES (100006, 10001, 101, 'images/2020/12/11/thumbnail/0f16327094.jpg', 'images/2020/12/11/original/0f16327094.jpg', 0, 0, 0, '2020-12-11 15:58:38', 0);
INSERT INTO `picture` VALUES (100007, 10001, 101, 'images/2020/12/11/thumbnail/597f1ceead.jpg', 'images/2020/12/11/original/597f1ceead.jpg', 0, 0, 0, '2020-12-11 15:58:39', 0);
INSERT INTO `picture` VALUES (100008, 10001, 101, 'images/2020/12/11/thumbnail/08ef153705.jpg', 'images/2020/12/11/original/08ef153705.jpg', 0, 0, 0, '2020-12-11 15:58:40', 0);
INSERT INTO `picture` VALUES (100009, 10002, 101, 'images/2020/12/11/thumbnail/36a359f6f7.jpg', 'images/2020/12/11/original/36a359f6f7.jpeg', 1, 0, 0, '2020-12-11 16:12:04', 1);
INSERT INTO `picture` VALUES (100010, 10002, 101, 'images/2020/12/11/thumbnail/dbcaba8715.jpg', 'images/2020/12/11/original/dbcaba8715.jpeg', 0, 0, 0, '2020-12-11 16:12:06', 0);
INSERT INTO `picture` VALUES (100011, 10002, 101, 'images/2020/12/11/thumbnail/d627d5afbf.jpg', 'images/2020/12/11/original/d627d5afbf.jpeg', 0, 0, 0, '2020-12-11 16:12:08', 0);
INSERT INTO `picture` VALUES (100012, 10002, 101, 'images/2020/12/11/thumbnail/2541cdd0f1.jpg', 'images/2020/12/11/original/2541cdd0f1.jpeg', 0, 0, 0, '2020-12-11 16:12:09', 0);
INSERT INTO `picture` VALUES (100013, 10002, 101, 'images/2020/12/11/thumbnail/6f28b96a60.jpg', 'images/2020/12/11/original/6f28b96a60.jpeg', 0, 0, 0, '2020-12-11 16:12:10', 0);
INSERT INTO `picture` VALUES (100014, 10003, 101, 'images/2020/12/11/thumbnail/639e3f6674.jpg', 'images/2020/12/11/original/639e3f6674.jpg', 0, 0, 0, '2020-12-11 16:13:57', 0);
INSERT INTO `picture` VALUES (100015, 10003, 101, 'images/2020/12/11/thumbnail/617c885c5b.jpg', 'images/2020/12/11/original/617c885c5b.jpg', 0, 0, 0, '2020-12-11 16:14:00', 0);
INSERT INTO `picture` VALUES (100016, 10003, 101, 'images/2020/12/11/thumbnail/d0526ebc35.jpg', 'images/2020/12/11/original/d0526ebc35.png', 0, 0, 0, '2020-12-11 16:14:14', 0);
INSERT INTO `picture` VALUES (100017, 10003, 101, 'images/2020/12/11/thumbnail/0994cbb35f.jpg', 'images/2020/12/11/original/0994cbb35f.jpg', 0, 0, 0, '2020-12-11 16:14:20', 0);
INSERT INTO `picture` VALUES (100018, 10003, 101, 'images/2020/12/11/thumbnail/6ea4480600.jpg', 'images/2020/12/11/original/6ea4480600.jpg', 0, 0, 0, '2020-12-11 16:14:25', 0);
INSERT INTO `picture` VALUES (100019, 0, 101, 'images/2020/12/11/thumbnail/2c72c93a55.jpg', 'images/2020/12/11/original/2c72c93a55.jpg', 0, 0, 0, '2020-12-11 16:17:43', 0);
INSERT INTO `picture` VALUES (100020, 0, 101, 'images/2020/12/11/thumbnail/d23044d3e4.jpg', 'images/2020/12/11/original/d23044d3e4.jpg', 0, 0, 0, '2020-12-11 16:17:52', 0);
INSERT INTO `picture` VALUES (100021, 10004, 101, 'images/2020/12/11/thumbnail/83e44b6fb5.jpg', 'images/2020/12/11/original/83e44b6fb5.jpg', 0, 0, 0, '2020-12-11 19:35:43', 0);
INSERT INTO `picture` VALUES (100022, 10004, 101, 'images/2020/12/11/thumbnail/51872754d8.jpg', 'images/2020/12/11/original/51872754d8.png', 1, 0, 0, '2020-12-11 19:35:44', 1);
INSERT INTO `picture` VALUES (100023, 10004, 101, 'images/2020/12/11/thumbnail/5aa9334cd1.jpg', 'images/2020/12/11/original/5aa9334cd1.png', 1, 0, 0, '2020-12-11 19:35:44', 1);
INSERT INTO `picture` VALUES (100024, 10004, 101, 'images/2020/12/11/thumbnail/8bfe530e76.jpg', 'images/2020/12/11/original/8bfe530e76.jpg', 0, 0, 0, '2020-12-11 19:35:44', 0);
INSERT INTO `picture` VALUES (100025, 10004, 101, 'images/2020/12/11/thumbnail/64fd77fb61.jpg', 'images/2020/12/11/original/64fd77fb61.jpg', 0, 0, 0, '2020-12-11 19:35:44', 0);
INSERT INTO `picture` VALUES (100026, 0, 101, 'images/2020/12/14/thumbnail/39ce102508.jpg', 'images/2020/12/14/original/39ce102508.jpg', 0, 1, 0, '2020-12-14 15:14:16', 5);

-- ----------------------------
-- Table structure for praise
-- ----------------------------
DROP TABLE IF EXISTS `praise`;
CREATE TABLE `praise`  (
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `picture_id` int(11) NOT NULL COMMENT '	图片ID',
  `is_cancel` int(11) NOT NULL COMMENT '是否取消收藏，0否，1是',
  `creation_time` datetime(0) NOT NULL COMMENT '	记录创建时间'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of praise
-- ----------------------------
INSERT INTO `praise` VALUES (101, 100008, 1, '2020-12-11 16:04:15');
INSERT INTO `praise` VALUES (101, 100021, 1, '2020-12-11 19:35:55');
INSERT INTO `praise` VALUES (101, 100022, 0, '2020-12-11 19:35:59');
INSERT INTO `praise` VALUES (101, 100023, 0, '2020-12-11 19:36:01');
INSERT INTO `praise` VALUES (101, 100024, 1, '2020-12-11 19:36:04');
INSERT INTO `praise` VALUES (101, 100025, 1, '2020-12-11 19:36:06');
INSERT INTO `praise` VALUES (101, 100009, 0, '2020-12-11 19:37:23');

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `category_id` int(11) NOT NULL COMMENT '分类id',
  `object_id` int(11) NOT NULL COMMENT '对象id',
  `object_type` int(11) NOT NULL COMMENT '对象类型，0图片，1图包',
  PRIMARY KEY (`tag_id`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE,
  CONSTRAINT `tag_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES (1, 101, 10001, 1);
INSERT INTO `tag` VALUES (2, 101, 100001, 0);
INSERT INTO `tag` VALUES (3, 101, 100002, 0);
INSERT INTO `tag` VALUES (4, 101, 100003, 0);
INSERT INTO `tag` VALUES (5, 101, 100004, 0);
INSERT INTO `tag` VALUES (6, 101, 100005, 0);
INSERT INTO `tag` VALUES (7, 101, 100006, 0);
INSERT INTO `tag` VALUES (8, 101, 100007, 0);
INSERT INTO `tag` VALUES (9, 101, 100008, 0);
INSERT INTO `tag` VALUES (10, 103, 10002, 1);
INSERT INTO `tag` VALUES (11, 104, 10002, 1);
INSERT INTO `tag` VALUES (12, 103, 100009, 0);
INSERT INTO `tag` VALUES (13, 104, 100009, 0);
INSERT INTO `tag` VALUES (14, 103, 100010, 0);
INSERT INTO `tag` VALUES (15, 104, 100010, 0);
INSERT INTO `tag` VALUES (16, 103, 100011, 0);
INSERT INTO `tag` VALUES (17, 104, 100011, 0);
INSERT INTO `tag` VALUES (18, 103, 100012, 0);
INSERT INTO `tag` VALUES (19, 104, 100012, 0);
INSERT INTO `tag` VALUES (20, 103, 100013, 0);
INSERT INTO `tag` VALUES (21, 104, 100013, 0);
INSERT INTO `tag` VALUES (22, 101, 10003, 1);
INSERT INTO `tag` VALUES (23, 103, 10003, 1);
INSERT INTO `tag` VALUES (24, 101, 100014, 0);
INSERT INTO `tag` VALUES (25, 103, 100014, 0);
INSERT INTO `tag` VALUES (26, 101, 100015, 0);
INSERT INTO `tag` VALUES (27, 103, 100015, 0);
INSERT INTO `tag` VALUES (28, 101, 100016, 0);
INSERT INTO `tag` VALUES (29, 103, 100016, 0);
INSERT INTO `tag` VALUES (30, 101, 100017, 0);
INSERT INTO `tag` VALUES (31, 103, 100017, 0);
INSERT INTO `tag` VALUES (32, 101, 100018, 0);
INSERT INTO `tag` VALUES (33, 103, 100018, 0);
INSERT INTO `tag` VALUES (34, 101, 100019, 0);
INSERT INTO `tag` VALUES (35, 101, 100020, 0);
INSERT INTO `tag` VALUES (36, 105, 10004, 1);
INSERT INTO `tag` VALUES (37, 106, 10004, 1);
INSERT INTO `tag` VALUES (38, 105, 100021, 0);
INSERT INTO `tag` VALUES (39, 106, 100021, 0);
INSERT INTO `tag` VALUES (40, 105, 100022, 0);
INSERT INTO `tag` VALUES (41, 106, 100022, 0);
INSERT INTO `tag` VALUES (42, 105, 100023, 0);
INSERT INTO `tag` VALUES (43, 106, 100023, 0);
INSERT INTO `tag` VALUES (44, 105, 100024, 0);
INSERT INTO `tag` VALUES (45, 106, 100024, 0);
INSERT INTO `tag` VALUES (46, 105, 100025, 0);
INSERT INTO `tag` VALUES (47, 106, 100025, 0);
INSERT INTO `tag` VALUES (48, 106, 100026, 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id，自动增值',
  `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户密码',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户邮箱',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户头像，填相对地址',
  `role` int(11) NOT NULL DEFAULT 2 COMMENT '用户权限，0超级管理员，1管理员，2普通用户',
  `enable` int(11) NOT NULL COMMENT '是否未被封禁，0否，1是',
  `creation_time` datetime(0) NOT NULL COMMENT '记录创建时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 103 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (101, '1556393081', '0CF5D3C34145110C2C709D7D6CDB5CF0', '1556393081@qq.com', NULL, NULL, 0, 1, '2020-12-05 20:57:56');
INSERT INTO `user` VALUES (102, '757738398', '0CF5D3C34145110C2C709D7D6CDB5CF0', '757738398@qq.com', NULL, NULL, 1, 1, '2020-12-09 21:08:08');

SET FOREIGN_KEY_CHECKS = 1;
