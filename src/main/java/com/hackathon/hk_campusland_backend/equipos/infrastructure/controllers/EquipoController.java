package com.hackathon.hk_campusland_backend.equipos.infrastructure.controllers;

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

import com.hackathon.hk_campusland_backend.equipos.domain.entity.Equipo;
import com.hackathon.hk_campusland_backend.equipos.domain.services.EquipoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/equipo")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    @GetMapping
    public ResponseEntity<List<Equipo>> listEquipoes() {
        List<Equipo> equipos = equipoService.getAll();
        return new ResponseEntity<>(equipos, HttpStatus.OK);
    } 

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> showEquipo(@PathVariable Long id){
        return equipoService.findById(id)
            .map(equipo -> new ResponseEntity<>(equipo, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Equipo> saveEquipo(@Valid @RequestBody Equipo equipo) {
        Equipo newEquipo = equipoService.save(equipo);
        return new ResponseEntity<>(newEquipo, HttpStatus.CREATED);
    }
}
