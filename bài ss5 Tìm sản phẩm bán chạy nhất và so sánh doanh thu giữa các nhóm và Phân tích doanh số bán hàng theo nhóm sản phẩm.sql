CREATE SCHEMA analysingproduct;
CREATE table analysingproduct.PRODUCT(
   product_id SERIAL PRIMARY KEY,
   product_name VARCHAR(100) NOT NULL,
   category VARCHAR(50)
);

CREATE TABLE analysingproduct.ORDERS (
                        order_id INT PRIMARY KEY,
                        product_id INT REFERENCES analysingproduct.PRODUCT (product_id),
                        quantity INT CHECK (quantity > 0),
                        total_price NUMERIC(10,2)
);

INSERT INTO analysingproduct.PRODUCT (product_id, product_name, category) VALUES
   (1, 'Laptop Dell', 'Electronics'),
   (2, 'iPhone 15', 'Electronics'),
   (3, 'Bàn học gỗ', 'Furniture'),
   (4, 'Ghế xoay', 'Furniture');


INSERT INTO analysingproduct.ORDERS (order_id, product_id, quantity, total_price) VALUES
   (101, 1, 2, 2200),
   (102, 2, 3, 3300),
   (103, 3, 5, 2500),
   (104, 4, 4, 1600),
   (105, 1, 1, 1100);

SELECT p.product_name,SUM(total_price) AS total_sales,SUM(quantity) AS total_quantity
FROM analysingproduct.ORDERS o JOIN analysingproduct.PRODUCT p on o.product_id = p.product_id
GROUP BY p.category,p.product_name;


SELECT
     o.total_price AS ps,
    CASE WHEN total_price > 2000 THEN 'ĐẠT'
         ELSE 'KO ĐẠT'
    END AS status
FROM analysingproduct.ORDERS o JOIN analysingproduct.PRODUCT p on o.product_id = p.product_id
GROUP BY total_price
ORDER BY total_price DESC;


SELECT SUM(total_price) AS total_sales,p.product_name,MAX(total_price)
FROM analysingproduct.ORDERS o JOIN analysingproduct.PRODUCT p on o.product_id = p.product_id
GROUP BY p.product_name;


SELECT SUM(total_price) AS total_sales
FROM analysingproduct.ORDERS o JOIN analysingproduct.PRODUCT p on o.product_id = p.product_id
GROUP BY p.category;


SELECT "PRODUCTID",category FROM
   (SELECT p.category AS category,o.product_id AS "PRODUCTID",SUM(o.quantity)
    FROM analysingproduct.ORDERS o JOIN analysingproduct.PRODUCT p on o.product_id = p.product_id
    GROUP BY o.product_id,p.category
    ORDER BY SUM(o.quantity) DESC LIMIT 1) AS "BẢNG PHỤ"
    INTERSECT
SELECT DISTINCT "PRODUCTID",category FROM
    ( SELECT DISTINCT p.category AS category,o.product_id AS "PRODUCTID", SUM(o.total_price)
      FROM analysingproduct.ORDERS o JOIN analysingproduct.PRODUCT p on o.product_id = p.product_id
      GROUP BY o.product_id,p.category
      HAVING SUM(o.total_price) > 3000) AS "BẢNG PHỤ 2"



