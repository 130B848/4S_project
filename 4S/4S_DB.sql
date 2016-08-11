SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+08:00";

-- 用户
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
	`user_id` INT NOT NULL,
	`username` VARCHAR(32) COLLATE utf8_bin NOT NULL,
	`password` VARCHAR(128) COLLATE utf8_bin NOT NULL,
	`type` VARCHAR(64) COLLATE utf8_bin NOT NULL,
	PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 用户功能
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
	`role_id` int NOT NULL,
	`role_name` varchar(32) COLLATE utf8_bin DEFAULT NULL,
	PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 关联集：用户-功能
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
	`role_id` INT NOT NULL,
	`user_id` INT NOT NULL,
	PRIMARY KEY (`role_id`, `user_id`),
	FOREIGN KEY(`role_id`) REFERENCES `role` (`role_id`),
	FOREIGN KEY(`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 厂家品牌
DROP TABLE IF EXISTS `garage`;
CREATE TABLE `garage`(
	`garage_brand` VARCHAR(64) COLLATE utf8_bin NOT NULL,
	PRIMARY KEY(`garage_brand`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS `sfx`;
CREATE TABLE `sfx`(
	`sfx` VARCHAR(64) COLLATE utf8_bin NOT NULL,
	PRIMARY KEY(`sfx`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 颜色
DROP TABLE IF EXISTS `color`;
CREATE TABLE `color`(
	`color` VARCHAR(32) COLLATE utf8_bin NOT NULL,
	PRIMARY KEY(`color`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand`(
	`garage_brand` VARCHAR(64) COLLATE utf8_bin NOT NULL,
	`brand` VARCHAR(64) COLLATE utf8_bin NOT NULL,
	PRIMARY KEY(`brand`,`garage_brand`),
	FOREIGN KEY(`garage_brand`) REFERENCES `garage`(`garage_brand`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 车型
DROP TABLE IF EXISTS `vehicle_type`;
CREATE TABLE `vehicle_type`(
	`garage_brand` VARCHAR(64) COLLATE utf8_bin NOT NULL,
	`brand` VARCHAR(64) COLLATE utf8_bin NOT NULL,
	`sfx` VARCHAR(64) COLLATE utf8_bin NOT NULL,
	`color` VARCHAR(32) COLLATE utf8_bin NOT NULL,
	`plan` INT NOT NULL,
	`stock` INT NOT NULL,
	`book` INT NOT NULL,
	`cost` DECIMAL(10,2) DEFAULT NULL,
	`price` DECIMAL(10,2) DEFAULT NULL,
	`discount` DECIMAL(10,2),
	PRIMARY KEY(`garage_brand`,`brand`,`sfx`,`color`),
	FOREIGN KEY(`brand`) REFERENCES `brand` (`brand`),
	FOREIGN KEY(`color`) REFERENCES `color` (`color`),
	FOREIGN KEY(`garage_brand`) REFERENCES `garage`(`garage_brand`),
	FOREIGN KEY(`sfx`) REFERENCES `sfx`(`sfx`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


-- 库存状态
DROP TABLE IF EXISTS `stock_status`;
CREATE TABLE `stock_status`(
	`stock_status` VARCHAR(32) COLLATE utf8_bin NOT NULL,
	PRIMARY KEY(`stock_status`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 车辆
DROP TABLE IF EXISTS `vehicle`;
CREATE TABLE `vehicle` (
	`vehicle_id` VARCHAR(128) NOT NULL,
	`brand` VARCHAR(64) COLLATE utf8_bin NOT NULL,
	`garage_brand` VARCHAR(64) COLLATE utf8_bin NOT NULL,
	`sfx` VARCHAR(64) COLLATE utf8_bin NOT NULL,
	`color` VARCHAR(32) COLLATE utf8_bin NOT NULL,
	`cost` DECIMAL(10,2) DEFAULT NULL,
	`predicted_time` TIMESTAMP default current_timestamp,
	`purchase_time` TIMESTAMP default current_timestamp,
	`price` DECIMAL(10,2) DEFAULT NULL,
	`discount` DECIMAL(10,2),
	`status` VARCHAR(32) NOT NULL,
	`normal` VARCHAR(1) NOT NULL,
	PRIMARY KEY (`vehicle_id`),
	-- FOREIGN KEY (`sfx`) REFERENCES `sfx` (`sfx`),
	FOREIGN KEY(`garage_brand`,`brand`,`sfx`,`color`) REFERENCES `vehicle_type` (`garage_brand`,`brand`,`sfx`,`color`),
	-- FOREIGN KEY(`color`) REFERENCES `color` (`color`),
	FOREIGN KEY(`status`) REFERENCES `stock_status` (`stock_status`)		
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


DROP TABLE IF EXISTS `vehicle_garage`;
CREATE TABLE `vehicle_garage`(
	`garage_brand` VARCHAR(64) COLLATE utf8_bin NOT NULL,
	`vehicle_id` VARCHAR(128),
	PRIMARY KEY(`garage_brand`,`vehicle_id`),
	FOREIGN KEY(`garage_brand`) REFERENCES `garage` (`garage_brand`),
	FOREIGN KEY(`vehicle_id`) REFERENCES `vehicle` (`vehicle_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS `vehicle_color`;
CREATE TABLE `vehicle_color`(
	`color` VARCHAR(32) COLLATE utf8_bin NOT NULL,
	`vehicle_id` VARCHAR(128),
	PRIMARY KEY(`color`,`vehicle_id`),
	FOREIGN KEY(`color`) REFERENCES `color` (`color`),
	FOREIGN KEY(`vehicle_id`) REFERENCES `vehicle` (`vehicle_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS `vehicle_stock_status`;
CREATE TABLE `vehicle_stock_status`(
	`stock_status` VARCHAR(32) COLLATE utf8_bin NOT NULL,
	`vehicle_id` VARCHAR(128),
	PRIMARY KEY(`stock_status`,`vehicle_id`),
	FOREIGN KEY(`stock_status`) REFERENCES `stock_status` (`stock_status`),
	FOREIGN KEY(`vehicle_id`) REFERENCES `vehicle` (`vehicle_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 顾客
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
	`customer_id` INT NOT NULL,
	`name` VARCHAR(32) COLLATE utf8_bin NOT NULL,
	`cellphone` VARCHAR(20) DEFAULT NULL,
	`wechat` VARCHAR(64) DEFAULT NULL,
	`gender` VARCHAR(1) DEFAULT NULL,
	`birthday` DATE DEFAULT NULL,
	`occupation` VARCHAR(64) COLLATE utf8_bin DEFAULT NULL,
	`occupation_type` VARCHAR(64) COLLATE utf8_bin DEFAULT NULL,
	`job` VARCHAR(64) COLLATE utf8_bin DEFAULT NULL,
	`family_size` INT DEFAULT NULL,
	`hobby` VARCHAR(64) COLLATE utf8_bin DEFAULT NULL,
	`income` DECIMAL(10,2) DEFAULT NULL,
	`area` VARCHAR(64) COLLATE utf8_bin DEFAULT NULL,
	`years` INT DEFAULT NULL,
	`source` VARCHAR(64) COLLATE utf8_bin DEFAULT NULL,
	PRIMARY KEY(`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
	
-- 订单 
DROP TABLE IF EXISTS `vehicle_order`;
CREATE TABLE `vehicle_order` (
	`order_id` varchar(64) NOT NULL,
	`customer_id` INT NOT NULL,
	`vehicle_id` VARCHAR(128) NOT NULL,
	`user_id` INT NOT NULL,
	`finish_status` VARCHAR(1) NOT NULL,
	`sale_price` DECIMAL(10,2) NOT NULL,
	`actual_get_money` DECIMAL(10,2),
	`create_time` TIMESTAMP default current_timestamp,
	`remark` VARCHAR(255) DEFAULT NULL,
	PRIMARY KEY(`order_id`),
	FOREIGN KEY(`customer_id`) REFERENCES `customer` (`customer_id`),
	FOREIGN KEY(`vehicle_id`) REFERENCES `vehicle` (`vehicle_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 精品类型
DROP TABLE IF EXISTS `gift_type`;
CREATE TABLE `gift_type` (
	`type` VARCHAR(64) COLLATE utf8_bin  NOT NULL,
	PRIMARY KEY(`type`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 保险类型
DROP TABLE IF EXISTS `insurance_type`;
CREATE TABLE `insurance_type` (
	`type` VARCHAR(64) COLLATE utf8_bin  NOT NULL,
	PRIMARY KEY(`type`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 精品
DROP TABLE IF EXISTS `gift`;
CREATE TABLE `gift` (
	`gift_id` int NOT NULL,
	`order_id` VARCHAR(64) DEFAULT NULL,
	`name` VARCHAR(64) NOT NULL,
	`type` VARCHAR(64) COLLATE utf8_bin NOT NULL,
	`cost` DECIMAL(10,2) NOT NULL,
	`discount` DECIMAL(10,2),
	`actual_get_money` DECIMAL(10,2),
	`default_price` DECIMAL(10,2) NOT NULL,
	`selling_price` DECIMAL(10,2),
	`garage_brand` VARCHAR(64) COLLATE utf8_bin NOT NULL,
	`brand` VARCHAR(64) COLLATE utf8_bin NOT NULL,
	PRIMARY KEY(`gift_id`),
	FOREIGN KEY(`garage_brand`,`brand`) REFERENCES `brand` (`garage_brand`,`brand`),
	FOREIGN KEY(`type`) REFERENCES `gift_type` (`type`),
	FOREIGN KEY(`order_id`) REFERENCES `vehicle_order`(`order_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 保险
DROP TABLE IF EXISTS `insurance` ;
CREATE TABLE `insurance`(
	`insurance_id` INT NOT NULL,
	`order_id` VARCHAR(64) DEFAULT NULL,
	`name` VARCHAR(64) NOT NULL,
	`type` VARCHAR(64) COLLATE utf8_bin NOT NULL,
	`cost` DECIMAL(10,2) NOT NULL,
	`discount` DECIMAL(10,2),
	`actual_get_money` DECIMAL(10,2),
	`default_price` DECIMAL(10,2) NOT NULL,
	`selling_price` DECIMAL(10,2),
	PRIMARY KEY(`insurance_id`),
	FOREIGN KEY(`type`) REFERENCES `insurance_type` (`type`),
	FOREIGN KEY(`order_id`) REFERENCES `vehicle_order`(`order_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


-- 水平事业类型
DROP TABLE IF EXISTS `additional_product_type`;
CREATE TABLE `additional_product_type` (
	`type` VARCHAR(64) COLLATE utf8_bin  NOT NULL,
	PRIMARY KEY(`type`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 水平事业
DROP TABLE IF EXISTS `additional_product` ;
CREATE TABLE `additional_product`(
	`additional_product_id` INT NOT NULL,
	`order_id` VARCHAR(64) DEFAULT NULL,
	`name` VARCHAR(64) NOT NULL,
	`type` VARCHAR(64) COLLATE utf8_bin NOT NULL,
	`cost` DECIMAL(10,2) NOT NULL,
	`discount` DECIMAL(10,2),
	`actual_get_money` DECIMAL(10,2),
	`default_price` DECIMAL(10,2) NOT NULL,
	`selling_price` DECIMAL(10,2),
	PRIMARY KEY(`additional_product_id`),
	FOREIGN KEY(`type`) REFERENCES `additional_product_type` (`type`),
	FOREIGN KEY(`order_id`) REFERENCES `vehicle_order`(`order_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 精品
-- DROP TABLE IF EXISTS `order_gift`;
-- CREATE TABLE `order_gift` (
-- 	`gift_id` int NOT NULL,
-- 	`order_id` VARCHAR(64) NOT NULL,
-- 	PRIMARY KEY(`gift_id`,`order_id`),
-- 	FOREIGN KEY(`gift_id`) REFERENCES `gift`(`gift_id`),
-- 	FOREIGN KEY(`order_id`) REFERENCES `vehicle_order`(`order_id`)
-- )ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- -- 保险
-- DROP TABLE IF EXISTS `order_insurance`;
-- CREATE TABLE `order_insurance` (
-- 	`insurance_id` int NOT NULL,
-- 	`order_id` VARCHAR(64) NOT NULL,
-- 	PRIMARY KEY(`insurance_id`,`order_id`),
-- 	FOREIGN KEY(`insurance_id`) REFERENCES `insurance`(`insurance_id`),
-- 	FOREIGN KEY(`order_id`) REFERENCES `vehicle_order`(`order_id`)
-- )ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 精品追加销售
DROP TABLE IF EXISTS `upsell_gift`;
CREATE TABLE `upsell_gift` (
	`gift_id` int NOT NULL,
	`order_id` VARCHAR(64) NOT NULL,
	`time` TIMESTAMP default current_timestamp,
	`remark` VARCHAR(255) DEFAULT NULL,
	PRIMARY KEY(`gift_id`,`order_id`),
	FOREIGN KEY(`gift_id`) REFERENCES `gift`(`gift_id`),
	FOREIGN KEY(`order_id`) REFERENCES `vehicle_order`(`order_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 保险追加销售
DROP TABLE IF EXISTS `upsell_insurance`;
CREATE TABLE `upsell_insurance` (
	`insurance_id` int NOT NULL,
	`order_id` VARCHAR(64) NOT NULL,
	`time` TIMESTAMP default current_timestamp,
	`remark` VARCHAR(255) DEFAULT NULL,
	PRIMARY KEY(`insurance_id`,`order_id`),
	FOREIGN KEY(`insurance_id`) REFERENCES `insurance`(`insurance_id`),
	FOREIGN KEY(`order_id`) REFERENCES `vehicle_order`(`order_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
