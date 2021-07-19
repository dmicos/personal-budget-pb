CREATE DATABASE  IF NOT EXISTS `personal_budget` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `personal_budget`;
-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
--
-- Host: localhost    Database: personal_budget
-- ------------------------------------------------------
-- Server version	5.7.27-0ubuntu0.19.04.1

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `name` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_46ccwnsi9409t36lurvtyljak` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (27,NULL,NULL,'Zakupy'),(28,NULL,NULL,'Dzieci i edukacja'),(29,NULL,NULL,'Mieszkanie, dom i ogród'),(30,NULL,NULL,'Prezenty i darowizny'),(31,NULL,NULL,'Osobiste'),(32,NULL,NULL,'Przychód'),(33,NULL,NULL,'Rachunki i media'),(34,NULL,NULL,'Rozrywka'),(35,NULL,NULL,'Samochód'),(36,NULL,NULL,'Usługi biznesowe'),(37,NULL,NULL,'Zdrowie'),(38,NULL,NULL,'Brak kategorii');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `counterparty`
--

DROP TABLE IF EXISTS `counterparty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `counterparty` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_nw6ukqgujv3esputrxam9e7v9` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `counterparty`
--

LOCK TABLES `counterparty` WRITE;
/*!40000 ALTER TABLE `counterparty` DISABLE KEYS */;
INSERT INTO `counterparty` VALUES (1,'2019-10-07 21:16:39',NULL,'AMIC POLSKA sp z o WROCLAW PL'),(2,'2019-10-07 21:16:39',NULL,'MPK7310 3WRO URBANCARD WROCLAW PL'),(3,'2019-10-07 21:16:39',NULL,'ZABKA Z6751 K1 WROCLAW PL'),(4,'2019-10-07 21:16:39',NULL,'Revolut2650 revolutcom GB'),(5,'2019-10-07 21:16:39',NULL,'KFC WROCLAW DELIKAT WROCLAW PL'),(6,'2019-10-07 21:16:39',NULL,'HAIDAICHUK YULIIA, ŻEGIESTOWSKA 13/12, 50-542 WROCŁAW'),(7,'2019-10-07 21:16:39',NULL,'MPK4627 3WRO URBANCARD WROCLAW PL'),(8,'2019-10-07 21:16:39',NULL,'GATE POLAND SP Z O Wroclaw PL'),(9,'2019-10-07 21:16:39',NULL,'MPK4634 2WRO URBANCARD WROCLAW PL'),(10,'2019-10-07 21:16:39',NULL,'eCard S.A., Arkonska 11 11, Gdansk'),(11,'2019-10-07 21:16:39',NULL,'Blue Media S.A.'),(12,'2019-10-07 21:16:39',NULL,'PHZ BALTONA B52 KATOWICE PYRZ PL'),(13,'2019-10-07 21:16:39',NULL,'SO COFFEE 49603 Pyrzowice PL'),(14,'2019-10-07 21:16:39',NULL,'jakdojadepl Poznan PL'),(15,'2019-10-07 21:16:39',NULL,'PLANET CASH, SUCHA 8-10, WROCLAW'),(16,'2019-10-07 21:16:39',NULL,'LIDL BOROWSKA Wroclaw PL'),(17,'2019-10-07 21:16:39',NULL,'POKLADNA U VSTUPU DO      TEPLICE N'),(18,'2019-10-07 21:16:39',NULL,'POKLADNA U VSTUPU DO      TEPLICE N, 2208890124 7375  9173'),(19,'2019-10-07 21:16:39',NULL,'Revolut8958 revolutcom GB');
/*!40000 ALTER TABLE `counterparty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `currency`
--

