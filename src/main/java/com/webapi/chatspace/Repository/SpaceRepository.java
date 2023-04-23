package com.webapi.chatspace.Repository;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.webapi.chatspace.Model.Space;

public interface SpaceRepository extends MongoRepository<Space, String>{
    public Optional<Space> findById(long id);
}
