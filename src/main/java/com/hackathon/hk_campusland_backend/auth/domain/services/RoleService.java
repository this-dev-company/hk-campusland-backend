package com.hackathon.hk_campusland_backend.auth.domain.services;

import java.util.List;
import java.util.Optional;

import com.hackathon.hk_campusland_backend.auth.domain.entity.Rol;

public interface RoleService {

    Optional<Rol> findById(Long id);

    List<Rol> getAll();
    
    Rol save(Rol role);
}
