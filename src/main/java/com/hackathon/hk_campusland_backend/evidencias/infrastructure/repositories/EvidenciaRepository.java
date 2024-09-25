package com.hackathon.hk_campusland_backend.evidencias.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hk_campusland_backend.evidencias.domain.entity.Evidencia;

@Repository
public interface EvidenciaRepository extends JpaRepository<Evidencia, Long> {

}
