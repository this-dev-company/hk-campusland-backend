package com.hackathon.hk_campusland_backend.organizaciones.domain.service;

import java.util.List;
import java.util.Optional;

import com.hackathon.hk_campusland_backend.auth.domain.entity.User;
import com.hackathon.hk_campusland_backend.organizaciones.domain.entity.Organizacion;

public interface OrganizacionInterface {
    void save(Organizacion organizacion);
    void delete(Organizacion organizacion);
    void update(Long id, Organizacion organizacion);
    List<Organizacion>  findAll();
    Optional<Organizacion> findById(Long id);

    Optional<Organizacion> findOrganizacionByAlias(String alias);
    List<Organizacion> findByUsuarioCreadorId(User usuario_creador_id);
}
