package com.project.expensetracker.controllers;

import com.project.expensetracker.entity.User;
import com.project.expensetracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping(value = "/{username}")
    public ResponseEntity<?> getUser(@PathVariable String username){
        User user = userService.getUser(username);
        if (user == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user);
    }

    @DeleteMapping(value = "/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username){
        if (!userService.userExists(username)) return ResponseEntity.notFound().build();
        userService.deleteUser(username);
        return ResponseEntity.ok().build();
    }




}
