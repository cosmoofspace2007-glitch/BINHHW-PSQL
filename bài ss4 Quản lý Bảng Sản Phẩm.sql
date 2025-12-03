CREATE SCHEMA promanage;
CREATE TABLE promanage.PRODUCTS (
   id SERIAL PRIMARY KEY,
   name VARCHAR(100),
   category VARCHAR(50),
   price INT,
   stock INT,
   manufacturer VARCHAR(50)
);

INSERT INTO promanage.PRODUCTS (name, category, price, stock, manufacturer) VALUES
  ('Laptop Dell XPS 13', 'Laptop', 25000000, 12, 'Dell'),
  ('Chuột Logitech M90', 'Phụ kiện', 150000, 50, 'Logitech'),
  ('Bàn phím cơ Razer', 'Phụ kiện', 2200000, 0, 'Razer'),
  ('Macbook Air M2', 'Laptop', 32000000, 7, 'Apple'),
  ('iPhone 14 Pro Max', 'Điện thoại', 35000000, 15, 'Apple'),
  ('Laptop Dell XPS 13', 'Laptop', 25000000, 12, 'Dell'),
  ('Tai nghe AirPods 3', 'Phụ kiện', 4500000, NULL, 'Apple');

INSERT INTO promanage.PRODUCTS (name, category, price, stock, manufacturer) VALUES
  ('Chuột không dây Logitech M170', 'Phụ kiện', 300000, 20, ' Logitech');

UPDATE promanage.PRODUCTS SET price = PRODUCTS.price * 10\100;

DELETE FROM promanage.PRODUCTS WHERE stock = 0;

SELECT * FROM promanage.PRODUCTS WHERE price BETWEEN 1000000 AND 3000000;

SELECT * FROM promanage.PRODUCTS WHERE stock ISNULL;

SELECT DISTINCT category FROM promanage.PRODUCTS;

SELECT * FROM promanage.PRODUCTS ORDER BY price DESC; SELECT * FROM promanage.PRODUCTS ORDER BY name ASC;

SELECT * FROM promanage.PRODUCTS WHERE category ILIKE '%LAPTOP%';

SELECT * FROM promanage.PRODUCTS ORDER BY name LIMIT 2;