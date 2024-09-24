package com.hackathon.hk_campusland_backend.generos.infrastructure.controllers;

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

import com.hackathon.hk_campusland_backend.generos.domain.entity.Genero;
import com.hackathon.hk_campusland_backend.generos.domain.services.GeneroService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/genero")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @GetMapping
    public ResponseEntity<List<Genero>> listGeneroes() {
        List<Genero> generos = generoService.getAll();
        return new ResponseEntity<>(generos, HttpStatus.OK);
    } 

    @GetMapping("/{id}")
    public ResponseEntity<Genero> showGenero(@PathVariable Long id){
        return generoService.findById(id)
            .map(genero -> new ResponseEntity<>(genero, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Genero> saveGenero(@Valid @RequestBody Genero genero) {
        Genero newGenero = generoService.save(genero);
        return new ResponseEntity<>(newGenero, HttpStatus.CREATED);
    }
}
