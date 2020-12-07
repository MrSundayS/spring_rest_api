package com.example.spring_rest_api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

// model class determine the data structure in our program
@Entity     // map the user class on database entity - support ORM
@Getter     // automatic injection code for this class covers getters
@Setter     // automatic injection code for this class covers setters
@AllArgsConstructor // automatic generation of contructor with all fields in arguments
@NoArgsConstructor  // automatic generation of contructor without arguments
public class User {
    @Id                                                 // PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO INCREMENTATION
    private int userId;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private LocalDateTime registrationDateTime = LocalDateTime.now();   // auto-generation actual dfate and time value
    private boolean status = false;
    @ManyToMany
    @JoinTable(                     // association (relation)
            name = "users_to_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public User(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
