package com.hackathon.hk_campusland_backend.tipos_telefonos.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackathon.hk_campusland_backend.tipos_telefonos.domain.entity.TipoTelefono;

public interface TipoTelefonoRepository extends JpaRepository<TipoTelefono, Long> {
    Optional<TipoTelefono> findTipoTelefonoByTipo(String tipo); 
}
