package com.library.webapp.repository;

import com.library.webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BookRepository extends CrudRepository<Book, String>{
    List<Book> findByBookName(String bookName);
}
