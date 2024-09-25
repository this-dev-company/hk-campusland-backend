package com.hackathon.hk_campusland_backend.ciudades.infrastructure.controllers;

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

import com.hackathon.hk_campusland_backend.ciudades.domain.entity.Ciudad;
import com.hackathon.hk_campusland_backend.ciudades.domain.services.CiudadService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ciudad")
public class CiudadController {

    @Autowired
    private CiudadService ciudadService;

    @GetMapping
    public ResponseEntity<List<Ciudad>> listCiudades() {
        List<Ciudad> ciudades = ciudadService.getAll();
        return new ResponseEntity<>(ciudades, HttpStatus.OK);
    } 

    @GetMapping("/{id}")
    public ResponseEntity<Ciudad> showCiudad(@PathVariable Long id){
        return ciudadService.findById(id)
            .map(ciudad -> new ResponseEntity<>(ciudad, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Ciudad> saveCiudad(@Valid @RequestBody Ciudad ciudad) {
        Ciudad newCiudad = ciudadService.save(ciudad);
        return new ResponseEntity<>(newCiudad, HttpStatus.CREATED);
    }
}
