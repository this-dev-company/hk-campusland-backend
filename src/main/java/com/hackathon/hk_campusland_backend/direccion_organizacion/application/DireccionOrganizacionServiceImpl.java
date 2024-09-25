package com.hackathon.hk_campusland_backend.direccion_organizacion.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hackathon.hk_campusland_backend.direccion_organizacion.domain.entity.DireccionOrganizacion;
import com.hackathon.hk_campusland_backend.direccion_organizacion.domain.services.DireccionOrganizacionService;
import com.hackathon.hk_campusland_backend.direccion_organizacion.infrastructure.repositories.DireccionOrganizacionRepository;
import com.hackathon.hk_campusland_backend.utils.exception.dto.BusinessException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DireccionOrganizacionServiceImpl implements DireccionOrganizacionService {

    @Autowired
    private DireccionOrganizacionRepository direccionOrganizacionRepository;

    @Override
    public Optional<DireccionOrganizacion> findById(Long id) {

        if (!direccionOrganizacionRepository.findById(id).isPresent()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "La direccion organizacion no existe");
        }

        return direccionOrganizacionRepository.findById(id);
    }

    @Override
    public List<DireccionOrganizacion> getAll() {
        List<DireccionOrganizacion> direccionOrganizaciones = direccionOrganizacionRepository.findAll();

        if (direccionOrganizaciones.isEmpty()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "No hay direcciones registrados");
        }

        return direccionOrganizacionRepository.findAll();
    }

    @Override
    public DireccionOrganizacion save(DireccionOrganizacion DireccionOrganizacion) {
        return direccionOrganizacionRepository.save(DireccionOrganizacion);
    }
}
