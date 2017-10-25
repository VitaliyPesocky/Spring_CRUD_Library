package com.app.repository;

import com.app.model.Student;

import java.util.List;

public interface StudentRepository {
    void addStudent(Student student);

    Student getStudentById(Integer id);

    void deleteStudent(Integer id);

    void updateStudent(Student student);

    List<Student> getAllStudents();
}
