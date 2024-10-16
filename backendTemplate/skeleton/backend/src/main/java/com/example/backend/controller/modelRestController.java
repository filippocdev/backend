package com.example.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.backend.model.Model;
import com.example.backend.service.ModelService;
// {% if values. lombok %}
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
/*{% endif %}*/@RestController
@RequestMapping("/model/v1")
public class modelRestController {
    
    private ModelService modelService;

    @GetMapping("/{id}")
    public ResponseEntity<Model> getModelById(@PathVariable String id){
        return ResponseEntity.ok().body(modelService.getModelById(id));
    }
}
