package com.hackathon.hk_campusland_backend.generos.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hk_campusland_backend.generos.domain.entity.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {
    
    Optional<Genero> findGeneroById(Long id);

    Optional<Genero> findGeneroByNombre(String nombre);

}
