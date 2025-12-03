CREATE SCHEMA studentinma;
CREATE table studentinma.STUDENT(
   id SERIAL PRIMARY KEY,
   full_name VARCHAR(100),
   gender VARCHAR(10),
   birth_year INT,
   major VARCHAR(50),
   gpa DECIMAL(2,1)
);

INSERT INTO studentinma.STUDENT (full_name, gender, birth_year, major, gpa) VALUES
   ('Nguyễn Văn A', 'Nam', 2002, 'CNTT', 3.6),
   ('Trần Thị Bích Ngọc', 'Nữ', 2001, 'Kinh tế', 3.2),
   ('Lê Quốc Cường', 'Nam', 2003, 'CNTT', 2.7),
   ('Phạm Minh Anh', 'Nữ', 2000, 'Luật', 3.9),
   ('Nguyễn Văn A', 'Nam', 2002, 'CNTT', 3.6),
   ('Lưu Đức Tài', 'Nam', 2004, 'Cơ khí',NULL),
   ('Võ Thị Thu Hằng', 'Nữ', 2001, 'CNTT', 3.0);

INSERT INTO studentinma.STUDENT (full_name, gender, birth_year, major, gpa) VALUES
    ('Phan Hoàng Nam', 'Nam', 2003, 'CNTT',  3.8);

UPDATE studentinma.STUDENT SET gpa = 3.4 WHERE id = 3;

DELETE FROM studentinma.STUDENT WHERE gpa ISNULL;

SELECT * FROM studentinma.STUDENT WHERE gpa >= 3.0 LIMIT 3;

SELECT DISTINCT major FROM studentinma.STUDENT;

SELECT * FROM studentinma.STUDENT ORDER BY gpa DESC;SELECT * FROM studentinma.STUDENT ORDER BY full_name;

SELECT * FROM studentinma.STUDENT WHERE full_name LIKE '%Nguyễn%';

SELECT * FROM studentinma.STUDENT WHERE birth_year BETWEEN 2001 AND 2003;