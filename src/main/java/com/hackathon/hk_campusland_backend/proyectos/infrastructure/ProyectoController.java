package com.hackathon.hk_campusland_backend.proyectos.infrastructure;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

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

import com.hackathon.hk_campusland_backend.proyectos.application.ProyectoServiceImpl;
import com.hackathon.hk_campusland_backend.proyectos.domain.entity.Proyecto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/proyecto")
public class ProyectoController {
@Autowired
    ProyectoServiceImpl proyectoServiceImpl;

    @Autowired
    ProyectoRepository proyectoRepository;

    @GetMapping("/list-all")
    public List<Proyecto> listAllProyecto() {
        return proyectoServiceImpl.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proyecto> showProyecto(@PathVariable Long id) {
        return proyectoServiceImpl.findById(id)
                .map(proyecto -> new ResponseEntity<>(proyecto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProyecto(@Valid @RequestBody Proyecto proyecto, BindingResult result) {
        // if (result.hasErrors()) {
        //     return validation(result);
        // }
        proyectoServiceImpl.save(proyecto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Proyecto created successfully");
    }

    // private ResponseEntity<?> validation(BindingResult result) {
    //     Map<String, String> errors = new HashMap<>();
    //     result.getFieldErrors().forEach(err -> {
    //         errors.put(err.getField(), "The field " + err.getField() + " " + err.getDefaultMessage());
    //     });
    //     return ResponseEntity.badRequest().body(errors);
    // }
}
