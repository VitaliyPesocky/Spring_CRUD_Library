package com.app.repository.impl;

import com.app.model.Student;
import com.app.repository.StudentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class StudentRepositoryImpl implements StudentRepository {
    private final SessionFactory sessionFactory;

    @Autowired
    public StudentRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addStudent(Student student) {
        Session session = sessionFactory.openSession();
        session.save(student);
    }

    @Override
    public Student getStudentById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    }

    @Override
    public void deleteStudent(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.load(Student.class, id);
        session.delete(student);
    }

    @Override
    public void updateStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        Student newStudent = session.get(Student.class, student.getId());
        newStudent.setAge(student.getAge());
        newStudent.setName(student.getName());
        newStudent.setExtrumural(student.isExtrumural());
        session.save(newStudent);
    }

    @Override
    public List<Student> getAllStudents() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Student").list();
    }
}
