package com.hackathon.hk_campusland_backend.equipos.domain.services;

import java.util.List;
import java.util.Optional;

import com.hackathon.hk_campusland_backend.equipos.domain.entity.Equipo;

public interface EquipoService {

    Optional<Equipo> findById(Long id);

    List<Equipo> getAll();
    
    Equipo save(Equipo equipo);
}
