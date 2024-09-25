package com.hackathon.hk_campusland_backend.direccion_organizacion.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hk_campusland_backend.direccion_organizacion.domain.entity.DireccionOrganizacion;

@Repository
public interface DireccionOrganizacionRepository extends JpaRepository<DireccionOrganizacion, Long> {
    Optional<DireccionOrganizacion> findByDireccion(String direccion); 
}
