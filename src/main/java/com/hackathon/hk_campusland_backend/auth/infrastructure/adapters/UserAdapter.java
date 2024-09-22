package com.hackathon.hk_campusland_backend.auth.infrastructure.adapters;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.hackathon.hk_campusland_backend.auth.application.services.UserService;
import com.hackathon.hk_campusland_backend.auth.domain.models.Rol;
import com.hackathon.hk_campusland_backend.auth.domain.models.User;
import com.hackathon.hk_campusland_backend.auth.domain.models.UserRole;
import com.hackathon.hk_campusland_backend.auth.infrastructure.repositories.RoleRepository;
import com.hackathon.hk_campusland_backend.auth.infrastructure.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserAdapter implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    @Transactional
    public User save(User user) {
        Optional<Rol> optionalRoleUser = roleRepository.findByRol("USER");
        List<UserRole> userRoles = new ArrayList<>();

        // Si se encuentra el rol "USER", crea un UserRole y lo agrega a la lista
        optionalRoleUser.ifPresent(role -> {
            UserRole userRole = UserRole.builder()
                .user(user)
                .rol(role)
                .build();
            userRoles.add(userRole);
        });

        // Si el usuario es administrador, agrega también el rol "ADMIN"
        if (user.isAdmin()) {
            Optional<Rol> optionalRoleAdmin = roleRepository.findByRol("ADMIN");
            optionalRoleAdmin.ifPresent(role -> {
                UserRole userRole = UserRole.builder()
                    .user(user)
                    .rol(role)
                    .build();
                userRoles.add(userRole);
            });
        }

        // Asigna la lista de UserRole al usuario
        user.setRoles(userRoles);

        // Codifica la contraseña
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Guarda el usuario con los roles asignados
        return userRepository.save(user);
    }


}
