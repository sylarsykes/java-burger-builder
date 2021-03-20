-- drinks.drink
INSERT INTO drinks.drink
	(name, description, `type`, `size`, price, created_by, created_date, last_modify_by, last_modified_date)
VALUES('Coke', NULL, 'NO_ALCOHOLIC', 'MEDIUM', 1.80, 'root-mbapp', CURRENT_DATE, NULL, NULL);
INSERT INTO drinks.drink
	(name, description, `type`, `size`, price, created_by, created_date, last_modify_by, last_modified_date)
VALUES('Coke Zero', NULL, 'NO_ALCOHOLIC', 'MEDIUM', 1.80, 'root-mbapp', CURRENT_DATE, NULL, NULL);
INSERT INTO drinks.drink
	(name, description, `type`, `size`, price, created_by, created_date, last_modify_by, last_modified_date)
VALUES('Diet Coke', NULL, 'NO_ALCOHOLIC', 'MEDIUM', 1.80, 'root-mbapp', CURRENT_DATE, NULL, NULL);
INSERT INTO drinks.drink
	(name, description, `type`, `size`, price, created_by, created_date, last_modify_by, last_modified_date)
VALUES('Nestea', NULL, 'NO_ALCOHOLIC', 'MEDIUM', 1.80, 'root-mbapp', CURRENT_DATE, NULL, NULL);
INSERT INTO drinks.drink
	(name, description, `type`, `size`, price, created_by, created_date, last_modify_by, last_modified_date)
VALUES('Mineral Water', NULL, 'NO_ALCOHOLIC', 'MEDIUM', 1.40, 'root-mbapp', CURRENT_DATE, NULL, NULL);
INSERT INTO drinks.drink
	(name, description, `type`, `size`, price, created_by, created_date, last_modify_by, last_modified_date)
VALUES('Estrella Galicia', NULL, 'ALCOHOLIC', 'MEDIUM', 2.00, 'root-mbapp', CURRENT_DATE, NULL, NULL);
INSERT INTO drinks.drink
	(name, description, `type`, `size`, price, created_by, created_date, last_modify_by, last_modified_date)
VALUES('Estrella Galicia 1906', NULL, 'ALCOHOLIC', 'MEDIUM', 2.00, 'root-mbapp', CURRENT_DATE, NULL, NULL);

-- drinks.localized_drink
INSERT INTO drinks.localized_drink
	(drink_id, locale, name, description)
VALUES(1, 'es', 'Coca Cola', NULL);
INSERT INTO drinks.localized_drink
	(drink_id, locale, name, description)
VALUES(2, 'es', 'Coca Cola Zero', NULL);
INSERT INTO drinks.localized_drink
	(drink_id, locale, name, description)
VALUES(3, 'es', 'Coca Cola Light', NULL);
INSERT INTO drinks.localized_drink
	(drink_id, locale, name, description)
VALUES(4, 'es', 'Nestea', NULL);
INSERT INTO drinks.localized_drink
	(drink_id, locale, name, description)
VALUES(5, 'es', 'Agua Mineral', NULL);
INSERT INTO drinks.localized_drink
	(drink_id, locale, name, description)
VALUES(6, 'es', 'Estrella Galicia', NULL);
INSERT INTO drinks.localized_drink
	(drink_id, locale, name, description)
VALUES(7, 'es', 'Estrella Galicia 1906', NULL);
