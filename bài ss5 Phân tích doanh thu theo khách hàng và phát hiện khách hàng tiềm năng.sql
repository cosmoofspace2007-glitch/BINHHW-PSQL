CREATE SCHEMA INCTY;
CREATE TABLE INCTY.customers (
                           customer_id INT PRIMARY KEY,
                           customer_name VARCHAR(100),
                           city VARCHAR(50)
);
INSERT INTO INCTY.customers (customer_id, customer_name, city) VALUES
             (1, 'Nguyễn Văn A', 'Hà Nội'),
             (2, 'Trần Thị B', 'Đà Nẵng'),
             (3, 'Lê Văn C', 'Hồ Chí Minh'),
             (4, 'Phạm Thị D', 'Hà Nội');

CREATE TABLE INCTY.orders (
                        order_id INT PRIMARY KEY,
                        customer_id INT,
                        order_date DATE,
                        total_price INT,
                        FOREIGN KEY (customer_id) REFERENCES INCTY.customers(customer_id)
);
INSERT INTO INCTY.orders (order_id, customer_id, order_date, total_price) VALUES
                                                                        (101, 1, '2024-12-20', 3000),
                                                                        (102, 2, '2025-01-05', 1500),
                                                                        (103, 1, '2025-02-10', 2500),
                                                                        (104, 3, '2025-02-15', 4000),
                                                                        (105, 4, '2025-03-01', 800);

CREATE TABLE INCTY.order_items (
                             item_id SERIAL PRIMARY KEY,
                             order_id INT REFERENCES INCTY.orders(order_id),
                             product_id INT NOT NULL,
                             quantity INT NOT NULL,
                             price INT NOT NULL

);
INSERT INTO INCTY.order_items (item_id,order_id, product_id, quantity, price) VALUES
                                                                    (0,101, 1, 2, 1500),
                                                                    (1,102, 2, 1, 1500),
                                                                    (2,103, 3, 5, 500),
                                                                    (3,104, 2, 4, 1000),
                                                                    (4,105, 1, 1, 800);
SELECT customer_name, o.order_id AS "TONG DON HANG",SUM(total_price) AS total_revenue
FROM INCTY.orders o JOIN incty.customers c on o.customer_id = c.customer_id
     JOIN incty.order_items oi on o.order_id = oi.order_id
GROUP BY customer_name,o.order_id
HAVING SUM(total_price) > 2000;


SELECT c.customer_id,customer_name,SUM(o.total_price) AS total_revenue
FROM INCTY.orders o JOIN incty.customers c on o.customer_id = c.customer_id
                    JOIN incty.order_items oi on o.order_id = oi.order_id
GROUP BY customer_name,c.customer_id
HAVING SUM(o.total_price) > (
                             SELECT AVG(total_revenue)
                            FROM( SELECT SUM(total_price) AS total_revenue
                                  FROM incty.orders
                                  GROUP BY customer_id) t);


SELECT city, o.order_id AS "TONG DON HANG",SUM(total_price) AS total_revenue
FROM INCTY.orders o JOIN incty.customers c on o.customer_id = c.customer_id
                    JOIN incty.order_items oi on o.order_id = oi.order_id
GROUP BY city,o.order_id
ORDER BY SUM(total_price) DESC LIMIT 1;

SELECT *
FROM INCTY.orders o INNER JOIN INCTY.order_items oi on o.order_id = oi.order_id
                    INNER JOIN INCTY.customers c on o.customer_id = c.customer_id

















