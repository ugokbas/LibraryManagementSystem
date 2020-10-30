package com.library.webapp.service;

import com.library.webapp.domain.Book;
import java.util.Collection;
import java.util.List;


public interface BookServiceInterface {

    public Book saveBook(Book book);
    public Boolean deleteBook(String bookId);
    public Book editBook(Book book);
    public Book findBook(String bookId);
    public Collection<Book> getAllBooks();
    public List<Book> getBooksByName(String name);
}
