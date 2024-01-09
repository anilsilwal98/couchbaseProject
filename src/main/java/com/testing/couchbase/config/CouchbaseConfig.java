package com.testing.couchbase.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@Configuration
@EnableCouchbaseRepositories(basePackages = { "com.testing.couchbase" })
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {
    public  final static String NODE_LIST = "list1";
    public static final String BUCKET_NAME = "bucket1";
    public static final String BUCKET_USERNAME = "user1";
    public static final String BUCKET_PASSWORD = "password1";
    @Override
    public String getConnectionString() {
        return NODE_LIST;
    }

    @Override
    public String getUserName() {
        return BUCKET_USERNAME;
    }

    @Override
    public String getPassword() {
        return BUCKET_PASSWORD;
    }

    @Override
    public String getBucketName() {
        return BUCKET_NAME;
    }
}
