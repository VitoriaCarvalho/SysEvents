-- MySQL dump 10.13  Distrib 5.7.24, for Linux (x86_64)
--
-- Host: localhost    Database: SysEvents
-- ------------------------------------------------------
-- Server version	5.7.24-0ubuntu0.18.04.1

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
-- Table structure for table `eventos`
--

DROP TABLE IF EXISTS `eventos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eventos` (
  `codEvento` varchar(5) NOT NULL,
  `titulo` varchar(50) DEFAULT NULL,
  `dataEvento` varchar(10) DEFAULT NULL,
  `valorInscricao` varchar(10) DEFAULT NULL,
  `descricao` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`codEvento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventos`
--

LOCK TABLES `eventos` WRITE;
/*!40000 ALTER TABLE `eventos` DISABLE KEYS */;
INSERT INTO `eventos` VALUES ('0101','Teste','10/10/2019','25','Evento teste'),('1201','Geek day','10/10/2018','15.90','Um evento bem legal'),('7548','Dia do esporte','10/12/2018','50','Evento de esporte'),('9596','SINFO','10/10/2018','15','Simpósio de Sistemas de Informação');
/*!40000 ALTER TABLE `eventos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscricao_minic_particip`
--

DROP TABLE IF EXISTS `inscricao_minic_particip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inscricao_minic_particip` (
  `codEvento` varchar(5) NOT NULL,
  `codMinicurso` varchar(5) NOT NULL,
  `cpfParticipante` varchar(11) NOT NULL,
  PRIMARY KEY (`codEvento`,`codMinicurso`,`cpfParticipante`),
  KEY `fk_codMinicurso` (`codMinicurso`),
  KEY `fk_cpfParticipanteMinic` (`cpfParticipante`),
  CONSTRAINT `fk_codEventoMinic1` FOREIGN KEY (`codEvento`) REFERENCES `eventos` (`codEvento`),
  CONSTRAINT `fk_codMinicurso` FOREIGN KEY (`codMinicurso`) REFERENCES `minicursos` (`codMinicurso`),
  CONSTRAINT `fk_cpfParticipanteMinic` FOREIGN KEY (`cpfParticipante`) REFERENCES `usuarios` (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscricao_minic_particip`
--

LOCK TABLES `inscricao_minic_particip` WRITE;
/*!40000 ALTER TABLE `inscricao_minic_particip` DISABLE KEYS */;
INSERT INTO `inscricao_minic_particip` VALUES ('7548','3096','11111111111');
/*!40000 ALTER TABLE `inscricao_minic_particip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscricoes`
--

DROP TABLE IF EXISTS `inscricoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inscricoes` (
  `codInscricao` varchar(5) NOT NULL,
  `codEvento` varchar(5) NOT NULL,
  `cpfParticipante` varchar(11) NOT NULL,
  PRIMARY KEY (`codInscricao`),
  KEY `fk_codEvento` (`codEvento`),
  KEY `fk_cpfParticipante` (`cpfParticipante`),
  CONSTRAINT `fk_codEvento` FOREIGN KEY (`codEvento`) REFERENCES `eventos` (`codEvento`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cpfParticipante` FOREIGN KEY (`cpfParticipante`) REFERENCES `usuarios` (`cpf`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscricoes`
--

LOCK TABLES `inscricoes` WRITE;
/*!40000 ALTER TABLE `inscricoes` DISABLE KEYS */;
INSERT INTO `inscricoes` VALUES ('5482','1201','11111111111'),('6052','1201','05173598395'),('6431','7548','05173598395'),('6573','7548','11111111111'),('9341','1201','11111111111'),('9494','1201','12345');
/*!40000 ALTER TABLE `inscricoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `minicursos`
--

DROP TABLE IF EXISTS `minicursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `minicursos` (
  `codMinicurso` varchar(5) NOT NULL,
  `codEvento` varchar(5) NOT NULL,
  `tituloMinicurso` varchar(50) DEFAULT NULL,
  `dataMinicurso` varchar(10) DEFAULT NULL,
  `horarioMinicurso` varchar(5) DEFAULT NULL,
  `valorMinicurso` varchar(10) DEFAULT NULL,
  `ministrante` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codMinicurso`),
  KEY `fk_codEventoMinic` (`codEvento`),
  CONSTRAINT `fk_codEventoMinic` FOREIGN KEY (`codEvento`) REFERENCES `eventos` (`codEvento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `minicursos`
--

LOCK TABLES `minicursos` WRITE;
/*!40000 ALTER TABLE `minicursos` DISABLE KEYS */;
INSERT INTO `minicursos` VALUES ('100','1201','Programação Funcional','12/12/2018','12:00','12','Pedro'),('3096','7548','9','9','9','9','9'),('8851','9596','Python para iniciantes','10/10/2018','14:00','10','Hélio Gás');
/*!40000 ALTER TABLE `minicursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `nome` varchar(50) DEFAULT NULL,
  `cpf` varchar(11) NOT NULL,
  `dataNasc` varchar(10) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `senha` varchar(10) DEFAULT NULL,
  `endereco` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('Vitória','05173598395','29/11/1998','vitoriiacb@gmail.com','123','Campo Grande'),('Joãozinho','11111111111','10/12/2002','joaozinho@gmail.com','123','THE'),('Ruthe','12345','26/09/2000','ruthe@gmail.com','123','Campo Grande - PI'),('Administrador','12345678910','01/01/1980','admin@gmail.com','123','Picos');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-05 14:55:50
