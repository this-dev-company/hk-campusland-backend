package com.hackathon.hk_campusland_backend.tareas.domain.services;

import java.util.List;
import java.util.Optional;

import com.hackathon.hk_campusland_backend.tareas.domain.entity.Tarea;

public interface TareaService {

    Optional<Tarea> findById(Long id);

    void delete(Tarea tarea);

    void update(Long id, Tarea tarea);

    List<Tarea> getAll();
    
    Tarea save(Tarea tarea);

    Optional<Tarea> findTareasByProyecto(Long proyecto);
}
