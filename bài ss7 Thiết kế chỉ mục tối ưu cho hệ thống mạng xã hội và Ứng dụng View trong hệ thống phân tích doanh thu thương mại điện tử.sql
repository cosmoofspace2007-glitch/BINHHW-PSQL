
CREATE TABLE shel.post (
                      post_id SERIAL PRIMARY KEY,
                      user_id INT NOT NULL,
                      content TEXT,
                      tags TEXT[],
                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      is_public BOOLEAN DEFAULT TRUE
);
INSERT INTO shel.post (post_id,user_id, content, tags, created_at, is_public) VALUES
                                                                     (0,1, 'Hôm nay trời đẹp quá!', ARRAY['life','weather'], '2025-01-01 10:00:00', TRUE),
                                                                     (1,2, 'Vừa hoàn thành bài tập SQL!', ARRAY['study','sql'], '2025-01-02 14:20:00', TRUE),
                                                                     (2,3, 'Đi chơi với bạn bè cuối tuần!', ARRAY['travel','friends'], '2025-01-03 09:15:00', TRUE),
                                                                     (3,4, 'Lập trình thật thú vị!', ARRAY['coding','fun'], '2025-01-04 18:40:00', TRUE),
                                                                     (4,5, 'Mình thích ăn lẩu!', ARRAY['food'], '2025-01-05 20:30:00', FALSE);

CREATE TABLE shel.post_like (
                           user_id INT NOT NULL,
                           post_id INT NOT NULL,
                           liked_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           PRIMARY KEY (user_id, post_id)
);
INSERT INTO shel.post_like (user_id, post_id, liked_at) VALUES
                                                       (1, 0, '2025-01-01 11:00:00'),
                                                       (2, 1, '2025-01-01 11:05:00'),
                                                       (3, 2, '2025-01-02 15:00:00'),
                                                       (4, 3, '2025-01-03 10:00:00'),
                                                       (5, 4, '2025-01-04 19:00:00');

EXPLAIN ANALYSE SELECT * FROM shel.post WHERE is_public = TRUE AND content ILIKE '%chơi%';
--Seq Scan on post  (cost=0.00..19.25 rows=1 width=81) (actual time=0.040..0.042 rows=1.00 loops=1)
--Filter: (is_public AND (content ~~* '%chơi%'::text))
--Rows Removed by Filter: 4
--Buffers: shared hit=1
--Planning:
--Buffers: shared hit=2
--Planning Time: 0.081 ms
--Execution Time: 0.054 ms

EXPLAIN ANALYSE SELECT * FROM shel.post WHERE LOWER(content) ILIKE '%chơi%' AND is_public = TRUE;
--Seq Scan on post  (cost=0.00..21.10 rows=1 width=81) (actual time=0.074..0.077 rows=1.00 loops=1)
--Filter: (is_public AND (lower(content) ~~* '%chơi%'::text))
--Rows Removed by Filter: 4
--Buffers: shared hit=1
--Planning Time: 0.100 ms
--Execution Time: 0.128 ms

CREATE INDEX idx_json_gin ON shel.post USING GIN (tags);
EXPLAIN ANALYSE SELECT * FROM shel.post WHERE tags   > ARRAY['travel'];
--Seq Scan on post  (cost=0.00..1.06 rows=2 width=81) (actual time=2.147..2.149 rows=1.00 loops=1)
--Filter: (tags > '{travel}'::text[])
--Rows Removed by Filter: 4
--Buffers: shared hit=50
--Planning:
--Buffers: shared hit=80
--Planning Time: 6.312 ms
--Execution Time: 2.177 ms


CREATE INDEX idx_post_recent_public
ON shel.post(created_at DESC )
WHERE post.is_public = TRUE;

EXPLAIN ANALYSE SELECT * FROM shel.post
WHERE is_public = TRUE AND created_at >= NOW() - INTERVAL '7 days';
--Seq Scan on post  (cost=0.00..1.09 rows=1 width=81) (actual time=0.060..0.060 rows=0.00 loops=1)
--Filter: (is_public AND (created_at >= (now() - '7 days'::interval)))
--Rows Removed by Filter: 5
--Buffers: shared hit=1
--Planning Time: 0.071 ms
--Execution Time: 0.069 ms

CREATE INDEX idx_hieu_suat ON shel.post (user_id,created_at);
SELECT * FROM shel.post
WHERE is_public = TRUE AND created_at >= NOW() - INTERVAL '7 days';

