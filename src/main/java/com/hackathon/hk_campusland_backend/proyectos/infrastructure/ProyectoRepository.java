package com.hackathon.hk_campusland_backend.proyectos.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackathon.hk_campusland_backend.proyectos.domain.entity.Proyecto;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

}
