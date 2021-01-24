-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: pokemon
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
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `Username` varchar(45) NOT NULL,
  `Password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('admin','admin'),('enzo','pepe'),('Salva','1');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pokemon`
--

DROP TABLE IF EXISTS `pokemon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pokemon` (
  `Numero` int NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Descripcion` varchar(500) DEFAULT NULL,
  `Altura` float DEFAULT NULL,
  `Peso` float DEFAULT NULL,
  `Categoria` varchar(45) DEFAULT NULL,
  `Habilidad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Numero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pokemon`
--

LOCK TABLES `pokemon` WRITE;
/*!40000 ALTER TABLE `pokemon` DISABLE KEYS */;
INSERT INTO `pokemon` VALUES (2,'Ivysaur','Cuando le crece bastante el bulbo del lomo, pierde la capacidad de erguirse sobre las patas traseras.',1,13,'Semilla','Epesura'),(3,'Venusaur','La planta florece cuando absorbe energía solar, lo cual le obliga a buscar siempre la luz del sol.',2,100,'Semilla','Espesura'),(4,'Charmander','Prefiere las cosas calientes. Dicen que cuando llueve le sale vapor de la punta de la cola.',0.6,8.5,'Lagartija','Mar Llamas'),(5,'Charmeleon','Este Pokémon de naturaleza agresiva ataca en combate con su cola llameante y hace trizas al rival con sus afiladas garras.',1.1,19,'Llama','Mar Llamas'),(6,'Charizard','Escupe un fuego tan caliente que funde las rocas. Causa incendios forestales sin querer.',1.7,90.5,'Llama','Mar Llama'),(7,'Squirtle','Cuando retrae su largo cuello en el caparazón, dispara agua a una presión increíble.',0.5,9,'Tortuguita','Torrente'),(8,'Wartortle','Se lo considera un símbolo de longevidad. Los ejemplares más ancianos tienen musgo sobre el caparazón.',1,22.5,'Tortuga','Torrente'),(9,'Blastoise','Para acabar con su enemigo, lo aplasta con el peso de su cuerpo. En momentos de apuro, se esconde en el caparazón.',1.6,85.5,'Armazon','Torrente'),(16,'Pidgey','Su docilidad es tal que suelen defenderse levantando arena en lugar de contraatacar.',0.3,1.8,'Pajarito','Vista lince'),(123,'qwe','23awd',12,21,'wad','wad'),(124,'Scyzor','Un bicho de metal',12123,123,'sda','mj'),(12312,'awq','131awwad',123,31,'awd','awda');
/*!40000 ALTER TABLE `pokemon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pokemon_tipo`
--

DROP TABLE IF EXISTS `pokemon_tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pokemon_tipo` (
  `Numero` int NOT NULL,
  `Codigo_Tipo` int NOT NULL,
  PRIMARY KEY (`Numero`,`Codigo_Tipo`),
  KEY `FK_Tipo_idx` (`Codigo_Tipo`),
  CONSTRAINT `FK_Numero` FOREIGN KEY (`Numero`) REFERENCES `pokemon` (`Numero`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Tipo` FOREIGN KEY (`Codigo_Tipo`) REFERENCES `tipos` (`Codigo_Tipo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pokemon_tipo`
--

LOCK TABLES `pokemon_tipo` WRITE;
/*!40000 ALTER TABLE `pokemon_tipo` DISABLE KEYS */;
INSERT INTO `pokemon_tipo` VALUES (123,1),(124,1),(7,2),(8,2),(9,2),(12312,2),(124,3),(4,7),(5,7),(6,7),(16,11),(2,12),(3,12),(2,17),(3,17),(6,18),(16,18);
/*!40000 ALTER TABLE `pokemon_tipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos`
--

DROP TABLE IF EXISTS `tipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipos` (
  `Codigo_Tipo` int NOT NULL AUTO_INCREMENT,
  `Nombre_Tipo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Codigo_Tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos`
--

LOCK TABLES `tipos` WRITE;
/*!40000 ALTER TABLE `tipos` DISABLE KEYS */;
INSERT INTO `tipos` VALUES (1,'Acero'),(2,'Agua'),(3,'Bicho'),(4,'Dragon'),(5,'Electrico'),(6,'Fantasma'),(7,'Fuego'),(8,'Hada'),(9,'Hielo'),(10,'Lucha'),(11,'Normal'),(12,'Planta'),(13,'Psiquico'),(14,'Roca'),(15,'Siniestro'),(16,'Tierra'),(17,'Veneno'),(18,'Volador');
/*!40000 ALTER TABLE `tipos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-24 22:18:33
