-- MariaDB dump 10.19  Distrib 10.4.24-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: reserfasi_tiket_db
-- ------------------------------------------------------
-- Server version	10.4.24-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `film`
--

DROP TABLE IF EXISTS `film`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `film` (
  `kd_film` bigint(20) NOT NULL AUTO_INCREMENT,
  `nm_film` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`kd_film`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `film`
--

LOCK TABLES `film` WRITE;
/*!40000 ALTER TABLE `film` DISABLE KEYS */;
INSERT INTO `film` VALUES (1,'Spiderman','');
/*!40000 ALTER TABLE `film` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jadwal`
--

DROP TABLE IF EXISTS `jadwal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jadwal` (
  `id_jadwal` bigint(20) NOT NULL AUTO_INCREMENT,
  `hg_tiket` decimal(19,2) DEFAULT NULL,
  `id_studio` bigint(20) DEFAULT NULL,
  `jm_mulai` time DEFAULT NULL,
  `jm_selesai` time DEFAULT NULL,
  `kd_film` bigint(20) DEFAULT NULL,
  `tgl_tayang` date DEFAULT NULL,
  PRIMARY KEY (`id_jadwal`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jadwal`
--

LOCK TABLES `jadwal` WRITE;
/*!40000 ALTER TABLE `jadwal` DISABLE KEYS */;
INSERT INTO `jadwal` VALUES (1,30000.00,1,'17:00:00','18:00:00',1,'2022-04-27');
/*!40000 ALTER TABLE `jadwal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kursi`
--

DROP TABLE IF EXISTS `kursi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kursi` (
  `id_jadwal` bigint(20) NOT NULL,
  `no_kursi` int(11) NOT NULL,
  `id_nota` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_jadwal`,`no_kursi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kursi`
--

LOCK TABLES `kursi` WRITE;
/*!40000 ALTER TABLE `kursi` DISABLE KEYS */;
INSERT INTO `kursi` VALUES (1,1,1),(1,2,1),(1,3,1);
/*!40000 ALTER TABLE `kursi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nota`
--

DROP TABLE IF EXISTS `nota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nota` (
  `id_nota` bigint(20) NOT NULL,
  `bayar` decimal(19,2) DEFAULT NULL,
  `id_user` bigint(20) DEFAULT NULL,
  `total` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id_nota`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nota`
--

LOCK TABLES `nota` WRITE;
/*!40000 ALTER TABLE `nota` DISABLE KEYS */;
INSERT INTO `nota` VALUES (1,50000.00,2,30000.00);
/*!40000 ALTER TABLE `nota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studio`
--

DROP TABLE IF EXISTS `studio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `studio` (
  `id_studio` bigint(20) NOT NULL AUTO_INCREMENT,
  `kursi` int(11) DEFAULT NULL,
  `studio` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_studio`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studio`
--

LOCK TABLES `studio` WRITE;
/*!40000 ALTER TABLE `studio` DISABLE KEYS */;
INSERT INTO `studio` VALUES (1,30,'Studio A');
/*!40000 ALTER TABLE `studio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id_user` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin@gmail.com','admin','ADMIN','admin'),(2,'Customer@gmail.com','customer','CUSTOMER','customer');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `vw_jadwal`
--

DROP TABLE IF EXISTS `vw_jadwal`;
/*!50001 DROP VIEW IF EXISTS `vw_jadwal`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vw_jadwal` (
  `id_jadwal` tinyint NOT NULL,
  `kd_film` tinyint NOT NULL,
  `id_studio` tinyint NOT NULL,
  `film` tinyint NOT NULL,
  `tiket` tinyint NOT NULL,
  `tanggal` tinyint NOT NULL,
  `mulai` tinyint NOT NULL,
  `selesai` tinyint NOT NULL,
  `studio` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vw_nota`
--

DROP TABLE IF EXISTS `vw_nota`;
/*!50001 DROP VIEW IF EXISTS `vw_nota`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vw_nota` (
  `id_jadwal` tinyint NOT NULL,
  `no_kursi` tinyint NOT NULL,
  `id_nota` tinyint NOT NULL,
  `username` tinyint NOT NULL,
  `nm_film` tinyint NOT NULL,
  `studio` tinyint NOT NULL,
  `tgl_tayang` tinyint NOT NULL,
  `jm_mulai` tinyint NOT NULL,
  `jm_selesai` tinyint NOT NULL,
  `hg_tiket` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `vw_jadwal`
--

/*!50001 DROP TABLE IF EXISTS `vw_jadwal`*/;
/*!50001 DROP VIEW IF EXISTS `vw_jadwal`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_unicode_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_jadwal` AS select `j`.`id_jadwal` AS `id_jadwal`,`f`.`kd_film` AS `kd_film`,`s`.`id_studio` AS `id_studio`,`f`.`nm_film` AS `film`,`j`.`hg_tiket` AS `tiket`,`j`.`tgl_tayang` AS `tanggal`,`j`.`jm_mulai` AS `mulai`,`j`.`jm_selesai` AS `selesai`,`s`.`studio` AS `studio` from ((`film` `f` join `jadwal` `j`) join `studio` `s`) where `f`.`kd_film` = `j`.`kd_film` and `s`.`id_studio` = `j`.`id_studio` and `f`.`status` = 1 */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_nota`
--

/*!50001 DROP TABLE IF EXISTS `vw_nota`*/;
/*!50001 DROP VIEW IF EXISTS `vw_nota`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_unicode_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_nota` AS select `j`.`id_jadwal` AS `id_jadwal`,`k`.`no_kursi` AS `no_kursi`,`n`.`id_nota` AS `id_nota`,`u`.`username` AS `username`,`f`.`nm_film` AS `nm_film`,`s`.`studio` AS `studio`,`j`.`tgl_tayang` AS `tgl_tayang`,`j`.`jm_mulai` AS `jm_mulai`,`j`.`jm_selesai` AS `jm_selesai`,`j`.`hg_tiket` AS `hg_tiket` from (((((`jadwal` `j` join `kursi` `k`) join `film` `f`) join `studio` `s`) join `nota` `n`) join `users` `u`) where `n`.`id_user` = `u`.`id_user` and `n`.`id_nota` = `k`.`id_nota` and `k`.`id_jadwal` = `j`.`id_jadwal` and `j`.`id_studio` = `s`.`id_studio` and `j`.`kd_film` = `f`.`kd_film` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-21 13:51:55
