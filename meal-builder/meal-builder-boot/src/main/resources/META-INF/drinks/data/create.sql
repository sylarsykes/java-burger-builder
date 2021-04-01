-- drinks.drink
INSERT INTO drinks.drink
	(name, description, `type`, `size`, price, start_date, end_date, created_by, created_date, last_modify_by, last_modified_date)
VALUES('Coke', 'Coca-Cola, or Coke, is a carbonated soft drink manufactured by The Coca-Cola Company.', 'NO_ALCOHOLIC', 'MEDIUM', 1.80, 
			CURRENT_TIMESTAMP(6), NULL, 'root-mbapp', CURRENT_TIMESTAMP(6), NULL, NULL);
INSERT INTO drinks.drink
	(name, description, `type`, `size`, price, start_date, end_date, created_by, created_date, last_modify_by, last_modified_date)
VALUES('Coke Zero', NULL, 'NO_ALCOHOLIC', 'MEDIUM', 1.80, 
			CURRENT_TIMESTAMP(6), NULL, 'root-mbapp', CURRENT_TIMESTAMP(6), NULL, NULL);
INSERT INTO drinks.drink
	(name, description, `type`, `size`, price, start_date, end_date, created_by, created_date, last_modify_by, last_modified_date)
VALUES('Diet Coke', NULL, 'NO_ALCOHOLIC', 'MEDIUM', 1.80, 
			CURRENT_TIMESTAMP(6), NULL, 'root-mbapp', CURRENT_TIMESTAMP(6), NULL, NULL);
INSERT INTO drinks.drink
	(name, description, `type`, `size`, price, start_date, end_date, created_by, created_date, last_modify_by, last_modified_date)
VALUES('Nestea', NULL, 'NO_ALCOHOLIC', 'MEDIUM', 1.80, 
			CURRENT_TIMESTAMP(6), NULL, 'root-mbapp', CURRENT_TIMESTAMP(6), NULL, NULL);
INSERT INTO drinks.drink
	(name, description, `type`, `size`, price, start_date, end_date, created_by, created_date, last_modify_by, last_modified_date)
VALUES('Mineral Water', NULL, 'NO_ALCOHOLIC', 'MEDIUM', 1.80, 
			CURRENT_TIMESTAMP(6), NULL, 'root-mbapp', CURRENT_TIMESTAMP(6), NULL, NULL);
INSERT INTO drinks.drink
	(name, description, `type`, `size`, price, start_date, end_date, created_by, created_date, last_modify_by, last_modified_date)
VALUES('Estrella Galicia', NULL, 'ALCOHOLIC', 'MEDIUM', 1.80, 
			CURRENT_TIMESTAMP(6), NULL, 'root-mbapp', CURRENT_TIMESTAMP(6), NULL, NULL);
INSERT INTO drinks.drink
	(name, description, `type`, `size`, price, start_date, end_date, created_by, created_date, last_modify_by, last_modified_date)
VALUES('Estrella Galicia 1906', NULL, 'ALCOHOLIC', 'MEDIUM', 1.80, 
			CURRENT_TIMESTAMP(6), NULL, 'root-mbapp', CURRENT_TIMESTAMP(6), NULL, NULL);

-- drinks.localized_name_drink
INSERT INTO drinks.localized_drink
	(drink_id, locale, field_name, value)
VALUES(1, 'es', 'name', 'Coca Cola');
INSERT INTO drinks.localized_drink
	(drink_id, locale, field_name, value)
VALUES(2, 'es', 'name', 'Coca Cola Zero');
INSERT INTO drinks.localized_drink
	(drink_id, locale, field_name, value)
VALUES(3, 'es', 'name', 'Coca Cola Light');
INSERT INTO drinks.localized_drink
	(drink_id, locale, field_name, value)
VALUES(4, 'es', 'name', 'Nestea');
INSERT INTO drinks.localized_drink
	(drink_id, locale, field_name, value)
VALUES(5, 'es', 'name', 'Agua Mineral');
INSERT INTO drinks.localized_drink
	(drink_id, locale, field_name, value)
VALUES(6, 'es', 'name', 'Estrella Galicia');
INSERT INTO drinks.localized_drink
	(drink_id, locale, field_name, value)
VALUES(7, 'es', 'name', 'Estrella Galicia 1906');

-- drinks.localized_description_drink
INSERT INTO drinks.localized_drink
	(drink_id, locale, field_name, value)
VALUES(1, 'es', 'description', 'Coca-Cola, conocida comúnmente como Coca en muchos países hispanohablantes (en inglés Coke), es una bebida gaseosa y refrescante vendida a nivel mundial en tiendas, restaurantes y máquinas expendedoras en más de doscientos países o territorios. Es un producto de The Coca-Cola Company, de origen estadounidense.');
