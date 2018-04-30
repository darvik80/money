-- noinspection SqlNoDataSourceInspectionForFile
INSERT INTO `currency` (`id`, `name`, `code`) VALUES (1, 'USD', 1);
INSERT INTO `currency` (`id`, `name`, `code`) VALUES (2, 'VND', 704);
INSERT INTO `currency` (`id`, `name`, `code`) VALUES (3, 'RUB', 643);

-- noinspection SqlNoDataSourceInspection
INSERT INTO `category` (`name`, `description`, `currency_id`, `operation`, `url_image`) VALUES ('Shop', 'Weekly shoping', 2, 2, '/images/shop-icon.png');
INSERT INTO `category` (`name`, `description`, `currency_id`, `operation`, `url_image`) VALUES ('Salary', 'Monthly salary', 1, 1, '/images/salary-icon.png');
INSERT INTO `category` (`name`, `description`, `currency_id`, `operation`, `url_image`) VALUES ('Tourism', '', 2, 2, '/images/tourism-icon.png');
INSERT INTO `category` (`name`, `description`, `currency_id`, `operation`, `url_image`) VALUES ('Beer', 'Beer, Pub, ...', 2, 2, '/images/beer-icon.png');
INSERT INTO `category` (`name`, `description`, `currency_id`, `operation`, `url_image`) VALUES ('Food', 'Going to a restaurant', 2, 2, '/images/food-icon.png');

INSERT INTO `image` (`url`) VALUES ('/images/shop-icon.png');
INSERT INTO `image` (`url`) VALUES ('/images/beer-icon.png');
INSERT INTO `image` (`url`) VALUES ('/images/food-icon.png');
INSERT INTO `image` (`url`) VALUES ('/images/salary-icon.png');
INSERT INTO `image` (`url`) VALUES ('/images/tourism-icon.png');