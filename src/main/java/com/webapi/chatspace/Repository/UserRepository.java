package com.webapi.chatspace.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.webapi.chatspace.Model.User;

public interface UserRepository extends MongoRepository<User, String> {
    public Optional<User> findById(long id);
}
