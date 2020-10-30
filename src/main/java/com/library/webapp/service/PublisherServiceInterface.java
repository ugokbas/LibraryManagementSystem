package com.library.webapp.service;

import com.library.webapp.domain.Publisher;
import java.util.Collection;
import java.util.List;


public interface PublisherServiceInterface {

    public Publisher savePublisher(Publisher pub);
    public Boolean deletePublisher(String pubId);
    public Publisher editPublisher(Publisher pub);
    public Publisher findPublisher(String pubId);
    public Collection<Publisher> getAllPublishers();
    public List<Publisher> getPublishersByName(String name);
}
