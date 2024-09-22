package com.hackathon.hk_campusland_backend.comentarios_tareas.infrastructure.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hk_campusland_backend.comentarios_tareas.domain.entity.ComentariosTarea;

@Repository
public interface ComentariosTareaRepository extends JpaRepository<ComentariosTarea, UUID> {

}
