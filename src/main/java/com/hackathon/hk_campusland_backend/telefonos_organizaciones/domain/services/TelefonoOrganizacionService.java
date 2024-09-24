package com.hackathon.hk_campusland_backend.telefonos_organizaciones.domain.services;

import java.util.List;
import java.util.Optional;

import com.hackathon.hk_campusland_backend.telefonos_organizaciones.domain.entity.TelefonoOrganizacion;

public interface TelefonoOrganizacionService {

    Optional<TelefonoOrganizacion> findById(Long id);

    List<TelefonoOrganizacion> getAll();
    
    TelefonoOrganizacion save(TelefonoOrganizacion telefonoOrganizacion);
}
