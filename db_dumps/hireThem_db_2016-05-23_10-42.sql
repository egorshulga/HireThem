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
) ENGINE=InnoDB AUTO_INCREMENT=221 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `educations`
--

LOCK TABLES `educations` WRITE;
/*!40000 ALTER TABLE `educations` DISABLE KEYS */;
INSERT INTO `educations` VALUES (90,NULL,'Belarusian State University of Informatics and Radioelectronics','Information Technologies Software','student','2017-06-30','2013-09-01',475),(211,NULL,'MIT','Philosophy','bachelor','2016-05-20','2016-05-01',932),(212,'','MIT','Philosophy','bach elor','2016-05-20','2016-05-01',475);
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
) ENGINE=InnoDB AUTO_INCREMENT=964 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resumes`
--

LOCK TABLES `resumes` WRITE;
/*!40000 ALTER TABLE `resumes` DISABLE KEYS */;
INSERT INTO `resumes` VALUES (475,1,'C/C++/C#/Web programmer.\r\nHas a good operational command of an English language.',NULL,'C/C++, C#, Java, Delphi, Assembler i80x86, HTML, PHP','Foreign languages','Nikita Dubko mefody93@gmail.com'),(932,1,'PHP programmer','Once had some experience of php coding','PHP','PHP',NULL),(933,1,'Great team lead for your project.\r\nFuck up the terms, money - all of this you can achieve with me!',', ','Communicatons, leading, crew organizing','Failing projects','Nikita Dubko');
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
INSERT INTO `users` VALUES (1,'scrilan@gmail.com','EMPLOYEE','̙;}hRX�����{���','m����N�','Egor','Shulga','Leader of the team developing HireThem','telegram: @egorshulga',NULL,1),(2,'scrilan@gmail.com','EMPLOYER','�(���Ɔ��;C��f���','*\n�(�','Egor','Shulga','','Mobile phone: +375 44 763-41-70\r\nHome e-mail: egorshulga@outlook.com\r\nSkype: scrilan\r\nTelegram: @egorshulga','�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0�\0\0\0�\0\0\0��g-\0\0\0	pHYs\0\0\0\0\0��\0\0\nOiCCPPhotoshop ICC profile\0\0xڝSgTS�=���BK���KoR RB���&*!	J�!��Q�EEȠ�����Q,�\n��!���������{�kּ������>�����H3Q5��B�������.@�\n$p\0�d!s�#\0�~<<+\"��\0x�\0�M��0���B�\\���t�8K�\0@z�B�\0@F���&S\0�\0`�cb�\0P-\0`\'��\0����{\0[�!��\0 e�D\0h;\0��V�E\0X0\0fK�9\0�-\00IWfH\0��\0���\0\00Q��)\0{\0`�##x\0��\0F�W<�+��*\0\0x��<�$9E�[-qWW.(�I+6aa�@.�y�2�4���\0\0������x����6��_-��\"bb���ϫp@\0\0�t~��,/�\Z�;�m��%�h^�u��f�@�\0���W�p�~<<E���������J�B[a�W}�g�_�W�l�~<�����$�2]�G�����L�ϒ	�b��G�����\"�Ib�X*�Qq�D���2�\"�B�)�%��d��,�>�5\0�j>{�-�]c�K\'Xt���\0\0�o��(�h���w��?�G�%\0�fI�q\0\0^D$.Tʳ?�\0\0D��*�A��,�����`6�B$��BB\nd�r`)��B(�Ͱ*`/�@4�Qh��p.�U�=p�a��(��	A�a!ڈb�X#����!�H�$ ɈQ\"K�5H1R�T UH�=r9�\\F��;�\02����G1���Q=��C��7\Z�F��dt1�����r�\Z=�6��Ыhڏ>C�0��3�l0.��B�8,	�c˱\"���\Z�V����cϱw�E�	6wB aAHXLXN�H� $4�	7	�Q�\'\"��K�&���b21�XH,#��/{�C�7$�C2\'��I��T��F�nR#�,��4H\Z#���dk�9�, +ȅ����3��!�[\n�b@q��S�(R�jJ��4�e�2AU��Rݨ�T5�ZB���R�Q��4u�9̓IK�����\Zhh�i��t�ݕN��W���G���w\r��ǈg(�gw��L�Ӌ�T071���oUX*�*|��\n�J�&�*/T����ުU�U�T��^S}�FU3S�	Ԗ�U��P�SSg�;���g�oT?�~Y��Y�L�OC�Q��_�� c�x,!k\r��u�5�&���|v*�����=���9C3J3W�R�f?�q��tN	�(���~���)�)�4L�1e\\k����X�H�Q�G�6����E�Y��A�J\'\\\'Gg����S�Sݧ\n�M=:��.�k���Dw�n��^��Lo��y���}/�T�m���GX�$��<�5qo</���QC]�@C�a�a�ᄑ��<��F�F�i�\\�$�m�mƣ&&!&KM�M�RM��)�;L;L���͢�֙5�=1�2��כ߷`ZxZ,����eI��Z�Yn�Z9Y�XUZ]�F���%ֻ�����N�N���gð�ɶ�����ۮ�m�}agbg�Ů��}�}��=\r���Z~s�r:V:ޚΜ�?}����/gX���3��)�i�S��Ggg�s�󈋉K��.�>.���Ƚ�Jt�q]�z��������ۯ�6�i�ܟ�4�)�Y3s���C�Q��?��0k߬~OCO�g��#/c/�W�װ��w��a�>�>r��>�<7�2�Y_�7��ȷ�O�o�_��C#�d�z��\0��%g��A�[��z|!��?:�e����A���AA�������!h�쐭!��Α�i�P~���a�a��~\'���W�?�p�X\Z�1�5w��Cs�D�D�Dޛg1O9�-J5*>�.j<�7�4�?�.fY��X�XIlK9.*�6nl��������{�/�]py�����.,:�@L�N8��A*��%�w%�\ny��g\"/�6ш�C\\*N�H*Mz�쑼5y$�3�,幄\'���L\rLݛ:��v m2=:�1����qB�!M��g�g�fvˬe����n��/��k���Y-\n�B��TZ(�*�geWf�͉�9���+��̳�ې7�����ᒶ��KW-X潬j9�<qy�\n�+�V�<���*m�O��W��~�&zMk�^�ʂ��k�U\n�}����]OX/Yߵa���>������(�x��oʿ�ܔ���Ĺd�f�f���-�[����n\r�ڴ\r�V����E�/��(ۻ��C���<��e����;?T�T�T�T6��ݵa��n��{��4���[���>ɾ�UUM�f�e�I���?�������m]�Nmq����#�׹���=TR��+�G�����w-\r6\rU����#pDy���	��\r:�v�{���vg/jB��F�S��[b[�O�>����z�G��4<YyJ�T�i��ӓg�ό���}~.��`ۢ�{�c��jo�t��E���;�;�\\�t���W�W��:_m�t�<���Oǻ�����\\k��z��{f���7����y���՞9=ݽ�zo������~r\'��˻�w\'O�_�@�A�C݇�?[�����j�w����G��������C���ˆ\r��8>99�?r����C�d�&����ˮ/~�����јѡ�򗓿m|������������x31^�V���w�w��O�| (�h���SЧ��������c3-�\0\0\0 cHRM\0\0z%\0\0��\0\0��\0\0��\0\0u0\0\0�`\0\0:�\0\0o�_�F\0\0�IDATx���OL�w��OA�+s2J�Cp�l��E���X͜��e��vZ��X��D��Yv��Lf�I���:��d�,�t�S)-���L���aّ�	�������=���).cL�$����1�1��h�rc����<H\0$\0�\0H@ \0	�D\0$\0�\0H@ \0	�D\0$\0�\0H@ \0	�D\0$\0�\0H@ \0	�@\0\0	�D\0$\0�\0H@ \0	�D\0$\0�\0h_8V<Wff��l2�����URR\"��5�\\4\Z�P$�yYY�7`������\"���L:������!�|oIrIJ$Z������ٽ�)*�Lj�ҥr������\\�PH��q6\Z����R�ܺe�_?���+^�󃛘��Ȉ._��-UU��uuvjCE�r�neeg�^3��ң�}VS�S�ͳz�S��,\rD\"���;�����F($o~��ldhH������۶p��1>r$�kNLL(62�k׮�j��I�:C!U����v+�����@$��}��|���^�TdY�\"�����ڱsgz�ܴI���:����L�����Р��z�V\\����a���\\Y9�\\wW��lޜ2��t`�~565���O�G���M�m�@\0�\0 \0@\0�\0 \0@\0�\0�M\0�\\�Rw��K�y�`�v��~�\'Oj����}�{7\0�	�G���;zi�b�{UQq�N44خ���E�?^��|ɘg\Z������f�Z\0���-c���\0��\0@\0�\0 \0@\0��\0h��Ni�+\0����O�����.q��\'c�Œ����W�&雳gu��������dR����κu��s\r��U����r2\n�u܊(�����{���y��^\'\Z\Z����ẍ́e�Hj�}��h�l�T����Z�u~-3�*��-}�y��X?\0@\0�\0 \0@\0�\0 \0@\0�\0 \0@\0�\0 \0�9\rp��e)m@,S��\r�\0�\Z�u��j������N��@\0����G���Z�`��5-c�H$�m�6-��0\00e��\"\0�\0 \0@\0�\0 \0@\0�\0 \0@\0�\0 \0@\0�\0 \08y[|>������0e��Ќ\0���Lཾ>���j��>�`�M-*|\n��˶\0�������%%)��bs�+V��ޔ����v�?\\��\r7>��|�g�Ξ;g;��uz�ۥ��x����S�O�x��W�S���֖�ܵk�<�Ԥ�r.t�����zu�Сi�w��N57+;+K�23O�ѱ1�|>UWW���j�Z��>e/�u��D��r��Zs��v�W�^UۥK�u;o�eY����ݻW�JK�@\"\0\0�\0H\0$ ��@ \0	�@\0\0	�D\0$\0�\0H@ \0	�D\0$\0�\0H@ \0	�D\0$\0�\0H@ \0	�D\0$\0�\0H\0 �\0H@ ��4<��\\Ƙ~N@����\0�%��)��\0\0\0\0IEND�B`�',1),(3,'upyachka@gmail.com','EMPLOYEE','.�#}���a�udun܊�~','w��:�F)','Попячса','Попячсо','','',NULL,1),(4,'banan@ana.com','EMPLOYER','��m��^^X�`j��N�y�','x6��:j��','Mr','Bananana',NULL,NULL,NULL,0);
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
INSERT INTO `vacancies` VALUES (166,2,'Software Engineer','Web Development','Learn Web Development best practices and get your career started',NULL,'Bachelor\'s degree in computer science or related discipline is preferable\r\nDeep knowledge and development experience of Web service platforms and middle tier technologies','Strong analytical and problem solving skills\r\nExtensive  web service platform experience\r\nGit, Stash\r\nJava, J2EE, Maven'),(392,2,'Scientist','Nuclear physics','Interesting work at Large Hadron Collider.',NULL,NULL,'R, C++, fastjet, pythia'),(394,4,'Banan','Wow, such bananas','Pick bananas','Loads of bananas','100500 bananas','Banana'),(411,1,'VACANCY title','VACANCY summary','VACANCY description','extraodinary salary','none of experience','loads skills');
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
) ENGINE=InnoDB AUTO_INCREMENT=235 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_experiences`
--

LOCK TABLES `work_experiences` WRITE;
/*!40000 ALTER TABLE `work_experiences` DISABLE KEYS */;
INSERT INTO `work_experiences` VALUES (89,'Joint Insitute for Nuclear Research','assistant','2015-07-01','2015-09-01',NULL,475),(225,'EPAM','junior developer','2016-05-01','2016-05-31','',475);
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

-- Dump completed on 2016-05-23 10:42:26
