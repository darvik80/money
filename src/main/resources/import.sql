-- noinspection SqlNoDataSourceInspectionForFile
INSERT INTO `currency` (`id`, `name`, `code`) VALUES (1, 'USD', 1);
INSERT INTO `currency` (`id`, `name`, `code`) VALUES (2, 'VND', 704);
INSERT INTO `currency` (`id`, `name`, `code`) VALUES (3, 'RUB', 643);

-- noinspection SqlNoDataSourceInspection
INSERT INTO `category` (`id`, `name`, `description`, `currency_id`, `operation`, `url_image`) VALUES (1, 'Shop', 'Weekly shoping', 2, 2, '/images/shop-icon.png');
INSERT INTO `category` (`id`, `name`, `description`, `currency_id`, `operation`, `url_image`) VALUES (2, 'Salary', 'Monthly salary', 1, 1, '/images/salary-icon.png');
INSERT INTO `category` (`id`, `name`, `description`, `currency_id`, `operation`, `url_image`) VALUES (3, 'Tourism', '', 2, 2, '/images/tourism-icon.png');
INSERT INTO `category` (`id`, `name`, `description`, `currency_id`, `operation`, `url_image`) VALUES (4, 'Beer', 'Beer, Pub, ...', 2, 2, '/images/beer-icon.png');
INSERT INTO `category` (`id`, `name`, `description`, `currency_id`, `operation`, `url_image`) VALUES (5, 'Food', 'Going to a restaurant', 2, 2, '/images/food-icon.png');

INSERT INTO `image` (`url`) VALUES ('/images/shop-icon.png');
INSERT INTO `image` (`url`) VALUES ('/images/beer-icon.png');
INSERT INTO `image` (`url`) VALUES ('/images/food-icon.png');
INSERT INTO `image` (`url`) VALUES ('/images/salary-icon.png');
INSERT INTO `image` (`url`) VALUES ('/images/tourism-icon.png');

INSERT INTO `cash_flow` (`category_id`, `description`, `amount_origin`, `amount`) VALUES (2, 'April', 5700, 5700*22700);
INSERT INTO `cash_flow` (`category_id`, `description`, `amount_origin`, `amount`) VALUES (1, 'Crest Maill', 1800000, 1800000);
INSERT INTO `cash_flow` (`category_id`, `description`, `amount_origin`, `amount`) VALUES (1, 'Beer', 800000, 800000);