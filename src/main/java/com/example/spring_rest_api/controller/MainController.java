package com.example.spring_rest_api.controller;
import com.example.spring_rest_api.model.User;
import com.example.spring_rest_api.repository.UserRepository;
import com.example.spring_rest_api.service.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

// CheetSheet
// ALT + Enter -> auto-hints
// CTRL + SHIFT + F10 -> run application server
// CTRL + D -> duplicate line
// ALT + Ins -> auto-generate
@RestController   // controller class -> mapping http request for method java methods
public class MainController {
    private UserServer userService;
    private UserRepository userRepository;
    // ALT + Enter - generate constructor
    @Autowired
    public MainController(UserServer userService) {
        this.userService = userService;
    }
    @DeleteMapping("/users/delete/{userId}")
    public boolean deleteUserById(@PathVariable("userId")int userId){
        return userService.deleteUserById(userId);
    }
    @PutMapping("/users/changePassword")
    public User updatePassword(@RequestParam("userId") int userId, @RequestParam("newPassword")String newPassword){
        return userService.updatePassword(userId,newPassword);
    }
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping("/users/register")
    public User registerUser(
        @RequestParam("name") String name,
        @RequestParam("lastName") String lastName,
        @RequestParam("email") String email,
        @RequestParam("password") String password
        ){
        return userService.addUser(new User(name,lastName,email,password));
    }
    @GetMapping("/users/findByEmail")
    public User getUserByEmail(
            @RequestParam("email") String email
    ){
        return userService.getUserByEmail(email);
    }

    @GetMapping("/")        // http://www.localhost:8080/
    public String homepage(){
        return "Hello in hompage";
    }
    @GetMapping("/user/id={userId}&name={name}&lastName={lastName}&email={email}&password={password}")
    public User getUser(
            @PathVariable("userId") int userId, @PathVariable("name") String name,
            @PathVariable("lastName") String lastName, @PathVariable("email") String email,
            @PathVariable("password") String password
    ){
        return new User(userId, name, lastName, email,password, LocalDateTime.now(), false, new HashSet<>());
    }

}