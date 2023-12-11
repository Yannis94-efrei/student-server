CREATE SEQUENCE IF NOT EXISTS SEQUENCE_STUDENT START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS Student (
                                       Id INT DEFAULT NEXTVAL('SEQUENCE_STUDENT') PRIMARY KEY,
                                       name VARCHAR(255),
                                       age INT
);

TRUNCATE TABLE Student;
