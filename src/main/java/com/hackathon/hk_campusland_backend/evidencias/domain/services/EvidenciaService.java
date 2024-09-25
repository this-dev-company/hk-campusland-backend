package com.hackathon.hk_campusland_backend.evidencias.domain.services;

import java.util.List;
import java.util.Optional;

import com.hackathon.hk_campusland_backend.evidencias.domain.entity.Evidencia;

public interface EvidenciaService {

    Optional<Evidencia> findById(Long id);

    List<Evidencia> getAll();
    
    Evidencia save(Evidencia evidencia);
}
