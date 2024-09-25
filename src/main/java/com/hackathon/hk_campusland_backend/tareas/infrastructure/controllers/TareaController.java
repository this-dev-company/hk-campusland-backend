package com.hackathon.hk_campusland_backend.tareas.infrastructure.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseEntity<Tarea> showTarea(@PathVariable Long id) {
        return tareaService.findById(id)
                .map(tarea -> new ResponseEntity<>(tarea, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Tarea> saveTarea(@Valid @RequestBody Tarea tarea) {
        Tarea newTarea = tareaService.save(tarea);
        return new ResponseEntity<>(newTarea, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTarea(@PathVariable Long id) {
        try {
            Optional<Tarea> tarea = tareaService.getAll().stream().filter(s -> s.getId().equals(id)).findFirst();
            if (tarea.isPresent()) {
                tareaService.delete(tarea.get());
                return ResponseEntity.ok("Tarea deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarea not found with id: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting Tarea: " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTarea(@PathVariable Long id, @Valid @RequestBody Tarea updatedTarea,
            BindingResult result) {
        try {
            Optional<Tarea> existingTareaOptional = tareaService.findById(id);
            if (existingTareaOptional.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarea not found with id: " + id);
            }

            tareaService.update(id, updatedTarea);
            return ResponseEntity.ok("Tarea updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error updating Tarea: " + e.getMessage());
        }
    }

}
