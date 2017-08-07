/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for actualize
CREATE DATABASE IF NOT EXISTS `actualize` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `actualize`;

-- Dumping structure for table actualize.client
CREATE TABLE IF NOT EXISTS `client` (
  `clientId` varchar(50) NOT NULL,
  `clientName` varchar(25) NOT NULL,
  `address` varchar(250) DEFAULT NULL,
  `creationDate` timestamp NULL DEFAULT NULL,
  `modificationDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `sessionTimeOut` varchar(255) NOT NULL DEFAULT '300',
  PRIMARY KEY (`clientId`),
  UNIQUE KEY `clientName` (`clientName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table actualize.client: ~5 rows (approximately)
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
REPLACE INTO `client` (`clientId`, `clientName`, `address`, `creationDate`, `modificationDate`, `sessionTimeOut`) VALUES
	('416365b2-75c6-11e7-b5a5-be2e44b06b34', 'Actualize', 'HYD', '2017-07-26 00:00:00', '2017-08-03 15:31:26', '300'),
	('a00deb64-7832-11e7-b5a5-be2e44b06b34', 'MuncyBank', 'US', '2017-08-03 15:31:18', '2017-08-03 15:31:24', '300'),
	('a00deefc-7832-11e7-b5a5-be2e44b06b34', 'CottonPortBank', 'US', '2017-08-03 15:32:03', '2017-08-03 15:32:03', '300'),
	('a00df0d2-7832-11e7-b5a5-be2e44b06b34', 'MyCreditUnion', 'US', '2017-08-03 15:33:24', '2017-08-03 15:33:25', '300'),
	('a00df26c-7832-11e7-b5a5-be2e44b06b34', 'BankOfLux', 'US', '2017-08-03 15:35:53', '2017-08-03 15:35:53', '300');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;

-- Dumping structure for table actualize.role
CREATE TABLE IF NOT EXISTS `role` (
  `roleId` varchar(50) NOT NULL,
  `roleName` varchar(25) NOT NULL,
  `displayName` varchar(25) NOT NULL,
  `creationDate` timestamp NULL DEFAULT NULL,
  `modificationDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`roleId`),
  UNIQUE KEY `roleNameUnique` (`roleName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table actualize.role: ~3 rows (approximately)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
REPLACE INTO `role` (`roleId`, `roleName`, `displayName`, `creationDate`, `modificationDate`) VALUES
	('4163601c-75c6-11e7-b5a5-be2e44b06b34', 'ADMIN', 'Administrator', '2017-07-26 00:00:00', '2017-07-31 13:49:53'),
	('41637156-75c6-11e7-b5a5-be2e44b06b34', 'SUPER_ADMIN', 'Super Administrator', '2017-07-31 13:53:34', '2017-07-31 13:53:36'),
	('416373c2-75c6-11e7-b5a5-be2e44b06b34', 'USER', 'Standard User', '2017-07-31 13:54:04', '2017-07-31 13:54:04');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Dumping structure for table actualize.services
CREATE TABLE IF NOT EXISTS `services` (
  `serviceId` varchar(50) NOT NULL,
  `serviceName` varchar(50) NOT NULL,
  `serviceDisplayName` varchar(50) NOT NULL,
  `serviceDescription` varchar(1500) NOT NULL,
  `creationDate` timestamp NULL DEFAULT NULL,
  `modificationDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`serviceId`),
  UNIQUE KEY `serviceName` (`serviceName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table actualize.services: ~0 rows (approximately)
/*!40000 ALTER TABLE `services` DISABLE KEYS */;
/*!40000 ALTER TABLE `services` ENABLE KEYS */;

-- Dumping structure for table actualize.useractivity
CREATE TABLE IF NOT EXISTS `useractivity` (
  `useractivityId` varchar(50) NOT NULL,
  `userId` varchar(25) NOT NULL,
  `loanId` varchar(25) NOT NULL,
  `serviceUtilized` varchar(100) NOT NULL,
  `responseStatus` varchar(10) NOT NULL,
  `requestStartTime` varchar(50) NOT NULL,
  `timeLapsedForRequest` varchar(50) NOT NULL,
  `creationDate` timestamp NULL DEFAULT NULL,
  `modificationDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`useractivityId`),
  KEY `activityUser` (`userId`),
  CONSTRAINT `activityUser` FOREIGN KEY (`userId`) REFERENCES `userdetails` (`userid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table actualize.useractivity: ~0 rows (approximately)
/*!40000 ALTER TABLE `useractivity` DISABLE KEYS */;
/*!40000 ALTER TABLE `useractivity` ENABLE KEYS */;

-- Dumping structure for table actualize.userdetails
CREATE TABLE IF NOT EXISTS `userdetails` (
  `userId` varchar(50) NOT NULL,
  `firstName` varchar(25) DEFAULT NULL,
  `lastName` varchar(25) DEFAULT NULL,
  `middleName` varchar(25) DEFAULT NULL,
  `suffix` varchar(25) DEFAULT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(200) NOT NULL,
  `email` varchar(50) NOT NULL,
  `authorities` varchar(360) NOT NULL,
  `accountNonExpired` char(1) NOT NULL,
  `accountNonLocked` char(1) NOT NULL,
  `credentialsNonExpired` char(1) NOT NULL,
  `failedLoginAttempts` int(11) NOT NULL,
  `resetPassword` char(1) NOT NULL,
  `enabled` char(1) NOT NULL,
  `passwordExpiryDate` varchar(50) NOT NULL,
  `lastSuccessfulLogin` varchar(50) NOT NULL,
  `lastSuccessfulLogout` varchar(50) NOT NULL,
  `sessionTimeOut` varchar(50) NOT NULL,
  `roleid` varchar(50) NOT NULL,
  `clientid` varchar(50) NOT NULL,
  `updatedBy` varchar(50) NOT NULL,
  `modificationDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `creationDate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `username` (`username`),
  KEY `userClient` (`clientid`),
  KEY `userrole` (`roleid`),
  CONSTRAINT `userClient` FOREIGN KEY (`clientid`) REFERENCES `client` (`clientId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `userrole` FOREIGN KEY (`roleid`) REFERENCES `role` (`roleId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table actualize.userdetails: ~15 rows (approximately)
/*!40000 ALTER TABLE `userdetails` DISABLE KEYS */;
REPLACE INTO `userdetails` (`userId`, `firstName`, `lastName`, `middleName`, `suffix`, `username`, `password`, `email`, `authorities`, `accountNonExpired`, `accountNonLocked`, `credentialsNonExpired`, `failedLoginAttempts`, `resetPassword`, `enabled`, `passwordExpiryDate`, `lastSuccessfulLogin`, `lastSuccessfulLogout`, `sessionTimeOut`, `roleid`, `clientid`, `updatedBy`, `modificationDate`, `creationDate`) VALUES
	('7fd5427e-7833-11e7-b5a5-be2e44b06b34', 'Compugain', 'HYD', NULL, 'Mr', 'admin', '$2a$10$iyzaWY22jmh3qSCepfwMg.PEIS8/GfYp4JLNqiBV0i2mTM4Abr3pm', 'admin@compugain.com', 'abc,def', '1', '1', '1', 1, '1', '1', '2017-08-30', '2017-08-03', '2017-08-03', '300', '41637156-75c6-11e7-b5a5-be2e44b06b34', '416365b2-75c6-11e7-b5a5-be2e44b06b34', 'admin', '2017-08-03 15:52:51', '2017-08-03 15:38:47'),
	('7fd54512-7833-11e7-b5a5-be2e44b06b34', 'Jane', 'Miller', NULL, 'Mr', 'jane.miller@muncybank.com', '$2a$10$d84Zkfbb30Be/qkbIsQple4brdAbict7O/fhnjnrU8HVN7c086Vju', 'jane.miller@muncybank.com', 'abc,def', '1', '1', '1', 1, '1', '1', '2017-08-30', '2017-08-03', '2017-08-03', '300', '4163601c-75c6-11e7-b5a5-be2e44b06b34', 'a00deb64-7832-11e7-b5a5-be2e44b06b34', 'admin', '2017-08-03 15:53:01', '2017-08-03 15:52:15'),
	('7fd5460c-7833-11e7-b5a5-be2e44b06b34', 'Vanessa', 'Vankirk', NULL, 'Ms', 'vanessa.vankirk@muncybank.com', '$2a$10$KM6TNNOmpMInLEuUOGzJ1urtKswF5jv1KlmNl6MNyFKrrprQcaeRi', 'vanessa.vankirk@muncybank.com', 'abc,def', '1', '1', '1', 1, '1', '1', '2017-08-30', '2017-08-03', '2017-08-03', '300', '4163601c-75c6-11e7-b5a5-be2e44b06b34', 'a00deb64-7832-11e7-b5a5-be2e44b06b34', 'admin', '2017-08-03 16:12:57', '2017-08-03 15:56:16'),
	('7fd54a44-7833-11e7-b5a5-be2e44b06b34', 'Michelle', 'Paisley', NULL, 'Ms', 'michelle.paisley@muncybank.com', '$2a$10$V1v3NCun43TGCQxXAQZb5O5GJP/1qEFaQXM3b9auwL5J9lZpHrAvC', 'michelle.paisley@muncybank.com', 'abc,def', '1', '1', '1', 1, '1', '1', '2017-08-30', '2017-08-03', '2017-08-03', '300', '4163601c-75c6-11e7-b5a5-be2e44b06b34', 'a00deb64-7832-11e7-b5a5-be2e44b06b34', 'admin', '2017-08-03 16:13:01', '2017-08-03 16:00:12'),
	('7fd54b34-7833-11e7-b5a5-be2e44b06b34', 'Toni', 'Levandoski', NULL, 'Mr', 'toni.levandoski@muncybank.com', '$2a$10$UosCahpmwM7hydNDs7PIqetb3blzyvbhYEBLFowwEohYAFHEJb5LK', 'toni.levandoski@muncybank.com', 'abc,def', '1', '1', '1', 1, '1', '1', '2017-08-30', '2017-08-03', '2017-08-03', '300', '4163601c-75c6-11e7-b5a5-be2e44b06b34', 'a00deb64-7832-11e7-b5a5-be2e44b06b34', 'admin', '2017-08-03 17:41:27', '2017-08-03 16:11:02'),
	('7fd54c24-7833-11e7-b5a5-be2e44b06b34', 'Roxann', 'Emick', NULL, 'Mr', 'roxann.emick@muncybank.com', '$2a$10$/TMN53dt5dPkRil4m.HK1usN21/XJo6j6h0KXsWOn/B83Un7FxaY6', 'roxann.emick@muncybank.com', 'abc,def', '1', '1', '1', 1, '1', '1', '2017-08-30', '2017-08-03', '2017-08-03', '300', '4163601c-75c6-11e7-b5a5-be2e44b06b34', 'a00deb64-7832-11e7-b5a5-be2e44b06b34', 'admin', '2017-08-03 16:45:27', '2017-08-03 16:45:27'),
	('7fd54cec-7833-11e7-b5a5-be2e44b06b34', 'Michelle', 'G', NULL, 'Mr', 'michelleg@cottonportbank.com', '$2a$10$9FuFbnJCo1xSBS65A7uiaeBD.vyJ/ocFaidScRxWhRY9n4Yl6RhoK', 'michelleg@cottonportbank.com', 'abc,def', '1', '1', '1', 1, '1', '1', '1', '1', '1', '300', '4163601c-75c6-11e7-b5a5-be2e44b06b34', 'a00deefc-7832-11e7-b5a5-be2e44b06b34', 'admin', '2017-08-03 17:02:42', '2017-08-03 16:48:13'),
	('7fd54db4-7833-11e7-b5a5-be2e44b06b34', 'Clasisad', NULL, NULL, 'Mr', 'clarisad@cottonportbank.com', '$2a$10$FwGpnVC1yTjfEIr3td74ZOnX7fixBQ.9jT8OgxXB5KuZPHk1Rumcy', 'clarisad@cottonportbank.com', 'abc,def', '1', '1', '1', 1, '1', '1', '1', '1', '1', '300', '4163601c-75c6-11e7-b5a5-be2e44b06b34', 'a00deefc-7832-11e7-b5a5-be2e44b06b34', 'admin', '2017-08-03 16:50:53', '2017-08-03 16:50:54'),
	('7fd54e7c-7833-11e7-b5a5-be2e44b06b34', 'Alisha', NULL, NULL, 'Ms', 'alisha@mycreditunion.com', '$2a$10$NcTag/UyAj.E94UIPgALF.rh6UkcYN1FWuEs2VyVnNU4qWK6TphB6', 'alisha@mycreditunion.com', 'abc,def', '1', '1', '1', 1, '1', '1', '1', '1', '1', '300', '4163601c-75c6-11e7-b5a5-be2e44b06b34', 'a00df0d2-7832-11e7-b5a5-be2e44b06b34', 'admin', '2017-08-03 17:02:45', '2017-08-03 17:01:29'),
	('7fd54f4e-7833-11e7-b5a5-be2e44b06b34', 'Tracy', NULL, NULL, 'Ms', 'tracy@mycreditunion.com', '$2a$10$DuWIVtPR7zXhMzpRraNRUuapa88FyyTBZZeyKmoWzvLSyHjO2iyMG', 'tracy@mycreditunion.com', 'abc,def', '1', '1', '1', 1, '1', '1', '1', '1', '1', '1', '4163601c-75c6-11e7-b5a5-be2e44b06b34', 'a00df0d2-7832-11e7-b5a5-be2e44b06b34', 'admin', '2017-08-03 17:04:54', '2017-08-03 17:04:55'),
	('87ab44b4-7840-11e7-b5a5-be2e44b06b34', 'Tiffany', NULL, NULL, 'Mr', 'tiffany@mycreditunion.com', '$2a$10$2kwQdyJT1ixZtS9cz5eDPOkkfOCXLBqHba.rB3TigRs8JRlsTG15q', 'tiffany@mycreditunion.com', 'abc,def', '1', '1', '1', 1, '1', '1', '1', '1', '1', '1', '4163601c-75c6-11e7-b5a5-be2e44b06b34', 'a00df0d2-7832-11e7-b5a5-be2e44b06b34', 'admin', '2017-08-03 17:15:08', '2017-08-03 17:15:09'),
	('87ab473e-7840-11e7-b5a5-be2e44b06b34', 'Pam', NULL, NULL, 'Mr', 'pam@mycreditunion.com', '$2a$10$9Dl2QqbR44Tyxvq.R7W2c.NMrz1JfqwzSNpSuNIaq7PN7c936a0Ly', 'pam@mycreditunion.com', 'abc,def', '1', '1', '1', 1, '1', '1', '1', '1', '1', '300', '4163601c-75c6-11e7-b5a5-be2e44b06b34', 'a00df0d2-7832-11e7-b5a5-be2e44b06b34', 'admin', '2017-08-03 17:16:56', '2017-08-03 17:16:56'),
	('87ab4982-7840-11e7-b5a5-be2e44b06b34', 'Crystal', 'Schneider', NULL, 'Mr', 'crystalschneider@bankoflux.com', '$2a$10$6jj.tf.0EWso17UiAhOo9Osmxqq8Jwv2z1q9akGpHSK2BgsR/dzZ6', 'crystalschneider@bankoflux.com', 'abc,de', '1', '1', '1', 1, '1', '1', '1', '1', '1', '300', '4163601c-75c6-11e7-b5a5-be2e44b06b34', 'a00df26c-7832-11e7-b5a5-be2e44b06b34', 'admin', '2017-08-03 17:33:23', '2017-08-03 17:33:24'),
	('87ab4e8c-7840-11e7-b5a5-be2e44b06b34', 'Trinamatzke', NULL, NULL, 'Mr', 'trinamatzke@bankoflux.com', '$2a$10$Q1WxLWId2QuSo6JcXC6e3.mNOu4HfgF4njlCo53OM83AcIJYVKVAC', 'trinamatzke@bankoflux.com', 'abc,def', '1', '1', '1', 1, '1', '1', '1', '1', '1', '300', '4163601c-75c6-11e7-b5a5-be2e44b06b34', 'a00df26c-7832-11e7-b5a5-be2e44b06b34', 'admin', '2017-08-03 17:34:55', '2017-08-03 17:34:56'),
	('87ab5094-7840-11e7-b5a5-be2e44b06b34', 'Ashleymetzler', NULL, NULL, 'Mr', 'ashleymetzler@bankoflux.com', '$2a$10$tXAh2bFJ224O6B/.vHMeQ.GfGQO1W7raf18Y27vOZKdTQv6jTSQRe', 'ashleymetzler@bankoflux.com', 'abc,def', '1', '1', '1', 1, '1', '1', '1', '1', '1', '300', '4163601c-75c6-11e7-b5a5-be2e44b06b34', 'a00df26c-7832-11e7-b5a5-be2e44b06b34', 'admin', '2017-08-03 17:36:49', '2017-08-03 17:36:49');
/*!40000 ALTER TABLE `userdetails` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;


create table oauth_client_details (
  client_id VARCHAR(255) PRIMARY KEY,
  resource_ids VARCHAR(255),
  client_secret VARCHAR(255),
  scope VARCHAR(255),
  authorized_grant_types VARCHAR(255),
  web_server_redirect_uri VARCHAR(255),
  authorities VARCHAR(255),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(255)
);

create table oauth_client_token (
  token_id VARCHAR(255),
  token BLOB,
  authentication_id VARCHAR(255),
  user_name VARCHAR(255),
  client_id VARCHAR(255)
);

create table oauth_access_token (
  token_id VARCHAR(255),
  token BLOB,
  authentication_id VARCHAR(255),
  user_name VARCHAR(255),
  client_id VARCHAR(255),
  authentication BLOB,
  refresh_token VARCHAR(255)
);

create table oauth_refresh_token (
  token_id VARCHAR(255),
  token BLOB,
  authentication BLOB
);

create table oauth_code (
  code VARCHAR(255), authentication BLOB
);
