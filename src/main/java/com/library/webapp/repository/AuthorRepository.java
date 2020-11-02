package com.library.webapp.repository;

import com.library.webapp.domain.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface AuthorRepository extends CrudRepository<Author, String>{
    List<Author> findByAutName(String autName);

    @Query(value="select * from author e where UPPER(e.aut_name) like %:keyword%" , nativeQuery = true)
    List<Author> findByKeyword(@Param("keyword") String keyword);
}
