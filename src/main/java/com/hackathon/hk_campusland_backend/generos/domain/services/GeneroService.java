package com.hackathon.hk_campusland_backend.generos.domain.services;

import java.util.List;
import java.util.Optional;

import com.hackathon.hk_campusland_backend.generos.domain.entity.Genero;

public interface GeneroService {

    Optional<Genero> findById(Long id);

    List<Genero> getAll();
    
    Genero save(Genero role);
}
