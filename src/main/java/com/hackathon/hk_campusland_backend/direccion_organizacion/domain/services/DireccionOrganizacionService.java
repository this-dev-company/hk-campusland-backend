package com.hackathon.hk_campusland_backend.direccion_organizacion.domain.services;

import java.util.List;
import java.util.Optional;

import com.hackathon.hk_campusland_backend.direccion_organizacion.domain.entity.DireccionOrganizacion;

public interface DireccionOrganizacionService {

    Optional<DireccionOrganizacion> findById(Long id);

    List<DireccionOrganizacion> getAll();
    
    DireccionOrganizacion save(DireccionOrganizacion direccionOrganizacion);
}
