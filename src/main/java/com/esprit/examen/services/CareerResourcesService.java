package com.esprit.examen.services;

import com.esprit.examen.entities.CareerResources;

import java.util.List;

public interface CareerResourcesService {
    List<CareerResources> searchCareerResources(String keyword);

}
