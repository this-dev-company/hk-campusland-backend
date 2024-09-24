package com.hackathon.hk_campusland_backend.paises.domain.services;

import java.util.List;
import java.util.Optional;

import com.hackathon.hk_campusland_backend.paises.domain.entity.Pais;

public interface PaisService {

    Optional<Pais> findById(Long id);

    List<Pais> getAll();
    
    Pais save(Pais pais);
}
