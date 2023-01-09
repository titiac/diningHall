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

 Date: 09/01/2023 13:53:18
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
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of dish
-- ----------------------------
INSERT INTO `dish` VALUES (1, '4', '草鱼，花椒', '水煮活鱼', 'https://cdn.acwing.com/media/article/image/2022/12/09/87795_ae1e462f77-%E9%B1%BC%E7%B1%BB%E5%9B%BE%E7%89%87.jpg', 10.5);
INSERT INTO `dish` VALUES (2, '2', '牛肉, 土豆, 黑椒', '黑椒牛肉粒', 'https://cdn.acwing.com/media/article/image/2022/12/09/87795_7601e11877-%E9%BB%91%E6%A4%92%E7%89%9B%E8%82%89%E7%B2%92.jpg', 7);
INSERT INTO `dish` VALUES (3, '1', '青椒, 猪肉', '青椒肉丝', 'https://cdn.acwing.com/media/article/image/2022/12/09/87795_80b8d18077-%E9%9D%92%E6%A4%92%E8%82%89%E4%B8%9D.jpg', 7);
INSERT INTO `dish` VALUES (4, '3', '孜然, 羊肉', '孜然羊肉', 'https://cdn.acwing.com/media/article/image/2022/12/09/87795_863b1e5a77-%E5%AD%9C%E7%84%B6%E7%BE%8A%E8%82%89.jpg', 7);
INSERT INTO `dish` VALUES (5, '5', '花椒, 豆腐', '麻婆豆腐', 'https://cdn.acwing.com/media/article/image/2022/12/09/87795_7ab404b377-%E9%BA%BB%E5%A9%86%E8%B1%86%E8%85%90.jpg ', 3);
INSERT INTO `dish` VALUES (6, '6', '上海青', '清炒上海青', 'https://cdn.acwing.com/media/article/image/2022/12/09/87795_805ddc3477-%E6%B8%85%E7%82%92%E4%B8%8A%E6%B5%B7%E9%9D%92.jpg', 3);
INSERT INTO `dish` VALUES (7, '7', '西红柿,鸡蛋', '西红柿炒鸡蛋', 'https://cdn.acwing.com/media/article/image/2022/12/09/87795_94574e4177-%E8%A5%BF%E7%BA%A2%E6%9F%BF%E7%82%92%E9%B8%A1%E8%9B%8B.jpg', 3);
INSERT INTO `dish` VALUES (8, '8', '五常大米', '米饭', 'https://cdn.acwing.com/media/article/image/2022/12/09/87795_7f2f6df477-%E7%B1%B3%E9%A5%AD.jpg', 2);
INSERT INTO `dish` VALUES (18, '8', '上海青，鸡蛋，挂面', '青菜鸡蛋面', 'https://cdn.acwing.com/media/article/image/2022/12/17/87795_869bfb6c7d-%E9%9D%92%E8%8F%9C%E9%B8%A1%E8%9B%8B%E9%9D%A2.jpg', 8);
INSERT INTO `dish` VALUES (19, '5', '豆腐，白芝麻', '脆豆腐', 'https://cdn.acwing.com/media/article/image/2022/12/17/87795_7ee48e3b7d-%E8%84%86%E8%B1%86%E8%85%90.jpg', 3);
INSERT INTO `dish` VALUES (20, '8', '火腿，五常大米', '火腿炒饭', 'https://cdn.acwing.com/media/article/image/2022/12/17/87795_96e0ad2e7d-%E7%83%A9%E9%A5%AD.jpg', 8);
INSERT INTO `dish` VALUES (21, '7', '火腿，鸡蛋', '火腿炒鸡蛋', 'https://cdn.acwing.com/media/article/image/2022/12/17/87795_9bf5454a7d-%E7%81%AB%E8%85%BF%E7%82%92%E9%B8%A1%E8%9B%8B.jpg', 5);
INSERT INTO `dish` VALUES (22, '5', '黄豆，水', '豆浆', 'https://cdn.acwing.com/media/article/image/2022/12/17/87795_b5469c027d-%E8%B1%86%E6%B5%86.jpg', 2);
INSERT INTO `dish` VALUES (23, '8', '香菇，猪肉，面粉', '香菇猪肉包', 'https://cdn.acwing.com/media/article/image/2022/12/17/87795_c72829217d-%E9%A6%99%E8%8F%87%E8%82%89%E5%8C%85.jpg', 1.5);
INSERT INTO `dish` VALUES (24, '8', '五常大米，猪肉，面粉', '肉丁烧卖', 'https://cdn.acwing.com/media/article/image/2022/12/17/87795_c1cbaf867d-%E7%83%A7%E5%8D%96.jpg', 1.5);
INSERT INTO `dish` VALUES (25, '7', '茶叶，蛋', '茶叶蛋', 'https://cdn.acwing.com/media/article/image/2022/12/17/87795_ee58f3737d-%E8%8C%B6%E5%8F%B6%E8%9B%8B.jpg', 1.5);
INSERT INTO `dish` VALUES (26, '6', '花菜', '清炒花菜', 'https://cdn.acwing.com/media/article/image/2022/12/17/87795_f431f37d7d-%E6%B8%85%E7%82%92%E8%8A%B1%E8%8F%9C.jpg', 3);
INSERT INTO `dish` VALUES (27, '6', '土豆', '清炒土豆丝', 'https://cdn.acwing.com/media/article/image/2022/12/17/87795_faba444a7d-%E6%B8%85%E7%82%92%E5%9C%9F%E8%B1%86%E4%B8%9D.jpg', 3);
INSERT INTO `dish` VALUES (28, '6', '包菜，猪肉，花椒', '干锅包菜', 'https://cdn.acwing.com/media/article/image/2022/12/17/87795_0b57e6a37d-%E5%B9%B2%E9%94%85%E5%8C%85%E8%8F%9C.jpg', 3);
INSERT INTO `dish` VALUES (29, '1', '猪肉', '红烧肉', 'https://cdn.acwing.com/media/article/image/2022/12/17/87795_e78b46247d-%E7%BA%A2%E7%83%A7%E8%82%89.jpg', 7);
INSERT INTO `dish` VALUES (30, '1', '蒜苔，猪肉', '蒜苔炒肉', 'https://cdn.acwing.com/media/article/image/2022/12/17/87795_de6b0c457d-%E8%92%9C%E8%8B%94%E7%82%92%E8%82%89.jpg', 7);
INSERT INTO `dish` VALUES (31, '1', '孜然，猪肉', '孜然肉粒', 'https://cdn.acwing.com/media/article/image/2022/12/17/87795_d9a8dba07d-%E5%AD%9C%E7%84%B6%E8%82%89%E7%B2%92.jpg', 7);
INSERT INTO `dish` VALUES (32, '2', '土豆，牛肉', '土豆牛肉煲', 'https://cdn.acwing.com/media/article/image/2022/12/17/87795_d67b0fa27d-%E5%9C%9F%E8%B1%86%E7%89%9B%E8%85%A9%E7%85%B2.jpg', 7);
INSERT INTO `dish` VALUES (33, '2', '绿豆芽，牛肚', '豆芽烧牛肚', 'https://cdn.acwing.com/media/article/image/2022/12/17/87795_cc9d1c5e7d-%E8%B1%86%E8%8A%BD%E7%83%A7%E7%89%9B%E8%82%9A.jpg', 8);
INSERT INTO `dish` VALUES (34, '1', '猪小排，萝卜', '萝卜排骨汤', 'https://cdn.acwing.com/media/article/image/2022/12/17/87795_bda161de7d-%E8%90%9D%E5%8D%9C%E6%8E%92%E9%AA%A8%E6%B1%A4.jpg', 6);
INSERT INTO `dish` VALUES (35, '3', '羊肉，萝卜', '滋补羊肉汤', 'https://cdn.acwing.com/media/article/image/2022/12/17/87795_cc2e94c47d-%E6%BB%8B%E8%A1%A5%E7%BE%8A%E8%82%89%E6%B1%A4.jpg', 7);
INSERT INTO `dish` VALUES (36, '3', '羊肉，花椒', '羊肉煲', 'https://cdn.acwing.com/media/article/image/2022/12/17/87795_d0c601577d-%E7%BE%8A%E8%82%89%E7%85%B2.jpg', 8);
INSERT INTO `dish` VALUES (37, '4', '鱼，大蒜', '蒜香鱼片', 'https://cdn.acwing.com/media/article/image/2022/12/17/87795_9bf7ee697d-%E8%92%9C%E9%A6%99%E9%B1%BC%E7%89%87.jpg', 8);
INSERT INTO `dish` VALUES (38, '4', '鱼', '红烧鱼', 'https://cdn.acwing.com/media/article/image/2022/12/17/87795_943de4b17d-%E7%BA%A2%E7%83%A7%E9%B1%BC.jpg', 8);
INSERT INTO `dish` VALUES (39, '4', '蛏子', '葱油蛏子', 'https://cdn.acwing.com/media/article/image/2022/12/17/87795_1af2d81e7d-%E8%91%B1%E6%B2%B9%E8%9B%8F%E5%AD%90.jpg', 7);
INSERT INTO `dish` VALUES (40, '4', '花蛤，花椒', '爆炒花蛤', 'https://cdn.acwing.com/media/article/image/2022/12/17/87795_1fb7f2e47d-%E7%88%86%E7%82%92%E8%8A%B1%E8%9B%A4.jpg', 7);

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
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of fzu_order
-- ----------------------------
INSERT INTO `fzu_order` VALUES (2, 'OO2212092301000541', 2, 1, 1, 3, 19.5, '2022-12-09 01:01:00', '2022-12-11 11:33:22', '2022-12-11 12:35:46');
INSERT INTO `fzu_order` VALUES (3, 'OO2212102339189930', 2, 1, 2, 3, 10.5, '2022-12-11 23:39:19', '2022-12-19 17:12:10', '2022-12-19 17:12:13');
INSERT INTO `fzu_order` VALUES (4, 'OO2212111810319195', 2, 1, 3, 3, 12.5, '2022-12-11 13:10:32', '2022-12-15 15:45:34', '2022-12-15 16:53:14');
INSERT INTO `fzu_order` VALUES (6, 'OO2212191717314715', 3, 1, 3, 3, 21.5, '2022-12-19 17:17:31', '2022-12-19 17:41:24', '2022-12-19 17:41:40');
INSERT INTO `fzu_order` VALUES (7, 'OO2212191717387423', 2, 1, 7, 3, 18.5, '2022-12-19 17:17:39', '2023-01-07 15:01:25', '2023-01-07 15:01:27');

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
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单详情表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES (1, 2, 1, 1);
INSERT INTO `order_detail` VALUES (2, 2, 2, 1);
INSERT INTO `order_detail` VALUES (3, 2, 8, 1);
INSERT INTO `order_detail` VALUES (4, 3, 1, 1);
INSERT INTO `order_detail` VALUES (5, 4, 1, 1);
INSERT INTO `order_detail` VALUES (6, 4, 8, 1);
INSERT INTO `order_detail` VALUES (8, 6, 4, 1);
INSERT INTO `order_detail` VALUES (9, 6, 36, 1);
INSERT INTO `order_detail` VALUES (10, 6, 7, 1);
INSERT INTO `order_detail` VALUES (11, 6, 25, 1);
INSERT INTO `order_detail` VALUES (12, 6, 8, 1);
INSERT INTO `order_detail` VALUES (13, 7, 1, 1);
INSERT INTO `order_detail` VALUES (14, 7, 5, 1);
INSERT INTO `order_detail` VALUES (15, 7, 19, 1);
INSERT INTO `order_detail` VALUES (16, 7, 22, 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '$2a$10$gkL6zwl27EE//54AsyFVCO08AOIQ.2oWE334c/Kvl7kKlcvIBAeqO', 95, 0);
INSERT INTO `user` VALUES (2, 'customer', '$2a$10$VWSDNrnmB52BEYJRNFFL5.iQ/uFNyjxpT2ht1McIJCuBNLZw.7Xfa', 95, 1);
INSERT INTO `user` VALUES (3, 'test', '$2a$10$JHcrOc6yHseMyLcRjiVqDeTbgOlwk21DzNPSxVFArPntQpNlpM5rO', 78.5, 1);

SET FOREIGN_KEY_CHECKS = 1;
