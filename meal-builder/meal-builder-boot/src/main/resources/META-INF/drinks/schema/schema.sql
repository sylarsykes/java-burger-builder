
-- drinks.ingredient definition

CREATE TABLE `ingredient` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) NOT NULL,
  `description` text DEFAULT NULL,
  `price` decimal(7,2) NOT NULL,
  `type` varchar(20) NOT NULL DEFAULT 'COCKTAIL',
  `created_by` varchar(60) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `last_modify_by` varchar(60) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK26hp93dj37w9wgo55l9aw0ohx` (`type`,`name`),
  UNIQUE KEY `UK_bcuaj97y3iu3t2vj26jg6hijj` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- drinks.drink definition

CREATE TABLE `drink` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) NOT NULL,
  `description` text DEFAULT NULL,
  `type` varchar(20) NOT NULL DEFAULT 'NO_ALCOHOLIC',
  `size` varchar(10) DEFAULT 'MEDIUM',
  `price` decimal(7,2) NOT NULL,
  `created_by` varchar(60) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `last_modify_by` varchar(60) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_gf07vui7f23acsy3j161804ej` (`name`),
  UNIQUE KEY `UKc47t6nxt7cn3fubrrtxj0traw` (`type`,`size`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- drinks.localized_name_drink definition

CREATE TABLE `localized_name_drink` (
  `drink_id` bigint(20) NOT NULL,
  `locale` varchar(2) NOT NULL,
  `field_name` varchar(60) NOT NULL,
  `value` text NOT NULL,
  PRIMARY KEY (`field_name`,`drink_id`,`locale`),
  UNIQUE KEY `UKmxw10kl8j49htwu4lfrv9jrjm` (`locale`,`field_name`,`value`) USING HASH,
  KEY `FK8s39i17pvpb6h82e7qi0h1m7q` (`drink_id`),
  CONSTRAINT `FK8s39i17pvpb6h82e7qi0h1m7q` FOREIGN KEY (`drink_id`) REFERENCES `drink` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- drinks.localized_description_drink definition

CREATE TABLE `localized_description_drink` (
  `drink_id` bigint(20) NOT NULL,
  `locale` varchar(2) NOT NULL,
  `field_name` varchar(60) NOT NULL,
  `value` text NOT NULL,
  PRIMARY KEY (`field_name`,`drink_id`,`locale`),
  UNIQUE KEY `UKqoay0c3pf0evvgnwfj7r74g5t` (`locale`,`field_name`,`value`) USING HASH,
  KEY `FKspxw4x8calqkfhk7wwxsxpmik` (`drink_id`),
  CONSTRAINT `FKspxw4x8calqkfhk7wwxsxpmik` FOREIGN KEY (`drink_id`) REFERENCES `drink` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- drinks.cocktail definition

CREATE TABLE `cocktail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) NOT NULL,
  `description` text DEFAULT NULL,
  `preparation` text NOT NULL,
  `glass_cocktail_id` int(11) DEFAULT NULL,
  `type` varchar(20) NOT NULL DEFAULT 'NO_ALCOHOLIC',
  `price` decimal(7,2) NOT NULL,
  `created_by` varchar(60) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `last_modify_by` varchar(60) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK8djt9f6w2ogabcfub62nobuqa` (`type`,`name`),
  UNIQUE KEY `UK_idg61yo32m6skd39pl3unjjjv` (`name`),
  KEY `FK9g38s7di8qni33keiiovpde6m` (`glass_cocktail_id`),
  CONSTRAINT `FK9g38s7di8qni33keiiovpde6m` FOREIGN KEY (`glass_cocktail_id`) REFERENCES `glass_cocktail` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- drinks.cocktail_ingredient definition

CREATE TABLE `cocktail_ingredient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ingredient_id` bigint(20) NOT NULL,
  `cocktail_id` bigint(20) NOT NULL,
  `position` smallint(6) NOT NULL,
  `count` varchar(255) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdtpdp8nx2opyj5ylwk60f915v` (`cocktail_id`),
  KEY `FKjmwkmu750duaxxgvge2qj1dy1` (`ingredient_id`),
  CONSTRAINT `FKdtpdp8nx2opyj5ylwk60f915v` FOREIGN KEY (`cocktail_id`) REFERENCES `cocktail` (`id`),
  CONSTRAINT `FKjmwkmu750duaxxgvge2qj1dy1` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;