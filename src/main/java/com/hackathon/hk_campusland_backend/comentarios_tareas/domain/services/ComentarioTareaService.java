package com.hackathon.hk_campusland_backend.comentarios_tareas.domain.services;

import java.util.List;
import java.util.Optional;

import com.hackathon.hk_campusland_backend.comentarios_tareas.domain.entity.ComentarioTarea;

public interface ComentarioTareaService {

    Optional<ComentarioTarea> findById(Long id);

    List<ComentarioTarea> getAll();
    
    ComentarioTarea save(ComentarioTarea comentarioTarea);
}
