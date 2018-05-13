-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: artkufar
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` longtext NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `id_artist` int(11) DEFAULT NULL,
  `id_buyer` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `id_artist_UNIQUE` (`id_artist`),
  UNIQUE KEY `id_buyer_UNIQUE` (`id_buyer`),
  KEY `id_artist_U_idx` (`id_artist`),
  CONSTRAINT `id_artist_U` FOREIGN KEY (`id_artist`) REFERENCES `artist` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `id_buyer_U` FOREIGN KEY (`id_buyer`) REFERENCES `buyer` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (6,'Frenzi','$2a$10$bHj.dF/tAsseTpUSjmBw5u.5xLHZ3O00ez8cbLU4l60vdRT1f2/8W','Igor','Bobek','igor@gmail.com',NULL,11),(8,'admin','$2a$10$bHj.dF/tAsseTpUSjmBw5u.5xLHZ3O00ez8cbLU4l60vdRT1f2/8W','admin','admin','admin@admin.admin',NULL,NULL),(17,'frenzi1','$2a$10$sRZRKaNt2zZISCarXhj2FuW9AYzZOA8aOuXLSG7KzNSEM.EaYdaYO','123','123','asd@asdasdasd.ru',14,NULL),(18,'frenzi3','$2a$10$.GuSJrzknlnVzQe6Y.x3Suy3d8RkqC698vC7EzYcMpzc4C79dbCau','Igor','Blabla','igorbla@gmail.com',15,NULL);
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

-- Dump completed on 2018-05-14  1:12:32
