# ************************************************************
# Sequel Pro SQL dump
# バージョン 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# ホスト: 127.0.0.1 (MySQL 5.7.22)
# データベース: my_ec
# 作成時刻: 2018-07-20 08:11:41 +0000
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

LOCK TABLES `category_l` WRITE;
/*!40000 ALTER TABLE `category_l` DISABLE KEYS */;

INSERT INTO `category_l` (`id`, `name`)
VALUES
	(1,'インナー'),
	(2,'アウター'),
	(3,'ボトムス・靴'),
	(4,'アクセサリー');

/*!40000 ALTER TABLE `category_l` ENABLE KEYS */;
UNLOCK TABLES;


# テーブルのダンプ category_s
# ------------------------------------------------------------

DROP TABLE IF EXISTS `category_s`;

CREATE TABLE `category_s` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `category_l` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `category_s` WRITE;
/*!40000 ALTER TABLE `category_s` DISABLE KEYS */;

INSERT INTO `category_s` (`id`, `name`, `category_l`)
VALUES
	(1,'シャツ','1'),
	(2,'セーター','1'),
	(3,'ジャケット','2'),
	(4,'コート','2'),
	(5,'ジーンズ','3'),
	(6,'靴','3'),
	(7,'ネックレス','4'),
	(8,'時計','4'),
	(9,'ベルト','4');

/*!40000 ALTER TABLE `category_s` ENABLE KEYS */;
UNLOCK TABLES;


# テーブルのダンプ item
# ------------------------------------------------------------

DROP TABLE IF EXISTS `item`;

CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(256) NOT NULL,
  `item_detail` varchar(256) NOT NULL,
  `price_with_tax` int(11) NOT NULL,
  `file_name` varchar(256) NOT NULL,
  `category_id` int(11) NOT NULL,
  `user_type` int(11) NOT NULL,
  `item_create_date` datetime DEFAULT NULL,
  `item_update_date` datetime DEFAULT NULL,
  `rate` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;

