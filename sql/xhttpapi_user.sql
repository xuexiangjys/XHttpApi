-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: xhttpapi
-- ------------------------------------------------------
-- Server version	5.7.22

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

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `gender` int(11) NOT NULL DEFAULT '1',
  `age` int(11) NOT NULL DEFAULT '0',
  `phone` tinytext NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'薛翔',1,24,'13813823453'),(3,'美雪',2,20,'13817834234'),(4,'王小丫',2,45,'17482954839'),(6,'hsrytxvniphjul',2,62,'43385781816'),(7,'bicaypmebv',2,60,'71320135160'),(8,'jzbzehfiouse',2,77,'13012082637'),(9,'nxwljumxqh',2,97,'71362289207'),(11,'bc',2,25,'93684867318'),(14,'jijzeyxz',2,99,'36027362539'),(15,'xxxxxxxxxxx',2,1000,'11111111111111'),(16,'oggaymvyiuoko',2,7,'40779778325'),(18,'hcwwuvwt',1,34,'00986596263'),(20,'nzdavkzojezq',2,23,'99150397457'),(21,'zpqlqtnavmmpyd',2,35,'20255732486'),(23,'zflwfnngnyjjozj',1,37,'84342210170'),(26,'kuvibqmogvcb',1,90,'57718284190'),(27,'zrkudohc',1,74,'27628260327'),(28,'lrjadjtnsaltonc',1,11,'25310759357'),(29,'kporgjuckqlyb',2,19,'02403757199'),(30,'tjcklwkrcu',1,87,'72546060000'),(31,'djlnatkowfeosb',1,30,'52863177462'),(32,'cxvbgssg',1,37,'25908268291');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-19 10:05:47
