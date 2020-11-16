package com.example.spring_rest_api.controller;
import com.example.spring_rest_api.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

// CheetSheet
// ALT + Enter -> auto-hints
// CTRL + SHIFT + F10 -> run application server
// CTRL + D -> duplicate line
// ALT + Ins -> auto-generate
@RestController   // controller class -> mapping http request for method java methods
public class MainController {
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
        return new User(userId, name, lastName, email,password, LocalDateTime.now(), false);
    }

}