INSERT INTO `item` (`id`, `item_name`, `item_detail`, `price_with_tax`, `file_name`, `category_id`, `user_type`, `item_create_date`, `item_update_date`, `rate`)
VALUES
	(1,'ウニクロのT-Shirt、シンプル白の無地','ウニクロの白シャツです。定番の一品。オールシーズンで活躍します。',5650,'img01.jpg',1,1,'2018-07-12 13:24:32','2018-07-12 13:24:32',20),
	(8,'ボーダー柄オリジナルセーター','ウニクロのセーター、肌触りが良く、高品質です。',6500,'img02.jpg',2,1,'2018-07-12 15:41:47','2018-07-12 15:41:47',10),
	(10,'ブラウンビジネスシューズ','高級感のある艶と柔らかい履き心地が特徴のビジネスシューズ',12000,'img03.jpg',6,1,'2018-07-12 18:14:36','2018-07-12 18:14:36',30),
	(11,'ウニクロのT-Shirt、シンプル赤の無地','ウニクロの赤シャツです。定番の一品。オールシーズンで活躍します。',3240,'img04.jpg',1,2,'2018-07-12 21:09:37','2018-07-12 21:09:37',10),
	(12,'ホワイト文字盤デザインウォッチ','時計売り上げNo1。スタイリッシュでファッションを引き立てます。',8920,'img05.jpg',8,2,'2018-07-12 21:14:26','2018-07-12 21:14:26',10),
	(13,'エメラルドグリーンのネックレス','ゴージャスなデザインの天然石ネックレス。様々な年代の女性から絶大な支持をいただいている人気商品です。',25600,'img06.jpg',7,2,'2018-07-12 21:22:47','2018-07-12 21:22:47',40),
	(14,'定番ブランドのスニーカー','学生に人気の定番スニーカーです。お手頃価格でご提供。',3980,'img07.jpg',6,1,'2018-07-12 21:24:57','2018-07-12 21:24:57',0),
	(15,'人気ブランドのウォッチ','並行輸入品。防水加工もある多機能ウォッチです。',32000,'img08.jpg',8,1,'2018-07-12 21:28:44','2018-07-12 21:28:44',50),
	(16,'レディースハイヒール、オープントゥ','女子会、お呼ばれにも。オープントゥのおしゃれなヒールです。',4320,'img09.jpg',6,2,'2018-07-12 21:39:21','2018-07-12 21:39:21',10),
	(17,'セレブレディース赤ヒール','セレブな雰囲気の高級ヒール。パーティーや２次会でも重宝します。',12200,'img10.jpg',6,2,'2018-07-12 21:44:08','2018-07-12 21:44:08',20),
	(18,'キュートなダブルオープンハートネックレス','かわいいデザインのネックレス。プレゼントにも。',32500,'img11.jpg',7,2,'2018-07-12 21:51:31','2018-07-12 21:51:31',0),
	(19,'高級腕時計','高級石を埋め込んだウォッチです。',800000,'img12.jpg',8,1,'2018-07-12 21:55:49','2018-07-12 21:55:49',10),
	(20,'レディーススポーティシューズ','スタイリッシュでスポーティーなレッドシューズ。丈夫なのでアウトドアでも使用できます。',13200,'img13.jpg',6,2,'2018-07-12 21:58:29','2018-07-12 21:58:29',20),
	(21,'ベージュレザーブーツ','レディース用。暖かみのあるデザインで履きごごちも抜群です。',8800,'img14.jpg',6,2,'2018-07-12 22:03:27','2018-07-14 14:17:35',0),
	(22,'グリーンの長袖シャツ','ウニクロオリジナル商品です。厚めの生地で非常に暖かいです。',3210,'img15.jpg',1,1,'2018-07-12 22:05:46','2018-07-12 22:05:46',10),
	(23,'本皮のブラウンベルト','本皮でできたビジネス用のベルトです。',4200,'img16.jpg',9,1,'2018-07-12 22:08:04','2018-07-13 17:39:10',10),
	(24,'長袖のヴィンテージデニムジャケット','ハリウッド俳優も着ていたヴィンテージジャケットです。カジュアルで幅広い年代に人気の商品。',22000,'img17.jpg',3,1,'2018-07-12 22:10:56','2018-07-12 22:10:56',10),
	(25,'有名スポーツブランドウェア','通気性抜群のスポーツウェアです。',5000,'img18.jpg',1,1,'2018-07-12 22:16:08','2018-07-12 22:16:08',10),
	(26,'カジュアルデザインシャツ','重ね着しやすいマストアイテム。遊び心がたっぷり詰まった商品です。',2900,'img19.jpg',1,1,'2018-07-12 22:19:29','2018-07-14 22:29:11',10),
	(30,'ウニクロのT-Shirt、シンプル緑の無地','子供用大人気のウニクロTシャツです。',1500,'img20.jpg',1,3,'2018-07-19 17:59:09','2018-07-19 17:59:09',10),
	(31,'あったかピンクコート冬用','カジュアルなピンクのコート。暖かく冬場の着心地バツグン。',23900,'img21.jpg',4,2,'2018-07-19 20:46:36','2018-07-19 21:04:08',20),
	(32,'シンプル白スニーカー通学用','通学にぴったりな白いスニーカーです。',2200,'img22.jpg',6,3,'2018-07-19 20:49:19','2018-07-19 20:58:58',0),
	(33,'メンズブラックジャケット','おしゃれなストリートファッションに',4900,'img23.jpg',3,1,'2018-07-19 20:53:35','2018-07-19 20:53:35',0),
	(34,'キッズグリーンジャケット','子役もおしゃれに着こなすグリーンのジャケットです。',1980,'img24.jpg',3,3,'2018-07-19 20:55:26','2018-07-19 20:55:26',10),
	(35,'ファー付きダウンジャケット','軽量でアウトドアにも使えます。ファー付きで暖かいです。',8900,'img25.jpg',3,2,'2018-07-19 20:58:16','2018-07-20 10:05:30',10);

/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;


# テーブルのダンプ t_buy
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_buy`;

CREATE TABLE `t_buy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `total_price` int(11) DEFAULT NULL,
  `delivery_method_id` int(11) DEFAULT NULL,
  `buy_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_buy` WRITE;
/*!40000 ALTER TABLE `t_buy` DISABLE KEYS */;

INSERT INTO `t_buy` (`id`, `user_id`, `total_price`, `delivery_method_id`, `buy_date`)
VALUES
	(16,2,118478,1,'2018-07-18 14:55:30'),
	(17,2,93080,3,'2018-07-18 15:11:38'),
	(18,2,727560,2,'2018-07-18 16:04:42'),
	(19,8,68460,3,'2018-07-18 17:36:30'),
	(20,2,81280,1,'2018-07-18 20:44:51'),
	(21,2,11340,1,'2018-07-18 22:47:41'),
	(22,2,11650,3,'2018-07-18 22:48:06'),
	(23,2,10560,3,'2018-07-18 22:49:11'),
	(24,8,36360,3,'2018-07-19 10:36:11'),
	(25,2,3780,3,'2018-07-19 16:44:06'),
	(26,2,6480,1,'2018-07-19 18:16:33'),
	(27,2,44840,3,'2018-07-19 21:13:02'),
	(28,2,19120,1,'2018-07-19 21:25:17'),
	(29,2,2200,2,'2018-07-19 21:25:48'),
	(30,2,2916,2,'2018-07-20 00:02:45'),
	(31,2,2200,1,'2018-07-20 00:03:13'),
	(32,2,3600000,1,'2018-07-20 00:03:39'),
	(33,2,720000,3,'2018-07-20 00:09:51'),
	(34,2,720000,1,'2018-07-20 00:14:15'),
	(35,2,9760,1,'2018-07-20 00:14:41'),
	(36,2,42000,1,'2018-07-20 00:15:04'),
	(37,2,1782,1,'2018-07-20 00:15:17'),
	(38,2,720000,1,'2018-07-20 00:16:03'),
	(39,2,2200,1,'2018-07-20 00:37:52'),
	(40,5,26896,2,'2018-07-20 10:07:18'),
	(41,5,2916,1,'2018-07-20 10:08:06'),
	(42,5,1782,2,'2018-07-20 16:04:20'),
	(43,5,24030,1,'2018-07-20 16:37:36');

