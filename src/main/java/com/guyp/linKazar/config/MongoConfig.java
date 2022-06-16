package com.guyp.linKazar.config;

import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class MongoConfig {

    @Autowired
    MongoClient mongoClient;

}
