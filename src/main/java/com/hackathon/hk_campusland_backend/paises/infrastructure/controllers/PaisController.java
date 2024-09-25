package com.hackathon.hk_campusland_backend.paises.infrastructure.controllers;

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

import com.hackathon.hk_campusland_backend.paises.domain.entity.Pais;
import com.hackathon.hk_campusland_backend.paises.domain.services.PaisService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pais")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping
    public ResponseEntity<List<Pais>> listPaises() {
        List<Pais> paises = paisService.getAll();
        return new ResponseEntity<>(paises, HttpStatus.OK);
    } 

    @GetMapping("/{id}")
    public ResponseEntity<Pais> showPais(@PathVariable Long id){
        return paisService.findById(id)
            .map(rol -> new ResponseEntity<>(rol, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Pais> savePais(@Valid @RequestBody Pais pais) {
        Pais newPais = paisService.save(pais);
        return new ResponseEntity<>(newPais, HttpStatus.CREATED);
    }
}
