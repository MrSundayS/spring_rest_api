package com.example.spring_rest_api.service;

import com.example.spring_rest_api.model.User;
import com.example.spring_rest_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service    // special class for implementation of business logic of api
public class UserServer {
    @Autowired      // implement dependency injection
    private UserRepository userRepository;  // object of repository
    // SELECT * FROM user;
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User addUser(User user){
        return userRepository.save(user);
    }
    public User getUserByEmail(String email){
        return userRepository.findFirstByEmail(email);
    }
}