package com.project.expensetracker.controllers;

import com.project.expensetracker.entity.User;
import com.project.expensetracker.services.AuthService;
import com.project.expensetracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
        if(authService.loginUser(user))return ResponseEntity.ok("Login successful");
        else return ResponseEntity.badRequest().body("Invalid username or password");
    }
    public ResponseEntity<?> logout(){
        return ResponseEntity.ok().build();
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user){
        if(authService.registerUser(user)) return ResponseEntity.ok("User registered successfully");
        else return ResponseEntity.badRequest().body("User with username: "+ user.getUsername()+" already exists");
    }
}

