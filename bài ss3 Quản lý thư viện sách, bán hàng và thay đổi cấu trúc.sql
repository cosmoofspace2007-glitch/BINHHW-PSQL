CREATE SCHEMA library;
CREATE table library. Books(
   book_id SERIAL PRIMARY KEY,
   title VARCHAR(70) UNIQUE NOT NULL,
   author VARCHAR(50) UNIQUE NOT NULL,
   published_year INT,
   available BOOLEAN DEFAULT TRUE
);


CREATE table library.Members(
    member_id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(70) NOT NULL UNIQUE,
    join_date DATE DEFAULT CURRENT_DATE
);

CREATE SCHEMA SALES;
CREATE table SALES.Products(
    product_id SERIAL PRIMARY KEY,
    product_name VARCHAR(50) NOT NULL,
    price NUMERIC(2,1),
    stock_quantity INT
);

CREATE table SALES.Orders(
    order_id SERIAL PRIMARY KEY,
    order_date DATE DEFAULT CURRENT_DATE,
    member_id INT REFERENCES library.Members(member_id)
);

CREATE table SALES. OrderDetails(
    order_detail_id SERIAL PRIMARY KEY,
    order_id INT REFERENCES SALES.Orders(order_id),
    product_id INT REFERENCES SALES.Products(product_id),
    quantity INT
);

ALTER table library.Books ADD COLUMN genre VARCHAR(100) UNIQUE;
ALTER table library.Books RENAME COLUMN available TO is_available;
ALTER table library.Members DROP COLUMN email;
DROP table SALES.OrderDetails