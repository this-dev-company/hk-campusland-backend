package com.hackathon.hk_campusland_backend.tareas.infrastructure.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hackathon.hk_campusland_backend.tareas.domain.entity.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
    List<Tarea> findByProyectoId(Long proyecto);

    @Query("SELECT t " +
       "FROM Notificacion n " +
       "JOIN Tarea t ON t.id = n.id.tarea " +
       "WHERE n.usuario.id = :usuarioId")
    List<Tarea> findTareasByUsuarioId(@Param("usuarioId") Long usuarioId);
}
