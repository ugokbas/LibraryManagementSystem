package com.library.webapp.service;

import com.library.webapp.domain.Publisher;
import com.library.webapp.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class PublisherServiceImplementation implements PublisherServiceInterface {

    @Autowired
    protected PublisherRepository publisherRepository;

    @Override
    public Publisher savePublisher(Publisher pub) {
        // TODO Auto-generated method stub
        return publisherRepository.save(pub);
    }

    @Override
    public Boolean deletePublisher(String pubId) {
        // TODO Auto-generated method stub
        Optional<Publisher> temp = publisherRepository.findById(pubId);
        if (temp != null) {
            publisherRepository.delete(temp.get());
            return true;
        }
        return false;
    }

    @Override
    public Publisher editPublisher(Publisher pub) {
        // TODO Auto-generated method stub
        return publisherRepository.save(pub);
    }

    @Override
    public Collection<Publisher> getAllPublishers() {
        // TODO Auto-generated method stub
        Iterable<Publisher> itr = publisherRepository.findAll();
        return (Collection<Publisher>) itr;
    }

    @Override
    public List<Publisher> getPublishersByName(String name) {
        return publisherRepository.findByPubName(name);
    }

    @Override
    public Publisher findPublisher(String pubId) {
        return publisherRepository.findById(pubId).get();
    }


}
