package com.hackathon.hk_campusland_backend.direccion_usuarios.domain.services;

import java.util.List;
import java.util.Optional;

import com.hackathon.hk_campusland_backend.direccion_usuarios.domain.entity.DireccionUsuario;

public interface DireccionUsuarioService {

    Optional<DireccionUsuario> findById(Long id);

    List<DireccionUsuario> getAll();
    
    DireccionUsuario save(DireccionUsuario direccionUsuario);
}
