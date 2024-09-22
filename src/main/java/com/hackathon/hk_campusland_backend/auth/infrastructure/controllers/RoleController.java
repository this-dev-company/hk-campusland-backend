package com.hackathon.hk_campusland_backend.auth.infrastructure.controllers;

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

import com.hackathon.hk_campusland_backend.auth.application.services.RoleService;
import com.hackathon.hk_campusland_backend.auth.domain.models.Rol;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<List<Rol>> listRoles() {
        List<Rol> roles = roleService.getAll();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    } 

    @GetMapping("/{id}")
    public ResponseEntity<Rol> showRol(@PathVariable Long id){
        return roleService.findById(id)
            .map(rol -> new ResponseEntity<>(rol, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Rol> saveRol(@Valid @RequestBody Rol rol) {
        Rol newRol = roleService.save(rol);
        return new ResponseEntity<>(newRol, HttpStatus.CREATED);
    }
}
