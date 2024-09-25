package com.hackathon.hk_campusland_backend.comentarios_tareas.infrastructure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.hk_campusland_backend.comentarios_tareas.domain.entity.ComentarioTarea;
import com.hackathon.hk_campusland_backend.comentarios_tareas.domain.services.ComentarioTareaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comentario-tarea")
public class ComentarioTareaController {

    @Autowired
    private ComentarioTareaService comentarioTareaService;

    @GetMapping
    public ResponseEntity<List<ComentarioTarea>> listComentarioTareaes() {
        List<ComentarioTarea> comentarioTareas = comentarioTareaService.getAll();
        return new ResponseEntity<>(comentarioTareas, HttpStatus.OK);
    } 

    @GetMapping("/{id}")
    public ResponseEntity<ComentarioTarea> showComentarioTarea(@PathVariable Long id){
        return comentarioTareaService.findById(id)
            .map(comentarioTarea -> new ResponseEntity<>(comentarioTarea, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ComentarioTarea> saveComentarioTarea(@Valid @RequestBody ComentarioTarea comentarioTarea) {
        ComentarioTarea newComentarioTarea = comentarioTareaService.save(comentarioTarea);
        return new ResponseEntity<>(newComentarioTarea, HttpStatus.CREATED);
    }
}
