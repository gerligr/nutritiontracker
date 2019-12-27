DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `person`;
DROP TABLE IF EXISTS `data_calculation`;
DROP TABLE IF EXISTS `menu`;
DROP TABLE IF EXISTS `person_menu`;


CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(190) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(190) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(190) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(190) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
);

CREATE TABLE IF NOT EXISTS `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `photo` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `age` int(11) NOT NULL,
  `gender` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `physical_activity` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_person_user_id` (`user_id`),
  CONSTRAINT `FK_person_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
);

CREATE TABLE IF NOT EXISTS `data_calculation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gender` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `age` int(11) NOT NULL,
  `physical_activity` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `energy` int(11) NOT NULL,
  `protein_min` int(11) NOT NULL,
  `protein_max` int(11) NOT NULL,
  `fat_min` int(11) NOT NULL,
  `fat_max` int(11) NOT NULL,
  `carb_min` int(11) NOT NULL,
  `carb_max` int(11) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `energy` int(11) NOT NULL,
  `protein` int(11) NOT NULL,
  `fat` int(11) NOT NULL,
  `carb` int(11) NOT NULL,
  `ingredients` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `instructions` text COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `person_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `person_id` int(11) NOT NULL,
  `breakfast` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `breakfast_amount` int(11) NOT NULL DEFAULT 0,
  `lunchsnack` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT '0',
  `lunchsnack_amount` int(11) DEFAULT 0,
  `lunch` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0',
  `lunch_amount` int(11) NOT NULL DEFAULT 0,
  `dinnersnack` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT '0',
  `dinnersnack_amount` int(11) DEFAULT 0,
  `dinner` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0',
  `dinner_amount` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `FK1_person_menu_person` (`person_id`),
  CONSTRAINT `FK1_person_menu_person` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`)
);