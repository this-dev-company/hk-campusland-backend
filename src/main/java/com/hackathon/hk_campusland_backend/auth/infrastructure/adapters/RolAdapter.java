package com.hackathon.hk_campusland_backend.auth.infrastructure.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.hk_campusland_backend.auth.application.services.RoleService;
import com.hackathon.hk_campusland_backend.auth.domain.models.Rol;
import com.hackathon.hk_campusland_backend.auth.infrastructure.repositories.RoleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RolAdapter implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Optional<Rol> findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public List<Rol> getAll(){
        return roleRepository.findAll();
    }

    @Override
    public Rol save(Rol role) {
        return roleRepository.save(role);
    }
}
