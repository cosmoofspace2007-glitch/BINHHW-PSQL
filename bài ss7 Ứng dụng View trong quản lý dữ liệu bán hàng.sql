CREATE TABLE customer (
                          customer_id SERIAL PRIMARY KEY,
                          full_name VARCHAR(100),
                          email VARCHAR(100),
                          phone VARCHAR(15)
);
INSERT INTO customer (customer_id,full_name, email, phone) VALUES
                                                   (00,'Nguyễn Văn A', 'a@gmail.com', '0901234567'),
                                                   (01,'Trần Thị B', 'b@gmail.com', '0912345678'),
                                                   (02,'Lê Văn C', 'c@gmail.com', '0923456789'),
                                                   (03,'Phạm Thị D', 'd@gmail.com', '0934567890'),
                                                   (04,'Hoàng Văn E', 'e@gmail.com', '0945678901');


CREATE TABLE orders (
                        order_id SERIAL PRIMARY KEY,
                        customer_id INT REFERENCES customer(customer_id),
                        total_amount DECIMAL(10,2),
                        order_date DATE
);
INSERT INTO orders (order_id,customer_id, total_amount, order_date) VALUES
                                                               (0,00, 2500.00, '2024-12-20'),
                                                               (1,01, 1800.50, '2025-01-10'),
                                                               (2,02, 3200.00, '2025-01-05'),
                                                               (3,03, 1500.00, '2025-02-02'),
                                                               (4,04, 4200.75, '2025-02-15');

CREATE VIEW v_order_summary AS
    SELECT full_name, total_amount, order_date
    FROM customer c JOIN orders o on c.customer_id = o.customer_id;

SELECT * FROM v_order_summary;

CREATE FUNCTION fn_thay_the_update()
RETURNS TRIGGER
AS $$
BEGIN
    UPDATE orders
    SET total_amount = 2000.00
    WHERE customer_id = 1;
END;
$$ LANGUAGE plpgsql;
CREATE TRIGGER update_bang
INSTEAD OF UPDATE ON v_order_summary
FOR EACH ROW
EXECUTE FUNCTION fn_thay_the_update();


CREATE OR REPLACE VIEW v_monthly_sales
AS
SELECT DATE_TRUNC('month',order_date) AS thang,SUM(total_amount) AS total_revenue
FROM orders
GROUP BY DATE_TRUNC('month',order_date)

--DROP VIEW xóa bảng ảo (View) không chứa dữ liệu, chỉ là truy vấn định nghĩa sẵn,
--còn DROP MATERIALIZED VIEW xóa bảng ảo vật chất (Materialized View) - là một bảng thực sự lưu trữ kết quả của một truy vấn phức tạp
--đã được tính toán và lưu trữ vật lý.



