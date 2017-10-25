package com.app.repository;

import com.app.model.Book;

import java.util.List;

public interface BookRepository {

    void addBook(Book book, int studentId);

    Book getBook(Integer id);

    List<Book> getAllBooksForUser(int studentId);

    void removeBook(Integer id);

    void updateBook(Book book);

}
