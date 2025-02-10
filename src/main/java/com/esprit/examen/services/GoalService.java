package com.esprit.examen.services;

import com.esprit.examen.entities.Goal;

import java.util.List;

public interface GoalService {

    int calculateProgress(Long goalId);
    List<Goal> getStaleGoals(int daysSinceLastUpdate);


}
