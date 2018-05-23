-- noinspection SqlNoDataSourceInspectionForFile
INSERT INTO currency (id, name, code) VALUES (1, 'USD', 1);
INSERT INTO currency (id, name, code) VALUES (2, 'VND', 704);
INSERT INTO currency (id, name, code) VALUES (3, 'RUB', 643);

-- noinspection SqlNoDataSourceInspection
INSERT INTO category (id, name, description, currency_id, operation, url_image) VALUES (1, 'Shop', 'Weekly shoping', 2, 2, '/images/shop-icon.png');
INSERT INTO category (id, name, description, currency_id, operation, url_image) VALUES (2, 'Salary', 'Monthly salary', 1, 1, '/images/salary-icon.png');
INSERT INTO category (id, name, description, currency_id, operation, url_image) VALUES (3, 'Tourism', '', 2, 2, '/images/tourism-icon.png');
INSERT INTO category (id, name, description, currency_id, operation, url_image) VALUES (4, 'Beer', 'Beer, Pub, ...', 2, 2, '/images/beer-icon.png');
INSERT INTO category (id, name, description, currency_id, operation, url_image) VALUES (5, 'Food', 'Going to a restaurant', 2, 2, '/images/food-icon.png');
INSERT INTO category (id, name, description, currency_id, operation, url_image) VALUES (6, 'Taxi', 'Vinasun, Grab...', 2, 2, '/images/taxi-icon.png');
INSERT INTO category (id, name, description, currency_id, operation, url_image) VALUES (7, 'Shop daily', 'Familymart, K-Mart...', 2, 2, '/images/shop-daily-icon.png');
INSERT INTO category (id, name, description, currency_id, operation, url_image) VALUES (8, 'Nanny', 'Cleaning, kids take care', 2, 2, '/images/bucket-icon.png');
INSERT INTO category (id, name, description, currency_id, operation, url_image) VALUES (9, 'Scooter', 'Gasolene, maintenance', 2, 2, '/images/scooter-icon.png');
INSERT INTO category (id, name, description, currency_id, operation, url_image) VALUES (10, 'Sauna', 'Golder lotus', 2, 2, '/images/sauna-icon.png');
INSERT INTO category (id, name, description, currency_id, operation, url_image) VALUES (11, 'Pharmacy', 'Medicines, vitamins ...', 2, 2, '/images/drugstore-icon.png');
INSERT INTO category (id, name, description, currency_id, operation, url_image) VALUES (12, 'Other', 'Some other...', 2, 2, '/images/other-icon.png');

INSERT INTO image (url) VALUES ('/images/shop-icon.png');
INSERT INTO image (url) VALUES ('/images/beer-icon.png');
INSERT INTO image (url) VALUES ('/images/food-icon.png');
INSERT INTO image (url) VALUES ('/images/salary-icon.png');
INSERT INTO image (url) VALUES ('/images/tourism-icon.png');

INSERT INTO cash_flow VALUES (4,220000,220000,'2018-05-11 08:13:55','Food',5),(5,65000,65000,'2018-05-11 08:14:08','Scooter',9),(6,2000000,2000000,'2018-05-11 08:15:13','Nanny',8),(7,220000,220000,'2018-05-11 08:29:52','Sauna',10),(8,42000,42000,'2018-05-11 08:30:04','Beer',4),(9,300000,300000,'2018-05-12 03:44:40','Beer',4),(10,21000,21000,'2018-05-12 03:44:48','Shop daily',7),(11,82000,82000,'2018-05-12 03:45:34','Beer',4),(12,66000,66000,'2018-05-12 04:38:22','Beer',4),(13,724400,724400,'2018-05-12 05:06:08','Shop daily',7),(14,40000,40000,'2018-05-12 05:06:14','Taxi',6),(15,20000,20000,'2018-05-12 05:06:54','Taxi',6),(16,42000,42000,'2018-05-12 09:06:08','Taxi',6),(17,43000,43000,'2018-05-12 11:46:04','Taxi',6),(18,43000,43000,'2018-05-12 12:56:36','Shop daily',7),(19,2479005,2479005,'2018-05-13 04:00:25','Shop',1),(20,44000,44000,'2018-05-13 08:20:26','Shop daily',7),(21,60000,60000,'2018-05-13 08:31:46','Shop daily',7),(22,370000,370000,'2018-05-14 03:04:05','Food',5),(23,245000,245000,'2018-05-14 03:04:16','Shop daily',7),(24,330000,330000,'2018-05-14 06:36:35','Food',5),(25,60000,60000,'2018-05-15 00:56:42','Food',5),(26,47000,47000,'2018-05-15 02:13:05','Taxi',6),(27,14000,14000,'2018-05-15 02:47:29','Taxi',6),(28,1000000,1000000,'2018-05-15 02:48:24','Nanny',8),(29,60000,60000,'2018-05-15 02:49:01','Scooter',9),(30,3000000,3000000,'2018-05-15 02:49:08','Scooter',9),(31,247500,247500,'2018-05-15 06:25:26','Food',5);

