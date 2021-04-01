-- drinks.ingredient definition

CREATE TABLE `ingredient` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(256) NOT NULL,
  `description` TEXT DEFAULT NULL,
  `type` VARCHAR(20) NOT NULL DEFAULT 'COCKTAIL',
  `price` DECIMAL(7,2) NOT NULL,
  `created_by` VARCHAR(60) NOT NULL,
  `created_date` DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `last_modify_by` VARCHAR(60) DEFAULT NULL,
  `last_modified_date` DATETIME(6) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK26hp93dj37w9wgo55l9aw0ohx` (`type`,`name`),
  UNIQUE KEY `UK_bcuaj97y3iu3t2vj26jg6hijj` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- drinks.drink definition

CREATE TABLE `drink` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(256) NOT NULL,
  `description` TEXT DEFAULT NULL,
  `type` VARCHAR(20) NOT NULL DEFAULT 'NO_ALCOHOLIC',
  `size` VARCHAR(10) DEFAULT 'MEDIUM',
  `price` DECIMAL(7,2) NOT NULL,
  `start_date` DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `end_date` DATETIME(6) DEFAULT NULL,
  `created_by` VARCHAR(60) NOT NULL,
  `created_date` DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `last_modify_by` VARCHAR(60) DEFAULT NULL,
  `last_modified_date` DATETIME(6) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_gf07vui7f23acsy3j161804ej` (`name`),
  UNIQUE KEY `UKc47t6nxt7cn3fubrrtxj0traw` (`type`,`size`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- drinks.localized_drink definition

CREATE TABLE `localized_drink` (  
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `drink_id` BIGINT(20) NOT NULL,
  `field_name` VARCHAR(60) NOT NULL,
  `locale` VARCHAR(2) NOT NULL,
  `value` TEXT NOT NULL,
  PRIMARY KEY (`id`,`drink_id`,`field_name`,`locale`),
  UNIQUE KEY `UKgqvof7yiv8tcp1oow1nrc0y0o` (`locale`,`field_name`,`value`) USING HASH,
  KEY `FKrr1sqtlg8091odotp9im5nd3v` (`drink_id`),
  CONSTRAINT `FKrr1sqtlg8091odotp9im5nd3v` FOREIGN KEY (`drink_id`) REFERENCES `drink` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- drinks.glass_cocktail definition

CREATE TABLE `glass_cocktail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(256) NOT NULL,
  `size` VARCHAR(10) NOT NULL DEFAULT 'MEDIUM',
  `created_by` VARCHAR(60) NOT NULL,
  `created_date` DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `last_modify_by` VARCHAR(60) DEFAULT NULL,
  `last_modified_date` DATETIME(6) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKt7pkyt6ja4pi0857kx0x0h6xh` (`size`,`name`),
  UNIQUE KEY `UK_i4a9nwku6weu6lq0gvqxtmyqc` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- drinks.cocktail definition

CREATE TABLE `cocktail` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(256) NOT NULL,
  `description` TEXT DEFAULT NULL,
  `preparation` TEXT NOT NULL,
  `glass_cocktail_id` INT(11) DEFAULT NULL,
  `type` VARCHAR(20) NOT NULL DEFAULT 'APPETIZER',
  `price` DECIMAL(7,2) NOT NULL,
  `start_date` DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `end_date` DATETIME(6) DEFAULT NULL,
  `created_by` VARCHAR(60) NOT NULL,
  `created_date` DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `last_modify_by` VARCHAR(60) DEFAULT NULL,
  `last_modified_date` DATETIME(6) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK8djt9f6w2ogabcfub62nobuqa` (`type`,`name`),
  UNIQUE KEY `UK_idg61yo32m6skd39pl3unjjjv` (`name`),
  KEY `FK9g38s7di8qni33keiiovpde6m` (`glass_cocktail_id`),
  CONSTRAINT `FK9g38s7di8qni33keiiovpde6m` FOREIGN KEY (`glass_cocktail_id`) REFERENCES `glass_cocktail` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- drinks.localized_cocktail definition

CREATE TABLE `localized_cocktail` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `cocktail_id` BIGINT(20) NOT NULL,
  `field_name` VARCHAR(60) NOT NULL,
  `locale` VARCHAR(2) NOT NULL,
  `value` TEXT NOT NULL,
  PRIMARY KEY (`id`,`cocktail_id`,`field_name`,`locale`),
  UNIQUE KEY `UK2t1lew95dvajrqiueckphp06h` (`locale`,`field_name`,`value`) USING HASH,
  KEY `FK6ijw6qa08kakgrpb9e5ngmpdo` (`cocktail_id`),
  CONSTRAINT `FK6ijw6qa08kakgrpb9e5ngmpdo` FOREIGN KEY (`cocktail_id`) REFERENCES `cocktail` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- drinks.cocktail_ingredient definition

CREATE TABLE `cocktail_ingredient` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `ingredient_id` BIGINT(20) NOT NULL,
  `cocktail_id` BIGINT(20) NOT NULL,
  `position` SMALLINT(6) NOT NULL,
  `count` VARCHAR(255) NOT NULL,
  `created_at` DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  PRIMARY KEY (`id`),
  KEY `FKdtpdp8nx2opyj5ylwk60f915v` (`cocktail_id`),
  KEY `FKjmwkmu750duaxxgvge2qj1dy1` (`ingredient_id`),
  CONSTRAINT `FKdtpdp8nx2opyj5ylwk60f915v` FOREIGN KEY (`cocktail_id`) REFERENCES `cocktail` (`id`),
  CONSTRAINT `FKjmwkmu750duaxxgvge2qj1dy1` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;