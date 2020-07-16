CREATE DATABASE student_management;
USE student_management;
CREATE TABLE student(
	id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(20),
    age INT,
    course VARCHAR(20),
	course_fee INT
    );
    
    INSERT INTO student(`name`, age, course, course_fee)
    VALUES
    ('Hoang', 21, 'CNTT', 400000),
    ('Viet', 19, 'DTVT', 320000),
    ('Huong', 18, 'KTDN', 600000),
    ('Nhan', 19, 'CK', 450000),
    ('Huong', 22, 'TCNH', 500000),
    ('Hong', 20, 'CNSH', 200000);
    
    DROP DATABASE student_management;

select name_student,sum(sotien) as tongtien from students
where name_student="Huong"
group by name_student;

select distinct name_student from students;  
