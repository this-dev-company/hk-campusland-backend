package com.hackathon.hk_campusland_backend.proyectos.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.hackathon.hk_campusland_backend.proyectos.domain.entity.Proyecto;
import com.hackathon.hk_campusland_backend.proyectos.domain.service.ProyectoInterface;
import com.hackathon.hk_campusland_backend.proyectos.infrastructure.ProyectoRepository;

import jakarta.transaction.Transactional;

public class ProyectoServiceImpl implements ProyectoInterface {

    @Autowired
    ProyectoRepository proyectoRepository;

    @Override
    @Transactional
    public void save(Proyecto proyecto) {
         proyectoRepository.save(proyecto);
    }

    @Override
    @Transactional
    public void delete(Proyecto proyecto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    @Transactional
    public void update(Long id, Proyecto proyecto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    @Transactional
    public List<Proyecto> findAll() {
        return proyectoRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Proyecto> findById(Long id) {
        return proyectoRepository.findById(id);
    }

}
