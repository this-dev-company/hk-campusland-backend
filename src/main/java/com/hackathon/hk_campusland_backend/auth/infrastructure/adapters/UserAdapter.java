package com.hackathon.hk_campusland_backend.auth.infrastructure.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.hackathon.hk_campusland_backend.auth.application.services.UserService;
import com.hackathon.hk_campusland_backend.auth.domain.models.User;
import com.hackathon.hk_campusland_backend.auth.infrastructure.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserAdapter implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

}
