package com.hackathon.hk_campusland_backend.proyectos_usuarios.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.hk_campusland_backend.proyectos.domain.entity.Proyecto;
import com.hackathon.hk_campusland_backend.proyectos_usuarios.application.ProyectoUsuarioServiceImpl;
import com.hackathon.hk_campusland_backend.proyectos_usuarios.domain.entity.ProyectoUsuario;
import com.hackathon.hk_campusland_backend.proyectos_usuarios.domain.entity.ProyectoUsuarioPK;
import com.hackathon.hk_campusland_backend.proyectos_usuarios.infrastructure.ProyectoUsuarioRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/proyectoUsuario")
public class ProyectoUsuarioController {

    @Autowired
    ProyectoUsuarioServiceImpl proyectoUsuarioServiceImpl;

    @Autowired
    ProyectoUsuarioRepository proyectoUsuarioRepository;

    @GetMapping("/list-all")
    public List<ProyectoUsuario> listAllProyectoUsuario() {
        return proyectoUsuarioServiceImpl.findAll();
    }

    @GetMapping("/{proyectoId}/{usuarioId}")
    public ResponseEntity<ProyectoUsuario> showProyectoUsuario(
            @PathVariable Long usuarioId,
            @PathVariable Long proyectoId) {
        ProyectoUsuarioPK id = new ProyectoUsuarioPK();
        id.setUsuario(usuarioId);
        id.setProyecto(proyectoId);
        return proyectoUsuarioServiceImpl.findById(id)
                .map(proyectoUsuario -> new ResponseEntity<>(proyectoUsuario, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/find-projects-of-user/{usuarioId}")
    public ResponseEntity<List<Proyecto>> getProyectosByusuarioId(@PathVariable Long usuarioId) {
        List<Proyecto> proyectos = proyectoUsuarioServiceImpl.findProyectosByUsuarioId(usuarioId);
        if (proyectos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(proyectos, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProyectoUsuario(@Valid @RequestBody ProyectoUsuario proyectoUsuario,
            BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        proyectoUsuarioServiceImpl.save(proyectoUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body("ProyectoUsuario created successfully");
    }
}
