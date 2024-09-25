package com.hackathon.hk_campusland_backend.auth.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hackathon.hk_campusland_backend.auth.domain.entity.Rol;
import com.hackathon.hk_campusland_backend.auth.domain.services.RoleService;
import com.hackathon.hk_campusland_backend.auth.infrastructure.repositories.RoleRepository;
import com.hackathon.hk_campusland_backend.utils.exception.dto.BusinessException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RolServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Optional<Rol> findById(Long id) {

        if (!roleRepository.findById(id).isPresent()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "El Rol no existe");
        }

        return roleRepository.findById(id);
    }

    @Override
    public List<Rol> getAll() {
        List<Rol> roles = roleRepository.findAll();

        if (roles.isEmpty()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "No hay Roles registrados");
        }

        return roleRepository.findAll();
    }

    @Override
    public Rol save(Rol rol) {

        Optional<Rol> existingRol = roleRepository.findByRol(rol.getRol());

        if (existingRol.isPresent()) {
            throw new BusinessException("P-300", HttpStatus.CONFLICT, "El Rol con ese nombre ya existe");
        }

        return roleRepository.save(rol);
    }
}
