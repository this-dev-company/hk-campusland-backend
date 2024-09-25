package com.hackathon.hk_campusland_backend.cargos.infrastructure.controllers;

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

import com.hackathon.hk_campusland_backend.cargos.domain.entity.Cargo;
import com.hackathon.hk_campusland_backend.cargos.domain.services.CargoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cargo")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @GetMapping
    public ResponseEntity<List<Cargo>> listCargos() {
        List<Cargo> cargos = cargoService.getAll();
        return new ResponseEntity<>(cargos, HttpStatus.OK);
    } 

    @GetMapping("/{id}")
    public ResponseEntity<Cargo> showCargo(@PathVariable Long id){
        return cargoService.findById(id)
            .map(cargo -> new ResponseEntity<>(cargo, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Cargo> saveCargo(@Valid @RequestBody Cargo cargo) {
        Cargo newCargo = cargoService.save(cargo);
        return new ResponseEntity<>(newCargo, HttpStatus.CREATED);
    }
}
