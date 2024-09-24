package com.hackathon.hk_campusland_backend.ciudades.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hackathon.hk_campusland_backend.ciudades.domain.entity.Ciudad;
import com.hackathon.hk_campusland_backend.ciudades.domain.services.CiudadService;
import com.hackathon.hk_campusland_backend.ciudades.infrastructure.repositories.CiudadRepository;
import com.hackathon.hk_campusland_backend.utils.exception.dto.BusinessException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CiudadServiceImpl implements CiudadService{

    @Autowired
    private CiudadRepository ciudadRepository;

    @Override
    public Optional<Ciudad> findById(Long id) {

        if (!ciudadRepository.findById(id).isPresent()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "El Ciudad no existe");
        }

        return ciudadRepository.findById(id);
    }

    @Override
    public List<Ciudad> getAll() {
        List<Ciudad> ciudades = ciudadRepository.findAll();

        if (ciudades.isEmpty()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "No hay Ciudades registrados");
        }

        return ciudadRepository.findAll();
    }

    @Override
    public Ciudad save(Ciudad ciudad) {

        Optional<Ciudad> existingCiudad = ciudadRepository.findCiudadByNombre(ciudad.getNombre());

        if (existingCiudad.isPresent()) {
            throw new BusinessException("P-300", HttpStatus.CONFLICT, "El Ciudad con ese nombre ya existe");
        }

        return ciudadRepository.save(ciudad);
    }

}
