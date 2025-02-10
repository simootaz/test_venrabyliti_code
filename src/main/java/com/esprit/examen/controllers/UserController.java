package com.esprit.examen.controllers;

import com.esprit.examen.entities.Goal;
import com.esprit.examen.entities.User;
import com.esprit.examen.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    @ResponseBody
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }





}
