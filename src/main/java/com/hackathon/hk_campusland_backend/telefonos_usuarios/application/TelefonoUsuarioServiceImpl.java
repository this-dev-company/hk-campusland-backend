package com.hackathon.hk_campusland_backend.telefonos_usuarios.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hackathon.hk_campusland_backend.telefonos_usuarios.domain.entity.TelefonoUsuario;
import com.hackathon.hk_campusland_backend.telefonos_usuarios.domain.services.TelefonoUsuarioService;
import com.hackathon.hk_campusland_backend.telefonos_usuarios.infrastructure.repositories.TelefonoUsuarioRepository;
import com.hackathon.hk_campusland_backend.utils.exception.dto.BusinessException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TelefonoUsuarioServiceImpl implements TelefonoUsuarioService {

    @Autowired
    private TelefonoUsuarioRepository telefonoUsuarioRepository;

    @Override
    public Optional<TelefonoUsuario> findById(Long id) {

        if (!telefonoUsuarioRepository.findById(id).isPresent()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "El telefono no existe");
        }

        return telefonoUsuarioRepository.findById(id);
    }

    @Override
    public List<TelefonoUsuario> getAll() {
        List<TelefonoUsuario> TelefonoUsuarioes = telefonoUsuarioRepository.findAll();

        if (TelefonoUsuarioes.isEmpty()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "No hay telefonos registrados");
        }

        return telefonoUsuarioRepository.findAll();
    }

    @Override
    public TelefonoUsuario save(TelefonoUsuario telefonoUsuario) {

        // Optional<TelefonoUsuario> existingTelefonoUsuario = telefonoUsuarioRepository.findByNumero(telefonoUsuario.getNumero());

        // if (existingTelefonoUsuario.isPresent()) {
        //     throw new BusinessException("P-300", HttpStatus.CONFLICT, "El TelefonoUsuario con ese nombre ya existe");
        // }

        return telefonoUsuarioRepository.save(telefonoUsuario);
    }
}
