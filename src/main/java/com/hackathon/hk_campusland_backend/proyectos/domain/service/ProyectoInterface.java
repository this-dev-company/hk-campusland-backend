package com.hackathon.hk_campusland_backend.proyectos.domain.service;

import java.util.List;
import java.util.Optional;

import com.hackathon.hk_campusland_backend.proyectos.domain.entity.Proyecto;

public interface ProyectoInterface {
    void save(Proyecto proyecto);
    void delete(Proyecto proyecto);
    void update(Long id, Proyecto proyecto);
    List<Proyecto>  findAll();
    Optional<Proyecto> findById(Long id);
}
