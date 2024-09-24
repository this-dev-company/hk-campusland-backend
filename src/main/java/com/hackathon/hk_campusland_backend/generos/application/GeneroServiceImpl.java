package com.hackathon.hk_campusland_backend.generos.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hackathon.hk_campusland_backend.generos.domain.entity.Genero;
import com.hackathon.hk_campusland_backend.generos.domain.services.GeneroService;
import com.hackathon.hk_campusland_backend.generos.infrastructure.repositories.GeneroRepository;
import com.hackathon.hk_campusland_backend.utils.exception.dto.BusinessException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    @Override
    public Optional<Genero> findById(Long id) {

        if (!generoRepository.findById(id).isPresent()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "El Genero no existe");
        }

        return generoRepository.findById(id);
    }

    @Override
    public List<Genero> getAll() {
        List<Genero> generos = generoRepository.findAll();

        if (generos.isEmpty()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "No hay generos registrados");
        }

        return generoRepository.findAll();
    }

    @Override
    public Genero save(Genero genero) {

        Optional<Genero> existingGenero = generoRepository.findGeneroByNombre(genero.getNombre());

        if (existingGenero.isPresent()) {
            throw new BusinessException("P-300", HttpStatus.CONFLICT, "El Genero con ese nombre ya existe");
        }

        return generoRepository.save(genero);
    }
    
}
