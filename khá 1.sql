CREATE SCHEMA Library
CREATE table Library.BOOKS(
    book_id SERIAL PRIMARY KEY,
    title varchar(100) NOT NULL,
    author varchar(50) NOT NULL,
    published_year INT,
    price NUMERIC

    );

