package com.library.webapp.repository;

import com.library.webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PublisherRepository extends CrudRepository<Publisher, String>{
    List<Publisher> findByPubName(String pubName);
}
