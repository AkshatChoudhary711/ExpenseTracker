package com.project.expensetracker.services;

import com.project.expensetracker.entity.User;
import com.project.expensetracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(String username){
        return userRepository.findByUsername(username);
    }
    public void deleteUser(String username){
        userRepository.deleteByUsername(username);
    }
    public boolean userExists(String username){
        return userRepository.existsByUsername(username);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }




}
