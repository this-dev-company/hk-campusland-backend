package com.hackathon.hk_campusland_backend.ciudades.domain.services;

import java.util.List;
import java.util.Optional;

import com.hackathon.hk_campusland_backend.ciudades.domain.entity.Ciudad;


public interface CiudadService {

    Optional<Ciudad> findById(Long id);

    List<Ciudad> getAll();
    
    Ciudad save(Ciudad ciudad);
}
