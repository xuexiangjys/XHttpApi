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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price` float NOT NULL,
  `author` varchar(45) NOT NULL,
  `description` longtext,
  `sales_volume` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `mark` int(11) DEFAULT NULL,
  `picture` longtext,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'第一行代码:Android(第2版)',53.8,'郭霖','本书被Android开发者誉为Android学习经典。',2,4,56,'Android第一行代码.jpg'),(2,'Android编程权威指南(第3版)',101.7,'比尔·菲利普斯 (Bill Phillips)','本书主要以其Android训练营教学课程为基础，融合了几位作者多年的心得体会，是一本完全面向实战的Android编程权 威指南。全书共36章，详细介绍了8个Android应用的开发过程。通过这些精心设计的应用，读者可掌握很多重要的理论知识和开发技巧，获得宝贵的开发经验。',2,5,145,'2018-06-04 19:50:12.jpg'),(3,'Android组件化架构',64.7,'苍王','本书首先介绍Android组件化开发的基础知识，剖析组件化的开发步骤和常见问题，探究组件化编译原理和编译优化措施。其次在项目架构上，介绍如何组织团队来使用组件化开发，并将业务和人力进行解耦。最后深入介绍组件化分发技术及运用，探讨组件化架构的演进及架构的思维',1,4,5,'1529491036859.jpg'),(4,'疯狂Android讲义(第3版)',78.8,'李刚','本书是《疯狂Android讲义》的第3版，本书基于最新的Android 5，并采用了Google推荐的IDE：Android Studio作为开发工具，书中每个案例、每个截图都全面升级到Android 5。',0,4,3,NULL),(5,'高性能Android应用开发',48.9,'道格·西勒斯 (Doug Sillars)','性能问题在很大程度上决定了用户是否会使用一 款App，本书正是Android性能方面的关键性指南。',1,5,23,NULL),(6,'计算机科学丛书：设计模式 可复用面向对象软件的基础',32.3,'Erich Gamma','《设计模式:可复用面向对象软件的基础》是引导读者走出软件设计迷宫的指路明灯，凝聚了软件开发界几十年设计经验的结晶。四位顶尖的面向对象领域专家精心选取了具有价值的设计实践，加以分类整理和命名，并用简洁而易于重用的形式表达出来。',0,4,54,NULL),(7,'Android源码设计模式解析与实战(第2版)',81.9,'何红辉','本书专门介绍Android源代码的设计模式，主要讲解面向对象的六大原则、主流的设计模式以及MVC和MVP模式。',3,5,11,NULL),(8,'Kotlin从零到精通Android开发',56,'欧阳燊','Kotlin从零到精通Android开发》是一部讲解Kotlin语言的入门书籍，从Kotlin语言的基本语法一直讲到如何将其运用于Android开发。由浅入深、从理论到实战，帮助读者快速掌握Kotlin开发技巧。',68,5,24,NULL);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
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
