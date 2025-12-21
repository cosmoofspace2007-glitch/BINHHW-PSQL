CREATE SCHEMA DEAL;
CREATE TABLE DEAL.flights (
                         flight_id SERIAL PRIMARY KEY,
                         flight_name VARCHAR(100),
                         available_seats INT
);
INSERT INTO DEAL.flights (flight_id,flight_name, available_seats) VALUES
                                                       (00,'VN123', 3),
                                                       (01,'VN456', 2),
                                                       (02,'VN789', 5),
                                                       (03,'VN101', 10),
                                                       (04,'VN202', 0);


CREATE TABLE DEAL.bookings (
                          booking_id SERIAL PRIMARY KEY,
                          flight_id INT REFERENCES DEAL.flights(flight_id),
                          customer_name VARCHAR(100)
);
INSERT INTO DEAL.bookings (booking_id,flight_id, customer_name) VALUES
                                                    (11,00, 'Nguyen Van A'),
                                                    (12,01, 'Tran Thi B'),
                                                    (13,02, 'Le Van C'),
                                                    (14,03, 'Pham Thi D'),
                                                    (15,04, 'Hoang Van E');
BEGIN;
UPDATE DEAL.flights
SET available_seats = flights.available_seats - 1
WHERE flight_name = 'VN123';
UPDATE DEAL.bookings
SET flight_id = 1
WHERE customer_name = 'Nguyen Van A';
COMMIT;
ROLLBACK;





CREATE TABLE DEAL.account(
    account_id SERIAL PRIMARY KEY,
    owner_name VARCHAR(100),
    balance NUMERIC(10,2)
);
INSERT INTO DEAL.account (owner_name, balance) VALUES
                        ('A',500000),
                        ('B',1000000);
BEGIN;
UPDATE DEAL.account
SET balance = account.balance - 500000
WHERE owner_name = 'B';
UPDATE DEAL.account
SET balance = account.balance + 500000
WHERE owner_name = 'A';
COMMIT;
ROLLBACK;




CREATE TABLE DEAL.products (
                                        product_id SERIAL PRIMARY KEY,
                                        product_name VARCHAR(100),
                                        stock INT,
                                        price NUMERIC(10,2)
);
INSERT INTO DEAL.products (product_id,product_name, stock, price) VALUES
                                                           (01,'Laptop Dell XPS 13', 50, 1299.99),
                                                           (02,'iPhone 15 Pro', 100, 999.99),
                                                           (03,'Samsung Galaxy S24', 75, 899.99),
                                                           (04,'Sony WH-1000XM5', 30, 349.99),
                                                           (05,'MacBook Pro 16-inch', 25, 2399.99),
                                                           (06,'Nintendo Switch OLED', 60, 349.99),
                                                           (07,'Logitech MX Master 3', 200, 99.99);


CREATE TABLE DEAL.orders (
                                      order_id SERIAL PRIMARY KEY,
                                      customer_name VARCHAR(100),
                                      total_amount NUMERIC(10,2),
                                      created_at TIMESTAMP DEFAULT NOW()
);
INSERT INTO DEAL.orders (order_id,customer_name, total_amount, created_at) VALUES
                                                                 (010,'Nguyễn Văn A', 2599.98, '2024-01-15 10:30:00'),
                                                                 (020,'Trần Thị B', 899.99, '2024-01-16 14:20:00'),
                                                                 (030,'Lê Văn C', 3499.98, '2024-01-17 09:15:00'),
                                                                 (040,'Phạm Thị D', 699.99, '2024-01-18 16:45:00'),
                                                                 (050,'Hoàng Văn E', 1299.99, '2024-01-19 11:00:00'),
                                                                 (060,'Đỗ Thị F', 199.98, '2024-01-20 13:30:00'),
                                                                 (070,'Vũ Văn G', 2399.99, '2024-01-21 08:50:00');


