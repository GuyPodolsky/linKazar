package com.guyp.linKazar.repository;

import com.guyp.linKazar.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findFirstByName(String name);

}

