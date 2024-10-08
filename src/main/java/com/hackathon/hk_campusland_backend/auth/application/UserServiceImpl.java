package com.hackathon.hk_campusland_backend.auth.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hackathon.hk_campusland_backend.auth.domain.entity.User;
import com.hackathon.hk_campusland_backend.auth.domain.services.UserService;
import com.hackathon.hk_campusland_backend.auth.infrastructure.repositories.UserRepository;
import com.hackathon.hk_campusland_backend.utils.exception.dto.BusinessException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findById(Long id) {

        if (!userRepository.findById(id).isPresent()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "El usuario no existe");
        }

        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {

        if (!userRepository.findByUsername(username).isPresent()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "El usuario no existe");
        }

        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getAll() {
        List<User> users = userRepository.findAll();

        if (users.isEmpty()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND,"No hay usuarios registrados");
        }

        return userRepository.findAll();
    }

}