CREATE INDEX idx_post_user_created_at
ON shel.post (user_id, created_at DESC);


EXPLAIN ANALYZE
SELECT *
FROM shel.post
WHERE user_id IN (1,3,5,8)
ORDER BY created_at DESC
LIMIT 20;
--Limit  (cost=1.11..1.12 rows=4 width=81) (actual time=0.020..0.021 rows=3.00 loops=1)
-- Buffers: shared hit=1
-- Sort  (cost=1.11..1.12 rows=4 width=81) (actual time=0.020..0.020 rows=3.00 loops=1)
--Sort Key: created_at DESC
--Sort Method: quicksort  Memory: 25kB
--Buffers: shared hit=1
--Seq Scan on post  (cost=0.00..1.07 rows=4 width=81) (actual time=0.014..0.015 rows=3.00 loops=1)
--"              Filter: (user_id = ANY ('{1,3,5,8}'::integer[]))"
--Rows Removed by Filter: 2
--Buffers: shared hit=1
--Planning Time: 0.158 ms
--Execution Time: 0.034 ms









CREATE TABLE sasor.customer (
                          customer_id SERIAL PRIMARY KEY,
                          full_name VARCHAR(100),
                          region VARCHAR(50)
);
INSERT INTO sasor.customer (customer_id,full_name,region) VALUES
                                             (111,'Nguyễn Văn A', 'Hà Nội'),
                                             (112,'Trần Thị B', 'Đà Nẵng'),
                                             (113,'Lê Văn C', 'Hồ Chí Minh'),
                                             (114,'Phạm Thị D', 'Hà Nội'),
                                             (115,'Hoàng Văn E', 'Cần Thơ');



CREATE TABLE sasor.orders (
                        order_id SERIAL PRIMARY KEY,
                        customer_id INT REFERENCES sasor.customer(customer_id),
                        total_amount DECIMAL(10,2),
                        order_date DATE,
                        status VARCHAR(20)
);
INSERT INTO sasor.orders (order_id,customer_id, total_amount, order_date, status) VALUES
                                                                       (0,111, 23000000, '2025-01-10', 'COMPLETED'),
                                                                       (1,112, 3000000, '2025-01-15', 'COMPLETED'),
                                                                       (2,113, 26500000, '2025-02-01', 'PENDING'),
                                                                       (3,114, 1500000, '2025-02-05', 'COMPLETED'),
                                                                       (4,115, 800000, '2025-02-10', 'CANCELLED');



CREATE TABLE sasor.product (
                         product_id SERIAL PRIMARY KEY,
                         name VARCHAR(100),
                         price DECIMAL(10,2),
                         category VARCHAR(50)
);
INSERT INTO sasor.product (product_id,name, price, category) VALUES
                                                (31,'Laptop Dell', 20000000, 'Electronics'),
                                                (32,'iPhone 15', 25000000, 'Electronics'),
                                                (33,'Tai nghe Sony', 3000000, 'Accessories'),
                                                (34,'Bàn phím cơ', 1500000, 'Accessories'),
                                                (35,'Chuột Logitech', 800000, 'Accessories');


CREATE TABLE sasor.order_detail (
                              order_id INT REFERENCES sasor.orders(order_id),
                              product_id INT REFERENCES sasor.product(product_id),
                              quantity INT
);
INSERT INTO sasor.order_detail (order_id, product_id, quantity) VALUES
                                                              (0, 31, 1),
                                                              (1, 32, 1),
                                                              (2, 33, 1),
                                                              (3, 34, 1),
                                                              (4, 35, 1);

CREATE VIEW v_revenue_by_region AS
SELECT region, sum(total_amount) AS total_revenue
FROM sasor.customer c JOIN sasor.orders o on c.customer_id = o.customer_id
GROUP BY region;
SELECT region FROM v_revenue_by_region ORDER BY total_revenue DESC LIMIT 3;

CREATE OR REPLACE VIEW v_order_detail_updatable AS
SELECT
    order_id,
    customer_id,
    order_date,
    total_amount,
    status
FROM sasor.orders
WHERE status IN ('COMPLETED')
WITH CHECK OPTION;

UPDATE v_order_detail_updatable
SET status = 'COMPLETED'
WHERE customer_id = 113;

CREATE OR REPLACE VIEW v_revenue_above_avg AS
SELECT *
FROM v_revenue_by_region
WHERE total_revenue >
      (
          SELECT AVG(total_revenue)
          FROM v_revenue_by_region
      );





