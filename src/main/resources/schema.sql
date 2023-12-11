CREATE TABLE IF NOT EXISTS Student (
    Id INT PRIMARY KEY,
    name VARCHAR(255),
    age INT
);
TRUNCATE TABLE Student;

create sequence IF NOT EXISTS RTDS_ADSINPUT_SEQ start with 1 increment by 1;