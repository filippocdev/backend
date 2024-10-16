package com.example.backend.model;
// {% if values.mongodb %}
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
// {% endif %}

// {% if values.postgresql %}
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
// {% endif %}

// {% if values.lombok %}
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// {% endif %}

// {% if values.lombok %}
// Generato con lombok
@NoArgsConstructor
@AllArgsConstructor
@Data
// {% endif %}

// {% if values.postgresql %}
// Generato con postgresql
@Entity
@Table(name = "model")
// {% endif %}

// {% if values.mongodb %}
// Generato con mongodb
@Document("model")
// {% endif %}

public class Model{

    @Id
    private String id;

}
