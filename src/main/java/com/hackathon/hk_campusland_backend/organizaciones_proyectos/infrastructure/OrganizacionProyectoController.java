package com.hackathon.hk_campusland_backend.organizaciones_proyectos.infrastructure;

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

import com.hackathon.hk_campusland_backend.organizaciones_proyectos.application.OrganizacionProyectoServiceImpl;
import com.hackathon.hk_campusland_backend.organizaciones_proyectos.domain.entity.OrganizacionProyecto;
import com.hackathon.hk_campusland_backend.organizaciones_proyectos.domain.entity.OrganizacionProyectoPK;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/organizacionProyecto")
public class OrganizacionProyectoController {
    @Autowired
    OrganizacionProyectoServiceImpl organizacionProyectoServiceImpl;

    @Autowired
    OrganizacionProyectoRepository organizacionProyectoRepository;

    @GetMapping("/list-all")
    public List<OrganizacionProyecto> listAllOrganizacionProyecto() {
        return organizacionProyectoServiceImpl.findAll();
    }

    @GetMapping("/{organizacionId}/{proyectoId}")
    public ResponseEntity<OrganizacionProyecto> showOrganizacionProyecto(
        @PathVariable Long organizacionId,
    @PathVariable Long proyectoId) {
        OrganizacionProyectoPK id = new OrganizacionProyectoPK();
        id.setOrganizacion(organizacionId);
        id.setProyecto(proyectoId);
        return organizacionProyectoServiceImpl.findById(id)
                .map(organizacionProyecto -> new ResponseEntity<>(organizacionProyecto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createOrganizacionProyecto(@Valid @RequestBody OrganizacionProyecto organizacionProyecto,
            BindingResult result) {
                if (result.hasErrors()) {
                    return ResponseEntity.badRequest().body(result.getAllErrors());
                }
            
        organizacionProyectoServiceImpl.save(organizacionProyecto);
        return ResponseEntity.status(HttpStatus.CREATED).body("OrganizacionProyecto created successfully");
    }
}
