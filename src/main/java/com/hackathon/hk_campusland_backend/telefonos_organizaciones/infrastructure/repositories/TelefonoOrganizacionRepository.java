package com.hackathon.hk_campusland_backend.telefonos_organizaciones.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hk_campusland_backend.telefonos_organizaciones.domain.entity.TelefonoOrganizacion;

@Repository
public interface TelefonoOrganizacionRepository extends JpaRepository<TelefonoOrganizacion, Long> {
     Optional<TelefonoOrganizacion> findTelefonoOrganizacionByNumero(String numero); 
}

