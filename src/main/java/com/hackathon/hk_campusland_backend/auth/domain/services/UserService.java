package com.hackathon.hk_campusland_backend.auth.domain.services;

import java.util.List;
import java.util.Optional;

import com.hackathon.hk_campusland_backend.auth.domain.entity.User;

public interface UserService {

    Optional<User> findById(Long id);
    
    List<User> getAll();

}
