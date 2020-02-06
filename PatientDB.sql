-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: localhost    Database: PatientDB
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Doctor_Office`
--

DROP TABLE IF EXISTS `Doctor_Office`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Doctor_Office` (
  `office_id` int NOT NULL AUTO_INCREMENT,
  `office_name` varchar(50) DEFAULT NULL,
  `office_address` varchar(60) DEFAULT NULL,
  `patient_pcp_id` int DEFAULT NULL,
  PRIMARY KEY (`office_id`),
  KEY `fk_patient_pcp` (`patient_pcp_id`),
  CONSTRAINT `fk_patient_pcp` FOREIGN KEY (`patient_pcp_id`) REFERENCES `Patient_PCP` (`pcp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Doctor_Office`
--

LOCK TABLES `Doctor_Office` WRITE;
/*!40000 ALTER TABLE `Doctor_Office` DISABLE KEYS */;
INSERT INTO `Doctor_Office` VALUES (1,'Dr. McGann and Associates','400 W Dover St Pittsburgh PA 15219',NULL),(2,'Dr. Zel and Associates','402 W Dover St Pittsburgh PA 15211',NULL),(3,'Dr. Elivio and Associates','404 W Dover St Pittsburgh PA 15213',NULL);
/*!40000 ALTER TABLE `Doctor_Office` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `HealthcareProvider`
--

DROP TABLE IF EXISTS `HealthcareProvider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `HealthcareProvider` (
  `provider_id` int NOT NULL AUTO_INCREMENT,
  `provider_name` varchar(30) DEFAULT NULL,
  `provider_address` varchar(50) DEFAULT NULL,
  `patient_id` int DEFAULT NULL,
  PRIMARY KEY (`provider_id`),
  KEY `_fk_patient_id` (`patient_id`),
  CONSTRAINT `_fk_patient_id` FOREIGN KEY (`patient_id`) REFERENCES `Patient` (`patient_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HealthcareProvider`
--

LOCK TABLES `HealthcareProvider` WRITE;
/*!40000 ALTER TABLE `HealthcareProvider` DISABLE KEYS */;
INSERT INTO `HealthcareProvider` VALUES (1,'Aetna','202 Main St Pittsburgh PA 15214',1),(2,'UPMC','204 Main St Pittsburgh PA 15212',2),(3,'Cigna','202 Main St Pittsburgh PA 15210',3),(4,'UPMC For You','200 Celcius St Pittsburgh PA 15226',4),(5,'UPMC','2611 E Ohath St Pittsburgh PA 15224',NULL),(6,'UPMC','2611 E Ohath St Pittsburgh PA 15224',NULL);
/*!40000 ALTER TABLE `HealthcareProvider` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medication`
--

DROP TABLE IF EXISTS `medication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medication` (
  `medication_id` int NOT NULL,
  `medication_name` varchar(30) DEFAULT NULL,
  `medication_description` varchar(100) DEFAULT NULL,
  `medication_side_effects` varchar(1000) DEFAULT NULL,
  `medication_directions` varchar(1000) DEFAULT NULL,
  `patient_id` int DEFAULT NULL,
  PRIMARY KEY (`medication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medication`
--

LOCK TABLES `medication` WRITE;
/*!40000 ALTER TABLE `medication` DISABLE KEYS */;
INSERT INTO `medication` VALUES (102,'Xanax','Anxiety Medication','Shakes or tremors. Sleeping difficulties. Confusion. Anxiety. Hallucinations. Seizures. Delirium Tremens.','The orally disintegrating tablet can be taken with or without water. Swallow the extended-release tablets whole; do not chew, crush, or break them. Your doctor will probably start you on a low dose of alprazolam and gradually increase your dose, not more than once every 3 or 4 days. Alprazolam can be habit-forming.',NULL),(208,'Lipitor','Statin','A very small number of people taking atorvastatin may have mild memory problems or confusion. If these rare effects occur, talk to your doctor. Rarely, statins may cause or worsen diabetes. Talk to your doctor about the benefits and risks. This drug may rarely cause muscle problems (which can rarely lead to very serious conditions called rhabdomyolysis and autoimmune myopathy). Tell your doctor right away if you develop any of these symptoms during treatment and if these symptoms persist after your doctor stops this drug: muscle pain/tenderness/weakness (especially with fever or unusual tiredness), signs of kidney problems (such as change in the amount of urine).','Atorvastatin comes as a tablet to take by mouth. It is usually taken once a day with or without food. Take atorvastatin at around the same time every day. Follow the directions on your prescription label carefully, and ask your doctor or pharmacist to explain any part you do not understand.',NULL),(659,'Valium','Anxiety Medication','Shakiness, unsteadiness, blurred vision, blistering of the skin, abdominal or stomach pain, chills, confusion, cough, dark urine, decrease in the frequency of urination, nightmares, outbursts of anger, lack of memory, irritability, itching, loss of interest or pleasure, lower back or side pain, pale skin, restlessness, slurred speech, dizziness, fast heartbeat, irregular breathing, feeling sad or empty','Take this medication by mouth with or without food as directed by your doctor. If you are using the liquid form of this medication, carefully measure the dose using a special measuring device/spoon. Do not use a household spoon because you may not get the correct dose.',NULL),(892,'Zoloft','Depression Medication','Heart disease, high blood pressure, or a stroke. Liver or kidney disease. Bleeding problems, or if you take warfarin. Seizures. Bipolar disorder (manic depression), or low levels of sodium in your blood.','Take this medication by mouth as directed by your doctor, usually once daily either in the morning or evening. The tablet or liquid form of this medication may be taken with or without food. The capsule form is usually taken with food.',NULL);
/*!40000 ALTER TABLE `medication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Patient`
--

DROP TABLE IF EXISTS `Patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Patient` (
  `patient_id` int NOT NULL AUTO_INCREMENT,
  `patient_first_name` varchar(30) DEFAULT NULL,
  `patient_last_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`patient_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Patient`
--

LOCK TABLES `Patient` WRITE;
/*!40000 ALTER TABLE `Patient` DISABLE KEYS */;
INSERT INTO `Patient` VALUES (1,'Tristin','Butz'),(2,'Rachel','Krupa'),(3,'Garret','Cherry'),(4,'Sabrina','Blake'),(5,'james','mcgavern'),(6,'hillary','clinton');
/*!40000 ALTER TABLE `Patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Patient_Location`
--

DROP TABLE IF EXISTS `Patient_Location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Patient_Location` (
  `location_id` int NOT NULL AUTO_INCREMENT,
  `street_number` int DEFAULT NULL,
  `street_name` varchar(30) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `state` char(2) DEFAULT NULL,
  `zip_code` varchar(12) DEFAULT NULL,
  `patient_id` int DEFAULT NULL,
  PRIMARY KEY (`location_id`),
  KEY `fk_patient_id` (`patient_id`),
  CONSTRAINT `fk_patient_id` FOREIGN KEY (`patient_id`) REFERENCES `Patient` (`patient_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Patient_Location`
--

LOCK TABLES `Patient_Location` WRITE;
/*!40000 ALTER TABLE `Patient_Location` DISABLE KEYS */;
INSERT INTO `Patient_Location` VALUES (1,2506,'Wylie Ave','Pittsburgh','PA','15219',1),(2,484,'Demoyne St','Pittsburgh','PA','15210',2),(3,2506,'E Carson','Pittsburgh','PA','15211',3);
/*!40000 ALTER TABLE `Patient_Location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_medication_junction`
--

DROP TABLE IF EXISTS `patient_medication_junction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_medication_junction` (
  `patient_id` int NOT NULL,
  `medication_id` int NOT NULL,
  `med_patient` int NOT NULL,
  PRIMARY KEY (`patient_id`,`medication_id`),
  KEY `fk_medication` (`medication_id`),
  CONSTRAINT `fk_medication` FOREIGN KEY (`medication_id`) REFERENCES `Medication` (`medication_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_patient` FOREIGN KEY (`patient_id`) REFERENCES `Patient` (`patient_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_medication_junction`
--

LOCK TABLES `patient_medication_junction` WRITE;
/*!40000 ALTER TABLE `patient_medication_junction` DISABLE KEYS */;
INSERT INTO `patient_medication_junction` VALUES (1,892,0);
/*!40000 ALTER TABLE `patient_medication_junction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Patient_PCP`
--

DROP TABLE IF EXISTS `Patient_PCP`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Patient_PCP` (
  `pcp_id` int NOT NULL AUTO_INCREMENT,
  `doctor_first_name` varchar(30) DEFAULT NULL,
  `doctor_last_name` varchar(30) DEFAULT NULL,
  `healthcareProvider` varchar(50) DEFAULT NULL,
  `patient_id` int DEFAULT NULL,
  PRIMARY KEY (`pcp_id`),
  KEY `fk_patient_id_` (`patient_id`),
  CONSTRAINT `fk_patient_id_` FOREIGN KEY (`patient_id`) REFERENCES `Patient` (`patient_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Patient_PCP`
--

LOCK TABLES `Patient_PCP` WRITE;
/*!40000 ALTER TABLE `Patient_PCP` DISABLE KEYS */;
INSERT INTO `Patient_PCP` VALUES (1,'Demitry','McGann','Aetna',1),(2,'Han','Zel','UPMC',2),(3,'Gret','Elivio','Cigna',3),(4,'Jamal','GE','UPMC',NULL),(5,'Jamal','Avery','UPMC',NULL);
/*!40000 ALTER TABLE `Patient_PCP` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-06 13:45:05
