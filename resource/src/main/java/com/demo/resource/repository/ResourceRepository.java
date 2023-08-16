package com.demo.resource.repository;

import com.demo.resource.model.Resource;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ResourceRepository extends MongoRepository<Resource, String>{
    public Optional<Resource> findByResourceName(String name);
}
