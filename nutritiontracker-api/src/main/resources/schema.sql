DROP TABLE IF EXISTS `person`;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `data_calculation`;
DROP TABLE IF EXISTS `foods`;

CREATE TABLE `user` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(190) NOT NULL,
    `password` VARCHAR(190) NOT NULL,
    `name`VARCHAR(190) NOT NULL,
    `email`VARCHAR(190) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE(username)
);

CREATE TABLE `person` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`user_id` INT(11) NULL DEFAULT NULL,
	`name` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`photo` VARCHAR(255) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`age` INT(11) NOT NULL,
	`gender` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`physical_activity` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `name` (`name`),
	INDEX `FK_person_user_id` (`user_id`),
	CONSTRAINT `FK_person_user_id` FOREIGN KEY (`user_id`) REFERENCES `person` (`id`)
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

CREATE TABLE IF NOT EXISTS `foods` (
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