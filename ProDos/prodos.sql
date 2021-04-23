CREATE DATABASE  IF NOT EXISTS `prodos` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `prodos`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: prodos
-- ------------------------------------------------------
-- Server version	5.6.25

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
-- Table structure for table `ciudad`
--

DROP TABLE IF EXISTS `ciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ciudad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `idprovincia` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idprov_ciud_idprov_prov_idx` (`idprovincia`),
  CONSTRAINT `idprov_ciud_idprov_prov` FOREIGN KEY (`idprovincia`) REFERENCES `provincia` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad`
--

LOCK TABLES `ciudad` WRITE;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` VALUES (1,'San Miguel',24),(2,'Mar del Plata',24),(4,'Mendoza',17),(5,'Formosa',8),(6,'San Pablo',15),(7,'asdasd',19),(8,'Ecatep',25);
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `edad` int(11) NOT NULL,
  `numdoc` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `idciudad` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idciu_cli_idciu_ciu_idx` (`idciudad`),
  CONSTRAINT `idciu_cli_idciu_ciu` FOREIGN KEY (`idciudad`) REFERENCES `ciudad` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Luciano',21,'40949030',6),(2,'Mauro',23,'40861004',1),(7,'Juan Pablo',21,'41024622',2);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pais` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(15) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` VALUES (1,'Argentina'),(2,'Brasil'),(3,'Uruguay'),(5,'Peru'),(6,'Venezuela'),(7,'Colombia'),(8,'Ecuador'),(9,'Bolivia'),(10,'Paraguay'),(11,'Mexico'),(12,'Francia');
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) CHARACTER SET latin1 NOT NULL,
  `razonsoc` varchar(40) CHARACTER SET latin1 NOT NULL,
  `cuit` varchar(15) CHARACTER SET latin1 NOT NULL,
  `mail` varchar(45) CHARACTER SET latin1 NOT NULL,
  `telefono` varchar(45) CHARACTER SET latin1 NOT NULL,
  `id_provincia` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idprovincia_proveedor_idprovincia_provincia_idx` (`id_provincia`),
  CONSTRAINT `idprovinvica_proveedor_idprovincia_proveedor` FOREIGN KEY (`id_provincia`) REFERENCES `provincia` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (3,'Serenisima','Mastelone S.A','6546465446','serenisima@gmail.com.ar','1141874475',1),(4,'Sancor ','Soric S.A','4654664','sancor@hotmail.com','1165565465',9);
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provincia`
--

DROP TABLE IF EXISTS `provincia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `provincia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(15) CHARACTER SET latin1 NOT NULL,
  `id_pais` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idpais_pais_idpais_provincia` (`id_pais`),
  CONSTRAINT `idpais_pais_idpais_provincia` FOREIGN KEY (`id_pais`) REFERENCES `pais` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provincia`
--

LOCK TABLES `provincia` WRITE;
/*!40000 ALTER TABLE `provincia` DISABLE KEYS */;
INSERT INTO `provincia` VALUES (1,'Formosa',1),(2,'Tucuman',1),(3,'Brasilia',2),(4,'Montevideo',3),(8,'Formosa',1),(9,'Chubut',1),(10,'Jujuy',1),(11,'Aracaibuo',6),(13,'Cusco',5),(14,'Coscu',5),(15,'ProvBra',2),(16,'Santa Fe',1),(17,'Mendoza',1),(18,'Entre Rios',1),(19,'DF',11),(20,'Paris',12),(23,'Rio negro',1),(24,'Buenos aires',1),(25,'California',11);
/*!40000 ALTER TABLE `provincia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'prodos'
--

--
-- Dumping routines for database 'prodos'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-24 20:41:14
