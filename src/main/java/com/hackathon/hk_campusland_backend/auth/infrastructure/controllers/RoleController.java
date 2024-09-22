package com.hackathon.hk_campusland_backend.auth.infrastructure.controllers;

import java.util.List;
import java.util.Optional;

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

@RestController
@RequestMapping("/test/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<Rol> listRoles(){
        return roleService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Rol> showRole(@PathVariable String id){
        return roleService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Rol> createRol(@RequestBody Rol rol){
        Rol newRol = roleService.save(rol);
        return new ResponseEntity<>(newRol, HttpStatus.CREATED);
    }
}
