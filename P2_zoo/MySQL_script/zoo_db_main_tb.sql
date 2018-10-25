-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: zoo_db
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `main_tb`
--

DROP TABLE IF EXISTS `main_tb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `main_tb` (
  `main_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) DEFAULT NULL,
  `Sex` varchar(45) DEFAULT NULL,
  `Next_Activity` varchar(45) DEFAULT NULL,
  `Last_Feeding` datetime DEFAULT NULL,
  `Food_tb_Type` varchar(45) NOT NULL,
  `IsFull_Location` varchar(45) NOT NULL,
  PRIMARY KEY (`main_ID`),
  KEY `fk_Main_tb_Food_tb_idx` (`Food_tb_Type`),
  KEY `fk_Main_tb_IsFull1_idx` (`IsFull_Location`),
  CONSTRAINT `fk_Main_tb_Food_tb` FOREIGN KEY (`Food_tb_Type`) REFERENCES `food_tb` (`type`),
  CONSTRAINT `fk_Main_tb_IsFull1` FOREIGN KEY (`IsFull_Location`) REFERENCES `isfull` (`location`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `main_tb`
--

LOCK TABLES `main_tb` WRITE;
/*!40000 ALTER TABLE `main_tb` DISABLE KEYS */;
INSERT INTO `main_tb` VALUES (1,'Jill','Female','Feed','2018-10-12 10:12:34','Gorilla','Jump_Around'),(2,'Mike','Male','Move','2018-10-12 10:03:34','Gorilla','Harley_Field'),(3,'Jake','Male','Medicate','2018-10-12 12:03:34','Monkey','Petting_World'),(4,'Jane','Female','Move','2018-10-12 02:03:34','Monkey','Monkey_Business'),(5,'Mary','Female','Feed','2018-10-13 02:03:34','Monkey','Petting_World'),(6,'Joey','Male','Move','2018-10-14 02:03:34','Kangraroo','Monkey_Business');
/*!40000 ALTER TABLE `main_tb` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-22 20:46:29
