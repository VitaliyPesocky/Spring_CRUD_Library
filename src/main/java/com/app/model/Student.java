package com.app.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "age")
    @NotNull
    private int age;

    @Column(name = "createddate")
    @NotNull
    @GeneratedValue
    private Date createdDate;

    @Column(name = "isadmin")
    @NotNull
    private boolean isExtrumural;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "student")
    private List<Book> books;

    public Student(){}

    public Student(String name, int age, boolean isExtrumural) {
        this.name = name;
        this.age = age;
        this.isExtrumural = isExtrumural;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate() {
        this.createdDate = new Timestamp(System.currentTimeMillis());
    }

    public boolean isExtrumural() {
        return isExtrumural;
    }

    public void setExtrumural(boolean extrumural) {
        isExtrumural = extrumural;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (age != student.age) return false;
        if (isExtrumural != student.isExtrumural) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        if (createdDate != null ? !createdDate.equals(student.createdDate) : student.createdDate != null) return false;
        return books != null ? books.equals(student.books) : student.books == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (isExtrumural ? 1 : 0);
        result = 31 * result + (books != null ? books.hashCode() : 0);
        return result;
    }
}
