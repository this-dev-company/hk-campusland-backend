package com.hackathon.hk_campusland_backend.auth.infrastructure.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.hk_campusland_backend.auth.application.services.UserService;
import com.hackathon.hk_campusland_backend.auth.domain.models.User;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService iUserService;

    @GetMapping
    public List<User> listUsers(){
        return iUserService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> showUser(@PathVariable String id){
        return iUserService.findById(id);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.created(URI.create("/user/userID")).body(iUserService.save(user));
    }

}
