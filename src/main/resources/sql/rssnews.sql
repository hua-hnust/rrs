/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : rssnews

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 18/03/2019 15:14:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for rss_news
-- ----------------------------
DROP TABLE IF EXISTS `rss_news`;
CREATE TABLE `rss_news`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `source_id` int(11) NULL DEFAULT NULL COMMENT '来源',
  `type_id` int(11) NULL DEFAULT NULL COMMENT '分类',
  `title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `author` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者',
  `published_date` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布时间',
  `link` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详情链接',
  `content` mediumtext CHARACTER SET utf16le COLLATE utf16le_general_ci NULL COMMENT '内容',
  `get_time` bigint(16) NULL DEFAULT NULL COMMENT '入库时间',
  `get_url` int(8) NULL DEFAULT NULL COMMENT 'rss链接',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `source_id`(`source_id`) USING BTREE,
  INDEX `type_id`(`type_id`) USING BTREE,
  INDEX `get_url`(`get_url`) USING BTREE,
  CONSTRAINT `rss_news_ibfk_1` FOREIGN KEY (`source_id`) REFERENCES `rss_source` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `rss_news_ibfk_2` FOREIGN KEY (`type_id`) REFERENCES `rss_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `rss_news_ibfk_3` FOREIGN KEY (`get_url`) REFERENCES `rss_xml` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2161 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '新闻表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for rss_source
-- ----------------------------
DROP TABLE IF EXISTS `rss_source`;
CREATE TABLE `rss_source`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `describe` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '新闻来源' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rss_source
-- ----------------------------
INSERT INTO `rss_source` VALUES (1, '人民网');

-- ----------------------------
-- Table structure for rss_type
-- ----------------------------
DROP TABLE IF EXISTS `rss_type`;
CREATE TABLE `rss_type`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `source_id` int(8) NULL DEFAULT NULL COMMENT '来源',
  `type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `source_id`(`source_id`) USING BTREE,
  CONSTRAINT `rss_type_ibfk_1` FOREIGN KEY (`source_id`) REFERENCES `rss_source` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '新闻类型' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rss_type
-- ----------------------------
INSERT INTO `rss_type` VALUES (1, 1, '国内');
INSERT INTO `rss_type` VALUES (2, 1, '国际');
INSERT INTO `rss_type` VALUES (3, 1, '经济');
INSERT INTO `rss_type` VALUES (4, 1, '体育');
INSERT INTO `rss_type` VALUES (5, 1, '教育');
INSERT INTO `rss_type` VALUES (6, 1, '生活');
INSERT INTO `rss_type` VALUES (7, 1, '汽车');
INSERT INTO `rss_type` VALUES (8, 1, '游戏');

-- ----------------------------
-- Table structure for rss_xml
-- ----------------------------
DROP TABLE IF EXISTS `rss_xml`;
CREATE TABLE `rss_xml`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `source_id` int(8) NULL DEFAULT NULL COMMENT '来源',
  `type_id` int(8) NULL DEFAULT NULL COMMENT '类型',
  `rss_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'url',
  `rss_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `source_id`(`source_id`) USING BTREE,
  INDEX `type_id`(`type_id`) USING BTREE,
  CONSTRAINT `rss_xml_ibfk_1` FOREIGN KEY (`source_id`) REFERENCES `rss_source` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `rss_xml_ibfk_2` FOREIGN KEY (`type_id`) REFERENCES `rss_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '新闻RSS链接' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rss_xml
-- ----------------------------
INSERT INTO `rss_xml` VALUES (2, 1, 2, 'http://www.people.com.cn/rss/world.xml', '人民网-国际新闻');
INSERT INTO `rss_xml` VALUES (3, 1, 3, 'http://www.people.com.cn/rss/finance.xml', '人民网-经济新闻');
INSERT INTO `rss_xml` VALUES (4, 1, 4, 'http://www.people.com.cn/rss/sports.xml', '人民网-体育新闻');
INSERT INTO `rss_xml` VALUES (7, 1, 7, 'http://www.people.com.cn/rss/auto.xml', '人民网-汽车新闻');
INSERT INTO `rss_xml` VALUES (8, 1, 8, 'http://www.people.com.cn/rss/game.xml', '人民网-游戏新闻');

SET FOREIGN_KEY_CHECKS = 1;
