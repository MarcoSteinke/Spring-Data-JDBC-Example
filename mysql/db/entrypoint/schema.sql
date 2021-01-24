DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
                        `username`       varchar(255) NOT NULL,
                        `password` varchar(255) DEFAULT NULL,
                        `salt`     varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;