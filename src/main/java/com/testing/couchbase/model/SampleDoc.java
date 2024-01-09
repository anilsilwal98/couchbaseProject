package com.testing.couchbase.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Document
public class SampleDoc<T> {
    @Id
    private String id;

    @Field
    @NonNull
    private String firstName;


    private Address address;

    @Field
    T data;


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }



    public String getId(){
        return this.id;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public T getData(){
        return this.data;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setData(T data){
        this.data = data;
    }

}
