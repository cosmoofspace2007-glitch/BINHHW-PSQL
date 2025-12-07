--Quản lý sản phẩm cửa hàng
CREATE SCHEMA manage;
CREATE TABLE manage.Product (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(100),
                         category VARCHAR(50),
                         price NUMERIC(10,2),
                         stock INT
);
INSERT INTO manage.Product (id,name, category, price, stock)
VALUES
    (101,'iPhone 15', 'Điện thoại', 23999000, 10),
    (102,'Samsung Galaxy S23', 'Điện thoại', 19999000, 8),
    (103,'Laptop Dell XPS 13', 'Laptop', 32999000, 5),
    (104,'Chuột Logitech G304', 'Phụ kiện', 799000, 25),
    (105,'Tai nghe Sony WH-1000XM5', 'Âm thanh', 7990000, 12);

SELECT name FROM manage.Product;

SELECT price FROM manage.Product ORDER BY price desc LIMIT 3;

SELECT name,price FROM manage.Product WHERE category = 'Điện thoại' AND price < 10000000;

SELECT name,stock FROM manage.Product ORDER BY stock ASC;


--Quản lý nhân viên công ty
CREATE TABLE manage.Employee (
                          id SERIAL PRIMARY KEY,
                          full_name VARCHAR(100),
                          department VARCHAR(50),
                          salary NUMERIC(10,2),
                          hire_date DATE
);
INSERT INTO manage.Employee (id,full_name, department, salary, hire_date)
VALUES
    (100,'Nguyen Van A', 'IT', 1500.00, '2022-01-15'),
    (101,'Tran Thi B', 'HR', 1200.00, '2021-11-02'),
    (102,'Le Van C', 'Finance', 1800.00, '2020-05-20'),
    (103,'Pham Thi D', 'Marketing', 1350.00, '2023-03-12'),
    (104,'Hoang Van E', 'IT', 1600.00, '2021-07-08'),
    (105,'Do Thi F', 'Sales', 1400.00, '2022-09-25');

UPDATE manage.Employee
  SET salary = salary * 0.1
WHERE department = 'IT';

DELETE FROM manage.Employee WHERE salary <= 1200;

SELECT full_name FROM manage.Employee WHERE full_name LIKE '%An%';

SELECT hire_date FROM manage.Employee WHERE hire_date BETWEEN '2023-01-01' AND '2023-12-31';


--Quản lý khách hàng và điểm thưởng
CREATE TABLE manage.Customer (
                                        id SERIAL PRIMARY KEY,
                                        name VARCHAR(100),
                                        email VARCHAR(100),
                                        phone VARCHAR(20),
                                        points INT
);
INSERT INTO manage.Customer (id,name, email, phone, points) VALUES
                                                      (111,'Nguyễn Văn An', 'nguyen.van.an@email.com', '0912345678', 1500),
                                                      (112,'Trần Thị Bình', 'tran.thi.binh@email.com', '0923456789', 2300),
                                                      (113,'Lê Văn Cường', 'le.van.cuong@email.com', '0934567890', 500),
                                                      (114,'Phạm Thị Dung', 'pham.thi.dung@email.com', '0945678901', 4200),
                                                      (115,'Hoàng Văn Em',NULL, '0956789012', 3100),
                                                      (116,'Vũ Thị Phương', 'vu.thi.phuong@email.com', '0967890123', 1200),
                                                      (117,'Đặng Minh Quân', 'dang.minh.quan@email.com', '0978901234', 2800);

SELECT DISTINCT name FROM manage.Customer;

SELECT DISTINCT name FROM manage.Customer WHERE email IS NULL;

SELECT DISTINCT name FROM manage.Customer OFFSET 6 LIMIT 1;

SELECT name,points FROM manage.Customer ORDER BY points DESC;


--Quản lý đơn hàng
CREATE TABLE manage.OrderInfo (
                           id SERIAL PRIMARY KEY,
                           customer_id INT,
                           order_date DATE,
                           total NUMERIC(10,2),
                           status VARCHAR(20)
);
INSERT INTO manage.OrderInfo (id,customer_id, order_date, total, status) VALUES
                                                                   (10,1, '2024-01-15', 1500000, 'Delivered'),
                                                                   (9,2, '2024-01-20', 2300000, 'Delivered'),
                                                                   (8,3, '2024-02-05', 800000, 'Delivered'),
                                                                   (7,1, '2024-02-10', 3200000, 'Processing'),
                                                                   (6,4, '2024-02-15', 4200000, 'Delivered'),
                                                                   (5,5, '2024-02-20', 3100000, 'Cancelled');

SELECT id,total FROM manage.OrderInfo WHERE total > 500000;

