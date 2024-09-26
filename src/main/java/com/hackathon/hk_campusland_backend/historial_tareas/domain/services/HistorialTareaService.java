package com.hackathon.hk_campusland_backend.historial_tareas.domain.services;

import java.util.List;
import java.util.Optional;

import com.hackathon.hk_campusland_backend.historial_tareas.domain.entity.HistorialTarea;

public interface HistorialTareaService {

    Optional<HistorialTarea> findById(Long id);

    List<HistorialTarea> getAll();
    
    HistorialTarea save(HistorialTarea historialTarea);

    Integer horasTrabajadasByUsuarioId(Long usuarioId);

    Integer findHorasByTareaId(Long tareaId);
}
