package com.hackathon.hk_campusland_backend.organizacion_usuarios.domain.services;

import java.util.List;
import java.util.Optional;

import com.hackathon.hk_campusland_backend.organizacion_usuarios.domain.entity.OrganizacionUsuario;
import com.hackathon.hk_campusland_backend.organizacion_usuarios.domain.entity.OrganizacionUsuarioPK;
import com.hackathon.hk_campusland_backend.organizaciones.domain.entity.Organizacion;

public interface OrganizacionUsuarioService {

    void save(OrganizacionUsuario organizacionUsuario);
    void delete(OrganizacionUsuario organizacionUsuario);
    void update(OrganizacionUsuarioPK id, OrganizacionUsuario organizacionUsuario);
    List<OrganizacionUsuario>  findAll();
    Optional<OrganizacionUsuario> findById(OrganizacionUsuarioPK id);
    List<Organizacion> findOrganizacionesByUsuarioId(Long id);
}
