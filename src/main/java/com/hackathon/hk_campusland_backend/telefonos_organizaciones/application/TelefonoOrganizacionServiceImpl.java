package com.hackathon.hk_campusland_backend.telefonos_organizaciones.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hackathon.hk_campusland_backend.telefonos_organizaciones.domain.entity.TelefonoOrganizacion;
import com.hackathon.hk_campusland_backend.telefonos_organizaciones.domain.services.TelefonoOrganizacionService;
import com.hackathon.hk_campusland_backend.telefonos_organizaciones.infrastructure.repositories.TelefonoOrganizacionRepository;
import com.hackathon.hk_campusland_backend.utils.exception.dto.BusinessException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TelefonoOrganizacionServiceImpl implements TelefonoOrganizacionService {

    @Autowired
    private TelefonoOrganizacionRepository telefonoOrganizacionRepository;

    @Override
    public Optional<TelefonoOrganizacion> findById(Long id) {

        if (!telefonoOrganizacionRepository.findById(id).isPresent()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "El TelefonoOrganizacion no existe");
        }

        return telefonoOrganizacionRepository.findById(id);
    }

    @Override
    public List<TelefonoOrganizacion> getAll() {
        List<TelefonoOrganizacion> TelefonoOrganizaciones = telefonoOrganizacionRepository.findAll();

        if (TelefonoOrganizaciones.isEmpty()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "No hay TelefonoOrganizaciones registrados");
        }

        return telefonoOrganizacionRepository.findAll();
    }

    @Override
    public TelefonoOrganizacion save(TelefonoOrganizacion TelefonoOrganizacion) {

        Optional<TelefonoOrganizacion> existingTelefonoOrganizacion = telefonoOrganizacionRepository.findTelefonoOrganizacionByNumero(TelefonoOrganizacion.getNumero());

        if (existingTelefonoOrganizacion.isPresent()) {
            throw new BusinessException("P-300", HttpStatus.CONFLICT, "El TelefonoOrganizacion con ese nombre ya existe");
        }

        return telefonoOrganizacionRepository.save(TelefonoOrganizacion);
    }
}