/*!40000 ALTER TABLE `t_buy` ENABLE KEYS */;
UNLOCK TABLES;


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

LOCK TABLES `t_buy_detail` WRITE;
/*!40000 ALTER TABLE `t_buy_detail` DISABLE KEYS */;

INSERT INTO `t_buy_detail` (`id`, `buy_id`, `item_id`, `buy_howmany`)
VALUES
	(1,16,17,5),
	(2,16,25,1),
	(3,16,24,3),
	(4,16,22,2),
	(5,17,21,5),
	(6,17,17,3),
	(7,17,24,1),
	(8,18,19,1),
	(9,18,23,2),
	(10,19,13,1),
	(11,19,25,3),
	(12,19,24,2),
	(13,20,23,1),
	(14,20,25,3),
	(15,20,15,4),
	(16,21,23,3),
	(17,22,26,1),
	(18,22,1,2),
	(19,23,20,1),
	(20,24,26,2),
	(21,24,24,1),
	(22,24,23,3),
	(23,25,23,1),
	(24,26,23,1),
	(25,26,30,2),
	(26,27,32,3),
	(27,27,31,2),
	(28,28,31,1),
	(29,29,32,1),
	(30,30,11,1),
	(31,31,32,1),
	(32,32,19,5),
	(33,33,19,1),
	(34,34,19,1),
	(35,35,17,1),
	(36,36,10,5),
	(37,37,34,1),
	(38,38,19,1),
	(39,39,32,1),
	(40,40,31,1),
	(41,40,16,2),
	(42,41,11,1),
	(43,42,34,1),
	(44,43,35,3);

/*!40000 ALTER TABLE `t_buy_detail` ENABLE KEYS */;
UNLOCK TABLES;


# テーブルのダンプ t_delivery_method
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_delivery_method`;

CREATE TABLE `t_delivery_method` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `delivery_name` varchar(256) DEFAULT NULL,
  `delivery_price` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_delivery_method` WRITE;
/*!40000 ALTER TABLE `t_delivery_method` DISABLE KEYS */;

INSERT INTO `t_delivery_method` (`id`, `delivery_name`, `delivery_price`)
VALUES
	(1,'通常配送',0),
	(2,'日時指定便',250),
	(3,'お急ぎ便',500);

/*!40000 ALTER TABLE `t_delivery_method` ENABLE KEYS */;
UNLOCK TABLES;


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
	(1,'okamoto','taisuke',1234567,'東京都','杉並区','〇〇〇〇',1234567890,'1990-06-25','base225001@gmail.com','男','21232F297A57A5A743894A0E4A801FC3','2018-07-06 16:57:22','2018-07-06 16:57:22',0),
	(2,'佐藤','一郎',2222222,'滋賀県','滋賀市','〇〇町',1000000,'1920-02-03','test@test.com','男','B642B4217B34B1E8D3BD915FC65C4452','2018-07-09 22:49:21','2018-07-20 11:02:33',4535),
	(5,'塩見','美紀',1100000,'栃木県','丸ばつ市','テスト丁目',13124234,'1963-06-10','shiomi_miki@example.com','女','A1734E69FD29F64D351DE52FBA75809A','2018-07-10 13:19:03','2018-07-20 15:54:14',256),
	(8,'宮沢 	','あおい',2143256,'青森県','あおもり','アオモリ',9093543,'1960-11-23','miyazawa_aoi@example.com','女','D37B51B92FAB9C715A8485CA88792FA6','2018-07-18 17:35:24','2018-07-20 11:04:14',0),
	(9,'平良 ','惇',3456667,'東京都','とうきょ','港区',802966735,'1977-01-22','hirara_atsushi@example.com','男','3BCDA3B08E0ED40D9FBE04320FA61E88','2018-07-20 10:42:16','2018-07-20 10:42:16',0);

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

LOCK TABLES `user_type` WRITE;
/*!40000 ALTER TABLE `user_type` DISABLE KEYS */;

INSERT INTO `user_type` (`id`, `type`)
VALUES
	(1,'Men'),
	(2,'Women'),
	(3,'Kids');

/*!40000 ALTER TABLE `user_type` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
