package com.hackathon.hk_campusland_backend.auth.infrastructure.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hackathon.hk_campusland_backend.auth.application.services.UserService;
import com.hackathon.hk_campusland_backend.auth.domain.models.User;
import com.hackathon.hk_campusland_backend.auth.exception.dto.BusinessException;
import com.hackathon.hk_campusland_backend.auth.infrastructure.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserAdapter implements UserService{

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
    public List<User> getAll() {
        List<User> users = userRepository.findAll();

        if (users.isEmpty()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND,"No hay usuarios registrados");
        }

        return userRepository.findAll();
    }

}
