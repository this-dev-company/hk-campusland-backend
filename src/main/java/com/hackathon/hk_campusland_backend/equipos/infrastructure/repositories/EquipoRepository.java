package com.hackathon.hk_campusland_backend.equipos.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hk_campusland_backend.equipos.domain.entity.Equipo;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {
    
}
