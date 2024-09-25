package com.hackathon.hk_campusland_backend.cargos.domain.services;

import java.util.List;
import java.util.Optional;

import com.hackathon.hk_campusland_backend.cargos.domain.entity.Cargo;

public interface CargoService {

    Optional<Cargo> findById(Long id);

    List<Cargo> getAll();
    
    Cargo save(Cargo cargo);
}
