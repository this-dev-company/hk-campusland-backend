package com.hackathon.hk_campusland_backend.comentarios_tareas.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hackathon.hk_campusland_backend.comentarios_tareas.domain.entity.ComentarioTarea;
import com.hackathon.hk_campusland_backend.comentarios_tareas.domain.services.ComentarioTareaService;
import com.hackathon.hk_campusland_backend.comentarios_tareas.infrastructure.repositories.ComentarioTareaRepository;
import com.hackathon.hk_campusland_backend.utils.exception.dto.BusinessException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComentarioTareaServiceImpl implements ComentarioTareaService {

    @Autowired
    private ComentarioTareaRepository comentarioTareaRepository;

    @Override
    public Optional<ComentarioTarea> findById(Long id) {

        if (!comentarioTareaRepository.findById(id).isPresent()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "El comentario de la tarea no existe");
        }

        return comentarioTareaRepository.findById(id);
    }

    @Override
    public List<ComentarioTarea> getAll() {
        List<ComentarioTarea> comentarioTareaes = comentarioTareaRepository.findAll();

        if (comentarioTareaes.isEmpty()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "No hay Comentarios registrados");
        }

        return comentarioTareaRepository.findAll();
    }

    @Override
    public ComentarioTarea save(ComentarioTarea comentarioTarea) {
        return comentarioTareaRepository.save(comentarioTarea);
    }
}
