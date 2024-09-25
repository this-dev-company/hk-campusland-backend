package com.hackathon.hk_campusland_backend.evidencias.infrastructure.controllers;

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

import com.hackathon.hk_campusland_backend.evidencias.domain.entity.Evidencia;
import com.hackathon.hk_campusland_backend.evidencias.domain.services.EvidenciaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/evidencia")
public class EvidenciaController {

     @Autowired
    private EvidenciaService evidenciaService;

    @GetMapping
    public ResponseEntity<List<Evidencia>> listEvidenciaes() {
        List<Evidencia> evidencias = evidenciaService.getAll();
        return new ResponseEntity<>(evidencias, HttpStatus.OK);
    } 

    @GetMapping("/{id}")
    public ResponseEntity<Evidencia> showEvidencia(@PathVariable Long id){
        return evidenciaService.findById(id)
            .map(evidencia -> new ResponseEntity<>(evidencia, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Evidencia> saveEvidencia(@Valid @RequestBody Evidencia evidencia) {
        Evidencia newEvidencia = evidenciaService.save(evidencia);
        return new ResponseEntity<>(newEvidencia, HttpStatus.CREATED);
    }
}
