# ************************************************************
# Sequel Pro SQL dump
# バージョン 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# ホスト: 127.0.0.1 (MySQL 5.7.22)
# データベース: my_ec
# 作成時刻: 2018-07-08 06:38:01 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# テーブルのダンプ category_l
# ------------------------------------------------------------

DROP TABLE IF EXISTS `category_l`;

CREATE TABLE `category_l` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# テーブルのダンプ category_s
# ------------------------------------------------------------

DROP TABLE IF EXISTS `category_s`;

CREATE TABLE `category_s` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `category_l` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# テーブルのダンプ item
# ------------------------------------------------------------

DROP TABLE IF EXISTS `item`;

CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(256) NOT NULL,
  `price_with_tax` int(11) NOT NULL,
  `file_name` varchar(256) NOT NULL,
  `category_id` int(11) NOT NULL,
  `item_create_date` varchar(256) DEFAULT NULL,
  `item_update_date` varchar(256) DEFAULT NULL,
  `rate` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# テーブルのダンプ t_buy
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_buy`;

CREATE TABLE `t_buy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `total_price` int(11) DEFAULT NULL,
  `delivery_method_id` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# テーブルのダンプ t_buy_detail
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_buy_detail`;

CREATE TABLE `t_buy_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buy_id` int(11) DEFAULT NULL,
  `item_id` int(11) DEFAULT NULL,
  `buy_howmany` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# テーブルのダンプ t_delivery_method
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_delivery_method`;

CREATE TABLE `t_delivery_method` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `delivery_name` varchar(256) DEFAULT NULL,
  `delivery_price` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# テーブルのダンプ user_info
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `family_name` varchar(256) NOT NULL,
  `first_name` varchar(256) NOT NULL,
  `address` int(11) NOT NULL,
  `prefecture` varchar(256) NOT NULL,
  `city` varchar(256) NOT NULL,
  `street` varchar(256) NOT NULL,
  `phone_number` int(11) NOT NULL,
  `birth_date` date NOT NULL,
  `mail` varchar(256) NOT NULL,
  `gender` varchar(256) NOT NULL,
  `password` varchar(256) NOT NULL,
  `user_create_date` datetime DEFAULT NULL,
  `user_update_date` datetime DEFAULT NULL,
  `user_point` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;

INSERT INTO `user_info` (`id`, `family_name`, `first_name`, `address`, `prefecture`, `city`, `street`, `phone_number`, `birth_date`, `mail`, `gender`, `password`, `user_create_date`, `user_update_date`, `user_point`)
VALUES
	(1,'okamoto','taisuke',1234567,'東京都','杉並区','〇〇〇〇',1234567890,'1990-06-25','base225001@gmail.com','男','admin','2018-07-06 16:57:22','2018-07-06 16:57:22',0);

/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;


# テーブルのダンプ user_type
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_type`;

CREATE TABLE `user_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
