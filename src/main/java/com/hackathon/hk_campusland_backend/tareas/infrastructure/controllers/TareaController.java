package com.hackathon.hk_campusland_backend.tareas.infrastructure.controllers;

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

import com.hackathon.hk_campusland_backend.tareas.domain.entity.Tarea;
import com.hackathon.hk_campusland_backend.tareas.domain.services.TareaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tarea")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @GetMapping
    public ResponseEntity<List<Tarea>> listTareaes() {
        List<Tarea> tareas = tareaService.getAll();
        return new ResponseEntity<>(tareas, HttpStatus.OK);
    } 

    @GetMapping("/{id}")
    public ResponseEntity<Tarea> showTarea(@PathVariable Long id){
        return tareaService.findById(id)
            .map(tarea -> new ResponseEntity<>(tarea, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Tarea> saveTarea(@Valid @RequestBody Tarea tarea) {
        Tarea newTarea = tareaService.save(tarea);
        return new ResponseEntity<>(newTarea, HttpStatus.CREATED);
    }
}
