CREATE SCHEMA DUCE;
CREATE TABLE DUCE.order_detail(
    id SERIAL PRIMARY KEY,
    order_id INT,
    product_name VARCHAR(100),
    quantity INT,
    unit_price NUMERIC

);
INSERT INTO DUCE.order_detail (order_id, product_name, quantity, unit_price) VALUES
  (101, 'iPhone 15 Pro', 1, 28990000),
  (101, 'AirPods Pro 2', 2, 5490000),
  (101, 'Apple Watch S9', 1, 11990000),
  (102, 'Samsung Galaxy S24', 1, 23990000),
  (102, 'Samsung Buds 2 Pro', 1, 3990000),
  (103, 'Laptop Dell XPS 13', 1, 32990000),
  (103, 'Wireless Mouse Logitech M331', 2, 399000),
  (104, 'Macbook Air M2', 1, 26990000),
  (104, 'Magic Mouse', 1, 2290000),
  (104, 'iPad Air 5', 1, 15990000);


CREATE OR REPLACE PROCEDURE calculate_order_total(
    order_id_input INT,
    OUT total NUMERIC
)
    LANGUAGE plpgsql
AS
$$
DECLARE
    doanh_thu INT;
BEGIN
    SELECT unit_price = total
    FROM DUCE.order_detail
    WHERE order_id = order_id_input
    INTO doanh_thu;
END;
$$;
CALL calculate_order_total(101,28990999);











CREATE TABLE DUCE.inventory (
                           product_id SERIAL PRIMARY KEY,
                           product_name VARCHAR(100),
                           quantity INT
);
INSERT INTO DUCE.inventory (product_id,product_name, quantity) VALUES
                                                   (11,'Chuột không dây', 120),
                                                   (12,'Bàn phím cơ', 45),
                                                   (13,'Tai nghe Bluetooth', 80),
                                                   (14,'Màn hình 24 inch', 30),
                                                   (15,'Laptop ASUS A15', 10);

CREATE OR REPLACE PROCEDURE check_stock(p_id INT, p_qty INT)
LANGUAGE plpgsql
AS $$
    DECLARE
        quan INT;
BEGIN
   SELECT quantity FROM DUCE.inventory
    WHERE product_id = p_id INTO quan;
IF
   quan < p_qty THEN
RAISE NOTICE 'KO ĐỦ KHO HÀNG';
    end if;
END;
$$;
CALL check_stock (11,130);







CREATE TABLE DUCE.employees (
                           emp_id SERIAL PRIMARY KEY,
                           emp_name VARCHAR(100),
                           job_level INT,
                           salary NUMERIC
);
INSERT INTO DUCE.employees (emp_id,emp_name, job_level, salary) VALUES
                                                        (01,'Nguyen Van A', 1, 800.00),
                                                        (02,'Tran Thi B', 2, 1200.00),
                                                        (03,'Le Van C', 3, 1500.00),
                                                        (04,'Pham Thi D', 1, 750.00),
                                                        (05,'Hoang Van E', 4, 2000.00),
                                                        (06,'Vo Thi F', 2, 1100.00),
                                                        (07,'Bui Van G', 5, 2500.00),
                                                        (08,'Dang Thi H', 3, 1450.00),
                                                        (09,'Do Van K', 4, 2100.00),
                                                        (10,'Phan Thi M', 2, 1300.00);

CREATE OR REPLACE PROCEDURE adjust_salary(p_emp_id INT,
    OUT p_new_salary NUMERIC)
LANGUAGE plpgsql
AS $$
    DECLARE
       le_vel INT;
       sa_la INT;
BEGIN
SELECT job_level FROM DUCE.employees
WHERE emp_id = p_emp_id INTO le_vel;
SELECT salary FROM DUCE.employees
WHERE emp_id = p_emp_id INTO sa_la;
IF le_vel = 1 THEN
     p_new_salary := sa_la + 0,05;
ELSIF le_vel = 2 THEN
     p_new_salary := sa_la + 0,1;
ELSIF le_vel = 3 THEN
     p_new_salary := sa_la + 0.15;
ELSE
    p_new_salary  := -1 ;
end if;
END;
$$;
DO $$
    DECLARE
        p_new_salary NUMERIC;
    BEGIN
        CALL adjust_salary(3, p_new_salary);
        RAISE NOTICE 'New Salary: %', p_new_salary;  -- Hiển thị giá trị của p_new_salary
    END $$;






CREATE TABLE DUCE.products (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(100),
                          price NUMERIC,
                          discount_percent INT
);
INSERT INTO DUCE.products(name, price, discount_percent) VALUES
                                                        ('Laptop Acer Aspire 5', 1599.99, 10),
                                                        ('Wireless Mouse Logitech M220', 299.50, 5),
                                                        ('Mechanical Keyboard RK84', 899.00, 15),
                                                        ('Samsung Galaxy A54', 6990.00, 20),
                                                        ('Bluetooth Speaker JBL Go 3', 750.00, 8),
                                                        ('Sony WH-1000XM5 Headphones', 4990.00, 30),
                                                        ('Apple iPad 9th Gen', 7990.00, 12),
                                                        ('USB 3.0 Kingston 64GB', 199.00, 0),
                                                        ('Dell UltraSharp 27 Monitor', 6990.00, 25),
                                                        ('Gaming Chair Warrior', 2590.00, 50);
CREATE OR REPLACE PROCEDURE calculate_discount
(
p_id INT,
OUT p_final_price NUMERIC,
OUT error VARCHAR(50))
LANGUAGE plpgsql
AS $$
    DECLARE
        per_cent INT;
        pri_ce NUMERIC;
BEGIN
SELECT price INTO pri_ce FROM DUCE.products WHERE id = p_id;
SELECT discount_percent INTO per_cent FROM DUCE.products WHERE id = p_id;
IF per_cent > 50 THEN
    error := 'GIẢM GIÁ GIỚI HẠN 50%';
    p_final_price := pri_ce;
ELSE
     p_final_price := pri_ce - (pri_ce * per_cent / 100);
     error := '';
end if;
END;
$$;
DO $$
    DECLARE
        p_final_price NUMERIC;
        error VARCHAR(50);
    BEGIN
        CALL calculate_discount (3, p_final_price,error);
        RAISE NOTICE 'New Price: %', p_final_price;
        RAISE NOTICE 'ERROR: %', error;
    END $$;


