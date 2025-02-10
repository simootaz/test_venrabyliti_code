package com.esprit.examen.servicesImpl;

import com.esprit.examen.entities.CareerResources;
import com.esprit.examen.repositories.CareerResourcesRepository;
import com.esprit.examen.services.CareerResourcesService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CareerResourcesServiceImpl implements CareerResourcesService {


    @Resource
    private CareerResourcesRepository careerResourcesRepository;

    @Override
    public List<CareerResources> searchCareerResources(String keyword) {
        return careerResourcesRepository.findByNameContainingIgnoreCase(keyword);
    }

}
