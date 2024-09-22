package com.hackathon.hk_campusland_backend.auth.application.services;

import java.util.List;
import java.util.Optional;

import com.hackathon.hk_campusland_backend.auth.domain.models.User;

public interface UserService {

    Optional<User> findById(String id);
    
    List<User> findAll();

    User save(User user);
}
