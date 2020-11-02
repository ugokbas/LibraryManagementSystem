package com.library.webapp.repository;

import com.library.webapp.domain.Author;
import com.library.webapp.domain.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface BookRepository extends CrudRepository<Book, String>{
    List<Book> findByBookName(String bookName);

    @Query(value="select * from book e where UPPER(e.aut_name) like %:keyword% or UPPER(e.book_name) like %:keyword% or UPPER(e.book_series_name) like %:keyword% or e.isbn like %:keyword%" , nativeQuery = true)
    List<Book> findByKeyword(@Param("keyword") String keyword);
}
