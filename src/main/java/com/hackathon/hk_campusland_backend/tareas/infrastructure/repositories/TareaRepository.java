package com.hackathon.hk_campusland_backend.tareas.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hk_campusland_backend.tareas.domain.entity.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
    Optional<Tarea> findByProyectoId(Long proyecto);
}
