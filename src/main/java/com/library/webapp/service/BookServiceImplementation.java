package com.library.webapp.service;

import com.library.webapp.domain.Book;
import com.library.webapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class BookServiceImplementation implements BookServiceInterface {

    @Autowired
    protected BookRepository bookRepository;

    @Override
    public Book saveBook(Book book) {
        // TODO Auto-generated method stub
        return bookRepository.save(book);
    }

    @Override
    public Boolean deleteBook(String bookId) {
        // TODO Auto-generated method stub
        Optional<Book> temp = bookRepository.findById(bookId);
        if (temp != null) {
            bookRepository.delete(temp.get());
            return true;
        }
        return false;
    }

    @Override
    public Book editBook(Book book) {
        // TODO Auto-generated method stub
        return bookRepository.save(book);
    }

    @Override
    public Collection<Book> getAllBooks() {
        // TODO Auto-generated method stub
        Iterable<Book> itr = bookRepository.findAll();
        return (Collection<Book>) itr;
    }

    @Override
    public List<Book> getBooksByName(String name) {
        return bookRepository.findByBookName(name);
    }

    @Override
    public Book findBook(String bookId) {
        return bookRepository.findById(bookId).get();
    }


}
