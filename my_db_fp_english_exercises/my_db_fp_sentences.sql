-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: my_db_fp
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `sentences`
--

DROP TABLE IF EXISTS `sentences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sentences` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sentence` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `hint` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `exercise_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `exercise_id` (`exercise_id`),
  CONSTRAINT `sentences_ibfk_1` FOREIGN KEY (`exercise_id`) REFERENCES `exercises` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=140 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sentences`
--

LOCK TABLES `sentences` WRITE;
/*!40000 ALTER TABLE `sentences` DISABLE KEYS */;
INSERT INTO `sentences` VALUES (101,'My name /{is}/ Adam.','to be',63),(102,'I /{like}/ cats and he /{likes}/ dogs.','to like',63),(103,'You /{speak}/ English very well.','to speak',63),(104,'It /{costs}/ a lot of money.','to cost',63),(105,'They /{live}/ in Paris.','to live',63),(106,'Does he /{go}/ to school every day?','to go',64),(107,'Does she /{like}/ coffee?','to like',64),(108,'Does it /{cost}/ a lot of money? ','to cost',64),(109,'Where /{do}/ you /{work}/?','do, to work',64),(110,'How much /{does}/ it cost?','do',64),(111,'I do not /{go}/ to school every day.','to go',65),(112,'We do not /{read}/ books, we /{like}/ moves.','to read, to like',65),(113,'He does not /{read}/ books, he /{likes}/ moves.','to read, to like',65),(114,'You do not/{speak}/ English very well. ','to speak',65),(115,'I /{came}/ to you.','to come',66),(116,'He /{opened}/ the door.','to open',66),(117,'We /{sang}/ and /{danced}/ all night long.','to sing, to dance',66),(118,'She /{played}/ volleyball.','to play',66),(119,'He /{did}/ his exercises regularly.','to do',66),(120,'Did you /{go}/ to cinema yesterday?','to go',67),(121,'Did you /{hear}/ the news?','to hear',67),(122,'I /{was}/ at home when it /{happened}/.','to be, to happen',67),(123,'I /{was not}/ at home when it /{happened}/.','to be (negative), to happen',67),(124,'They /{were not}/ in China at all.','to be (negative)',67),(125,'I will /{read}/ an interesting book.','to read',68),(126,'You will /{buy}/ a new dress.','to buy',68),(127,'He will /{play}/ tennis. ','to play',68),(128,'It will /{help}/ you. ','to help',68),(129,'I will not /{go}/ for a walk tomorrow.','to go',69),(130,'The project will not /{be}/ presented next week.','to be',69),(131,'Will I /{go}/ for a walk tomorrow? ','to go',69),(132,'My husband will not /{buy}/ this dress for me.','to buy',69);
/*!40000 ALTER TABLE `sentences` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-14 21:55:59
