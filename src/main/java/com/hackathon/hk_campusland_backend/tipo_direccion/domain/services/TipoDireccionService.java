package com.hackathon.hk_campusland_backend.tipo_direccion.domain.services;

import java.util.List;
import java.util.Optional;

import com.hackathon.hk_campusland_backend.tipo_direccion.domain.entity.TipoDireccion;

public interface TipoDireccionService {

    Optional<TipoDireccion> findById(Long id);

    List<TipoDireccion> getAll();
    
    TipoDireccion save(TipoDireccion tipoDireccion);
}
