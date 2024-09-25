package com.hackathon.hk_campusland_backend.telefonos_usuarios.domain.services;

import java.util.List;
import java.util.Optional;

import com.hackathon.hk_campusland_backend.telefonos_usuarios.domain.entity.TelefonoUsuario;

public interface TelefonoUsuarioService {

    Optional<TelefonoUsuario> findById(Long id);

    List<TelefonoUsuario> getAll();
    
    TelefonoUsuario save(TelefonoUsuario telefonoUsuarioe);
}
