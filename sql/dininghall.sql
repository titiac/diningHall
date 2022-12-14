/*
 Navicat Premium Data Transfer

 Source Server         : MySQL80
 Source Server Type    : MySQL
 Source Server Version : 80030 (8.0.30)
 Source Host           : localhost:3306
 Source Schema         : dininghall

 Target Server Type    : MySQL
 Target Server Version : 80030 (8.0.30)
 File Encoding         : 65001

 Date: 12/12/2022 13:36:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dish
-- ----------------------------
DROP TABLE IF EXISTS `dish`;
CREATE TABLE `dish`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `ingredient` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `photo` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` double NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dish
-- ----------------------------
INSERT INTO `dish` VALUES (1, '4', '草鱼, 花椒, 豆腐, 豆瓣酱', '水煮活鱼', 'https://www.shutterstock.com/shutterstock/photos/1910030092/display_1500/stock-photo-fish-curry-seer-fish-curry-traditional-indian-fish-curry-kerala-special-dish-using-coconut-1910030092.jpg', 10.5);
INSERT INTO `dish` VALUES (2, '2', '牛肉, 土豆, 黑椒', '黑椒牛肉粒', 'https://cdn.acwing.com/media/article/image/2022/12/09/87795_7601e11877-%E9%BB%91%E6%A4%92%E7%89%9B%E8%82%89%E7%B2%92.jpg', 7);
INSERT INTO `dish` VALUES (3, '1', '青椒, 猪肉', '青椒肉丝', 'https://cdn.acwing.com/media/article/image/2022/12/09/87795_80b8d18077-%E9%9D%92%E6%A4%92%E8%82%89%E4%B8%9D.jpg', 7);
INSERT INTO `dish` VALUES (4, '3', '孜然, 羊肉', '孜然羊肉', 'https://cdn.acwing.com/media/article/image/2022/12/09/87795_863b1e5a77-%E5%AD%9C%E7%84%B6%E7%BE%8A%E8%82%89.jpg', 7);
INSERT INTO `dish` VALUES (5, '5', '花椒, 豆腐', '麻婆豆腐', 'https://cdn.acwing.com/media/article/image/2022/12/09/87795_7ab404b377-%E9%BA%BB%E5%A9%86%E8%B1%86%E8%85%90.jpg ', 3);
INSERT INTO `dish` VALUES (6, '6', '上海青', '清炒上海青', 'https://cdn.acwing.com/media/article/image/2022/12/09/87795_805ddc3477-%E6%B8%85%E7%82%92%E4%B8%8A%E6%B5%B7%E9%9D%92.jpg', 3);
INSERT INTO `dish` VALUES (7, '7', '西红柿,鸡蛋', '西红柿炒鸡蛋', 'https://cdn.acwing.com/media/article/image/2022/12/09/87795_94574e4177-%E8%A5%BF%E7%BA%A2%E6%9F%BF%E7%82%92%E9%B8%A1%E8%9B%8B.jpg', 3);
INSERT INTO `dish` VALUES (8, '8', '五常大米', '米饭', 'https://cdn.acwing.com/media/article/image/2022/12/09/87795_7f2f6df477-%E7%B1%B3%E9%A5%AD.jpg', 2);

-- ----------------------------
-- Table structure for fzu_order
-- ----------------------------
DROP TABLE IF EXISTS `fzu_order`;
CREATE TABLE `fzu_order`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_no` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `diner_id` int NULL DEFAULT NULL,
  `staff_id` int NULL DEFAULT NULL,
  `seat_id` int NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `total` double NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `start_time` datetime NULL DEFAULT NULL,
  `finish_time` datetime NULL DEFAULT NULL,
  UNIQUE INDEX `id`(`id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fzu_order
-- ----------------------------
INSERT INTO `fzu_order` VALUES (2, 'OO2212092301000541', 2, 1, 1, 3, 19.5, '2022-12-09 01:01:00', '2022-12-11 11:33:22', '2022-12-11 12:35:46');
INSERT INTO `fzu_order` VALUES (3, 'OO2212102339189930', 2, NULL, 2, 1, 10.5, '2022-12-11 23:39:19', NULL, NULL);
INSERT INTO `fzu_order` VALUES (4, 'OO2212111810319195', 2, NULL, 3, 1, 12.5, '2022-12-11 13:10:32', NULL, NULL);

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NULL DEFAULT NULL COMMENT '对应订单表id',
  `dish_id` int NULL DEFAULT NULL COMMENT '菜品id',
  `num` int NULL DEFAULT NULL COMMENT '菜品数量',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单详情表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES (1, 2, 1, 1);
INSERT INTO `order_detail` VALUES (2, 2, 2, 1);
INSERT INTO `order_detail` VALUES (3, 2, 8, 1);
INSERT INTO `order_detail` VALUES (4, 3, 1, 1);
INSERT INTO `order_detail` VALUES (5, 4, 1, 1);
INSERT INTO `order_detail` VALUES (6, 4, 8, 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `balance` double NULL DEFAULT NULL,
  `type` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '$2a$10$gkL6zwl27EE//54AsyFVCO08AOIQ.2oWE334c/Kvl7kKlcvIBAeqO', 19.5, 0);
INSERT INTO `user` VALUES (2, 'customer', '$2a$10$VWSDNrnmB52BEYJRNFFL5.iQ/uFNyjxpT2ht1McIJCuBNLZw.7Xfa', 108, 1);

SET FOREIGN_KEY_CHECKS = 1;
