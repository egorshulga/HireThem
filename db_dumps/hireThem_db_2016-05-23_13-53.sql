-- MySQL dump 10.13  Distrib 5.7.11, for Win64 (x86_64)
--
-- Host: localhost    Database: hire_them
-- ------------------------------------------------------
-- Server version	5.7.11-log

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
-- Table structure for table `educations`
--

DROP TABLE IF EXISTS `educations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `educations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` text,
  `university` varchar(255) NOT NULL,
  `specialty` varchar(255) DEFAULT NULL,
  `degree` varchar(255) DEFAULT NULL,
  `end_date` varchar(255) DEFAULT NULL,
  `start_date` varchar(255) DEFAULT NULL,
  `resume_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IXFK_educations_resumes` (`resume_id`),
  CONSTRAINT `FK_educations_resumes` FOREIGN KEY (`resume_id`) REFERENCES `resumes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKo2o6l2a14fq9hkoo9io2st374` FOREIGN KEY (`resume_id`) REFERENCES `resumes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=222 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `educations`
--

LOCK TABLES `educations` WRITE;
/*!40000 ALTER TABLE `educations` DISABLE KEYS */;
/*!40000 ALTER TABLE `educations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resumes`
--

DROP TABLE IF EXISTS `resumes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resumes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `summary` text NOT NULL,
  `description` text,
  `skills` text,
  `interests` text,
  `references` text,
  PRIMARY KEY (`id`),
  KEY `IXFK_resume_user` (`employee_id`),
  CONSTRAINT `FK_resume_user` FOREIGN KEY (`employee_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKfqdp8jg2h4dlitiiomlc8yg7m` FOREIGN KEY (`employee_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=965 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resumes`
--

LOCK TABLES `resumes` WRITE;
/*!40000 ALTER TABLE `resumes` DISABLE KEYS */;
/*!40000 ALTER TABLE `resumes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `user_type` enum('EMPLOYEE','EMPLOYER') NOT NULL DEFAULT 'EMPLOYEE',
  `encrypted_password` blob NOT NULL,
  `password_salt` blob NOT NULL,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `about` text,
  `contact_info` varchar(255) DEFAULT ' ',
  `avatar` longblob,
  `is_admin` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `IX_email_user_type` (`email`,`user_type`),
  KEY `IX_surname` (`surname`),
  KEY `IX_user_type` (`user_type`),
  KEY `IX_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (2,'scrilan@gmail.com','EMPLOYER','ÔøΩ(ÔøΩÔøΩÔøΩ∆ÜÔøΩÔøΩ;CÔøΩÔøΩfÔøΩÔøΩÔøΩ','*\nÔøΩ(ÔøΩ','Egor','Shulga','','Mobile phone: +375 44 763-41-70Home e-mail: egorshulga@outlook.comSkype: scrilanTelegram: @egorshulga',NULL,1),(3,'upyachka@gmail.com','EMPLOYEE','.ÔøΩ#}ÔøΩÔøΩÔøΩaÔøΩudun‹äÔøΩ~','wÔøΩÔøΩ:ÔøΩF)','–ü–æ–ø—è—á—Å–∞','–ü–æ–ø—è—á—Å–æ','','',NULL,0),(4,'banan@ana.com','EMPLOYER','ÔøΩÔøΩmÔøΩÔøΩ^^XÔøΩ`jÔøΩÔøΩNÔøΩyÔøΩ','x6ÔøΩÔøΩ:jÔøΩÔøΩ','Mr','Bananana','','',NULL,0),(5,'scrilan@gmail.com','EMPLOYEE','¸>|ê¸OZÿå√•£ö.Zèí\ÿ','j\«Véå™\¬','Egor','Shulga','','telegram @egorshulga',NULL,1),(7,'hjdsf@mail.com','EMPLOYEE',',ARj@\n_õOWƒ°â$\ ﬁ≤\”','x\‹{\‚\÷\…Ò','MEFODY','dark','','',NULL,0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vacancies`
--

DROP TABLE IF EXISTS `vacancies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vacancies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employer_id` int(11) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `summary` text NOT NULL,
  `description` text,
  `salary` text,
  `required_experience` text,
  `required_skills` text,
  PRIMARY KEY (`id`),
  KEY `IXFK_vacancy_user` (`employer_id`),
  CONSTRAINT `FK_vacancy_user` FOREIGN KEY (`employer_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKpixydo9jsh8rxduhkccb326y6` FOREIGN KEY (`employer_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=412 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vacancies`
--

LOCK TABLES `vacancies` WRITE;
/*!40000 ALTER TABLE `vacancies` DISABLE KEYS */;
INSERT INTO `vacancies` VALUES (166,2,'Software Engineer','Web Development','Learn Web Development best practices and get your career started',NULL,'Bachelor\'s degree in computer science or related discipline is preferable\r\nDeep knowledge and development experience of Web service platforms and middle tier technologies','Strong analytical and problem solving skills\r\nExtensive  web service platform experience\r\nGit, Stash\r\nJava, J2EE, Maven'),(392,2,'Scientist','Nuclear physics','Interesting work at Large Hadron Collider.',NULL,NULL,'R, C++, fastjet, pythia'),(394,4,'Banan','Wow, such bananas','Pick bananas','Loads of bananas','100500 bananas','Banana');
/*!40000 ALTER TABLE `vacancies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_experiences`
--

DROP TABLE IF EXISTS `work_experiences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work_experiences` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(255) NOT NULL,
  `position` varchar(255) NOT NULL,
  `start_date` varchar(255) DEFAULT NULL,
  `end_date` varchar(255) DEFAULT NULL,
  `description` text,
  `resume_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IXFK_work_experiences_resumes` (`resume_id`),
  KEY `IX_organization` (`company_name`),
  CONSTRAINT `FK_work_experiences_resumes` FOREIGN KEY (`resume_id`) REFERENCES `resumes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKlan3wij52dk67mbv21koxmqnw` FOREIGN KEY (`resume_id`) REFERENCES `resumes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=236 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_experiences`
--

LOCK TABLES `work_experiences` WRITE;
/*!40000 ALTER TABLE `work_experiences` DISABLE KEYS */;
/*!40000 ALTER TABLE `work_experiences` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-23 13:53:43
