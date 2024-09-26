package com.hackathon.hk_campusland_backend.historial_tareas.infrastructure.controllers;

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

import com.hackathon.hk_campusland_backend.historial_tareas.domain.entity.HistorialTarea;
import com.hackathon.hk_campusland_backend.historial_tareas.domain.services.HistorialTareaService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/historial-tarea")
public class HistorialTareaController {

    @Autowired
    private HistorialTareaService historialTareaService;

    @GetMapping
    public ResponseEntity<List<HistorialTarea>> listHistorialTareas() {
        List<HistorialTarea> HistorialTareaes = historialTareaService.getAll();
        return new ResponseEntity<>(HistorialTareaes, HttpStatus.OK);
    } 

    @GetMapping("/{id}")
    public ResponseEntity<HistorialTarea> showHistorialTarea(@PathVariable Long id){
        return historialTareaService.findById(id)
            .map(historialTarea -> new ResponseEntity<>(historialTarea, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<HistorialTarea> saveHistorialTarea(@Valid @RequestBody HistorialTarea historialTarea) {
        HistorialTarea newHistorialTarea = historialTareaService.save(historialTarea);
        return new ResponseEntity<>(newHistorialTarea, HttpStatus.CREATED);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Integer> getHorasTrabajadasByUsuarioId(@PathVariable Long id) {
        Integer horas = historialTareaService.horasTrabajadasByUsuarioId(id);
        return ResponseEntity.ok(horas);
    }

    @GetMapping("/tarea/{id}")
    public ResponseEntity<Integer> findHorasByTareaId(@PathVariable Long id){
        Integer horas = historialTareaService.findHorasByTareaId(id);
        return ResponseEntity.ok(horas);
    }
}
