DROP SEQUENCE IF EXISTS students_global_sequence;
DROP SEQUENCE IF EXISTS books1_global_sequence;
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS books;

CREATE SEQUENCE students_global_sequence START 1000;
CREATE SEQUENCE books1_global_sequence START 1000;
CREATE TABLE students (
  id          INTEGER PRIMARY KEY DEFAULT nextval('students_global_sequence'),
  name        VARCHAR NOT NULL,
  age         INTEGER,
  createdDate TIMESTAMP           DEFAULT now(),
  isAdmin     BOOLEAN             DEFAULT TRUE
);

CREATE TABLE books (
  id      INTEGER PRIMARY KEY DEFAULT nextval('books1_global_sequence'),
  student_id INTEGER NOT NULL,
  title   VARCHAR     NOT NULL,
  pages   INTEGER     NOT NULL,
  author  VARCHAR(40) NOT NULL,
  FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE
)
