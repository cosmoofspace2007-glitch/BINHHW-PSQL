CREATE SCHEMA SV;
CREATE table SV.Students(
    student_id SERIAL PRIMARY KEY,
    ho_ten VARCHAR(50) UNIQUE NOT NULL,
    dia_chi VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    ngay_sinh DATE NOT NULL
);

CREATE table SV.Courses(
    course_id SERIAL PRIMARY KEY,
    course_name VARCHAR(100) UNIQUE NOT NULL,
    credits VARCHAR(100)
);

CREATE table SV.Enrollments(
    enrollment_id SERIAL PRIMARY KEY,
    student_id INT REFERENCES SV.Students(student_id),
    course_id INT REFERENCES SV.Courses(course_id)
)