package com.hackathon.hk_campusland_backend.auth.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackathon.hk_campusland_backend.auth.domain.models.Rol;

public interface RoleRepository extends JpaRepository<Rol, String> {
    Optional<Rol> findByRol(String rol); 
}
