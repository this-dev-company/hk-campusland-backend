package com.hackathon.hk_campusland_backend.tipo_direccion.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hk_campusland_backend.tipo_direccion.domain.entity.TipoDireccion;

@Repository
public interface TipoDireccionRepository extends JpaRepository<TipoDireccion, Long>{
    Optional<TipoDireccion> findTipoDireccionByTipo(String tipo); 
}
