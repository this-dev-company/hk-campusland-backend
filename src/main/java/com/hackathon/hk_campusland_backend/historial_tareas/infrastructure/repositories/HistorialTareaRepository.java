package com.hackathon.hk_campusland_backend.historial_tareas.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hackathon.hk_campusland_backend.historial_tareas.domain.entity.HistorialTarea;

@Repository
public interface HistorialTareaRepository extends JpaRepository<HistorialTarea, Long> {

    @Query(value = "SELECT SUM(ht.horas) " +
               "FROM usuarios u " +
               "JOIN notificaciones noti ON noti.usuario_id = u.id " +
               "JOIN tareas tar ON tar.id = noti.tarea_id " +
               "JOIN historial_tareas ht ON ht.tarea_id = tar.id " +
               "WHERE u.id = :usuarioId", 
            nativeQuery = true)
    Integer findHorasByUsuarioId(@Param("usuarioId") Long usuarioId);

    
    @Query(
        value = "SELECT SUM(ht.horas) FROM historial_tareas ht WHERE ht.tarea_id = :tareaId",
        nativeQuery = true
        )
    Integer sumHorasByTareaId(@Param("tareaId") Long tareaId);
}
