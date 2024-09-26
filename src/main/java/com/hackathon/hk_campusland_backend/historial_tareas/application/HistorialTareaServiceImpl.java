package com.hackathon.hk_campusland_backend.historial_tareas.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hackathon.hk_campusland_backend.historial_tareas.domain.entity.HistorialTarea;
import com.hackathon.hk_campusland_backend.historial_tareas.domain.services.HistorialTareaService;
import com.hackathon.hk_campusland_backend.historial_tareas.infrastructure.repositories.HistorialTareaRepository;
import com.hackathon.hk_campusland_backend.utils.exception.dto.BusinessException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HistorialTareaServiceImpl implements HistorialTareaService {

    @Autowired
    private HistorialTareaRepository historialTareaRepository;
    
    @Override
    public Optional<HistorialTarea> findById(Long id) {

        if (!historialTareaRepository.findById(id).isPresent()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "El historial de tarea no existe");
        }

        return historialTareaRepository.findById(id);
    }

    @Override
    public List<HistorialTarea> getAll() {
        List<HistorialTarea> historialTareas = historialTareaRepository.findAll();

        if (historialTareas.isEmpty()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "No hay historial de tareas registrados");
        }

        return historialTareaRepository.findAll();
    }

    @Override
    public HistorialTarea save(HistorialTarea historialTarea) {
        return historialTareaRepository.save(historialTarea);
    }

    @Override
    public Integer horasTrabajadasByUsuarioId(Long usuarioId) {
        return historialTareaRepository.findHorasByUsuarioId(usuarioId);
    }

    @Override
    public Integer findHorasByTareaId(Long tareaId) {
        return historialTareaRepository.sumHorasByTareaId(tareaId);
    }
}
