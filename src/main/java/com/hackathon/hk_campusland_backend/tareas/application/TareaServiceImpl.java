package com.hackathon.hk_campusland_backend.tareas.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hackathon.hk_campusland_backend.tareas.domain.entity.Tarea;
import com.hackathon.hk_campusland_backend.tareas.domain.services.TareaService;
import com.hackathon.hk_campusland_backend.tareas.infrastructure.repositories.TareaRepository;
import com.hackathon.hk_campusland_backend.utils.exception.dto.BusinessException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TareaServiceImpl implements TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public Optional<Tarea> findById(Long id) {

        if (!tareaRepository.findById(id).isPresent()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "La Tarea no existe");
        }

        return tareaRepository.findById(id);
    }

    @Override
    public List<Tarea> getAll() {
        List<Tarea> Tareaes = tareaRepository.findAll();

        if (Tareaes.isEmpty()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "No hay Tareas registradas");
        }

        return tareaRepository.findAll();
    }

    @Override
    public Tarea save(Tarea Tarea) {
        return tareaRepository.save(Tarea);
    }
}
