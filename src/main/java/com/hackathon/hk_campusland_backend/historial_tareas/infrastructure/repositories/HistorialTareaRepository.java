package com.hackathon.hk_campusland_backend.historial_tareas.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hk_campusland_backend.historial_tareas.domain.entity.HistorialTarea;

@Repository
public interface HistorialTareaRepository extends JpaRepository<HistorialTarea, Long> {

}
