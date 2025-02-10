package com.esprit.examen.controllers;

import com.esprit.examen.entities.Goal;
import com.esprit.examen.services.GoalService;
import com.esprit.examen.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GoalController {

    @Autowired
    private UserService userService;

    @Autowired
    private GoalService goalService;

    @PostMapping("/addGoalToUser")
    public ResponseEntity<Goal> addGoalToUser(@RequestBody Goal goal, @RequestParam String userName) {
        try {
            Goal createdGoal = userService.addGoal(goal, userName);
            return ResponseEntity.ok(createdGoal);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/{goalId}/progress")
    public ResponseEntity<Integer> getGoalProgress(@PathVariable Long goalId) {
        try {
            int progress = goalService.calculateProgress(goalId);
            return ResponseEntity.ok(progress);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