SELECT id,order_date FROM manage.OrderInfo WHERE order_date BETWEEN '2024-10-01' AND '2024-11-01';

SELECT id,status FROM manage.OrderInfo WHERE status <> 'Delivered';

SELECT id,order_date FROM manage.OrderInfo ORDER BY order_date DESC LIMIT 2;


--Quản lý khóa học trực tuyến
CREATE TABLE manage.Course (
                                      id SERIAL PRIMARY KEY,
                                      title VARCHAR(100),
                                      instructor VARCHAR(50),
                                      price NUMERIC(10,2),
                                      duration INT
);
INSERT INTO manage.Course (id,title, instructor, price, duration) VALUES
                                                            (23,'Lập trình Python cơ bản', 'Nguyễn Văn A', 1200000, 30),
                                                            (24,'Lập trình Java nâng cao', 'Trần Thị B', 2500000, 45),
                                                            (25,'Thiết kế Web với HTML/CSS/JS', 'Lê Văn C', 1800000, 40),
                                                            (26,'Khoa học dữ liệu với Python', 'Phạm Thị D', 3500000, 60),
                                                            (27,'Machine Learning cơ bản', 'Hoàng Văn E', 4200000, 55),
                                                            (28,'Quản trị cơ sở dữ liệu SQL', 'Vũ Thị F', 1500000, 35);

UPDATE manage.Course
   SET price = Course.price * 15/100
WHERE duration > 30;

DELETE FROM manage.Course WHERE title ILIKE '%DEMO%';

SELECT title FROM manage.Course WHERE title LIKE '%SQL%';

SELECT title,price FROM manage.Course  WHERE price BETWEEN 500000 AND 2000000 ORDER BY price DESC;


--Thống kê doanh thu cửa hàng
CREATE TABLE manage.Orders (
                        id SERIAL PRIMARY KEY,
                        customer_id INT,
                        order_date DATE,
                        total_amount NUMERIC(10,2)
);

INSERT INTO manage.Orders (id,customer_id, order_date, total_amount) VALUES
                                                               (00,1, '2024-01-05', 1500000),
                                                               (01,2, '2024-01-10', 2300000),
                                                               (02,3, '2024-01-15', 850000),
                                                               (03,1, '2024-01-20', 3200000),
                                                               (04,4, '2024-01-25', 4200000),
                                                               (05,5, '2024-02-01', 3100000),
                                                               (07,6, '2024-02-05', 1250000);

SELECT SUM(total_amount) AS "TỔNG DOANH THU",COUNT(customer_id) AS "SỐ ĐƠN HÀNG" FROM manage.Orders;

SELECT customer_id,AVG(total_amount) FROM manage.Orders GROUP BY customer_id;

SELECT total_amount,order_date FROM manage.Orders GROUP BY order_date,total_amount HAVING total_amount > 50000000;


SELECT total_amount FROM manage.Orders ORDER BY total_amount DESC LIMIT 5;


-- Báo cáo dữ liệu tổng hợp
CREATE TABLE manage.OLdCustomers (
                              id SERIAL PRIMARY KEY,
                              name VARCHAR(100),
                              city VARCHAR(50)
);
INSERT INTO manage.OLdCustomers (id,name, city) VALUES
                                          (20,'Nguyễn Văn An', 'Hà Nội'),
                                          (21,'Trần Thị Bình', 'Đà Nẵng'),
                                          (22,'Lê Văn Cường', 'Hồ Chí Minh'),
                                          (23,'Phạm Thị Dung', 'Hải Phòng'),
                                          (24,'Hoàng Văn Em', 'Cần Thơ'),
                                          (25,'Vũ Thị Phương', 'Hà Nội');

CREATE TABLE manage.NewCustomers (
                              id SERIAL PRIMARY KEY,
                              name VARCHAR(100),
                              city VARCHAR(50)
);
INSERT INTO manage.NewCustomers (id,name, city) VALUES
                                          (20,'Nguyễn Văn An', 'Hà Nội'),
                                          (45,'Lê Thị Thu Hà', 'Hà Nội'),
                                          (90,'Nguyễn Hoàng Nam', 'Đà Nẵng'),
                                          (23,'Phạm Thị Dung', 'Hải Phòng'),
                                          (76,'Vũ Đình Long', 'Hồ Chí Minh'),
                                          (21,'Trần Thị Bình', 'Đà Nẵng');
SELECT name FROM manage.NewCustomers
UNION
SELECT name FROM manage.OLdCustomers;

SELECT name FROM manage.NewCustomers
INTERSECT
SELECT name FROM manage.OLdCustomers;


SELECT
(SELECT city,COUNT(name) FROM manage.NewCustomers
GROUP BY city)
AND
(SELECT city,COUNT(name) FROM manage.OLdCustomers
GROUP BY city)
