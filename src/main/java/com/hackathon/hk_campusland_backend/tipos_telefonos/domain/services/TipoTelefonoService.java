package com.hackathon.hk_campusland_backend.tipos_telefonos.domain.services;

import java.util.List;
import java.util.Optional;

import com.hackathon.hk_campusland_backend.tipos_telefonos.domain.entity.TipoTelefono;

public interface TipoTelefonoService {

    Optional<TipoTelefono> findById(Long id);

    List<TipoTelefono> getAll();
    
    TipoTelefono save(TipoTelefono tipoTelefono);
}
