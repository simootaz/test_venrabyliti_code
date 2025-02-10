package com.esprit.examen.servicesImpl;

import com.esprit.examen.entities.Goal;
import com.esprit.examen.entities.User;
import com.esprit.examen.repositories.GoalRepository;
import com.esprit.examen.repositories.UserReposirory;
import com.esprit.examen.services.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserReposirory userReposirory;


    @Resource
    private GoalRepository goalRepository;

    @Override
    public User createUser(User user) {
        return userReposirory.save(user);
    }

    @Override
    public Goal addGoal(Goal goal, String userName) {
        Optional<User> user = userReposirory.findByName(userName);
        if (user.isPresent()) {
            goal.setUser(user.get());
            user.get().getGoals().add(goal);
            userReposirory.save(user.get());
            return goalRepository.save(goal);
        } else {
            throw new RuntimeException("User not found");
        }
    }
}
