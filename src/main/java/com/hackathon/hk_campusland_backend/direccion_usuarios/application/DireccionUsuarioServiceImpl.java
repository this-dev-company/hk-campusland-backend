package com.hackathon.hk_campusland_backend.direccion_usuarios.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hackathon.hk_campusland_backend.direccion_usuarios.domain.entity.DireccionUsuario;
import com.hackathon.hk_campusland_backend.direccion_usuarios.domain.services.DireccionUsuarioService;
import com.hackathon.hk_campusland_backend.direccion_usuarios.infrastructure.repositories.DireccionUsuarioRepository;
import com.hackathon.hk_campusland_backend.utils.exception.dto.BusinessException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DireccionUsuarioServiceImpl implements DireccionUsuarioService {

    @Autowired
    private DireccionUsuarioRepository direccionUsuarioRepository;

    @Override
    public Optional<DireccionUsuario> findById(Long id) {

        if (!direccionUsuarioRepository.findById(id).isPresent()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "La direccion del usuario no existe");
        }

        return direccionUsuarioRepository.findById(id);
    }

    @Override
    public List<DireccionUsuario> getAll() {
        List<DireccionUsuario> direccionUsuarioes = direccionUsuarioRepository.findAll();

        if (direccionUsuarioes.isEmpty()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "No hay direcciones de usuario registrados");
        }

        return direccionUsuarioRepository.findAll();
    }

    @Override
    public DireccionUsuario save(DireccionUsuario direccionUsuario) {

        Optional<DireccionUsuario> existingDireccionUsuario = direccionUsuarioRepository.findDireccionUsuarioByDireccion(direccionUsuario.getDireccion());

        if (existingDireccionUsuario.isPresent()) {
            throw new BusinessException("P-300", HttpStatus.CONFLICT, "El direccion del usuario con ese nombre ya existe");
        }

        return direccionUsuarioRepository.save(direccionUsuario);
    }
}
