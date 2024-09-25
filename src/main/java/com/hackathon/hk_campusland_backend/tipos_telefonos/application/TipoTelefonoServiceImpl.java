package com.hackathon.hk_campusland_backend.tipos_telefonos.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hackathon.hk_campusland_backend.tipos_telefonos.domain.entity.TipoTelefono;
import com.hackathon.hk_campusland_backend.tipos_telefonos.domain.services.TipoTelefonoService;
import com.hackathon.hk_campusland_backend.tipos_telefonos.infrastructure.repositories.TipoTelefonoRepository;
import com.hackathon.hk_campusland_backend.utils.exception.dto.BusinessException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoTelefonoServiceImpl implements TipoTelefonoService {

    @Autowired
    private TipoTelefonoRepository tipoTelefonoRepository;

    @Override
    public Optional<TipoTelefono> findById(Long id) {

        if (!tipoTelefonoRepository.findById(id).isPresent()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "El Rol no existe");
        }

        return tipoTelefonoRepository.findById(id);
    }

    @Override
    public List<TipoTelefono> getAll() {
        List<TipoTelefono> TipoTelefonoes = tipoTelefonoRepository.findAll();

        if (TipoTelefonoes.isEmpty()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "No hay Tipo Telefonoes registrados");
        }

        return tipoTelefonoRepository.findAll();
    }

    @Override
    public TipoTelefono save(TipoTelefono tipoTelefono) {

        Optional<TipoTelefono> existingTipoTelefono = tipoTelefonoRepository.findTipoTelefonoByTipo(tipoTelefono.getTipo());

        if (existingTipoTelefono.isPresent()) {
            throw new BusinessException("P-300", HttpStatus.CONFLICT, "El Tipo Telefono con ese nombre ya existe");
        }

        return tipoTelefonoRepository.save(tipoTelefono);
    }
}
