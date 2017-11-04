package com.app.repository.impl;

import com.app.model.Book;
import com.app.model.Student;
import com.app.repository.BookRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class BookRepositoryImpl implements BookRepository {
    private SessionFactory sessionFactory;

    @Autowired
    public BookRepositoryImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void addBook(Book book, int studentId) {
        Session session = sessionFactory.openSession();
        book.setStudent(session.get(Student.class, studentId));
        session.save(book);
    }

    @Override
    public Book getBook(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Book.class, id);
    }

    @Override
    public List<Book> getAllBooksForUser(int studentId) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Book b where b.student.id=:studentId").setParameter("studentId", studentId).list();
    }

    @Override
    public void removeBook(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.load(Book.class, id);
        if(book != null){
            session.delete(book);
        }
    }

    @Override
    public void updateBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        Book newBook = session.get(Book.class, book.getId());
        newBook.setAuthor(book.getAuthor());
        newBook.setPages(book.getPages());
        newBook.setTitle(book.getTitle());
        session.save(newBook);
    }
}
