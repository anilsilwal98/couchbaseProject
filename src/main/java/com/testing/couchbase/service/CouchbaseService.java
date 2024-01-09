package com.testing.couchbase.service;

import com.testing.couchbase.model.SampleDoc;

import java.util.List;
import java.util.Optional;

public interface CouchbaseService {
    Optional<SampleDoc> findOne(String id);

    List<SampleDoc> findAll();

    List<SampleDoc> findByFirstName(String firstName);

    List<SampleDoc> findByLastName(String lastName);

    void create(SampleDoc SampleDoc);

    void update(SampleDoc SampleDoc);

    void delete(SampleDoc SampleDoc);
}