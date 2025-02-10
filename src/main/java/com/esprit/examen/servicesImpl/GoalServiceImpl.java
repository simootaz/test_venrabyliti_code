package com.esprit.examen.servicesImpl;

import com.esprit.examen.entities.CareerResources;
import com.esprit.examen.entities.Goal;
import com.esprit.examen.repositories.CareerResourcesRepository;
import com.esprit.examen.repositories.GoalRepository;
import com.esprit.examen.services.GoalService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class GoalServiceImpl implements GoalService {


    @Resource
    private CareerResourcesRepository careerResourcesRepository;

    @Resource
    private GoalRepository goalRepository;

    @Override
    public int calculateProgress(Long goalId) {
        List<CareerResources> resources = careerResourcesRepository.findByGoal_GoalId(goalId);
        if (resources.isEmpty()) {
            return 0;
        }
        long completedCount = resources.stream().filter(CareerResources::isCompleted).count();
        return (int) ((double) completedCount / resources.size() * 100);
    }


    @Override
    public List<Goal> getStaleGoals(int daysSinceLastUpdate) {
        LocalDate cutoffDate = LocalDate.now().minusDays(daysSinceLastUpdate);
        return goalRepository.findByLastUpdatedBefore(cutoffDate);
    }
}
