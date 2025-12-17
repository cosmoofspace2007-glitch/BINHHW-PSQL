create schema GERR;
create table GERR.product(
   id SERIAL PRIMARY KEY,
   name VARCHAR(80),
   price NUMERIC,
   last_modified TIMESTAMP
);
INSERT INTO GERR.product (id,name, price, last_modified) VALUES
                                                      (001,'Laptop Dell', 15000000, NOW()),
                                                      (002,'iPhone 13', 22000000, NOW() - INTERVAL '1 day'),
                                                      (003,'Samsung Galaxy S22', 18000000, NOW() - INTERVAL '2 days'),
                                                      (004,'Chuột Logitech', 450000, NOW() - INTERVAL '3 days'),
                                                      (005,'Bàn phím cơ', 1200000, NOW() - INTERVAL '5 days');



CREATE OR REPLACE FUNCTION update_last_modified(in_id INT,in_last_modified TIMESTAMP)
RETURNS TIMESTAMP AS
$$
BEGIN
    UPDATE GERR.product
    SET last_modified = in_last_modified
    WHERE id = in_id;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_update_last_modified
    BEFORE UPDATE ON
    GERR.product
    FOR EACH ROW
    EXECUTE FUNCTION update_last_modified();

DROP FUNCTION update_last_modified






CREATE TABLE GERR.customers (
                           id SERIAL PRIMARY KEY,
                           name VARCHAR(100),
                           credit_limit NUMERIC
);
INSERT INTO GERR.customers (id,name, credit_limit) VALUES
                                               (111,'Nguyễn Văn A', 10000000),
                                               (112,'Trần Thị B', 15000000),
                                               (113,'Lê Văn C', 8000000),
                                               (114,'Phạm Thị D', 20000000),
                                               (115,'Hoàng Văn E', 12000000);

CREATE TABLE GERR.orders (
                        id SERIAL PRIMARY KEY,
                        customer_id INT REFERENCES GERR.customers(id),
                        order_amount NUMERIC

);
INSERT INTO GERR.orders (id,customer_id, order_amount) VALUES
                                                   (1,111, 3000000),
                                                   (2,112, 2500000),
                                                   (3,113, 7000000),
                                                   (4,114, 9000000),
                                                   (5,115, 5000000),
                                                   (6,115, 6000000);

CREATE OR REPLACE FUNCTION check_credit_limit(in_customer_id INT,in_order_amount INT)
RETURNS INT
AS $$
BEGIN
SELECT credit_limit,order_amount FROM
   GERR.customers c JOIN GERR.orders o on c.id = o.customer_id;
IF GERR.orders.order_amount > GERR.customers.credit_limit THEN
   RAISE EXCEPTION 'KO HỢP LỆ';
ELSE
     INSERT INTO GERR.orders(customer_id,order_amount)
    VALUES(in_customer_id,in_order_amount);
END IF;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_check_credit
BEFORE INSERT ON
GERR.orders
FOR EACH ROW
EXECUTE FUNCTION check_credit_limit()




CREATE TABLE GERR.employees (
                           id SERIAL PRIMARY KEY,
                           name VARCHAR(100),
                           position VARCHAR(100),
                           salary NUMERIC
);
CREATE TABLE employees_log (
                               log_id SERIAL PRIMARY KEY,
                               employee_id INT,
                               operation VARCHAR(10),
                               old_data JSONB,
                               new_data JSONB,
                               change_time TIMESTAMP DEFAULT NOW()
);
CREATE OR REPLACE FUNCTION log_employee_changes()
RETURNS TRIGGER
LANGUAGE plpgsql
AS $$
BEGIN
IF TG_OP = 'INSERT' THEN
INSERT INTO employees_log (
employee_id,
operation,
old_data,
new_data,
change_time
)
VALUES (
NEW.id,
'INSERT',
NULL,
to_jsonb(NEW),
NOW()
);
RETURN NEW;
    ELSIF TG_OP = 'UPDATE' THEN
        INSERT INTO employees_log (
            employee_id,
            operation,
            old_data,
            new_data,
            change_time
        )
        VALUES (
                   NEW.id,
                   'UPDATE',
                   to_jsonb(OLD),
                   to_jsonb(NEW),
                   NOW()
               );
        RETURN NEW;

    ELSIF TG_OP = 'DELETE' THEN
        INSERT INTO employees_log (
            employee_id,
            operation,
            old_data,
            new_data,
            change_time
        )
        VALUES (
OLD.id,
'DELETE',
to_jsonb(OLD),
NULL,
NOW()
);
RETURN OLD;
END IF;
END;
$$;
CREATE TRIGGER trg_log_employee_changes
    AFTER INSERT OR UPDATE OR DELETE
    ON GERR.employees
    FOR EACH ROW
EXECUTE FUNCTION log_employee_changes();





CREATE TABLE GERR.products (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(100),
                          stock INT NOT NULL
);


CREATE TABLE GERR.orders (
                        id SERIAL PRIMARY KEY,
                        product_id INT REFERENCES products(id),
                        quantity INT NOT NULL
);
CREATE OR REPLACE FUNCTION update_product_stock()
    RETURNS TRIGGER
    LANGUAGE plpgsql
AS $$
BEGIN
    -- Khi thêm đơn hàng mới
    IF TG_OP = 'INSERT' THEN
        UPDATE GERR.products
        SET stock = stock - NEW.quantity
        WHERE id = NEW.product_id;

        -- Khi cập nhật đơn hàng
    ELSIF TG_OP = 'UPDATE' THEN
        UPDATE GERR.products
        SET stock = stock + OLD.quantity - NEW.quantity
        WHERE id = NEW.product_id;

        -- Khi xóa đơn hàng
    ELSIF TG_OP = 'DELETE' THEN
        UPDATE GERR.products
        SET stock = stock + OLD.quantity
        WHERE id = OLD.product_id;
    END IF;

    RETURN NULL;
END;
$$;

CREATE TRIGGER trg_update_stock
    AFTER INSERT OR UPDATE OR DELETE
    ON GERR.orders
    FOR EACH ROW
EXECUTE FUNCTION update_product_stock();













