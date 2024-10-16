package com.example.backend.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// {% if values.postgres %}




@Document("model")
public class Model{

    @Id
    private String id;

}
