package com.hackathon.hk_campusland_backend.notificaciones.domain.services;

import java.util.List;
import java.util.Optional;

import com.hackathon.hk_campusland_backend.notificaciones.domain.entity.Notificacion;
import com.hackathon.hk_campusland_backend.notificaciones.domain.entity.NotificacionPK;
import com.hackathon.hk_campusland_backend.tareas.domain.entity.Tarea;

public interface NotificacionService {

    void save(Notificacion notificacion);
    void delete(Notificacion notificacion);
    void update(NotificacionPK id, Notificacion notificacion);
    List<Notificacion>  findAll();
    Optional<Notificacion> findById(NotificacionPK id);
    List<Tarea> findNotificacionTareaByUsuarioId(Long id);
}   
