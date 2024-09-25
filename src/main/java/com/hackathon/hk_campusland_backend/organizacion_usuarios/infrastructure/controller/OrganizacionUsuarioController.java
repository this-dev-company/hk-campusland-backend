package com.hackathon.hk_campusland_backend.organizacion_usuarios.infrastructure.controller;

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

import com.hackathon.hk_campusland_backend.organizacion_usuarios.application.OrganizacionUsuarioServiceImpl;
import com.hackathon.hk_campusland_backend.organizacion_usuarios.domain.entity.OrganizacionUsuario;
import com.hackathon.hk_campusland_backend.organizacion_usuarios.domain.entity.OrganizacionUsuarioPK;
import com.hackathon.hk_campusland_backend.organizaciones.domain.entity.Organizacion;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/organizacion-usuario")
public class OrganizacionUsuarioController {

    @Autowired
    OrganizacionUsuarioServiceImpl organizacionUsuarioServiceImpl;

    @GetMapping("/list-all")
    public List<OrganizacionUsuario> listAllOrganizacionUsuario() {
        return organizacionUsuarioServiceImpl.findAll();
    }

    @GetMapping("/{organizacionId}/{usuarioId}")
    public ResponseEntity<OrganizacionUsuario> showOrganizacionUsuario(
            @PathVariable Long usuarioId,
            @PathVariable Long organizacionId) {
        OrganizacionUsuarioPK id = new OrganizacionUsuarioPK();
        id.setUser(usuarioId);
        id.setOrganizacion(organizacionId);
        return organizacionUsuarioServiceImpl.findById(id)
                .map(organizacionUsuario -> new ResponseEntity<>(organizacionUsuario, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/find-organizaciones-of-user/{usuarioId}")
    public ResponseEntity<List<Organizacion>> getOrganizacionesByUsuarioId(@PathVariable Long usuarioId) {
        List<Organizacion> organizaciones = organizacionUsuarioServiceImpl.findOrganizacionesByUsuarioId(usuarioId);
        if (organizaciones.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(organizaciones, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createOrganizacionUsuario(@Valid @RequestBody OrganizacionUsuario organizacionUsuario,
            BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        organizacionUsuarioServiceImpl.save(organizacionUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body("organizacionUsuario created successfully");
    }
}
