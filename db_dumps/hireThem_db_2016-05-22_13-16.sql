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
  `end_date` date DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `resume_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IXFK_educations_resumes` (`resume_id`),
  CONSTRAINT `FK_educations_resumes` FOREIGN KEY (`resume_id`) REFERENCES `resumes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKo2o6l2a14fq9hkoo9io2st374` FOREIGN KEY (`resume_id`) REFERENCES `resumes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=213 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `educations`
--

LOCK TABLES `educations` WRITE;
/*!40000 ALTER TABLE `educations` DISABLE KEYS */;
INSERT INTO `educations` VALUES (90,NULL,'Belarusian State University of Informatics and Radioelectronics','Information Technologies Software','student','2017-06-30','2013-09-01',475),(211,NULL,'MIT','Philosophy','bachelor','2016-05-20','2016-05-01',932),(212,NULL,'MIT','Philosophy','bachelor','2016-05-20','2016-05-01',475);
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
) ENGINE=InnoDB AUTO_INCREMENT=933 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resumes`
--

LOCK TABLES `resumes` WRITE;
/*!40000 ALTER TABLE `resumes` DISABLE KEYS */;
INSERT INTO `resumes` VALUES (475,1,'C/C++/C#/Web programmer.\r\nHas a good operational command of an English language.','','C/C++, C#, Java, Delphi, Assembler i80x86, HTML, PHP','Foreign languages','Nikita Dubko mefody93@gmail.com'),(932,1,'PHP programmer','Once had some experience of php coding','PHP','PHP',NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'scrilan@gmail.com','EMPLOYEE','t\äK$ðÒš?Æ°‘@C\ê&4D\Z\Ã','Ã…»ˆ\\À´b','Egor','Shulga','new','new',NULL,0),(2,'scrilan@gmail.com','EMPLOYER','ï¿½(ï¿½ï¿½ï¿½Æ†ï¿½ï¿½;Cï¿½ï¿½fï¿½ï¿½ï¿½','*\nï¿½(ï¿½','Egor','Shulga','','Mobile phone: +375 44 763-41-70\r\nHome e-mail: egorshulga@outlook.com\r\nSkype: scrilan\r\nTelegram: @egorshulga','‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0 \0\0\0 \0\0\0‹\Ïg-\0\0\0	pHYs\0\0\0\0\0šœ\0\0\nOiCCPPhotoshop ICC profile\0\0xÚSgTS\é=÷\ÞôBKˆ€”KoR RB‹€‘&*!	Jˆ!¡\ÙQÁEEÈ ˆŽŽ€ŒQ,Š\n\Ø\ä!¢Žƒ£ˆŠ\Êû\á{£kÖ¼÷\æ\Íþµ\×>\ç¬ó³\ÏÀ–H3Q5€©B\àƒ\Ç\Ä\Æ\á\ä.@\n$p\0³d!sý#\0ø~<<+\"À¾\0x\Ó\0ÀM›À0‡ÿ\êB™\\€„Àt‘8K€\0@zŽB¦\0@F€˜&S\0 \0`\Ëcb\ã\0P-\0`\'\æ\Ó\0€ø™{\0[”! ‘\0 eˆD\0h;\0¬\ÏVŠE\0X0\0fK\Ä9\0\Ø-\00IWfH\0°·\0À\Î²\0\00Qˆ…)\0{\0`\È##x\0„™\0FòW<ñ+®\ç*\0\0x™²<¹$9E[-qWW.(\ÎI+6aaš@.\Ây™24\àó\Ì\0\0 ‘\àƒóýx\Î®\Î\Î6Ž¶_-\ê¿ÿ\"bb\ãþ\åÏ«p@\0\0\át~\Ñþ,/³\Z€;€mþ¢%\îh^ u÷‹f²@µ\0 \é\ÚWópø~<<E¡¹\Ù\Ù\å\ä\ä\ØJ\ÄB[a\ÊW}þg\Â_ÀWýlù~<ü÷õ\à¾\â$2]Gø\à\Â\ÌôL¥Ï’	„b\Ü\æGü·ÿü\Ó\"\ÄIb¹X*\ãQqŽDšŒó2¥\"‰B’)\Å%\Òÿd\â\ß,û>\ß5\0°j>{‘-¨]cöK\'XtÀ\â÷\0\0ò»oÁ\Ô(€hƒ\á\Ïwÿ\ï?ýG %\0€fI’q\0\0^D$.TÊ³?\Ç\0\0D *°AôÁ,ÀÁ\ÜÁü`6„B$\Ä\ÂBB\nd€r`)¬‚B(†Í°*`/\Ô@4ÀQh†“p.\ÂU¸=púažÁ(¼	A\Èa!ÚˆbŠX#Ž™…ø!ÁH‹$ ÉˆQ\"K‘5H1RŠT UHò=r9‡\\Fº‘;\È\02‚ü†¼G1”²Q=\ÔµC¹¨7\Z„F¢\Ðdt1š ›\Ðr´\Z=Œ6¡\çÐ«hÚ>C\Ç0À\è3\Äl0.\Æ\ÃB±8,	“cË±\"¬«\Æ\Z°V¬»‰õcÏ±wEÀ	6wB aAHXLXN\ØH¨ $4\Ú	7	„Q\Â\'\"“¨K´&ºù\Äb21‡XH,#\Ö/{ˆC\Ä7$‰C2\'¹I±¤T\Ò\ÒF\ÒnR#\é,©›4H\Z#“\É\Údk²9”, +È…\ä\ä\Ã\ä3\ä\ä!ò[\nb@q¤øS\â(R\ÊjJ\å\å4\åe˜2AU£šRÝ¨¡T5ZB­¡¶R¯Q‡¨4uš9ÍƒIK¥­¢•\Ó\Zhh÷i¯\ètºÝ•N—\ÐW\Ò\Ë\éG\è—\èôw\r†ƒÇˆg(›gw¯˜L¦Ó‹\ÇT071\ë˜\ç™™oUX*¶*|‘\Ê\n•J•&•*/T©ª¦ªÞªUóU\ËT©^S}®FU3S\ã©	Ô–«UªP\ëSSg©;¨‡ªg¨oT?¤~Yý‰Y\ÃL\ÃOC¤Q ±_\ã¼\Æ c³x,!k\r«†u5\Ä&±\Í\Ù|v*»˜ý»‹=ª©¡9C3J3W³Ró”f?\ã˜qøœtN	\ç(§—ó~Š\Þ\ï)\â)¦4L¹1e\\kª–—–X«H«Q«G\ë½6®í§¦½E»YûA\ÇJ\'\\\'Gg\Î\çS\ÙSÝ§\n§M=:õ®.ªk¥¡»Dw¿n§î˜ž¾^€žLo§\Þy½\çú}/ýTýmú§õGX³$\Û\Î<\Å5qo</\Ç\ÛñQC]\Ã@C¥a•a—á„‘¹\Ñ<£\ÕFFŒi\Æ\\\ã$\ãm\ÆmÆ£&&!&KM\êM\îšRM¹¦)¦;L;L\Ç\Í\ÌÍ¢\ÍÖ™5›=1\×2\ç›\ç›×›ß·`ZxZ,¶¨¶¸eI²\äZ¦Yî¶¼n…Z9Y¥XUZ]³F­­%Ö»­»§§¹N“N«ž\ÖgÃ°ñ¶É¶©·°\å\ØÛ®¶m¶}agbg·Å®\Ãî“½“}º}ý=\r‡\Ù«Z~s´r:V:ÞšÎœ\î?}\Åô–\é/gX\Ï\Ï\Ø3\ã¶\Ë)\ÄiS›\ÓGgg¹sƒóˆ‹‰K‚\Ë.—>.›\Æ\ÝÈ½\äJtõq]\áz\Òõ›³›\Â\í¨Û¯\î6\îi\î‡ÜŸ\Ì4Ÿ)žY3s\Ð\Ã\ÈC\àQ\å\Ñ?Ÿ•0kß¬~OCOgµ\ç#/c/‘W­×°·¥wª÷a\ï>ö>rŸ\ã>\ã<7\Þ2\ÞY_\Ì7À·È·\ËO\Ãož_…\ßC#ÿdÿzÿ\Ñ\0§€%g‰A[ûøz|!¿Ž?:\Ûeö²\Ù\íAŒ ¹AA‚­‚\åÁ­!h\Èì­!÷\ç˜Î‘\Îi…P~\è\Ö\Ða\æa‹\Ã~\'…‡…W†?ŽpˆX\Z\Ñ1—5w\Ñ\ÜCs\ßDúD–DÞ›g1O9¯-J5*>ª.j<\Ú7º4º?\Æ.fY\Ì\ÕXXIlK9.*®6nl¾\ßü\íó‡\â\â\ã{˜/\È]py¡\Î\Âô…§©.,:–@LˆN8”ðA*¨Œ%òw%Ž\ny\Â\Âg\"/\Ñ6Ñˆ\ØC\\*NòH*Mz’ì‘¼5y$\Å3¥,å¹„\'©¼L\rLÝ›:žšv m2=:½1ƒ’‘qBª!M“¶g\êg\æfvË¬e…²þ\Ån‹·/•\Ék³¬Y-\n¶B¦\èTZ(\×*²geWf¿Í‰\Ê9–«ž+\Í\íÌ³\ÊÛ7œ\ïŸÿ\í\Âá’¶¥†KW-Xæ½¬j9²<qy\Û\n\ã+†V¬<¸Š¶*m\ÕO«\íW—®~½&zMk^ÁÊ‚Áµk\ëU\n\å…}\ë\Ü\×\í]OX/Yßµaú†>‰Š®\Û—\Ø(\Üx\å‡oÊ¿™Ü”´©«Ä¹d\Ïf\Òf\é\æ\Þ-ž[–ª—\æ—n\r\ÙÚ´\r\ßV´\íõöE\Û/—\Í(Û»ƒ¶C¹£¿<¸¼e§\É\Î\Í;?T¤TôTúT6\î\ÒÝµa\×øn\Ñ\î{¼ö4\ì\Õ\Û[¼÷ý>É¾\ÛUUM\Õf\ÕeûIû³÷?®‰ª\éø–ûm]­Nmq\í\Ç\Òý#¶×¹\Ô\Õ\Ò=TR\Ö+\ëG\Ç¾þ\ïw-\r6\rUœ\Æ\â#pDy\ä\é÷	\ß÷\r:\ÚvŒ{¬\á\Óvg/jBšòšF›Sšû[b[ºO\Ì>\Ñ\Ö\ê\ÞzüG\Ûœ4<YyJóT\Éi\Ú\é‚Ó“gòÏŒ•}~.ù\Ü`Û¢¶{\çc\Î\ßjo\ïºt\á\ÒEÿ‹\ç;¼;\Î\\ò¸tò²\Û\åW¸Wš¯:_m\êt\ê<þ“\ÓOÇ»œ»š®¹\\k¹\îz½µ{f÷\éž7\Î\Ýô½yñÿ\ÖÕž9=Ý½ózo÷\Å÷õ\ß\Ý~r\'ý\ÎË»\Ùw\'î­¼O¼_ô@\íA\ÙCÝ‡\Õ?[þ\Ü\Ø\ï\ÜjÀw ó\Ñ\ÜG÷…ƒ\Ïþ‘õC™Ë†\r†\ëž8>99\â?rý\éü§C\Ïd\Ï&žþ¢þË®/~ø\Õ\ë\×\ÎÑ˜Ñ¡—ò—“¿m|¥ý\êÀ\ë¯\Û\Æ\Â\Æ¾\Éx31^ôVû\íÁw\Üw\ï£\ßO\ä| (ÿhù±õSÐ§û“““ÿ˜óüc3-\Û\0\0\0 cHRM\0\0z%\0\0€ƒ\0\0ùÿ\0\0€\é\0\0u0\0\0\ê`\0\0:˜\0\0o’_\ÅF\0\0\ÅIDATx\Ú\ì\ÝOL“w\ÇñOAð+s2J™Cp\Ól“\áE“\Ã\ÐXÍœšŒež\ÌvZ¼–XºD¡‰Yvñ\âLf\ÜI¨ø\ç:¡€d\Æ,\Ût±S)-Œ\á\èL\éó\ÛaÙ‘\ç©	•÷ûü\å\áù=¿¿\á).cL¿$·ˆ¦¿1—1\Æðh¦rcþ\â¤™<H\0$\0\0H@ \0	€D\0$\0\0H@ \0	€D\0$\0\0H@ \0	€D\0$\0\0H@ \0	€@\0\0	€D\0$\0\0H@ \0	€D\0$\0\0h_8V<Wff¦\ãl2™\ÔüùóURR\"—\Ë5\é\\4\Z\ÕP$¢yYY\Î7`Œ’–¥¢¢\"\å\ä\äL:\Ç‡•™‘!\Ù|oIrIJ$Z’—§‚‚‚Ù½þ)*™Lj\éÒ¥r»\Ý\é°¢¼\\¡PH\Çq6\Z\ê\í\ÒRõÜºe»_?®\Ï\Ö+^¯óƒ›˜\ÐðÈˆ._¹¢-UU“\ÎuuvjCE…r\Ýneeg\Û^3\Ã\åÒ£}VS£S\ÍÍ³zýS‘±,\rD\"º\êý;\Ò\à»\ë\×\ëF($o~¾\ãldhH«\Ë\Êô\ã\íÛ¶pü\Ø1>r$¥kNLL(62¢k×®©j\ë\ÖI\ç:C!U”—\Ë\ív+\Û \Ë\å\Ò@$¢š}û\Ô|úô¬^ÿTdY–\"±˜‚­­Ú±sgz¬Ü´Iò¦ð\Ó:‰¨´¬L¶\Ð\ØÐ ºúz½V\\œÀ\á\áaµƒ\Ú\\Y9\é\\wW—¶lÞœ2À\Þt`ÿ~565\Í\êõOÀGªµ­M\ïm\ß@\0€\0 \0@\0€\0 \0@\0€\0œM\0\ß\\¹Rw\ï\ÝKùy¨`Àvýµ~¿\'Ojºû\î\Â}´{7\0\Ó	\àG\ê\î;ziñb\Ç{UQq±N44Ø®¿\å\âE?^žü|É˜g\Z£\Øð°\ê\ê\ê´f\íZ\0¦À\ç-cŒ\í\Þ\0€\é\0@\0€\0 \0@\0ðù\0hŒ\ãNiþ+\0\ÎöðûOýŠýò³\ä.q¼\×\'c\êÅ’\åòû\ê¿W\ï&é›³gu\æ\Ì½¼\Äùš\ÉdR\Ç\ÇôÎºuœ€s\r\à…U\êÿõ†r2\n\ïuÜŠ(ÿ\Õ\Õ\Úó{\í\Éy°¾^\'\Z\Z”‘\áxÍ„e\ÉHjµ}\ê\ßh\àl\ÜT­ÁŽ›Z\äu~-3‰*¯\ì-}\Ðy\Å\à³X?\0@\0€\0 \0@\0€\0 \0@\0€\0 \0@\0€\0 \0À9\rpù²e)m@,S°­\r€\0œ\Z€uµµj”\Ê—ÿÿÁNŸð@\0¦°§§G\Ý\Ý\ÝZ´`\ã5-c”H$´m\Û6-³\Ù0\00e€\Ï\"\0€\0 \0@\0€\0 \0@\0€\0 \0@\0€\0 \0@\0€\0 \08y[|>µ··«°°0e€\í¡ÐŒ\0¬ª¬Là½¾>\Õúýj\ìú>\Ô`ûM-*|\n€¡Ë¶\0ª­«\Ó\ë%%)Œ\Åbs\à+V\è·\ÞÞ”\ç½þœv€?\\¿®\r7>\Õ\×|¼gÎž;g;ó\íŠuz\ÔÛ¥”\çx½¿“\ÇSªO²xÀ\ïW\ÓSþ»\ÖÖ–\íÜµk\î<\ÙÔ¤\á°r.tœ\Ç\åõzuðÐ¡i\Øwÿ¾N57+;+Kó23OÀÑ±1ù|>UWW\Û\Î\ÞjúZ£\á>e/\Ìu¼‡Dü±r¼…Zs¨\ÆvýW¯^UÛ¥K\Êu;o™eYú\ç\É\íÝ»W«JK\ç@\"\0\0‰\0H\0$ €@ \0	€@\0\0	€D\0$\0\0H@ \0	€D\0$\0\0H@ \0	€D\0$\0\0H@ \0	€D\0$\0\0H\0 \0H@ \Ñô4<š©\\Æ˜~N@š©ð\ß\0÷%˜\Ä)¸¸\0\0\0\0IEND®B`‚',0),(3,'upyachka@gmail.com','EMPLOYEE','.\Ð#}\ç\Ù\Ça«udunÜŠ°~','w£Š:\ÜF)','ÐŸÐ¾Ð¿ÑÑ‡ÑÐ°ffffffffffffffffffffffffffffffffffffffffffffffffff','ÐŸÐ¾Ð¿ÑÑ‡ÑÐ¾',NULL,NULL,NULL,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=393 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vacancies`
--

LOCK TABLES `vacancies` WRITE;
/*!40000 ALTER TABLE `vacancies` DISABLE KEYS */;
INSERT INTO `vacancies` VALUES (166,2,'Software Engineer','Web Development','Learn Web Development best practices and get your career started',NULL,'Bachelor\'s degree in computer science or related discipline is preferable\r\nDeep knowledge and development experience of Web service platforms and middle tier technologies','Strong analytical and problem solving skills\r\nExtensive  web service platform experience\r\nGit, Stash\r\nJava, J2EE, Maven'),(392,2,'Scientist','Nuclear physics','Interesting work at Large Hadron Collider.',NULL,NULL,'R, C++, fastjet, pythia');
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
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `description` text,
  `resume_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IXFK_work_experiences_resumes` (`resume_id`),
  KEY `IX_organization` (`company_name`),
  CONSTRAINT `FK_work_experiences_resumes` FOREIGN KEY (`resume_id`) REFERENCES `resumes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKlan3wij52dk67mbv21koxmqnw` FOREIGN KEY (`resume_id`) REFERENCES `resumes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=226 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_experiences`
--

LOCK TABLES `work_experiences` WRITE;
/*!40000 ALTER TABLE `work_experiences` DISABLE KEYS */;
INSERT INTO `work_experiences` VALUES (89,'Joint Insitute for Nuclear Research','assistant','2015-07-01','2015-09-01',NULL,475),(225,'EPAM','junior developer','2016-05-01','2016-05-31','Some super secret projects.\r\nBeen fired because of disclosure of the commercial secrets.',475);
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

-- Dump completed on 2016-05-22 13:16:02
