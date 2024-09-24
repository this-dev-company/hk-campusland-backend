package com.hackathon.hk_campusland_backend.tipos_telefonos.infrastructure.controllers;

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

import com.hackathon.hk_campusland_backend.tipos_telefonos.domain.entity.TipoTelefono;
import com.hackathon.hk_campusland_backend.tipos_telefonos.domain.services.TipoTelefonoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tipotelefono")
public class TipoTelefonoController {

    @Autowired
    private TipoTelefonoService tipoTelefonoService;

    @GetMapping
    public ResponseEntity<List<TipoTelefono>> listTipoTelefonoes() {
        List<TipoTelefono> tipoTelefonoes = tipoTelefonoService.getAll();
        return new ResponseEntity<>(tipoTelefonoes, HttpStatus.OK);
    } 

    @GetMapping("/{id}")
    public ResponseEntity<TipoTelefono> showTipoTelefono(@PathVariable Long id){
        return tipoTelefonoService.findById(id)
            .map(tipoTelefono -> new ResponseEntity<>(tipoTelefono, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<TipoTelefono> saveTipoTelefono(@Valid @RequestBody TipoTelefono tipoTelefono) {
        TipoTelefono newTipoTelefono = tipoTelefonoService.save(tipoTelefono);
        return new ResponseEntity<>(newTipoTelefono, HttpStatus.CREATED);
    }
}
