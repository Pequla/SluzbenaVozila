-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: servisno_odrzavanje
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `model`
--

DROP TABLE IF EXISTS `model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `model` (
  `model_id` int unsigned NOT NULL AUTO_INCREMENT,
  `marka` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `tip` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `zapremina` int unsigned NOT NULL,
  `snaga` int unsigned NOT NULL,
  `vrsta_id` int unsigned NOT NULL,
  PRIMARY KEY (`model_id`),
  UNIQUE KEY `model_id_UNIQUE` (`model_id`),
  UNIQUE KEY `tip_UNIQUE` (`tip`),
  KEY `fq_vrsta_model_idx` (`vrsta_id`),
  CONSTRAINT `fk_vrsta_model` FOREIGN KEY (`vrsta_id`) REFERENCES `vrsta` (`vrsta_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `model`
--

LOCK TABLES `model` WRITE;
/*!40000 ALTER TABLE `model` DISABLE KEYS */;
INSERT INTO `model` VALUES (1,'FIAT','TIPO 1.6MJTD',1596,88,1),(2,'FIAT','PANDA 1.3MJTD',1248,59,2),(3,'FAIT','PUNTO VAN 1.2',1242,44,3),(4,'FIAT','DUCATO 2.3MJTD',2287,88,4),(5,'MERCEDES BENZ','ATEGO 1318',4249,130,5),(6,'MERCEDES BENZ','CITAN 1.5CDI',1461,82,3);
/*!40000 ALTER TABLE `model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `putni_nalog`
--

DROP TABLE IF EXISTS `putni_nalog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `putni_nalog` (
  `nalog_id` int unsigned NOT NULL AUTO_INCREMENT,
  `vozilo_id` int unsigned NOT NULL,
  `zaposleni_id` int unsigned NOT NULL,
  `km` int unsigned NOT NULL,
  `datum` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`nalog_id`),
  UNIQUE KEY `nalog_id_UNIQUE` (`nalog_id`),
  KEY `vozilo_id_idx` (`vozilo_id`),
  KEY `zaposleni_id_idx` (`zaposleni_id`),
  CONSTRAINT `fk_vozilo_nalog` FOREIGN KEY (`vozilo_id`) REFERENCES `vozilo` (`vozilo_id`),
  CONSTRAINT `fk_zaposleni_nalog` FOREIGN KEY (`zaposleni_id`) REFERENCES `zaposleni` (`zaposleni_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `putni_nalog`
--

LOCK TABLES `putni_nalog` WRITE;
/*!40000 ALTER TABLE `putni_nalog` DISABLE KEYS */;
INSERT INTO `putni_nalog` VALUES (1,2,1,14000,'2020-02-03 14:42:59'),(2,2,3,70000,'2021-06-03 14:42:59'),(3,1,2,115,'2021-01-02 14:42:59'),(4,1,4,41000,'2021-06-03 14:42:59'),(5,12,3,300000,'2021-06-03 15:52:34'),(6,12,4,340000,'2021-06-03 15:52:34'),(7,2,3,114300,'2021-06-04 15:16:48');
/*!40000 ALTER TABLE `putni_nalog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `radionica`
--

DROP TABLE IF EXISTS `radionica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `radionica` (
  `radionica_id` int unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `pib` int unsigned NOT NULL,
  `adresa` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `mail` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `telefon` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`radionica_id`),
  UNIQUE KEY `radionica_id_UNIQUE` (`radionica_id`),
  UNIQUE KEY `pib_UNIQUE` (`pib`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `radionica`
--

LOCK TABLES `radionica` WRITE;
/*!40000 ALTER TABLE `radionica` DISABLE KEYS */;
INSERT INTO `radionica` VALUES (1,'AK KOLE ZEMUN',100426309,'Cara Dusana 109','info@akole.rs','0113168701'),(2,'AK KOMRESOR',104128245,'Zorza Klemansoa 19','info@akomresor.rs','0112323232'),(3,'MB SCG',100002080,'Omladinskih Brigada 33','info@mbscg.rs','0113019001'),(4,'JEVTOVIC CARS',107591609,'Prislonica bb','office@jevtovicars.co.rs','032301101');
/*!40000 ALTER TABLE `radionica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servis`
--

DROP TABLE IF EXISTS `servis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servis` (
  `servis_id` int unsigned NOT NULL AUTO_INCREMENT,
  `vozilo_id` int unsigned NOT NULL,
  `km` int unsigned NOT NULL,
  `datum` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `usluga_id` int unsigned NOT NULL,
  `radionica_id` int unsigned NOT NULL,
  `iznos` int unsigned NOT NULL,
  PRIMARY KEY (`servis_id`),
  UNIQUE KEY `servis_id_UNIQUE` (`servis_id`),
  KEY `radionica_id_idx` (`radionica_id`),
  KEY `vozilo_id_fq_idx` (`vozilo_id`),
  KEY `fk_usluga_servis_idx` (`usluga_id`),
  CONSTRAINT `fk_radionica_servis` FOREIGN KEY (`radionica_id`) REFERENCES `radionica` (`radionica_id`),
  CONSTRAINT `fk_usluga_servis` FOREIGN KEY (`usluga_id`) REFERENCES `usluga` (`usluga_id`),
  CONSTRAINT `fk_vozilo_servis` FOREIGN KEY (`vozilo_id`) REFERENCES `vozilo` (`vozilo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servis`
--

LOCK TABLES `servis` WRITE;
/*!40000 ALTER TABLE `servis` DISABLE KEYS */;
INSERT INTO `servis` VALUES (1,1,30285,'2021-06-03 13:24:28',2,1,3800),(2,2,17547,'2021-06-03 13:33:49',2,3,4700),(3,3,15110,'2021-06-03 13:33:49',2,1,3900),(4,2,18140,'2021-06-03 13:33:49',6,2,1200),(5,2,31511,'2021-06-03 14:09:06',2,3,4700),(6,2,44578,'2021-06-03 14:12:15',2,3,4700),(7,2,44578,'2021-06-03 14:15:59',3,1,12780),(8,2,45800,'2021-06-03 14:23:25',4,2,3000),(9,12,147000,'2021-06-03 17:04:12',2,3,14900);
/*!40000 ALTER TABLE `servis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usluga`
--

DROP TABLE IF EXISTS `usluga`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usluga` (
  `usluga_id` int unsigned NOT NULL AUTO_INCREMENT,
  `opis` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`usluga_id`),
  UNIQUE KEY `usluga_id_UNIQUE` (`usluga_id`),
  UNIQUE KEY `opis_UNIQUE` (`opis`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usluga`
--

LOCK TABLES `usluga` WRITE;
/*!40000 ALTER TABLE `usluga` DISABLE KEYS */;
INSERT INTO `usluga` VALUES (4,'DOPUNA KLIME'),(6,'ELEKTRICARSKI RADOVI'),(7,'KOMBINOVANO'),(5,'LIMARSKO FARBARSKI RADOVI'),(2,'MALI SERVIS'),(1,'NEPOZNATO'),(3,'VELIKI SERVIS');
/*!40000 ALTER TABLE `usluga` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vozilo`
--

DROP TABLE IF EXISTS `vozilo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vozilo` (
  `vozilo_id` int unsigned NOT NULL AUTO_INCREMENT,
  `registarska_oznaka` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `broj_sasije` varchar(17) COLLATE utf8_unicode_ci NOT NULL,
  `vlasnik` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `godina_proizvodnje` int unsigned NOT NULL,
  `model_id` int unsigned NOT NULL,
  PRIMARY KEY (`vozilo_id`),
  UNIQUE KEY `vozilo_id_UNIQUE` (`vozilo_id`),
  UNIQUE KEY `broj_sasije_UNIQUE` (`broj_sasije`),
  UNIQUE KEY `registarska_oznaka_UNIQUE` (`registarska_oznaka`),
  KEY `fk_model_vozilo_idx` (`model_id`),
  CONSTRAINT `fk_model_vozilo` FOREIGN KEY (`model_id`) REFERENCES `model` (`model_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vozilo`
--

LOCK TABLES `vozilo` WRITE;
/*!40000 ALTER TABLE `vozilo` DISABLE KEYS */;
INSERT INTO `vozilo` VALUES (1,'NS544RA','ZFA35600006C08873','MERCATA',2020,1),(2,'NS119ZP','ZFA35600006G93729','MERCATA',2019,1),(3,'NS101FV','ZFA35600006G68329','MERCATA',2021,1),(4,'NS533AJ','ZFA31200003A29982','MERCATA',2018,2),(5,'NS520HA','ZFA31200003888393','MERCATA',2019,2),(6,'NS361AH','ZFA31200003324214','MERCATA',2020,2),(7,'NS541UT','ZFA18800007043617','MERCATA',2013,3),(8,'NS534SO','ZFA18800007025827','MARCATA',2013,3),(9,'NS093CL','ZFA18800007042000','MERCATA',2013,3),(10,'NS584ZC','ZFA25000002122583','MERCATA',2019,4),(11,'NS110VP','ZFA25000002E56616','MERCATA',2020,4),(12,'NS434VM','ZFA25000002E81820','MERCATA',2021,4),(13,'NS782MV','WDB9700671L336133','MERCATA',2015,5),(14,'NS550TC','WDB9700671L336134','MERCATA',2015,5);
/*!40000 ALTER TABLE `vozilo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vrsta`
--

DROP TABLE IF EXISTS `vrsta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vrsta` (
  `vrsta_id` int unsigned NOT NULL AUTO_INCREMENT,
  `opis` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`vrsta_id`),
  UNIQUE KEY `vrsta_id_UNIQUE` (`vrsta_id`),
  UNIQUE KEY `opis_UNIQUE` (`opis`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vrsta`
--

LOCK TABLES `vrsta` WRITE;
/*!40000 ALTER TABLE `vrsta` DISABLE KEYS */;
INSERT INTO `vrsta` VALUES (5,'KAMION/SLEPER'),(2,'MALO PUTNICKO VOZILO'),(3,'MALO TERETNO VOZILO'),(6,'NEPOZNATO'),(8,'TEST VRSTA PUT'),(1,'VELIKO PUTNICKO VOZILO'),(4,'VELIKO TERETNO VOZILO');
/*!40000 ALTER TABLE `vrsta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zaposleni`
--

DROP TABLE IF EXISTS `zaposleni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zaposleni` (
  `zaposleni_id` int unsigned NOT NULL AUTO_INCREMENT,
  `ime` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `prezime` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `ovlascenje` int unsigned NOT NULL DEFAULT '0',
  `mobilni` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `jmbg` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`zaposleni_id`),
  UNIQUE KEY `zaposleni_id_UNIQUE` (`zaposleni_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zaposleni`
--

LOCK TABLES `zaposleni` WRITE;
/*!40000 ALTER TABLE `zaposleni` DISABLE KEYS */;
INSERT INTO `zaposleni` VALUES (1,'Ljiljana','Buzurovic',0,'0644333775','lbuzovic@company.rs','0801958715202'),(2,'Goran','Dimitrijevic',3,'0612345678','gdimitrijevic@company.rs','1307977710148'),(3,'Boban','Savic',2,'0648752514','bsavic@company.rs','1810969710302'),(4,'Ivica','Kolb',5,'0644598742','ikolb@company.rs','0201968710154'),(5,'Georgios','Papanikolak',1,'063200300','gpapanikolak@company.rs','2206973710696'),(6,'Goran','Kosevic',4,'0655207252','gkosevic@company.rs','1507965710112');
/*!40000 ALTER TABLE `zaposleni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'servisno_odrzavanje'
--

--
-- Dumping routines for database 'servisno_odrzavanje'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-04 15:20:26
