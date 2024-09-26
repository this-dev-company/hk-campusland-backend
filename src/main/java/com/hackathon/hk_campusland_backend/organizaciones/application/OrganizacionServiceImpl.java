package com.hackathon.hk_campusland_backend.organizaciones.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.hk_campusland_backend.auth.domain.entity.User;
import com.hackathon.hk_campusland_backend.organizaciones.domain.entity.Organizacion;
import com.hackathon.hk_campusland_backend.organizaciones.domain.service.OrganizacionInterface;
import com.hackathon.hk_campusland_backend.organizaciones.infrastructure.OrganizacionRepository;

import jakarta.transaction.Transactional;

@Service
public class OrganizacionServiceImpl implements OrganizacionInterface {

    @Autowired
    OrganizacionRepository organizacionRepository;

    @Override
    @Transactional
    public void save(Organizacion organizacion) {
         organizacionRepository.save(organizacion);
    }

    @Override
    @Transactional
    public void delete(Organizacion organizacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    @Transactional
    public void update(Long id, Organizacion organizacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    @Transactional
    public List<Organizacion> findAll() {
        return organizacionRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Organizacion> findById(Long id) {
        return organizacionRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Organizacion> findOrganizacionByAlias(String alias) {
        return organizacionRepository.findByAlias(alias);
    }

    @Override
    @Transactional
    public List<Organizacion> findByUsuarioCreadorId(User usuario_creador_id) {
        return organizacionRepository.findByUsuarioCreador(usuario_creador_id);
    }

}
