package com.testing.couchbase.service;

import com.testing.couchbase.model.SampleDoc;
import com.testing.couchbase.repository.CouchbaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@Qualifier("CouchbaseRepositoryService")
public class CouchbaseRepositoryService implements CouchbaseService {

    @Autowired
    private CouchbaseRepository repo;

    public Optional<SampleDoc> findOne(String id) {
        return repo.findById(id);
    }

    public List<SampleDoc> findAll() {
        List<SampleDoc> people = new ArrayList<SampleDoc>();
        Iterator<SampleDoc> it = repo.findAll().iterator();
        while(it.hasNext()) {
            people.add(it.next());
        }
        return people;
    }

    public List<SampleDoc> findByFirstName(String firstName) {
        return repo.findByFirstName(firstName);
    }

    @Override
    public List<SampleDoc> findByLastName(String lastName) {
        return null;
    }

    public void create(SampleDoc sampleDoc) {
        repo.save(sampleDoc);
    }

    public void update(SampleDoc sampleDoc) {
        repo.save(sampleDoc);
    }

    public void delete(SampleDoc sampleDoc) {
        repo.delete(sampleDoc);
    }
}
