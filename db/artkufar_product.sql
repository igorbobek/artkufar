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
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `image` longtext NOT NULL,
  `price` int(11) NOT NULL,
  `description` longtext,
  `id_artist` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_artist_PR_idx` (`id_artist`),
  CONSTRAINT `id_artist_PR` FOREIGN KEY (`id_artist`) REFERENCES `artist` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (25,'sdfsfdghs','fghsfghsfgh',123,'sfghsfgh',NULL),(26,'asdfasdfasdf','asdfasdfasdf',123123,'afasdf',NULL),(27,'asasasdads','123',1231,'asdasdads',NULL),(28,'asdasd','asdasd',123,'asd',NULL),(29,'adfasdf','asdfasdf',123123,'123',NULL),(30,'Лавандовое поле','https://artcenter.s3.eu-central-1.amazonaws.com/base/users/1315/works/iVxBRqHALd.jpg',12323,'картина на холсте, картина маслом, лаванда, картина мастихином, мастихин, мастихиновая техника, лавандовоеполе, подарок, лето, яркая картина, фиолетовый, для интерьера, интерьерная картина, интерьерная живопись, пейзаж',14),(31,'Яблоневый сад','https://artcenter.s3.eu-central-1.amazonaws.com/base/users/1287/works/KF3NJfaEWG.jpg',11111,'ШИКАРНО',15),(32,'Цветок','https://artcenter.s3.eu-central-1.amazonaws.com/base/users/1315/works/p4NTRoui9v.png',10000,'картина, интерьерные картины, интерьерная живопись, предмет интерьера, картина на холсте, картина в интерьер, картина абстрактная, картина акрилом, абстракция, цветок, голубой, серебро',14);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-14  1:12:30
