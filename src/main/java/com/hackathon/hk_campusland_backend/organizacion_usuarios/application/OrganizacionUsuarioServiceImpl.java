package com.hackathon.hk_campusland_backend.organizacion_usuarios.application;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.hk_campusland_backend.organizacion_usuarios.domain.entity.OrganizacionUsuario;
import com.hackathon.hk_campusland_backend.organizacion_usuarios.domain.entity.OrganizacionUsuarioPK;
import com.hackathon.hk_campusland_backend.organizacion_usuarios.domain.services.OrganizacionUsuarioService;
import com.hackathon.hk_campusland_backend.organizacion_usuarios.infrastructure.repository.OrganizacionUsuarioRepository;
import com.hackathon.hk_campusland_backend.organizaciones.domain.entity.Organizacion;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrganizacionUsuarioServiceImpl implements OrganizacionUsuarioService {
    
    @Autowired
    OrganizacionUsuarioRepository organizacionUsuarioRepository;

    @Override
    @Transactional
    public void save(OrganizacionUsuario organizacionUsuario) {
        organizacionUsuarioRepository.save(organizacionUsuario);
    }

    @Override
    @Transactional
    public void delete(OrganizacionUsuario organizacionUsuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    @Transactional
    public void update(OrganizacionUsuarioPK id, OrganizacionUsuario organizacionUsuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    @Transactional
    public List<OrganizacionUsuario> findAll() {
        return organizacionUsuarioRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<OrganizacionUsuario> findById(OrganizacionUsuarioPK id) {
        return organizacionUsuarioRepository.findById(id);
    }

    @Override
    @Transactional
    public List<Organizacion> findOrganizacionesByUsuarioId(Long id) {
        return organizacionUsuarioRepository.findByUserId(id)
                .stream()
                .map(organizacionUsuario -> organizacionUsuario.getOrganizacion())
                .collect(Collectors.toList());
    }
}
