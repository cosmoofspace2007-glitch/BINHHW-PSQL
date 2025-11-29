CREATE SCHEMA university
CREATE table university.STUDENT(
    student_id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    birth_date DATE,
    email VARCHAR(70) NOT NULL UNIQUE
);

CREATE table university.COURSES(
    courses_id SERIAL PRIMARY KEY,
    courses_name varchar(100) NOT NULL,
    credits INT
);

CREATE TABLE university.Enrollments (
        enrollment_id SERIAL PRIMARY KEY,
        student_id INT REFERENCES STUDENT(student_id),
        courses_id INT REFERENCES COURSES(courses_id),
        enroll_date DATE
);