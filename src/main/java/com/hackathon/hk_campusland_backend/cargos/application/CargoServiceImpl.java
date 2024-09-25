package com.hackathon.hk_campusland_backend.cargos.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hackathon.hk_campusland_backend.cargos.domain.entity.Cargo;
import com.hackathon.hk_campusland_backend.cargos.domain.services.CargoService;
import com.hackathon.hk_campusland_backend.cargos.infrastructure.repositories.CargoRepository;
import com.hackathon.hk_campusland_backend.utils.exception.dto.BusinessException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CargoServiceImpl implements CargoService{

    @Autowired
    private CargoRepository cargoRepository;

    @Override
    public Optional<Cargo> findById(Long id) {

        if (!cargoRepository.findById(id).isPresent()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "El Cargo no existe");
        }

        return cargoRepository.findById(id);
    }

    @Override
    public List<Cargo> getAll() {
        List<Cargo> Cargoes = cargoRepository.findAll();

        if (Cargoes.isEmpty()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "No hay Cargos registrados");
        }

        return cargoRepository.findAll();
    }

    @Override
    public Cargo save(Cargo Cargo) {

        Optional<Cargo> existingCargo = cargoRepository.findCargoByCargo(Cargo.getCargo());

        if (existingCargo.isPresent()) {
            throw new BusinessException("P-300", HttpStatus.CONFLICT, "El Cargo con ese nombre ya existe");
        }

        return cargoRepository.save(Cargo);
    }
}
