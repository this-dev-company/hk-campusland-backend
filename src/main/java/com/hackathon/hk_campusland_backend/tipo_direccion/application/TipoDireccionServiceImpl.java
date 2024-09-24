package com.hackathon.hk_campusland_backend.tipo_direccion.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hackathon.hk_campusland_backend.tipo_direccion.domain.entity.TipoDireccion;
import com.hackathon.hk_campusland_backend.tipo_direccion.domain.services.TipoDireccionService;
import com.hackathon.hk_campusland_backend.tipo_direccion.infrastructure.repositories.TipoDireccionRepository;
import com.hackathon.hk_campusland_backend.utils.exception.dto.BusinessException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoDireccionServiceImpl implements TipoDireccionService {
    
    @Autowired
    private TipoDireccionRepository tipoDireccionRepository;

    @Override
    public Optional<TipoDireccion> findById(Long id) {

        if (!tipoDireccionRepository.findById(id).isPresent()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "El tipo direccion no existe");
        }

        return tipoDireccionRepository.findById(id);
    }

    @Override
    public List<TipoDireccion> getAll() {
        List<TipoDireccion> tipoDirecciones = tipoDireccionRepository.findAll();

        if (tipoDirecciones.isEmpty()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "No hay tipo direcciones registrados");
        }

        return tipoDireccionRepository.findAll();
    }

    @Override
    public TipoDireccion save(TipoDireccion tipoDireccion) {

        Optional<TipoDireccion> existingTipoDireccion = tipoDireccionRepository.findTipoDireccionByTipo(tipoDireccion.getTipo());

        if (existingTipoDireccion.isPresent()) {
            throw new BusinessException("P-300", HttpStatus.CONFLICT, "El tipo direccion con ese nombre ya existe");
        }

        return tipoDireccionRepository.save(tipoDireccion);
    }
}
