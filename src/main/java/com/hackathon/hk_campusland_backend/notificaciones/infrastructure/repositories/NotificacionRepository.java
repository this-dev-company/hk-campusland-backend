package com.hackathon.hk_campusland_backend.notificaciones.infrastructure.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hk_campusland_backend.notificaciones.domain.entity.Notificacion;
import com.hackathon.hk_campusland_backend.notificaciones.domain.entity.NotificacionPK;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, NotificacionPK> {
    List<Notificacion> findTareasByUsuarioId(Long usuarioId);
}
