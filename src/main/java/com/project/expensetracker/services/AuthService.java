package com.project.expensetracker.services;

import com.project.expensetracker.entity.User;
import com.project.expensetracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    public boolean loginUser(User user){
        User user1 = userRepository.findByUsername(user.getUsername());
        if (user1 == null) return false;
        return user1.getPassword().equals(user.getPassword());
    }

    public boolean registerUser(User user){
        if(userRepository.existsByUsername(user.getUsername())) return false;
        else{
            userRepository.save(user);
            return true;
        }
    }
}
