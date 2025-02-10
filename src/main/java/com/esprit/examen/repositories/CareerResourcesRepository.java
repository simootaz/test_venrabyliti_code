package com.esprit.examen.repositories;

import com.esprit.examen.entities.CareerResources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CareerResourcesRepository extends JpaRepository<CareerResources, Long> {
    List<CareerResources> findByGoal_GoalId(Long goalId);
    List<CareerResources> findByNameContainingIgnoreCase(String keyword);

}
