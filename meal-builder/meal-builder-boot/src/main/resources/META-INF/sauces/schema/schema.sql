
-- sauces.ingredient definition

CREATE TABLE `ingredient` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) NOT NULL,
  `description` text DEFAULT NULL,
  `type` varchar(20) NOT NULL DEFAULT 'SAUCE',
  `price` decimal(7,2) NOT NULL,
  `created_by` varchar(60) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `last_modify_by` varchar(60) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK26hp93dj37w9wgo55l9aw0ohx` (`type`,`name`),
  UNIQUE KEY `UK_bcuaj97y3iu3t2vj26jg6hijj` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- sauces.sauce definition

CREATE TABLE `sauce` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) NOT NULL,
  `description` text DEFAULT NULL,
  `preparation` text NOT NULL,
  `size` varchar(10) DEFAULT 'MEDIUM',
  `price` decimal(7,2) NOT NULL,
  `created_by` varchar(60) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `last_modify_by` varchar(60) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_s4feg9vkis7xjax33j89i96s0` (`name`),
  UNIQUE KEY `UKh3xa3ghyk96hjxio65cxeimiy` (`size`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- sauces.sauce_ingredient definition

CREATE TABLE `sauce_ingredient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ingredient_id` bigint(20) NOT NULL,
  `sauce_id` bigint(20) NOT NULL,
  `position` smallint(6) NOT NULL,
  `count` varchar(255) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3ju76bhlws0ifbujk6rnqb2cq` (`ingredient_id`),
  KEY `FK3f3m8lwhbb3nqc5sag2xx5u7x` (`sauce_id`),
  CONSTRAINT `FK3f3m8lwhbb3nqc5sag2xx5u7x` FOREIGN KEY (`sauce_id`) REFERENCES `sauce` (`id`),
  CONSTRAINT `FK3ju76bhlws0ifbujk6rnqb2cq` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;