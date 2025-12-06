CREATE SCHEMA sasor
CREATE TABLE sasor.customers (
                               customer_id SERIAL PRIMARY KEY,
                               customer_name VARCHAR(100),
                               city VARCHAR(50)
);
INSERT INTO sasor.customers (customer_id,customer_name, city) VALUES
                                                (101,'Nguyễn Văn An', 'Hà Nội'),
                                                (102,'Trần Thị Bình', 'Đà Nẵng'),
                                                (103,'Lê Văn Cường', 'Hồ Chí Minh'),
                                                (104,'Phạm Thị Dung', 'Hải Phòng'),
                                                (105,'Hoàng Văn Em', 'Cần Thơ');


CREATE TABLE sasor.orders (
                        order_id SERIAL PRIMARY KEY,
                        customer_id INT REFERENCES customers(customer_id),
                        order_date DATE,
                        total_amount NUMERIC(10,2)
);

INSERT INTO sasor.orders (order_id,customer_id, order_date, total_amount) VALUES
                                                              (1,101,'2024-12-01', 5000000),
                                                              (2,102,'2024-12-02', 3200000),
                                                              (3,103,'2024-12-03', 7800000),
                                                              (4,104,'2024-12-04', 1200000),
                                                              (5,105,'2024-12-05', 4500000);

CREATE TABLE sasor.order_items (
                             item_id SERIAL PRIMARY KEY,
                             order_id INT REFERENCES orders(order_id),
                             product_name VARCHAR(100),
                             quantity INT,
                             price NUMERIC(10,2)
);

INSERT INTO sasor.order_items (item_id,order_id, product_name, quantity,price) VALUES
                                        (001, 1,'Laptop Dell XPS 13', 1, 5000000),
                                        (002, 2,'iPhone 15 Pro', 5, 3200000),
                                        (003, 3,'Máy ảnh Sony A7III', 2, 7800000),
                                        (004, 4,'Tai nghe AirPods Pro', 4, 1200000),
                                        (005, 5,'Apple Watch Series 9', 2, 4500000);


SELECT c.customer_name,o.order_date,o.total_amount
    FROM sasor.order_items n join orders o on n.order_id = o.order_id
     join  customers c on o.customer_id = c.customer_id
GROUP BY o.order_id,c.customer_name,o.order_date,o.total_amount;

SELECT SUM(total_amount),AVG(total_amount),MAX(total_amount),MIN(total_amount),COUNT(o.order_id)
FROM sasor.order_items n join orders o on n.order_id = o.order_id
                   join  customers c on o.customer_id = c.customer_id
GROUP BY o.order_id;

SELECT c.city, SUM(total_amount)
FROM sasor.order_items n join orders o on n.order_id = o.order_id
                   join  customers c on o.customer_id = c.customer_id
GROUP BY c.city
HAVING SUM(total_amount) > 10000;

SELECT c.customer_id AS "CUSTOMERID",c.customer_name AS "CUSTOMERNAME",SUM(total_amount) AS tdt
FROM  sasor.orders n join  sasor.customers c on c.customer_id = n.customer_id
GROUP BY c.customer_name,c.customer_id
ORDER BY SUM(total_amount) DESC LIMIT 1
HAVING SUM(total_amount) =
(SELECT MAX(tdt) FROM
    (SELECT c.customer_id AS "CUSTOMERID",c.customer_name AS "CUSTOMERNAME",SUM(total_amount) AS tdt
FROM  sasor.orders n join  sasor.customers c on c.customer_id = n.customer_id
GROUP BY c.customer_name,c.customer_id )AS "DANH SÁCH KH");


SELECT DISTINCT city FROM sasor.customers
UNION
SELECT DISTINCT c.city FROM sasor.orders n join  sasor.customers c on c.customer_id = n.customer_id


SELECT DISTINCT city FROM sasor.customers
INTERSECT
SELECT DISTINCT c.city FROM sasor.orders n join  sasor.customers c on c.customer_id = n.customer_id




