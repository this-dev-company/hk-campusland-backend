package com.hackathon.hk_campusland_backend.auth.application.services;

import java.util.List;
import java.util.Optional;

import com.hackathon.hk_campusland_backend.auth.domain.models.Rol;

public interface RoleService {

    Optional<Rol> findById(String id);

    List<Rol> getAll();
    
    Rol save(Rol role);
}
