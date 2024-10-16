package com.example.backend.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.model.Model;


@Repository
public interface ModelRepository extends MongoRepository<Model, String>{
    
}
