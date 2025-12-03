CREATE SCHEMA management;
CREATE table management.Products(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    category VARCHAR(50),
    price NUMERIC(10,2),
    stock INT
);

INSERT INTO management.Products (name, category, price, stock) VALUES
    ('Laptop Dell', 'Electronics', 1500.00, 5),
    ('Chuột Logitech', 'Electronics', 25.50, 50),
    ('Bàn phím Razer', 'Electronics', 120.00, 20),
    ('Tủ lạnh LG', 'Home Appliances', 800.00, 3),
    ('Máy giặt Samsung', 'Home Appliances', 600.00, 2);

INSERT INTO management.Products (name, category, price, stock) VALUES
    ('Điều hòa Panasonic',  'Home Appliances',  400.000, 10);

UPDATE management.Products SET stock = 7 WHERE id = 1;

DELETE FROM management.Products WHERE stock ISNULL;

SELECT * FROM management.Products ORDER BY price ASC;

SELECT DISTINCT category FROM management.Products;

SELECT * FROM management.Products WHERE price BETWEEN 100 AND 1000;

SELECT * FROM management.Products WHERE name  LIKE '%Samsung%';

SELECT * FROM management.Products WHERE name LIKE '%LG%';

SELECT * FROM management.Products ORDER BY products DESC LIMIT 2;

SELECT * FROM management.Products ORDER BY products LIMIT 2 OFFSET 3


