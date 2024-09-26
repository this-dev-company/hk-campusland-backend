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

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TareaServiceImpl implements TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    @Override
    @Transactional
    public Optional<Tarea> findById(Long id) {

        if (!tareaRepository.findById(id).isPresent()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "La Tarea no existe");
        }

        return tareaRepository.findById(id);
    }

    @Override
    @Transactional
    public List<Tarea> getAll() {
        List<Tarea> Tareaes = tareaRepository.findAll();

        if (Tareaes.isEmpty()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "No hay Tareas registradas");
        }

        return tareaRepository.findAll();
    }

    @Override
    @Transactional
    public Tarea save(Tarea Tarea) {
        return tareaRepository.save(Tarea);
    }

    @Override
    @Transactional
    public void delete(Tarea tarea) {
        tareaRepository.delete(tarea);
    }

    @Override
    @Transactional
    public void update(Long id, Tarea tarea) {
        Optional<Tarea> existingTareaOpt = tareaRepository.findById(id);

        if (existingTareaOpt.isPresent()) {
            Tarea existingTarea = existingTareaOpt.get();

            existingTarea.setNombre(tarea.getNombre());
            existingTarea.setDescripcion(tarea.getDescripcion());
            existingTarea.setStartAt(tarea.getStartAt());
            existingTarea.setEndAt(tarea.getEndAt());
            existingTarea.setHorasEstimadas(tarea.getHorasEstimadas());
            existingTarea.setProyecto(tarea.getProyecto());
            existingTarea.setTipoTarea(tarea.getTipoTarea());
            existingTarea.setEstadoTarea(tarea.getEstadoTarea());

            tareaRepository.save(existingTarea);
        } else {
            throw new EntityNotFoundException("Tarea not found with id: " + id);
        }
    }

    @Override
    public List<Tarea> findTareasByProyecto(Long proyecto) {
        return tareaRepository.findByProyectoId(proyecto);
    }

    @Override
    public List<Tarea> findTareaByUser(long userId) {
        return tareaRepository.findTareasByUsuarioId(userId);
    }
}
