package com.example.backend.service;

import java.util.Optional;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.backend.model.Model;
import com.example.backend.repository.ModelRepository;

// {% if values. lombok %}
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
// {% endif %}
@Service
public class ModelService {

    ModelRepository modelRepository;

    public List<Model> findAll(){
        return modelRepository.findAll();
    }

    public Model getModelById(String id){
        
        Optional<Model> optModel = modelRepository.findById(id);
        if ( optModel.isPresent() ){
            return optModel.get();
        }
        return null;
    }
}