DROP TABLE IF EXISTS `currency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `currency` (
  `iso` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`iso`),
  UNIQUE KEY `UK_ou8q9939fa4k88wjh17qwcmre` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `currency`
--

LOCK TABLES `currency` WRITE;
/*!40000 ALTER TABLE `currency` DISABLE KEYS */;
/*!40000 ALTER TABLE `currency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subcategory`
--

DROP TABLE IF EXISTS `subcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subcategory` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_e060alu3238gwu0mvhgh6xkhd` (`name`),
  KEY `FKe4hdbsmrx9bs9gpj1fh4mg0ku` (`category_id`),
  CONSTRAINT `FKe4hdbsmrx9bs9gpj1fh4mg0ku` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subcategory`
--

LOCK TABLES `subcategory` WRITE;
/*!40000 ALTER TABLE `subcategory` DISABLE KEYS */;
INSERT INTO `subcategory` VALUES (1,NULL,NULL,'Spożywcze',27),(2,NULL,NULL,'Papierosy',27),(3,NULL,NULL,'Gazety i czasopisma',27),(4,NULL,NULL,'Chemia',27),(5,NULL,NULL,'Hobby',27),(6,NULL,NULL,'Odzież i obuwie',27),(7,NULL,NULL,'Elektronika i oprogramowanie',27),(8,NULL,NULL,'Alkohol',27),(9,NULL,NULL,'Inne zakupy',27);
/*!40000 ALTER TABLE `subcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_1wdpsed5kna2y38hnbgrnhi5b` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transactions` (
  `transaction_number` bigint(20) NOT NULL,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `account_number` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `accounting_date` date DEFAULT NULL,
  `amount_payment` double DEFAULT NULL,
  `amount_transaction` double DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `bank_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `blocked_amount` double DEFAULT NULL,
  `currency_balance` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `details` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `transaction_date` date DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `counterparty_id` bigint(20) NOT NULL,
  `currency_blocked_iso` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `currency_payment_iso` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `currency_transaction_iso` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `subcategory_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`transaction_number`),
  KEY `FKjhlvpx4nsouykkrc8r9bpvmhi` (`category_id`),
  KEY `FKj6he1ihdfl6voiggp55ok90j` (`counterparty_id`),
  KEY `FKlf237w5cueu5dnuy1ha6e86uv` (`currency_blocked_iso`),
  KEY `FKi2pnb4ys617s9xml0e0lnbm68` (`currency_payment_iso`),
  KEY `FK9oq7dcsftvprb1sc9pblfrkrr` (`currency_transaction_iso`),
  KEY `FKrqok5xstls3oejnn591d81mme` (`subcategory_id`),
  CONSTRAINT `FK9oq7dcsftvprb1sc9pblfrkrr` FOREIGN KEY (`currency_transaction_iso`) REFERENCES `currency` (`iso`),
  CONSTRAINT `FKi2pnb4ys617s9xml0e0lnbm68` FOREIGN KEY (`currency_payment_iso`) REFERENCES `currency` (`iso`),
  CONSTRAINT `FKj6he1ihdfl6voiggp55ok90j` FOREIGN KEY (`counterparty_id`) REFERENCES `counterparty` (`id`),
  CONSTRAINT `FKjhlvpx4nsouykkrc8r9bpvmhi` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FKlf237w5cueu5dnuy1ha6e86uv` FOREIGN KEY (`currency_blocked_iso`) REFERENCES `currency` (`iso`),
  CONSTRAINT `FKrqok5xstls3oejnn591d81mme` FOREIGN KEY (`subcategory_id`) REFERENCES `subcategory` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` VALUES (201924164002341087,'2019-10-07 21:16:39',NULL,'79105000281000002410093963','2019-08-28',NULL,-100,7622.14,'ING Bank Śląski S.A.',NULL,'PLN','TR.BLIK -100.00  ','Wypłata gotówki BLIK 29.08.2019 Nr transakcji 46554919931','2019-08-28',NULL,15,NULL,NULL,NULL,NULL),(201924164008192706,'2019-10-07 21:16:39',NULL,'72105015751000009717882436','2019-08-28',NULL,-0.55,7784.39,'ING Bank Śląski S.A.',NULL,'PLN',' ','przelew Smart Saver Płatność kartą 27.08.2019 Nr karty 4246xx5693 Kwota: 11,00 PLN','2019-08-28',NULL,6,NULL,NULL,NULL,NULL),(201924164008200483,'2019-10-07 21:16:39',NULL,'72105015751000009717882436','2019-08-28',NULL,-4.85,7779.54,'ING Bank Śląski S.A.',NULL,'PLN',' ','przelew Smart Saver Płatność kartą 27.08.2019 Nr karty 4246xx5693 Kwota: 97,00 PLN','2019-08-28',NULL,6,NULL,NULL,NULL,NULL),(201924164008279266,'2019-10-07 21:16:39',NULL,'72105015751000009717882436','2019-08-28',NULL,-4.18,7775.79,'ING Bank Śląski S.A.',NULL,'PLN',' ','przelew Smart Saver Płatność kartą 27.08.2019 490,00 CZK Kwota: 83,52 PLN','2019-08-28',NULL,6,NULL,NULL,NULL,NULL),(201924197201515912,'2019-10-07 21:16:39',NULL,'13105017641000002307657854','2019-08-28',NULL,-30,7496.74,'ING Bank Śląski S.A.',NULL,'PLN','PRZELEW  ','Doładowanie telefonu nr 48794352885 Nr ref.792933281','2019-08-28',NULL,11,NULL,NULL,NULL,NULL),(201924197304784245,'2019-10-07 21:16:39',NULL,'1915031/19730','2019-08-28',-490,-83.52,7779.97,'',NULL,'PLN','TR.KART -83.52  ','Płatność kartą 27.08.2019 490,00 CZK Nr karty 4246xx5693','2019-08-28',NULL,18,NULL,NULL,NULL,NULL),(201924197304784250,'2019-10-07 21:16:39',NULL,'8042544/13841','2019-08-28',NULL,-2.51,7773.28,'',NULL,'PLN','TR.KART -2.51  ','Prowizja za przewalutowanie Płatność kartą 27.08.2019 Nr karty 4246xx5693','2019-08-28',NULL,17,NULL,NULL,NULL,NULL),(201924264002343775,'2019-10-07 21:16:39',NULL,'79105000281000002410093963','2019-08-29',NULL,-364,7128.51,'ING Bank Śląski S.A.',NULL,'PLN','TR.BLIK -364.00  ','Płatność BLIK 30.08.2019 Nr transakcji 46578918366 paczkomaty.pl','2019-08-29',NULL,10,NULL,NULL,NULL,NULL),(201924264008039216,'2019-10-07 21:16:39',NULL,'72105015751000009717882436','2019-08-29',NULL,-0.42,7496.32,'ING Bank Śląski S.A.',NULL,'PLN',' ','przelew Smart Saver Płatność kartą 28.08.2019 Nr karty 4246xx5693 Kwota: 8,40 PLN','2019-08-29',NULL,6,NULL,NULL,NULL,NULL),(201924264008047534,'2019-10-07 21:16:39',NULL,'72105015751000009717882436','2019-08-29',NULL,-1.2,7495.12,'ING Bank Śląski S.A.',NULL,'PLN',' ','przelew Smart Saver Płatność kartą 28.08.2019 Nr karty 4246xx5693 Kwota: 24,00 PLN','2019-08-29',NULL,6,NULL,NULL,NULL,NULL),(201924264008066326,'2019-10-07 21:16:39',NULL,'72105015751000009717882436','2019-08-29',NULL,-0.33,7494.79,'ING Bank Śląski S.A.',NULL,'PLN',' ','przelew Smart Saver Płatność kartą 28.08.2019 Nr karty 4246xx7454 Kwota: 6,50 PLN','2019-08-29',NULL,6,NULL,NULL,NULL,NULL),(201924264008095205,'2019-10-07 21:16:39',NULL,'72105015751000009717882436','2019-08-29',NULL,-1.35,7493.44,'ING Bank Śląski S.A.',NULL,'PLN',' ','przelew Smart Saver Płatność kartą 28.08.2019 Nr karty 4246xx5693 Kwota: 27,09 PLN','2019-08-29',NULL,6,NULL,NULL,NULL,NULL),(201924264008125438,'2019-10-07 21:16:39',NULL,'72105015751000009717882436','2019-08-29',NULL,-0.65,7492.79,'ING Bank Śląski S.A.',NULL,'PLN',' ','przelew Smart Saver Płatność kartą 28.08.2019 Nr karty 4246xx7454 Kwota: 12,97 PLN','2019-08-29',NULL,6,NULL,NULL,NULL,NULL),(201924264008157671,'2019-10-07 21:16:39',NULL,'72105015751000009717882436','2019-08-29',NULL,-0.28,7492.51,'ING Bank Śląski S.A.',NULL,'PLN',' ','przelew Smart Saver Płatność kartą 28.08.2019 Nr karty 4246xx5693 Kwota: 5,50 PLN','2019-08-29',NULL,6,NULL,NULL,NULL,NULL),(201924264008304815,'2019-10-07 21:16:39',NULL,'72105015751000009717882436','2019-08-29',NULL,-18.2,7110.31,'ING Bank Śląski S.A.',NULL,'PLN',' ','przelew Smart Saver Płatność BLIK 30.08.2019 Nr transakcji 46578918366 Kwota: 364,00 PLN','2019-08-29',NULL,6,NULL,NULL,NULL,NULL),(201924364008012095,'2019-10-07 21:16:39',NULL,'72105015751000009717882436','2019-08-30',NULL,-2.33,7018.62,'ING Bank Śląski S.A.',NULL,'PLN',' ','przelew Smart Saver Płatność kartą 29.08.2019 Nr karty 4246xx5693 Kwota: 46,50 PLN','2019-08-30',NULL,6,NULL,NULL,NULL,NULL),(201924364008053776,'2019-10-07 21:16:39',NULL,'72105015751000009717882436','2019-08-30',NULL,-0.35,7018.27,'ING Bank Śląski S.A.',NULL,'PLN',' ','przelew Smart Saver Płatność kartą 29.08.2019 Nr karty 4246xx5693 Kwota: 7,00 PLN','2019-08-30',NULL,6,NULL,NULL,NULL,NULL),(201924364008053778,'2019-10-07 21:16:39',NULL,'72105015751000009717882436','2019-08-30',NULL,-0.35,7017.92,'ING Bank Śląski S.A.',NULL,'PLN',' ','przelew Smart Saver Płatność kartą 29.08.2019 Nr karty 4246xx5693 Kwota: 7,00 PLN','2019-08-30',NULL,6,NULL,NULL,NULL,NULL),(201924364008053780,'2019-10-07 21:16:39',NULL,'72105015751000009717882436','2019-08-30',NULL,-0.7,7017.22,'ING Bank Śląski S.A.',NULL,'PLN',' ','przelew Smart Saver Płatność kartą 29.08.2019 Nr karty 4246xx5693 Kwota: 14,00 PLN','2019-08-30',NULL,6,NULL,NULL,NULL,NULL),(201924364008140719,'2019-10-07 21:16:39',NULL,'72105015751000009717882436','2019-08-30',NULL,-5,7012.22,'ING Bank Śląski S.A.',NULL,'PLN',' ','przelew Smart Saver Płatność kartą 29.08.2019 Nr karty 4246xx5693 Kwota: 100,00 PLN','2019-08-30',NULL,6,NULL,NULL,NULL,NULL),(201924364008170462,'2019-10-07 21:16:39',NULL,'72105015751000009717882436','2019-08-30',NULL,-1.05,7011.17,'ING Bank Śląski S.A.',NULL,'PLN',' ','przelew Smart Saver Płatność kartą 29.08.2019 Nr karty 4246xx5693 Kwota: 20,90 PLN','2019-08-30',NULL,6,NULL,NULL,NULL,NULL),(201924364008220433,'2019-10-07 21:16:39',NULL,'72105015751000009717882436','2019-08-30',NULL,-2.56,7008.61,'ING Bank Śląski S.A.',NULL,'PLN',' ','przelew Smart Saver Płatność kartą 29.08.2019 Nr karty 4246xx7454 Kwota: 51,14 PLN','2019-08-30',NULL,6,NULL,NULL,NULL,NULL),(201924397301037514,'2019-10-07 21:16:39',NULL,'1915031/19730','2019-08-30',NULL,-46.5,7526.74,'',NULL,'PLN','TR.KART -46.50  ','Płatność kartą 29.08.2019 Nr karty 4246xx5693','2019-08-28',NULL,12,NULL,NULL,NULL,NULL),(201924397301344588,'2019-10-07 21:16:39',NULL,'1915031/19730','2019-08-30',NULL,-7,7594.14,'',NULL,'PLN','TR.KART -7.00  ','Płatność kartą 29.08.2019 Nr karty 4246xx5693','2019-08-28',NULL,14,NULL,NULL,NULL,NULL),(201924397301344595,'2019-10-07 21:16:39',NULL,'1915031/19730','2019-08-30',NULL,-14,7608.14,'',NULL,'PLN','TR.KART -14.00  ','Płatność kartą 29.08.2019 Nr karty 4246xx5693','2019-08-28',NULL,14,NULL,NULL,NULL,NULL),(201924397301344596,'2019-10-07 21:16:39',NULL,'1915031/19730','2019-08-30',NULL,-7,7601.14,'',NULL,'PLN','TR.KART -7.00  ','Płatność kartą 29.08.2019 Nr karty 4246xx5693','2019-08-28',NULL,14,NULL,NULL,NULL,NULL),(201924397303089179,'2019-10-07 21:16:39',NULL,'1915031/19730','2019-08-30',NULL,-100,7784.94,'',NULL,'PLN','TR.KART -100.00  ','Płatność kartą 29.08.2019 Nr karty 4246xx5693','2019-08-28',NULL,19,NULL,NULL,NULL,NULL),(201924397303333408,'2019-10-07 21:16:39',NULL,'1915031/19730','2019-08-30',NULL,-20.9,7573.24,'',NULL,'PLN','TR.KART -20.90  ','Płatność kartą 29.08.2019 Nr karty 4246xx5693','2019-08-28',NULL,13,NULL,NULL,NULL,NULL),(201924397304228427,'2019-10-07 21:16:39',NULL,'1915031/19730','2019-08-30',NULL,-51.14,7722.14,'',NULL,'PLN','TR.KART -51.14  ','Płatność kartą 29.08.2019 Nr karty 4246xx7454','2019-08-28',NULL,16,NULL,NULL,NULL,NULL),(201924597301090010,'2019-10-07 21:16:39',NULL,'1915031/19730','2019-09-01',NULL,-3.29,7100.12,'',NULL,'PLN','TR.KART -3.29  ','Płatność kartą 30.08.2019 Nr karty 4246xx7454','2019-08-29',NULL,1,NULL,NULL,NULL,NULL),(201924597302642295,'2019-10-07 21:16:39',NULL,'1915031/19730','2019-09-01',NULL,-2.4,7097.72,'',NULL,'PLN','TR.KART -2.40  ','Płatność kartą 30.08.2019 Nr karty 4246xx7454','2019-08-29',NULL,9,NULL,NULL,NULL,NULL),(201924597302660822,'2019-10-07 21:16:39',NULL,'1915031/19730','2019-09-01',NULL,-6.9,7103.41,'',NULL,'PLN','TR.KART -6.90  ','Płatność kartą 30.08.2019 Nr karty 4246xx7454','2019-08-29',NULL,1,NULL,NULL,NULL,NULL),(201924597302682666,'2019-10-07 21:16:39',NULL,'1915031/19730','2019-09-01',NULL,-2.4,7025.34,'',NULL,'PLN','TR.KART -2.40  ','Płatność kartą 30.08.2019 Nr karty 4246xx7454','2019-08-29',NULL,7,NULL,NULL,NULL,NULL),(201924597302745837,'2019-10-07 21:16:39',NULL,'1915031/19730','2019-09-01',NULL,-69.98,7027.74,'',NULL,'PLN','TR.KART -69.98  ','Płatność kartą 30.08.2019 Nr karty 4246xx7454','2019-08-29',NULL,8,NULL,NULL,NULL,NULL),(201924597303036109,'2019-10-07 21:16:39',NULL,'1915031/19730','2019-09-01',NULL,-4.39,7020.95,'',NULL,'PLN','TR.KART -4.39  ','Płatność kartą 30.08.2019 Nr karty 4246xx7454','2019-08-29',NULL,1,NULL,NULL,NULL,NULL),(201924597305818367,'2019-10-07 21:16:39',NULL,'1915031/19730','2019-09-01',NULL,-4.39,5982.88,'',NULL,'PLN','TR.KART -4.39  ','Płatność kartą 31.08.2019 Nr karty 4246xx7454','2019-08-30',NULL,1,NULL,NULL,NULL,NULL),(201924597305946268,'2019-10-07 21:16:39',NULL,'1915031/19730','2019-09-01',NULL,-15.95,6992.66,'',NULL,'PLN','TR.KART -15.95  ','Płatność kartą 31.08.2019 Nr karty 4246xx7454','2019-08-30',NULL,5,NULL,NULL,NULL,NULL),(201924597306469576,'2019-10-07 21:16:39',NULL,'1915031/19730','2019-09-01',NULL,-2.4,5987.27,'',NULL,'PLN','TR.KART -2.40  ','Płatność kartą 31.08.2019 Nr karty 4246xx7454','2019-08-30',NULL,2,NULL,NULL,NULL,NULL),(201924597306606642,'2019-10-07 21:16:39',NULL,'1915031/19730','2019-09-01',NULL,-2.99,5989.67,'',NULL,'PLN','TR.KART -2.99  ','Płatność kartą 31.08.2019 Nr karty 4246xx7454','2019-08-30',NULL,3,NULL,NULL,NULL,NULL),(201924597308818634,'2019-10-07 21:16:39',NULL,'1915031/19730','2019-09-01',NULL,-1000,5992.66,'',NULL,'PLN','TR.KART -1000.00  ','Płatność kartą 31.08.2019 Nr karty 4246xx5693','2019-08-30',NULL,4,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactions_tags`
--

DROP TABLE IF EXISTS `transactions_tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transactions_tags` (
  `transactions_transaction_number` bigint(20) NOT NULL,
  `tags_id` bigint(20) NOT NULL,
  PRIMARY KEY (`transactions_transaction_number`,`tags_id`),
  KEY `FKomyxqhd6wbmardso0uesuitis` (`tags_id`),
  CONSTRAINT `FKb6mcfqftmfe8dbr2iqhkrx8m3` FOREIGN KEY (`transactions_transaction_number`) REFERENCES `transactions` (`transaction_number`),
  CONSTRAINT `FKomyxqhd6wbmardso0uesuitis` FOREIGN KEY (`tags_id`) REFERENCES `tag` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions_tags`
--

LOCK TABLES `transactions_tags` WRITE;
/*!40000 ALTER TABLE `transactions_tags` DISABLE KEYS */;
/*!40000 ALTER TABLE `transactions_tags` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-07 23:33:58
