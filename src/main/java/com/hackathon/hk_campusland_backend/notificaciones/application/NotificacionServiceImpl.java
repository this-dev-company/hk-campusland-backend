package com.hackathon.hk_campusland_backend.notificaciones.application;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.hk_campusland_backend.notificaciones.domain.entity.Notificacion;
import com.hackathon.hk_campusland_backend.notificaciones.domain.entity.NotificacionPK;
import com.hackathon.hk_campusland_backend.notificaciones.domain.services.NotificacionService;
import com.hackathon.hk_campusland_backend.notificaciones.infrastructure.repositories.NotificacionRepository;
import com.hackathon.hk_campusland_backend.tareas.domain.entity.Tarea;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificacionServiceImpl implements NotificacionService{

    @Autowired
    NotificacionRepository notificacionRepository;

    @Override
    @Transactional
    public void save(Notificacion Notificacion) {
        notificacionRepository.save(Notificacion);
    }

    @Override
    @Transactional
    public void delete(Notificacion Notificacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    @Transactional
    public void update(NotificacionPK id, Notificacion Notificacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    @Transactional
    public List<Notificacion> findAll() {
        return notificacionRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Notificacion> findById(NotificacionPK id) {
        return notificacionRepository.findById(id);
    }

    @Override
    @Transactional
    public List<Tarea> findNotificacionTareaByUsuarioId(Long id) {
        return notificacionRepository.findTareasByUsuarioId(id)
                .stream()
                .map(notificacion -> notificacion.getTarea())
                .collect(Collectors.toList());
    }
}
