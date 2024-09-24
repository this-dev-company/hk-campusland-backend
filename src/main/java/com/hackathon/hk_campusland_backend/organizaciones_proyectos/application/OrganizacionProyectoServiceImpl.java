package com.hackathon.hk_campusland_backend.organizaciones_proyectos.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.hk_campusland_backend.organizaciones_proyectos.domain.entity.OrganizacionProyecto;
import com.hackathon.hk_campusland_backend.organizaciones_proyectos.domain.entity.OrganizacionProyectoPK;
import com.hackathon.hk_campusland_backend.organizaciones_proyectos.domain.service.OrganizacionProyectoInterface;
import com.hackathon.hk_campusland_backend.organizaciones_proyectos.infrastructure.OrganizacionProyectoRepository;

import jakarta.transaction.Transactional;

@Service
public class OrganizacionProyectoServiceImpl implements OrganizacionProyectoInterface {

    @Autowired
    OrganizacionProyectoRepository organizacionProyectoRepository;

    @Override
    @Transactional
    public void save(OrganizacionProyecto organizacionProyecto) {
         organizacionProyectoRepository.save(organizacionProyecto);
    }

    @Override
    @Transactional
    public void delete(OrganizacionProyecto organizacionProyecto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    @Transactional
    public void update(OrganizacionProyectoPK id, OrganizacionProyecto organizacionProyecto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    @Transactional
    public List<OrganizacionProyecto> findAll() {
        return organizacionProyectoRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<OrganizacionProyecto> findById(OrganizacionProyectoPK id) {
        return organizacionProyectoRepository.findById(id);
    }
}
