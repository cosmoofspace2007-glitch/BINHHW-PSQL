CREATE SCHEMA shel
CREATE TABLE shel.book (
                      book_id SERIAL PRIMARY KEY,
                      title VARCHAR(255),
                      author VARCHAR(100),
                      genre VARCHAR(50),
                      price DECIMAL(10,2),
                      description TEXT,
                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO shel.book (book_id,title, author, genre, price, description)
VALUES
    (011,'The Silent Patient', 'Alex Michaelides', 'Thriller', 12.99, 'A psychological thriller about a woman who stops speaking.'),
    (012,'Atomic Habits', 'James Clear', 'Self-help', 15.50, 'A guide to building better habits.'),
    (013,'Clean Code', 'Robert C. Martin', 'Programming', 32.00, 'A book about writing clean and maintainable code.'),
    (014,'1984', 'George Orwell', 'Dystopian', 10.99, 'A classic novel depicting a totalitarian regime.'),
    (015,'The Hobbit', 'J.R.R. Tolkien', 'Fantasy', 14.25, 'A fantasy adventure preceding The Lord of the Rings.'),
    (016,'Rich Dad Poor Dad', 'Robert Kiyosaki', 'Finance', 11.80, 'Book about financial education and mindset.'),
    (017,'Deep Work', 'Cal Newport', 'Productivity', 13.40, 'A book on improving focus and work efficiency.'),
    (018,'Harry Potter and the Philosopher''s Stone', 'J.K. Rowling', 'Fantasy', 16.30, 'The first book in the Harry Potter series.'),
    (019,'The Subtle Art of Not Giving a F*ck', 'Mark Manson', 'Self-help', 14.99, 'A counterintuitive approach to living a better life.'),
    (020,'To Kill a Mockingbird', 'Harper Lee', 'Classic', 9.75, 'A story of racial injustice in the Deep South.');


EXPLAIN ANALYSE SELECT author FROM shel.book WHERE author ILIKE '%Lee%';
--Seq Scan on book  (cost=0.00..11.00 rows=3 width=218) (actual time=0.020..0.021 rows=1.00 loops=1)
-- Filter: ((author)::text ~~* '%Lee%'::text)
--Rows Removed by Filter: 9
--Buffers: shared hit=1
--Planning Time: 0.051 ms
--Execution Time: 0.032 ms


CREATE INDEX idx_book_author ON shel.book(author);
EXPLAIN ANALYSE SELECT author FROM shel.book WHERE author ILIKE '%Lee%';
--Seq Scan on book  (cost=0.00..1.12 rows=1 width=218) (actual time=0.024..0.024 rows=1.00 loops=1)
--Filter: ((author)::text ~~* '%Lee%'::text)
--Rows Removed by Filter: 9
--Buffers: shared hit=1
--Planning Time: 0.058 ms
--Execution Time: 0.034 ms

CREATE INDEX idx_genre_author ON shel.book(genre);
SELECT genre FROM shel.book WHERE genre LIKE '%F%';

CLUSTER shel.book USING book_pkey



