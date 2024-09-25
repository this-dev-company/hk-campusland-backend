package com.hackathon.hk_campusland_backend.evidencias.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hackathon.hk_campusland_backend.evidencias.domain.entity.Evidencia;
import com.hackathon.hk_campusland_backend.evidencias.domain.services.EvidenciaService;
import com.hackathon.hk_campusland_backend.evidencias.infrastructure.repositories.EvidenciaRepository;
import com.hackathon.hk_campusland_backend.utils.exception.dto.BusinessException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EvidenciaServiceImpl implements EvidenciaService {

    @Autowired
    private EvidenciaRepository evidenciaRepository;

    @Override
    public Optional<Evidencia> findById(Long id) {

        if (!evidenciaRepository.findById(id).isPresent()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "La evidencia no existe");
        }

        return evidenciaRepository.findById(id);
    }

    @Override
    public List<Evidencia> getAll() {
        List<Evidencia> evidencias = evidenciaRepository.findAll();

        if (evidencias.isEmpty()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "No hay evidencias registradas");
        }

        return evidenciaRepository.findAll();
    }

    @Override
    public Evidencia save(Evidencia Evidencia) {
        return evidenciaRepository.save(Evidencia);
    }
}
