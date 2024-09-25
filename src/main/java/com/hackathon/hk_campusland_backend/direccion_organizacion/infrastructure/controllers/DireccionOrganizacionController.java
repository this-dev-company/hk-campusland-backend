package com.hackathon.hk_campusland_backend.direccion_organizacion.infrastructure.controllers;

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

import com.hackathon.hk_campusland_backend.direccion_organizacion.domain.entity.DireccionOrganizacion;
import com.hackathon.hk_campusland_backend.direccion_organizacion.domain.services.DireccionOrganizacionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/direccion-organizacion")
public class DireccionOrganizacionController {

    @Autowired
    private DireccionOrganizacionService direccionOrganizacionService;

    @GetMapping
    public ResponseEntity<List<DireccionOrganizacion>> listDireccionOrganizaciones() {
        List<DireccionOrganizacion> direccionOrganizaciones = direccionOrganizacionService.getAll();
        return new ResponseEntity<>(direccionOrganizaciones, HttpStatus.OK);
    } 

    @GetMapping("/{id}")
    public ResponseEntity<DireccionOrganizacion> showDireccionOrganizacion(@PathVariable Long id){
        return direccionOrganizacionService.findById(id)
            .map(direccionOrganizacion -> new ResponseEntity<>(direccionOrganizacion, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<DireccionOrganizacion> saveDireccionOrganizacion(@Valid @RequestBody DireccionOrganizacion direccionOrganizacion) {
        DireccionOrganizacion newDireccionOrganizacion = direccionOrganizacionService.save(direccionOrganizacion);
        return new ResponseEntity<>(newDireccionOrganizacion, HttpStatus.CREATED);
    }
}
