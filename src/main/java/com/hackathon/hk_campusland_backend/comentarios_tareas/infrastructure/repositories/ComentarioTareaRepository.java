package com.hackathon.hk_campusland_backend.comentarios_tareas.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hk_campusland_backend.comentarios_tareas.domain.entity.ComentarioTarea;

@Repository
public interface ComentarioTareaRepository extends JpaRepository<ComentarioTarea, Long> {

}
