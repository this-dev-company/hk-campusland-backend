package com.hackathon.hk_campusland_backend.organizaciones_proyectos.application;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hackathon.hk_campusland_backend.organizaciones_proyectos.domain.entity.OrganizacionProyecto;
import com.hackathon.hk_campusland_backend.organizaciones_proyectos.domain.entity.OrganizacionProyectoPK;
import com.hackathon.hk_campusland_backend.organizaciones_proyectos.domain.service.OrganizacionProyectoInterface;
import com.hackathon.hk_campusland_backend.organizaciones_proyectos.infrastructure.OrganizacionProyectoRepository;
import com.hackathon.hk_campusland_backend.proyectos.domain.entity.Proyecto;
import com.hackathon.hk_campusland_backend.utils.exception.dto.BusinessException;

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

    @Override
    @Transactional
    public List<Proyecto> findProyectosByOrganizacionId(Long organizacionId) {

        List<OrganizacionProyecto> proyectos = organizacionProyectoRepository.findByOrganizacionId(organizacionId);
        
        if (proyectos.isEmpty()) {
            throw new BusinessException("P-404", HttpStatus.NOT_FOUND, "No hay proyectos registrados a esa organizacion");
        }

        return organizacionProyectoRepository.findByOrganizacionId(organizacionId)
                .stream()
                .map(organizacionProyecto -> organizacionProyecto.getProyecto())
                .collect(Collectors.toList());
    }
}
