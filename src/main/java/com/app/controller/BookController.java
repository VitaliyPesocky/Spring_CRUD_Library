package com.app.controller;

import com.app.model.Book;
import com.app.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {
    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = "deleteBook/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable Integer id, Model model) {
        Book book = bookRepository.getBook(id);
        bookRepository.removeBook(id);
        Integer studentId = book.getStudent().getId();
        model.addAttribute("studentId", studentId);
        return "redirect:/listOfBooks/{studentId}";
    }

    @RequestMapping(value = "addBook/{studentId}", method = RequestMethod.GET)
    public String addBook(ModelMap model, @PathVariable Integer studentId) {
        model.addAttribute("studentId", studentId);
        return "addBook";
    }

    @RequestMapping(value = "addBook/{studentId}", method = RequestMethod.POST)
    public String addBook(@RequestParam("title") String title, @RequestParam("pages") String pages, @RequestParam("author") String author,
                          @PathVariable Integer studentId) {
        Book book = new Book(title, Integer.parseInt(pages), author);
        bookRepository.addBook(book, studentId);
        return "redirect:/listOfBooks/{studentId}";
    }

    @RequestMapping(value = "updateBook/{id}", method = RequestMethod.GET)
    public String updateBook(@PathVariable Integer id, Model model) {
        model.addAttribute("bookAttribute" ,bookRepository.getBook(id));
        return "updateBook";
    }

    @RequestMapping(value = "updateBook/{id}", method = RequestMethod.POST)
    public String updateBook(@RequestParam("title") String title, @RequestParam("pages") String pages, @RequestParam("author") String author,
                             @PathVariable Integer id, Model model) {
        Book book = bookRepository.getBook(id);
        book.setAuthor(author);
        book.setPages(Integer.parseInt(pages));
        book.setTitle(title);
        bookRepository.updateBook(book);
        model.addAttribute("studentId", book.getStudent().getId());
        return "redirect:/listOfBooks/{studentId}";
    }

    @RequestMapping(value = "listOfBooks/{studentId}", method = RequestMethod.GET)
    public String getBooksByStudId(Model model, @PathVariable Integer studentId) {
        List<Book> books = bookRepository.getAllBooksForUser(studentId);
        model.addAttribute("books", books);
        model.addAttribute("studentId", studentId);
        return "listOfBooks";
    }
}
