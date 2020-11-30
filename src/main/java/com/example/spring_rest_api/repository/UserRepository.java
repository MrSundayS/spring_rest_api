package com.example.spring_rest_api.repository;

import com.example.spring_rest_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findFirstByEmail(String email);    // -> SELECT * FROM user WHERE email = ?;

}
