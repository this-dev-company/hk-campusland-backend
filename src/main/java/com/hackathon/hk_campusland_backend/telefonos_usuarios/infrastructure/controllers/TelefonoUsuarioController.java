package com.hackathon.hk_campusland_backend.telefonos_usuarios.infrastructure.controllers;

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

import com.hackathon.hk_campusland_backend.telefonos_usuarios.domain.entity.TelefonoUsuario;
import com.hackathon.hk_campusland_backend.telefonos_usuarios.domain.services.TelefonoUsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/telefono-usuario")
public class TelefonoUsuarioController {

    @Autowired
    private TelefonoUsuarioService telefonoUsuarioService;

    @GetMapping
    public ResponseEntity<List<TelefonoUsuario>> listTelefonoUsuarios() {
        List<TelefonoUsuario> telefonoUsuarios = telefonoUsuarioService.getAll();
        return new ResponseEntity<>(telefonoUsuarios, HttpStatus.OK);
    } 

    @GetMapping("/{id}")
    public ResponseEntity<TelefonoUsuario> showTelefonoUsuario(@PathVariable Long id){
        return telefonoUsuarioService.findById(id)
            .map(telefonoUsuario -> new ResponseEntity<>(telefonoUsuario, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<TelefonoUsuario> saveTelefonoUsuario(@Valid @RequestBody TelefonoUsuario telefonoUsuario) {
        TelefonoUsuario newTelefonoUsuario = telefonoUsuarioService.save(telefonoUsuario);
        return new ResponseEntity<>(newTelefonoUsuario, HttpStatus.CREATED);
    }
}
