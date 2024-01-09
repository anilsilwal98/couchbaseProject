package com.testing.couchbase.controller;

import com.testing.couchbase.model.Address;
import com.testing.couchbase.model.SampleDoc;
import com.testing.couchbase.service.CouchbaseRepositoryService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.ILoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@Slf4j
public class CouchBaseController {

    @Autowired
    private CouchbaseRepositoryService couchbaseRepositoryService;
    @GetMapping("/hello")
    public String exposeHelloWorld(){
        SampleDoc<String> sample = new SampleDoc<>();
        sample.setId("123");
        sample.setAddress(getAddress());
        sample.setData("data");
        sample.setFirstName("anil");
        couchbaseRepositoryService.create(sample);
        final Optional<SampleDoc> doc = couchbaseRepositoryService.findOne("123");
        if(doc.isPresent()){
            return "firstName:" + doc.get().getFirstName() + "Data:" + doc.get().getData();
        }
        return "Hello World";
    }

    @GetMapping("/helloOther")
    public Address exposeHelloWorldAddress(){
        SampleDoc<Address> sample = new SampleDoc<>();
        Address address = getAddress();
        sample.setId("1234");
        sample.setAddress(address);
        sample.setData(address);
        sample.setFirstName("anil");
        try{
            couchbaseRepositoryService.create(sample);
            final Optional<SampleDoc> doc = couchbaseRepositoryService.findOne("1234");
            if(doc.isPresent()){
                return (Address) doc.get().getData();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    private static Address getAddress() {
        Address address = new Address();
        address.setCity("xx");
        address.setStreetAddress("XXXXX");
        address.setCountry("USA");
        address.setZipCode(78717);
        return address;
    }
}
