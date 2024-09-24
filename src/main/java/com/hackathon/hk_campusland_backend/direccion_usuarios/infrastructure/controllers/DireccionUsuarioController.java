package com.hackathon.hk_campusland_backend.direccion_usuarios.infrastructure.controllers;

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

import com.hackathon.hk_campusland_backend.direccion_usuarios.domain.entity.DireccionUsuario;
import com.hackathon.hk_campusland_backend.direccion_usuarios.domain.services.DireccionUsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/direccionusuario")
public class DireccionUsuarioController {

    @Autowired
    private DireccionUsuarioService direccionUsuarioService;
    
    @GetMapping
    public ResponseEntity<List<DireccionUsuario>> listDireccionUsuarios() {
        List<DireccionUsuario> direccionUsuarios = direccionUsuarioService.getAll();
        return new ResponseEntity<>(direccionUsuarios, HttpStatus.OK);
    } 

    @GetMapping("/{id}")
    public ResponseEntity<DireccionUsuario> showDireccionUsuario(@PathVariable Long id){
        return direccionUsuarioService.findById(id)
            .map(DireccionUsuario -> new ResponseEntity<>(DireccionUsuario, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<DireccionUsuario> saveDireccionUsuario(@Valid @RequestBody DireccionUsuario direccionUsuario) {
        DireccionUsuario newDireccionUsuario = direccionUsuarioService.save(direccionUsuario);
        return new ResponseEntity<>(newDireccionUsuario, HttpStatus.CREATED);
    }
}
