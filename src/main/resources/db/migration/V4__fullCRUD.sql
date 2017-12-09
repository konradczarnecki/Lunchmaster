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


/*
  RESTAURANT
*/


DROP TABLE IF EXISTS `restaurant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;


LOCK TABLES `restaurant` WRITE;
/*!40000 ALTER TABLE `restaurant` DISABLE KEYS */;
INSERT INTO `restaurant` VALUES
  (1,'111 111 111','adres 1 xxx','dsfsadffdf','afgfdjhyuerthtrnb',30,'Viet Thai','https://static.pyszne.pl/images/restaurants/pl/NO0Q0PO/logo_465x320.png'),
  (2,'222 222 222','adres 2 xxx','serrggrrgrg','sthragarg',60,'Chmielarnia','https://static.pyszne.pl/images/restaurants/pl/53R3NQ3/logo_465x320.png'),
  (3,'111 111 111','test address','test link','test restaurant',30,'TEST RESTAURANT','http://kennethmhill.com/yahoo_site_admin/assets/images/test.219135300_std.PNG');
/*!40000 ALTER TABLE `restaurant` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;


/*
  DISH
*/


DROP TABLE IF EXISTS `dish`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dish` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `img` varchar(1024) DEFAULT NULL,
  `restaurant_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `restaurant_id_idx` (`restaurant_id`),
  CONSTRAINT `FKt13glsbe9ivpka00hbeg539cv` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant` (`id`),
  CONSTRAINT `restaurant_id` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;


LOCK TABLES `dish` WRITE;
/*!40000 ALTER TABLE `dish` DISABLE KEYS */;
INSERT INTO `dish` VALUES
  (1,'Kaczucha',18.5,NULL,1),
  (2,'Sajgonki',9.5,NULL,1),
  (3,'Baranina Balti',24,NULL,2),
  (4,'Kurczak Curry',21,NULL,2),
  (6,'TEST DISH',15,NULL,1);
/*!40000 ALTER TABLE `dish` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;


/*
  IMG
*/


DROP TABLE IF EXISTS `img`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `img` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;


LOCK TABLES `img` WRITE;
/*!40000 ALTER TABLE `img` DISABLE KEYS */;
/*!40000 ALTER TABLE `img` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;


/*
  ROLE
*/


DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `rolename_UNIQUE` (`rolename`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;



LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES
  (2,'ADMIN'),
  (1,'USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;


/*
  USER
*/


DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `part` varchar(255) NOT NULL,
  `grp` varchar(255) NOT NULL,
  `team` varchar(45) NOT NULL,
  `floor` int(11) NOT NULL,
  `bank_account` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `account_expired` bit(1) DEFAULT 0,
  `account_locked` bit(1) DEFAULT 0,
  `credentials_expired` bit(1) DEFAULT 0,
  `enabled` bit(1) DEFAULT 1,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `mobile_UNIQUE` (`mobile`),
  UNIQUE KEY `bank_account_UNIQUE` (`bank_account`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;


LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES
  (1,'Mikolaj','Slefarski','mikolaj.slefarski@gmail.com','737767882','Service Development','VD SA','VD',13,'<bank acc>','pwd', 0, 0, 0, 1),
  (2,'Jan','Kowalski','jankowalski@nowhere.com','3423453','Service Development','VD SA','VD',13,'<bank acc 2>','pwd', 0, 0, 0, 1),
  (4,'Yolo','Yolo','olo.yolo@gmail.com','1111111','Service Development','VD SA','VD',13,'<bank acc 4>','pwd', 0, 0, 0, 1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;


/*
  USER_ROLE
*/


DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
  (1, 1),
  (2, 1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;


/*
  LUNCH
*/


DROP TABLE IF EXISTS `lunch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lunch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lunchmaster_id` int(11) NOT NULL,
  `status` enum('OPEN','CLOSED','ORDERED','DELIVERED','ARCHIEVED') NOT NULL,
  `deadline` datetime NOT NULL,
  `expected_delivery` int(11) NOT NULL,
  `rst_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id_idx_2` (`lunchmaster_id`),
  KEY `rst_id_idx` (`rst_id`),
  CONSTRAINT `FKp2epskrqa5p32ka1hjlo35jr3` FOREIGN KEY (`lunchmaster_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKr5cbw9dy7nusm1x1kt4raj892` FOREIGN KEY (`rst_id`) REFERENCES `restaurant` (`id`),
  CONSTRAINT `lunchmaster_id` FOREIGN KEY (`lunchmaster_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `rst_id` FOREIGN KEY (`rst_id`) REFERENCES `restaurant` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;


LOCK TABLES `lunch` WRITE;
/*!40000 ALTER TABLE `lunch` DISABLE KEYS */;
INSERT INTO `lunch` VALUES
  (1,1,'OPEN','2017-12-13 12:00:00',30,1),
  (2,2,'OPEN','2017-10-13 12:30:00',15,2);
/*!40000 ALTER TABLE `lunch` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;


/*
  LUNCHORDER
*/


DROP TABLE IF EXISTS `lunchorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lunchorder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lunch_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `lunch_id_index_idx` (`lunch_id`),
  KEY `user_id_index_idx` (`user_id`),
  CONSTRAINT `FKmr3seon7pl63s9p5fm87vid0b` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKov2d1729odyn7uyym1fc50fc` FOREIGN KEY (`lunch_id`) REFERENCES `lunch` (`id`),
  CONSTRAINT `lunch_id_index` FOREIGN KEY (`lunch_id`) REFERENCES `lunch` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_id_index` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;





LOCK TABLES `lunchorder` WRITE;
/*!40000 ALTER TABLE `lunchorder` DISABLE KEYS */;
INSERT INTO `lunchorder` VALUES
  (1,1,1,'tylko sos do sajgonek, kurwa!!!'),
  (2,1,2,NULL),(3,2,4,'tylko sos do sajgonek, kurwa!!!');
/*!40000 ALTER TABLE `lunchorder` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;


/*
  LUNCHORDER_DISH
*/


DROP TABLE IF EXISTS `lunchorder_dish`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lunchorder_dish` (
  `lunchorder_id` int(11) NOT NULL,
  `dish_id` int(11) NOT NULL,
  KEY `lunchorder_id_idx` (`lunchorder_id`),
  KEY `dish_id_idx` (`dish_id`),
  CONSTRAINT `dish_id` FOREIGN KEY (`dish_id`) REFERENCES `dish` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `lunchorder_id` FOREIGN KEY (`lunchorder_id`) REFERENCES `lunchorder` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


LOCK TABLES `lunchorder_dish` WRITE;
/*!40000 ALTER TABLE `lunchorder_dish` DISABLE KEYS */;
INSERT INTO `lunchorder_dish` VALUES
  (1,1),
  (1,2),
  (2,1),
  (3,3);
/*!40000 ALTER TABLE `lunchorder_dish` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;