CREATE TABLE DEAL.order_items (
                                           order_item_id SERIAL PRIMARY KEY,
                                           order_id INT REFERENCES DEAL.orders(order_id),
                                           product_id INT REFERENCES DEAL.products(product_id),
                                           quantity INT,
                                           subtotal NUMERIC(10,2)
);
INSERT INTO DEAL.order_items (order_item_id,order_id, product_id, quantity, subtotal) VALUES
                                                                       (0, 010,01, 2, 2599.98),
                                                                       (1, 020,02, 1, 899.99),
                                                                       (4, 030,03, 1, 2399.99),
                                                                       (9, 040,04, 1, 399.99),
                                                                       (34,050,05, 1, 699.99),
                                                                       (6, 060,06, 1, 1299.99),
                                                                       (7, 070,07, 2, 199.98);

BEGIN;
DO $$
BEGIN
IF
(SELECT stock FROM DEAL.products WHERE product_id = 1) < 2
OR (SELECT stock FROM DEAL.products WHERE product_id = 2) < 1
THEN RAISE EXCEPTION 'KO ĐỦ';
END IF;
END $$;

INSERT INTO DEAL.orders(customer_name, total_amount) VALUES
('Nguyễn Văn A',2599.98)
RETURNING orders.order_id;

UPDATE DEAL.products
SET stock = stock - 2
WHERE product_id = 1;

UPDATE DEAL.products
SET stock = stock - 1
WHERE product_id = 2;

INSERT INTO DEAL.order_items (order_id, product_id, quantity, subtotal)
VALUES
    (20, 19, 89, 2599.98),
    (10, 20, 70, 999.99);

COMMIT;
ROLLBACK;


UPDATE DEAL.products
SET stock = 0
WHERE product_id = 2;

DO $$
    BEGIN
        IF
            (SELECT stock FROM DEAL.products WHERE product_id = 1) < 2
                OR (SELECT stock FROM DEAL.products WHERE product_id = 2) < 1
        THEN RAISE EXCEPTION 'KO ĐỦ';
        END IF;
    END $$;






CREATE TABLE DEAL.accounts(
    account_id SERIAL PRIMARY KEY,
    customers_name VARCHAR(100),
    balance NUMERIC(10,2)
);
INSERT INTO DEAL.accounts(account_id,customers_name, balance) VALUES
                    (223,'Hoàng Văn L',2000000.00),
                    (224,'Nguyễn Thiên Q',1000000.00);

CREATE TABLE DEAL.transactions(
    trans_id SERIAL PRIMARY KEY,
    account_id INT REFERENCES DEAL.accounts(account_id),
    amount NUMERIC (10,2),
    trans_type VARCHAR(20),
    create_at TIMESTAMP DEFAULT NOW()
);
INSERT INTO DEAL.transactions(trans_id,account_id, amount, trans_type,create_at) VALUES
                (1, 223,5000000, 'Deposit', '2024-01-15 09:30:00'),
                (2, 224,7000000, 'Withdrawal', '2024-01-16 14:20:00');
BEGIN;
DO $$
    DECLARE v_balance NUMERIC(10,2);
BEGIN
SELECT balance INTO v_balance
FROM DEAL.accounts a JOIN deal.transactions t on a.account_id = t.account_id;

IF v_balance >= 2000000.00 THEN
    UPDATE DEAL.accounts
    SET balance = balance - 2000000.00
    WHERE account_id = 223;
ELSE
    RAISE EXCEPTION 'KO ĐỦ SỐ DƯ';
end if;
END $$;
COMMIT;



BEGIN;
DO $$
    DECLARE v_balance NUMERIC(10,2);
    BEGIN
        SELECT balance INTO v_balance
        FROM DEAL.accounts a JOIN deal.transactions t on a.account_id = t.account_id;

        IF v_balance >= 2000000.00 THEN
            UPDATE DEAL.accounts
            SET balance = balance - 2000000.00
            WHERE account_id = 225;
        ELSE
            RAISE EXCEPTION 'KO ĐỦ SỐ DƯ';
        end if;
    END $$;
COMMIT;
ROLLBACK;
