package com.hackathon.hk_campusland_backend.tipo_direccion.infrastructure.controllers;

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

import com.hackathon.hk_campusland_backend.tipo_direccion.domain.entity.TipoDireccion;
import com.hackathon.hk_campusland_backend.tipo_direccion.domain.services.TipoDireccionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tipodireccion")
public class TipoDireccionController {

    @Autowired
    private TipoDireccionService tipoDireccionService;

    @GetMapping
    public ResponseEntity<List<TipoDireccion>> listTipoDirecciones() {
        List<TipoDireccion> tipoDirecciones = tipoDireccionService.getAll();
        return new ResponseEntity<>(tipoDirecciones, HttpStatus.OK);
    } 

    @GetMapping("/{id}")
    public ResponseEntity<TipoDireccion> showTipoDireccion(@PathVariable Long id){
        return tipoDireccionService.findById(id)
            .map(TipoDireccion -> new ResponseEntity<>(TipoDireccion, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<TipoDireccion> saveTipoDireccion(@Valid @RequestBody TipoDireccion tipoDireccion) {
        TipoDireccion newTipoDireccion = tipoDireccionService.save(tipoDireccion);
        return new ResponseEntity<>(newTipoDireccion, HttpStatus.CREATED);
    }
}
