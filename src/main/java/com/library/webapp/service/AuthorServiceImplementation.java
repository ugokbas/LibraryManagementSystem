package com.library.webapp.service;

import com.library.webapp.domain.Author;
import com.library.webapp.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class AuthorServiceImplementation implements AuthorServiceInterface {

    @Autowired
    protected AuthorRepository authorRepository;

    @Override
    public Author saveAuthor(Author aut) {
        // TODO Auto-generated method stub
        return authorRepository.save(aut);
    }

    @Override
    public Boolean deleteAuthor(String autId) {
        // TODO Auto-generated method stub
        Optional<Author> temp = authorRepository.findById(autId);
        if (temp != null) {
            authorRepository.delete(temp.get());
            return true;
        }
        return false;
    }

    @Override
    public Author editAuthor(Author aut) {
        // TODO Auto-generated method stub
        return authorRepository.save(aut);
    }

    @Override
    public Collection<Author> getAllAuthors() {
        // TODO Auto-generated method stub
        Iterable<Author> itr = authorRepository.findAll();
        return (Collection<Author>) itr;
    }

    @Override
    public List<Author> getAuthorsByName(String name) {
        return authorRepository.findByAutName(name);
    }

    @Override
    public Author findAuthor(String autId) {
        return authorRepository.findById(autId).get();
    }


}
