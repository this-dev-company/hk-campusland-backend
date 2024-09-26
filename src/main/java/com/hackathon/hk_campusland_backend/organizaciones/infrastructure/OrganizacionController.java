package com.hackathon.hk_campusland_backend.organizaciones.infrastructure;

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

import com.hackathon.hk_campusland_backend.auth.application.UserServiceImpl;
import com.hackathon.hk_campusland_backend.auth.domain.entity.User;
import com.hackathon.hk_campusland_backend.organizaciones.application.OrganizacionServiceImpl;
import com.hackathon.hk_campusland_backend.organizaciones.domain.entity.Organizacion;
import com.hackathon.hk_campusland_backend.utils.exception.dto.BusinessException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/organizacion")
public class OrganizacionController {
    @Autowired
    OrganizacionServiceImpl organizacionServiceImpl;

    @Autowired
    OrganizacionRepository organizacionRepository;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/list-all")
    public List<Organizacion> listAllOrganizacion() {
        return organizacionServiceImpl.findAll();
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Organizacion> showOrganizacionById(@PathVariable Long id) {
        return organizacionServiceImpl.findById(id)
                .map(organizacion -> new ResponseEntity<>(organizacion, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/find-by-alias/{alias}")
    public ResponseEntity<Organizacion> showOrganizacionByAlias(@PathVariable String alias) {
        return organizacionServiceImpl.findOrganizacionByAlias(alias)
                .map(organizacion -> new ResponseEntity<>(organizacion, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createOrganizacion(@Valid @RequestBody Organizacion organizacion, BindingResult result) {
        organizacionServiceImpl.save(organizacion);
        return organizacionServiceImpl.findOrganizacionByAlias(organizacion.getAlias())
                .map(org -> new ResponseEntity<>(org, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/by-usuario-creador/{usuarioCreadorId}")
    public List<Organizacion> getOrganizacionesByUsuarioCreadorId(@PathVariable Long usuarioCreadorId) {
        User user = userService.findById(usuarioCreadorId)
                .orElseThrow(() -> new BusinessException("P-404", HttpStatus.NOT_FOUND,
                        "User not found with ID: " + usuarioCreadorId));

        List<Organizacion> organizaciones = organizacionServiceImpl.findByUsuarioCreadorId(user);
        if (organizaciones.isEmpty()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND,
                    "No organizations found for user with ID: " + usuarioCreadorId);
        }
        return organizaciones;
    }

}
