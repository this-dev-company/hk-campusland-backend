package com.hackathon.hk_campusland_backend.proyectos_usuarios.domain.service;

import java.util.List;
import java.util.Optional;

import com.hackathon.hk_campusland_backend.proyectos.domain.entity.Proyecto;
import com.hackathon.hk_campusland_backend.proyectos_usuarios.domain.entity.ProyectoUsuario;
import com.hackathon.hk_campusland_backend.proyectos_usuarios.domain.entity.ProyectoUsuarioPK;

public interface ProyectoUsuarioInterface {
    void save(ProyectoUsuario proyectoUsuario);
    void delete(ProyectoUsuario proyectoUsuario);
    void update(ProyectoUsuarioPK id, ProyectoUsuario proyectoUsuario);
    List<ProyectoUsuario>  findAll();
    Optional<ProyectoUsuario> findById(ProyectoUsuarioPK id);
    List<Proyecto> findProyectosByUsuarioId(Long id);
}
