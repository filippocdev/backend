package com.example.backend.repository;

// Generato con {% if values.mongodb %} Mongodb {% elif values.postgresql %} Postgresql

// {% if values.mongodb %}
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
// {% endif %}
import com.example.backend.model.Model;


// {% if values.mongodb %}
@Repository
public interface ModelRepository extends MongoRepository<Model, String> {
    
}
//{% endif %}

// {% if values.postgresdb %}

// public interface ModelRepository extends JpaRepository<Model, String> {}

    


// {% endif %}