package com.hackathon.hk_campusland_backend.paises.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hackathon.hk_campusland_backend.paises.domain.entity.Pais;
import com.hackathon.hk_campusland_backend.paises.domain.services.PaisService;
import com.hackathon.hk_campusland_backend.paises.infrastructure.repositories.PaisRepository;
import com.hackathon.hk_campusland_backend.utils.exception.dto.BusinessException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaisServiceImpl implements PaisService{

    @Autowired
    private PaisRepository paisRepository;

    @Override
    public Optional<Pais> findById(Long id) {

        if (!paisRepository.findById(id).isPresent()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "El Pais no existe");
        }

        return paisRepository.findById(id);
    }

    @Override
    public List<Pais> getAll() {
        List<Pais> paises = paisRepository.findAll();

        if (paises.isEmpty()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "No hay Paises registrados");
        }

        return paisRepository.findAll();
    }

    @Override
    public Pais save(Pais pais) {

        Optional<Pais> existingPais = paisRepository.findPaisByNombre(pais.getNombre());

        if (existingPais.isPresent()) {
            throw new BusinessException("P-300", HttpStatus.CONFLICT, "El pais con ese nombre ya existe");
        }

        return paisRepository.save(pais);
    }
}
