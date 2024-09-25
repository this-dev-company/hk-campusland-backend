package com.hackathon.hk_campusland_backend.notificaciones.infrastructure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.hk_campusland_backend.notificaciones.application.NotificacionServiceImpl;
import com.hackathon.hk_campusland_backend.notificaciones.domain.entity.Notificacion;
import com.hackathon.hk_campusland_backend.notificaciones.domain.entity.NotificacionPK;
import com.hackathon.hk_campusland_backend.tareas.domain.entity.Tarea;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/notificacion")
public class NotificacionController {

    @Autowired
    NotificacionServiceImpl notificacionServiceImpl;

    @GetMapping("/list-all")
    public List<Notificacion> listAllNotificacion() {
        return notificacionServiceImpl.findAll();
    }

    @GetMapping("/{tareaId}/{usuarioId}")
    public ResponseEntity<Notificacion> showNotificacion(
            @PathVariable Long usuarioId,
            @PathVariable Long tareaId) {
        NotificacionPK id = new NotificacionPK();
        id.setUsuario(usuarioId);
        id.setTarea(tareaId);
        return notificacionServiceImpl.findById(id)
                .map(notificacion -> new ResponseEntity<>(notificacion, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/find-tareas-of-user/{usuarioId}")
    public ResponseEntity<List<Tarea>> getTareasNotificaiconByUsuarioId(@PathVariable Long usuarioId) {
        List<Tarea> tareas = notificacionServiceImpl.findNotificacionTareaByUsuarioId(usuarioId);
        if (tareas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tareas, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createNotificacion(@Valid @RequestBody Notificacion notificacion,
            BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        notificacionServiceImpl.save(notificacion);
        return ResponseEntity.status(HttpStatus.CREATED).body("Notificacion created successfully");
    }
}
