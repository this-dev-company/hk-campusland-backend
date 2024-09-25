package com.hackathon.hk_campusland_backend.proyectos_usuarios.application;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.hk_campusland_backend.proyectos.domain.entity.Proyecto;
import com.hackathon.hk_campusland_backend.proyectos_usuarios.domain.entity.ProyectoUsuario;
import com.hackathon.hk_campusland_backend.proyectos_usuarios.domain.entity.ProyectoUsuarioPK;
import com.hackathon.hk_campusland_backend.proyectos_usuarios.domain.service.ProyectoUsuarioInterface;
import com.hackathon.hk_campusland_backend.proyectos_usuarios.infrastructure.ProyectoUsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class ProyectoUsuarioServiceImpl implements ProyectoUsuarioInterface {

    @Autowired
    ProyectoUsuarioRepository proyectoUsuarioRepository;

    @Override
    @Transactional
    public void save(ProyectoUsuario proyectoUsuario) {
        proyectoUsuarioRepository.save(proyectoUsuario);
    }

    @Override
    @Transactional
    public void delete(ProyectoUsuario proyectoUsuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    @Transactional
    public void update(ProyectoUsuarioPK id, ProyectoUsuario proyectoUsuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    @Transactional
    public List<ProyectoUsuario> findAll() {
        return proyectoUsuarioRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<ProyectoUsuario> findById(ProyectoUsuarioPK id) {
        return proyectoUsuarioRepository.findById(id);
    }

    @Override
    @Transactional
    public List<Proyecto> findProyectosByUsuarioId(Long id) {
        return proyectoUsuarioRepository.findByUsuarioId(id)
                .stream()
                .map(proyectoUsuario -> proyectoUsuario.getProyecto())
                .collect(Collectors.toList());
    }

}
