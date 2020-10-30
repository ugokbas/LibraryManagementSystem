package com.library.webapp.repository;

import com.library.webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AuthorRepository extends CrudRepository<Author, String>{
    List<Author> findByAutName(String autName);
}
