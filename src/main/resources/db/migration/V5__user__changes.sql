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

ALTER TABLE `user`
MODIFY COLUMN `part` varchar(255) DEFAULT NULL,
MODIFY COLUMN `grp` varchar(255) DEFAULT NULL,
MODIFY  COLUMN `team` varchar(45) DEFAULT NULL,
MODIFY  COLUMN `floor` int(11) DEFAULT NULL;

UPDATE `user`
SET `password` = '$2a$12$q1JFyn/VyuUx4BzdCvgexO8DEsJrK8g.eYzGduVAZKEYa/zO5r.62`'
WHERE `email` = 'mikolaj.slefarski@gmail.com';

UPDATE `user`
SET `password` = '$2a$12$iHFWBFcY7w0NYGWpFl5VoukFJHO/xcT4qYn3yQlJ.xU8NhHajmueS'
WHERE `email` = 'jankowalski@nowhere.com';

UPDATE `user`
SET `password` = '$2a$12$D5xawe0q.cVA3TJdW2aBSu4T706zo6NXG8iHt.FMYJPBdjbqLQFm6'
WHERE `email` = 'olo.yolo@gmail.com';

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;