package com.esprit.examen.controllers;


import com.esprit.examen.entities.CareerResources;
import com.esprit.examen.services.CareerResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CareerResourcesController {


    @Autowired
    private CareerResourcesService careerResourcesService;

    @GetMapping("/search")
    public ResponseEntity<List<CareerResources>> searchCareerResources(@RequestParam String keyword) {
        List<CareerResources> resources = careerResourcesService.searchCareerResources(keyword);
        if (resources.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resources);
    }
}
