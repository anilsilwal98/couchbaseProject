package com.testing.couchbase.repository;

import com.testing.couchbase.model.SampleDoc;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CouchbaseRepository extends CrudRepository<SampleDoc, String> {
    List<SampleDoc> findByFirstName(String firstName);

}

