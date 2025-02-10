package com.esprit.examen.services;

import com.esprit.examen.entities.Goal;
import com.esprit.examen.entities.User;

public interface UserService {
    public User createUser(User user);
    Goal addGoal(Goal goal, String userName);

}
