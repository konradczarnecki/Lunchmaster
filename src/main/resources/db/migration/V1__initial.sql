/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;


DROP TABLE IF EXISTS `restaurant`;
CREATE TABLE `restaurant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `link` varchar(1024) DEFAULT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `avg_delivery_time` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `logo` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `dish`;
CREATE TABLE `dish` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `img` varchar(1024) DEFAULT NULL,
  `restaurant_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `restaurant_id_idx` (`restaurant_id`),
  CONSTRAINT `restaurant_id` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `img`;
CREATE TABLE `img` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `part` varchar(255) NOT NULL,
  `group` varchar(255) NOT NULL,
  `team` varchar(45) NOT NULL,
  `floor` int(11) NOT NULL,
  `bank_account` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `mobile_UNIQUE` (`mobile`),
  UNIQUE KEY `bank_account_UNIQUE` (`bank_account`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `lunch`;
CREATE TABLE `lunch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lunchmaster_id` int(11) NOT NULL,
  `status` varchar(45) NOT NULL,
  `deadline` datetime NOT NULL,
  `expected_delivery` int(11) NOT NULL,
  `rst_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id_idx_2` (`lunchmaster_id`),
  KEY `rst_id_idx` (`rst_id`),
  CONSTRAINT `lunchmaster_id` FOREIGN KEY (`lunchmaster_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `rst_id` FOREIGN KEY (`rst_id`) REFERENCES `restaurant` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `lunchorder`;
CREATE TABLE `lunchorder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lunch_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `lunch_id_index_idx` (`lunch_id`),
  KEY `user_id_index_idx` (`user_id`),
  CONSTRAINT `lunch_id_index` FOREIGN KEY (`lunch_id`) REFERENCES `lunch` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_id_index` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `lunchorder_dish`;
CREATE TABLE `lunchorder_dish` (
  `lunchorder_id` int(11) NOT NULL,
  `dish_id` int(11) NOT NULL,
  KEY `lunchorder_id_index_idx` (`lunchorder_id`),
  KEY `dish_id_index_idx` (`dish_id`),
  CONSTRAINT `dish_id_index` FOREIGN KEY (`dish_id`) REFERENCES `dish` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `lunchorder_id_index` FOREIGN KEY (`lunchorder_id`) REFERENCES `lunchorder` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `user` VALUES (1,'Mikolaj','Slefarski','mikolaj.slefarski@gmail.com','737767882','Service Development','VD SA','VD',13,'<bank acc>'),(2,'Jan','Kowalski','jankowalski@nowhere.com','3423453','Service Development','VD SA','VD',13,'<bank acc 2>');
INSERT INTO `restaurant` VALUES (1,'111 111 111','adres 1 xxx','dsfsadffdf','afgfdjhyuerthtrnb',30,'Viet Thai','https://static.pyszne.pl/images/restaurants/pl/NO0Q0PO/logo_465x320.png'),(2,'222 222 222','adres 2 xxx','serrggrrgrg','sthragarg',60,'Chmielarnia','https://static.pyszne.pl/images/restaurants/pl/53R3NQ3/logo_465x320.png');
INSERT INTO `dish` VALUES (1,'Kaczucha',18.5,NULL,1),(2,'Sajgonki',9.5,NULL,1),(3,'Baranina Balti',24,NULL,2),(4,'Kurczak Curry',21,NULL,2);
INSERT INTO `lunch` VALUES (1,1,'OPEN','2017-10-13 12:00:00',30,1),(2,2,'OPEN','2017-10-13 12:30:00',15,2);
INSERT INTO `lunchorder` VALUES (1,1,1,'tylko sos do sajgonek, kurwa!!!'),(2,1,2,NULL),(3,2,1,'tylko szybako, kurwa!!! >:U');
INSERT INTO `lunchorder_dish` VALUES (1,1),(1,2),(1,2),(2,3),(2,4);



/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;