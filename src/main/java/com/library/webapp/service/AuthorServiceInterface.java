package com.library.webapp.service;

import com.library.webapp.domain.Author;
import java.util.Collection;
import java.util.List;


public interface AuthorServiceInterface {

    public Author saveAuthor(Author aut);
    public Boolean deleteAuthor(String autId);
    public Author editAuthor(Author aut);
    public Author findAuthor(String autId);
    public Collection<Author> getAllAuthors();
    public List<Author> getAuthorsByName(String name);
}
