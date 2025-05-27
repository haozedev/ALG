-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        8.0.41 - MySQL Community Server - GPL
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  12.10.0.7000
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- 导出  表 test.categories 结构
CREATE TABLE IF NOT EXISTS `categories` (
  `category_id` int NOT NULL AUTO_INCREMENT COMMENT '类别唯一标识',
  `category_name` varchar(255) NOT NULL COMMENT '类别名称',
  `description` text COMMENT '类别描述',
  `created_at` datetime DEFAULT NULL COMMENT '类别创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '类别信息更新时间',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品类别表';

-- 正在导出表  test.categories 的数据：~4 rows (大约)
INSERT INTO `categories` (`category_id`, `category_name`, `description`, `created_at`, `updated_at`) VALUES
	(1, '沙发', '各种类型沙发', '2025-05-26 10:04:32', '2025-05-26 10:04:32'),
	(2, '餐桌', '各种餐桌', '2025-05-26 10:04:32', '2025-05-26 10:04:32'),
	(3, '衣柜', '各种衣柜', '2025-05-26 10:04:32', '2025-05-26 10:04:32'),
	(4, '书架', '各种书架', '2025-05-26 10:04:32', '2025-05-26 10:04:32');

-- 导出  表 test.coupons 结构
CREATE TABLE IF NOT EXISTS `coupons` (
  `coupon_id` int NOT NULL AUTO_INCREMENT COMMENT '优惠券唯一标识',
  `code` varchar(255) NOT NULL COMMENT '优惠券代码',
  `description` text COMMENT '优惠券描述',
  `discount_type` enum('percentage','fixed') NOT NULL COMMENT '优惠类型：百分比折扣或固定金额折扣',
  `discount_value` decimal(10,2) NOT NULL COMMENT '折扣值（百分比或固定金额）',
  `minimum_order_amount` decimal(10,2) DEFAULT NULL COMMENT '最低订单金额限制（可为空）',
  `valid_from` datetime DEFAULT NULL COMMENT '优惠券有效开始时间',
  `valid_to` datetime DEFAULT NULL COMMENT '优惠券有效结束时间',
  `usage_limit` int DEFAULT NULL COMMENT '优惠券使用次数限制（可为空）',
  `created_at` datetime DEFAULT NULL COMMENT '优惠券创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '优惠券信息更新时间',
  PRIMARY KEY (`coupon_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='优惠券表';

-- 正在导出表  test.coupons 的数据：~2 rows (大约)
INSERT INTO `coupons` (`coupon_id`, `code`, `description`, `discount_type`, `discount_value`, `minimum_order_amount`, `valid_from`, `valid_to`, `usage_limit`, `created_at`, `updated_at`) VALUES
	(1, 'FURN10', '家具10%折扣', 'percentage', 10.00, 1000.00, '2025-05-26 10:15:16', '2025-06-26 10:15:16', 1, '2025-05-26 10:15:16', '2025-05-26 10:15:16'),
	(2, 'FREE50', '满5000减500', 'fixed', 500.00, 5000.00, '2025-05-26 10:15:16', '2025-07-26 10:15:16', 1, '2025-05-26 10:15:16', '2025-05-26 10:15:16');

-- 导出  表 test.orders 结构
CREATE TABLE IF NOT EXISTS `orders` (
  `order_id` int NOT NULL AUTO_INCREMENT COMMENT '订单唯一标识',
  `user_id` int NOT NULL COMMENT '下单用户',
  `total_amount` decimal(10,2) NOT NULL COMMENT '订单总金额',
  `order_status` enum('pending','processing','shipped','delivered','cancelled') NOT NULL COMMENT '订单状态',
  `created_at` datetime DEFAULT NULL COMMENT '订单创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '订单信息更新时间',
  PRIMARY KEY (`order_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单表';

-- 正在导出表  test.orders 的数据：~3 rows (大约)
INSERT INTO `orders` (`order_id`, `user_id`, `total_amount`, `order_status`, `created_at`, `updated_at`) VALUES
	(1, 1, 4598.00, 'pending', '2025-05-26 10:21:09', '2025-05-26 10:21:09'),
	(2, 2, 3299.00, 'processing', '2025-05-26 10:21:09', '2025-05-26 10:21:09'),
	(3, 3, 918.00, 'shipped', '2025-05-26 10:21:09', '2025-05-26 10:21:09');

-- 导出  表 test.order_details 结构
CREATE TABLE IF NOT EXISTS `order_details` (
  `detail_id` int NOT NULL AUTO_INCREMENT COMMENT '订单详情唯一标识',
  `order_id` int NOT NULL COMMENT '关联的订单',
  `product_id` int NOT NULL COMMENT '商品',
  `quantity` int NOT NULL COMMENT '商品数量',
  `price` decimal(10,2) NOT NULL COMMENT '商品在订单中的价格（可能和商品表中的价格不同，用于记录下单时的价格）',
  `created_at` datetime DEFAULT NULL COMMENT '订单详情创建时间',
  PRIMARY KEY (`detail_id`),
  KEY `order_id` (`order_id`),
  KEY `product_id` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单详情表';

-- 正在导出表  test.order_details 的数据：~4 rows (大约)
INSERT INTO `order_details` (`detail_id`, `order_id`, `product_id`, `quantity`, `price`, `created_at`) VALUES
	(1, 1, 1, 1, 2999.00, '2025-05-26 10:21:22'),
	(2, 1, 2, 1, 1599.00, '2025-05-26 10:21:22'),
	(3, 2, 3, 1, 3299.00, '2025-05-26 10:21:22'),
	(4, 3, 4, 2, 459.00, '2025-05-26 10:21:22');

-- 导出  表 test.products 结构
CREATE TABLE IF NOT EXISTS `products` (
  `product_id` int NOT NULL AUTO_INCREMENT COMMENT '商品唯一标识',
  `product_name` varchar(255) NOT NULL COMMENT '商品名称',
  `description` text COMMENT '商品描述',
  `price` decimal(10,2) NOT NULL COMMENT '商品价格',
  `stock_quantity` int NOT NULL COMMENT '商品库存数量',
  `category_id` int DEFAULT NULL COMMENT '商品所属类别',
  `created_at` datetime DEFAULT NULL COMMENT '商品添加时间',
  `updated_at` datetime DEFAULT NULL COMMENT '商品信息更新时间',
  `dimension_length` decimal(10,2) DEFAULT NULL COMMENT '家具长度（单位：厘米）',
  `dimension_width` decimal(10,2) DEFAULT NULL COMMENT '家具宽度（单位：厘米）',
  `dimension_height` decimal(10,2) DEFAULT NULL COMMENT '家具高度（单位：厘米）',
  `weight` decimal(10,2) DEFAULT NULL COMMENT '家具重量（单位：千克）',
  `material` varchar(255) DEFAULT NULL COMMENT '家具材质（如实木、板材、金属等）',
  `color` varchar(255) DEFAULT NULL COMMENT '家具颜色',
  `style` varchar(255) DEFAULT NULL COMMENT '家具风格（如现代、中式、欧式等）',
  `is_assembly_required` tinyint(1) DEFAULT NULL COMMENT '是否需要组装（0表示不需要，1表示需要）',
  PRIMARY KEY (`product_id`),
  KEY `category_id` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品表';

-- 正在导出表  test.products 的数据：~4 rows (大约)
INSERT INTO `products` (`product_id`, `product_name`, `description`, `price`, `stock_quantity`, `category_id`, `created_at`, `updated_at`, `dimension_length`, `dimension_width`, `dimension_height`, `weight`, `material`, `color`, `style`, `is_assembly_required`) VALUES
	(1, '现代布艺沙发', '舒适现代布艺沙发', 2999.00, 10, 1, '2025-05-26 10:04:53', '2025-05-26 10:04:53', 200.00, 90.00, 90.00, 35.00, '布艺', '灰色', '现代', 1),
	(2, '实木餐桌', '耐用实木餐桌', 1599.00, 8, 2, '2025-05-26 10:04:53', '2025-05-26 10:04:53', 120.00, 80.00, 75.00, 50.00, '实木', '棕色', '中式', 0),
	(3, '推拉门衣柜', '大容量推拉门衣柜', 3299.00, 5, 3, '2025-05-26 10:04:53', '2025-05-26 10:04:53', 200.00, 60.00, 230.00, 60.00, '板材', '白色', '现代', 1),
	(4, '多层书架', '简易多层书架', 459.00, 20, 4, '2025-05-26 10:04:53', '2025-05-26 10:04:53', 80.00, 30.00, 180.00, 12.00, '实木', '原木色', '北欧', 1);

-- 导出  表 test.shopping_carts 结构
CREATE TABLE IF NOT EXISTS `shopping_carts` (
  `cart_id` int NOT NULL AUTO_INCREMENT COMMENT '购物车唯一标识',
  `user_id` int NOT NULL COMMENT '购物车所属用户',
  `product_id` int NOT NULL COMMENT '购物车中的商品',
  `quantity` int NOT NULL COMMENT '商品数量',
  `created_at` datetime DEFAULT NULL COMMENT '商品添加到购物车时间',
  `updated_at` datetime DEFAULT NULL COMMENT '购物车记录更新时间',
  PRIMARY KEY (`cart_id`),
  KEY `user_id` (`user_id`),
  KEY `product_id` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='购物车表';

-- 正在导出表  test.shopping_carts 的数据：~8 rows (大约)
INSERT INTO `shopping_carts` (`cart_id`, `user_id`, `product_id`, `quantity`, `created_at`, `updated_at`) VALUES
	(5, 1, 1, 1, '2025-05-26 10:06:37', '2025-05-26 10:06:37'),
	(6, 1, 2, 1, '2025-05-26 10:06:37', '2025-05-26 10:06:37'),
	(7, 2, 3, 1, '2025-05-26 10:06:37', '2025-05-26 10:06:37'),
	(8, 3, 4, 2, '2025-05-26 10:06:37', '2025-05-26 10:06:37'),
	(9, 1, 1, 1, '2025-05-26 10:13:11', '2025-05-26 10:13:11'),
	(10, 1, 2, 1, '2025-05-26 10:13:11', '2025-05-26 10:13:11'),
	(11, 2, 3, 1, '2025-05-26 10:13:11', '2025-05-26 10:13:11'),
	(12, 3, 4, 2, '2025-05-26 10:13:11', '2025-05-26 10:13:11');

-- 导出  表 test.sys_user_token 结构
CREATE TABLE IF NOT EXISTS `sys_user_token` (
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `token` varchar(255) NOT NULL COMMENT 'token',
  `expire_time` datetime NOT NULL COMMENT '过期时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户token表';

-- 正在导出表  test.sys_user_token 的数据：~2 rows (大约)
INSERT INTO `sys_user_token` (`user_id`, `token`, `expire_time`, `update_time`) VALUES
	(6, 'fd2faba2f4ced5f5599cda98e7a2382a', '2025-05-28 03:49:15', '2025-05-27 15:49:15'),
	(7, '6c3cedcb35f161c219d8edac498aae6b', '2025-05-28 05:32:20', '2025-05-27 17:32:20');

-- 导出  表 test.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '用户唯一标识',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '用户密码（加密存储）',
  `mobile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户电话号码',
  `create_time` datetime DEFAULT NULL COMMENT '用户创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '用户信息更新时间',
  `salt` char(20) DEFAULT NULL COMMENT '盐',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';

-- 正在导出表  test.user 的数据：~4 rows (大约)
INSERT INTO `user` (`user_id`, `username`, `password`, `mobile`, `create_time`, `update_time`, `salt`) VALUES
	(1, 'user1', 'password1', '13800138001', '2025-05-26 10:27:06', '2025-05-26 10:27:06', NULL),
	(2, 'user2', 'password2', '13900139002', '2025-05-26 10:27:06', '2025-05-26 10:27:06', NULL),
	(3, 'user3', 'password3', '13700137003', '2025-05-26 10:27:06', '2025-05-26 10:27:06', NULL),
	(4, 'user4', 'password4', '13600136004', '2025-05-26 10:27:06', '2025-05-26 10:27:06', NULL),
	(6, 'admin', '3de73c8604201ff804b18b67781528b4542301dd5f0af24cc9a046e8540fca8d', '13366719283', '2025-05-27 15:28:20', NULL, 'l8GRrUv2n7cKBX1PdToY'),
	(7, 'admin1', 'bf4e928dc1867f5e3a7f9875b9fd1b1cac594cb839e2303bdd57671d21b6772d', '13366719283', '2025-05-27 17:32:12', NULL, 'aiFS8FpXvRTvZ0J78sUI');

-- 导出  表 test.user_coupons 结构
CREATE TABLE IF NOT EXISTS `user_coupons` (
  `user_coupon_id` int NOT NULL AUTO_INCREMENT COMMENT '用户优惠券关联唯一标识',
  `user_id` int NOT NULL COMMENT '关联用户',
  `coupon_id` int NOT NULL COMMENT '关联优惠券',
  `used_order_id` int DEFAULT NULL COMMENT '使用该优惠券的订单（如果已使用）',
  `created_at` datetime DEFAULT NULL COMMENT '用户领取优惠券时间',
  `updated_at` datetime DEFAULT NULL COMMENT '用户优惠券关联信息更新时间',
  PRIMARY KEY (`user_coupon_id`),
  KEY `user_id` (`user_id`),
  KEY `coupon_id` (`coupon_id`),
  KEY `used_order_id` (`used_order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户优惠券关联表';

-- 正在导出表  test.user_coupons 的数据：~3 rows (大约)
INSERT INTO `user_coupons` (`user_coupon_id`, `user_id`, `coupon_id`, `used_order_id`, `created_at`, `updated_at`) VALUES
	(1, 1, 1, NULL, '2025-05-26 10:15:29', '2025-05-26 10:15:29'),
	(2, 2, 2, 2, '2025-05-26 10:15:29', '2025-05-26 10:15:29'),
	(3, 3, 1, NULL, '2025-05-26 10:15:29', '2025-05-26 10:15:29');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
