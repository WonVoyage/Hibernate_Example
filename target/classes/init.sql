CREATE SCHEMA IF NOT EXISTS test;
USE test;

DROP TABLE IF exists student;
create table students
(
    id BIGINT PRIMARY KEY Auto_increment,
    name_student varchar(100),
    surname varchar(100),
    course_name varchar(100)
);

INSERT into students (name_student, surname, course_name) values('Alex', 'Marshall', 'Java');