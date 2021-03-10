-- meals.ingredient definition

CREATE TABLE `ingredient` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) NOT NULL,
  `description` text DEFAULT NULL,
  `type` varchar(20) NOT NULL DEFAULT 'BURGER',
  `price` decimal(7,2) NOT NULL,
  `created_by` varchar(60) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `last_modify_by` varchar(60) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK26hp93dj37w9wgo55l9aw0ohx` (`type`,`name`),
  UNIQUE KEY `UK_bcuaj97y3iu3t2vj26jg6hijj` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- meals.category definition

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(10) NOT NULL,
  `description` text DEFAULT NULL,
  `created_by` varchar(60) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `last_modify_by` varchar(60) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_acatplu22q5d1andql2jbvjy7` (`code`),
  UNIQUE KEY `UKacatplu22q5d1andql2jbvjy7` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- meals.food_starter definition

CREATE TABLE `food_starter` (
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
  UNIQUE KEY `UK_9y6q6env51vv7mbtd7i2t28oh` (`name`),
  UNIQUE KEY `UK8dl2ve9m5vbdwukwt6ma3ktwo` (`size`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- meals.food_starter_ingredient definition

CREATE TABLE `food_starter_ingredient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ingredient_id` bigint(20) NOT NULL,
  `food_starter_id` bigint(20) NOT NULL,
  `position` smallint(6) NOT NULL,
  `count` varchar(255) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKampj7spg1cjl0u8kcqq2fk0ed` (`food_starter_id`),
  KEY `FKlfhj2nwg4p1dmrko1kv82cs9s` (`ingredient_id`),
  CONSTRAINT `FKampj7spg1cjl0u8kcqq2fk0ed` FOREIGN KEY (`food_starter_id`) REFERENCES `food_starter` (`id`),
  CONSTRAINT `FKlfhj2nwg4p1dmrko1kv82cs9s` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- meals.salad definition

CREATE TABLE `salad` (
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
  UNIQUE KEY `UK_b53pmsuhgdiuj5bp3fkduy2bs` (`name`),
  UNIQUE KEY `UKc4sm3heeh6pbn8bw2i1lbbcs4` (`size`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- meals.salad_ingredient definition

CREATE TABLE `salad_ingredient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ingredient_id` bigint(20) NOT NULL,
  `salad_id` bigint(20) NOT NULL,
  `position` smallint(6) NOT NULL,
  `count` varchar(255) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK68xnrq41rruvg4sq75nsvvd5v` (`ingredient_id`),
  KEY `FK4kr6quijq6hp3krqcovfbq5kp` (`salad_id`),
  CONSTRAINT `FK4kr6quijq6hp3krqcovfbq5kp` FOREIGN KEY (`salad_id`) REFERENCES `salad` (`id`),
  CONSTRAINT `FK68xnrq41rruvg4sq75nsvvd5v` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- meals.burger definition

CREATE TABLE `burger` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) NOT NULL,
  `description` text DEFAULT NULL,
  `preparation` text NOT NULL,
  `type` varchar(10) DEFAULT 'MEAT',
  `size` varchar(10) DEFAULT 'MEDIUM',
  `price` decimal(7,2) NOT NULL,
  `created_by` varchar(60) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `last_modify_by` varchar(60) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_qm9rsq8wk7j98djf79cndlj3o` (`name`),
  UNIQUE KEY `UK1xa9grvsp1gxvrrdglu4crrjk` (`type`,`size`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- meals.burger_category definition

CREATE TABLE `burger_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `burger_id` bigint(20) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKejdbb4dtfr2mhdnltadpjd61j` (`burger_id`),
  KEY `FKhj25tqm17cde5m7my9idmwr0y` (`category_id`),
  CONSTRAINT `FKejdbb4dtfr2mhdnltadpjd61j` FOREIGN KEY (`burger_id`) REFERENCES `burger` (`id`),
  CONSTRAINT `FKhj25tqm17cde5m7my9idmwr0y` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- meals.burger_bread definition

CREATE TABLE `burger_bread` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `burger_id` bigint(20) NOT NULL,
  `name` varchar(256) NOT NULL,
  `description` text DEFAULT NULL,
  `size` varchar(10) DEFAULT 'MEDIUM',
  `price` decimal(7,2) NOT NULL,
  `created_by` varchar(60) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `last_modify_by` varchar(60) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sbl2n2avwram9df2dfe1s9mv` (`name`),
  UNIQUE KEY `UKhm26ajoy4gw55b9c50bfpdyvp` (`size`,`name`),
  KEY `FK8qsr2vmj818mmx3fj9nkn5jkj` (`burger_id`),
  CONSTRAINT `FK8qsr2vmj818mmx3fj9nkn5jkj` FOREIGN KEY (`burger_id`) REFERENCES `burger` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- meals.burger_ingredient definition

CREATE TABLE `burger_ingredient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ingredient_id` bigint(20) NOT NULL,
  `burger_id` bigint(20) NOT NULL,
  `position` smallint(6) NOT NULL,
  `count` varchar(255) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdqlgnllbd1ey0mos6gy60d45l` (`burger_id`),
  KEY `FK1dsqnsuwv510eu83kiqvh1b2n` (`ingredient_id`),
  CONSTRAINT `FK1dsqnsuwv510eu83kiqvh1b2n` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredient` (`id`),
  CONSTRAINT `FKdqlgnllbd1ey0mos6gy60d45l` FOREIGN KEY (`burger_id`) REFERENCES `burger` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- meals.kebab definition

CREATE TABLE `kebab` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) NOT NULL,
  `description` text DEFAULT NULL,
  `preparation` text NOT NULL,
  `type` varchar(10) DEFAULT 'MEAT',
  `size` varchar(10) DEFAULT 'MEDIUM',
  `price` decimal(7,2) NOT NULL,
  `kebab_bread_id` int(11) DEFAULT NULL,
  `created_by` varchar(60) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `last_modify_by` varchar(60) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_4138eamu2jhkwcw5vg2ysbytn` (`name`),
  UNIQUE KEY `UKqcltwq6tgjwlry2ypfnxe2bce` (`type`,`size`,`name`),
  KEY `FK1nf2im9097o1itjqekstltj2` (`kebab_bread_id`),
  CONSTRAINT `FK1nf2im9097o1itjqekstltj2` FOREIGN KEY (`kebab_bread_id`) REFERENCES `kebab_bread` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- meals.kebab_bread definition

CREATE TABLE `kebab_bread` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) NOT NULL,
  `description` text DEFAULT NULL,
  `size` varchar(10) DEFAULT 'MEDIUM',
  `price` decimal(7,2) NOT NULL,
  `created_by` varchar(60) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `last_modify_by` varchar(60) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_rvh6a6xhugc3lius6ceoyqcdg` (`name`),
  UNIQUE KEY `UKmvsa0rwoomhh4ygeqhrer1syr` (`size`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- meals.kebab_category definition

CREATE TABLE `kebab_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `kebab_id` bigint(20) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd858l9mjii8nbjgvwtyr7xagq` (`category_id`),
  KEY `FK8yp2xw2c18xtya4eymydnaei7` (`kebab_id`),
  CONSTRAINT `FK8yp2xw2c18xtya4eymydnaei7` FOREIGN KEY (`kebab_id`) REFERENCES `kebab` (`id`),
  CONSTRAINT `FKd858l9mjii8nbjgvwtyr7xagq` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- meals.kebab_ingredient definition

CREATE TABLE `kebab_ingredient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ingredient_id` bigint(20) NOT NULL,
  `kebab_id` bigint(20) NOT NULL,
  `position` smallint(6) NOT NULL,
  `count` varchar(255) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg9jdr8qnc0dpt7l83qdk33tdk` (`ingredient_id`),
  KEY `FKf93ext6gqkhwdwlj0hckv0450` (`kebab_id`),
  CONSTRAINT `FKf93ext6gqkhwdwlj0hckv0450` FOREIGN KEY (`kebab_id`) REFERENCES `kebab` (`id`),
  CONSTRAINT `FKg9jdr8qnc0dpt7l83qdk33tdk` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- meals.sandwich definition

CREATE TABLE `sandwich` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) NOT NULL,
  `description` text DEFAULT NULL,
  `preparation` text NOT NULL,
  `type` varchar(10) DEFAULT 'MEAT',
  `size` varchar(10) DEFAULT 'MEDIUM',
  `price` decimal(7,2) NOT NULL,
  `created_by` varchar(60) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `last_modify_by` varchar(60) DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_euqr9nguy55hdtd51ktw4icjt` (`name`),
  UNIQUE KEY `UKixme17ogrgwnlidwymq9ea7x6` (`type`,`size`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- meals.sandwich_category definition

CREATE TABLE `sandwich_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `sandwich_id` bigint(20) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8uipxdwhpt8dra7qr6s9m0yss` (`category_id`),
  KEY `FKf9ovcyce5d3sapkiyctr6vj1w` (`sandwich_id`),
  CONSTRAINT `FK8uipxdwhpt8dra7qr6s9m0yss` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FKf9ovcyce5d3sapkiyctr6vj1w` FOREIGN KEY (`sandwich_id`) REFERENCES `sandwich` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- meals.sandwich_ingredient definition

CREATE TABLE `sandwich_ingredient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ingredient_id` bigint(20) NOT NULL,
  `sandwich_id` bigint(20) NOT NULL,
  `position` smallint(6) NOT NULL,
  `count` varchar(255) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsfufp5xnlnb98gf67j8o00115` (`ingredient_id`),
  KEY `FKi0w83qwt5n3227k266sjey9jo` (`sandwich_id`),
  CONSTRAINT `FKi0w83qwt5n3227k266sjey9jo` FOREIGN KEY (`sandwich_id`) REFERENCES `sandwich` (`id`),
  CONSTRAINT `FKsfufp5xnlnb98gf67j8o00115` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- meals.dessert definition

CREATE TABLE `dessert` (
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
  UNIQUE KEY `UK_9wi096d77i5edd7n04eqqmaus` (`name`),
  UNIQUE KEY `UK1bihsdsk6irnbt1cmqk23ol5x` (`size`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- meals.dessert_ingredient definition

CREATE TABLE `dessert_ingredient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ingredient_id` bigint(20) NOT NULL,
  `dessert_id` bigint(20) NOT NULL,
  `position` smallint(6) NOT NULL,
  `count` varchar(255) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqetefwoh21g24xe1axbt6anim` (`dessert_id`),
  KEY `FKtml8tl17ffl2ktldr4roo0tyy` (`ingredient_id`),
  CONSTRAINT `FKqetefwoh21g24xe1axbt6anim` FOREIGN KEY (`dessert_id`) REFERENCES `dessert` (`id`),
  CONSTRAINT `FKtml8tl17ffl2ktldr4roo0tyy` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;