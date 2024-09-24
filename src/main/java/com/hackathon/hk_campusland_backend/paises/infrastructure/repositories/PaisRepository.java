package com.hackathon.hk_campusland_backend.paises.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hk_campusland_backend.paises.domain.entity.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long>{
    Optional<Pais> findPaisByNombre(String nombre);
}
