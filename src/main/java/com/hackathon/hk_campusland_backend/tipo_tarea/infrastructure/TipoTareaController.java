package com.hackathon.hk_campusland_backend.tipo_tarea.infrastructure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.hackathon.hk_campusland_backend.tipo_tarea.application.TipoTareaServiceImpl;
import com.hackathon.hk_campusland_backend.tipo_tarea.domain.entity.TipoTarea;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tipoTarea")
public class TipoTareaController {

    @Autowired
    TipoTareaServiceImpl tipoTareaServiceImpl;

    @Autowired
    TipoTareaRepository tipoTareaRepository;

    @GetMapping("/list-all")
    public List<TipoTarea> listAllTipoTarea() {
        return tipoTareaServiceImpl.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoTarea> showTipoTarea(@PathVariable Long id) {
        return tipoTareaServiceImpl.findById(id)
                .map(tipoTarea -> new ResponseEntity<>(tipoTarea, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTipoTarea(@Valid @RequestBody TipoTarea tipoTarea, BindingResult result) {
        if (result.hasErrors()) {
            return validation(result);
        }
        tipoTareaServiceImpl.save(tipoTarea);
        return ResponseEntity.status(HttpStatus.CREATED).body("TipoTarea created successfully");
    }

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "The field " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }

}
