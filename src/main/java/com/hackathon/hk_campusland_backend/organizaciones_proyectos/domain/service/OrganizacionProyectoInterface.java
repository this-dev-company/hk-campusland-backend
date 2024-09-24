package com.hackathon.hk_campusland_backend.organizaciones_proyectos.domain.service;

import java.util.List;
import java.util.Optional;

import com.hackathon.hk_campusland_backend.organizaciones_proyectos.domain.entity.OrganizacionProyecto;
import com.hackathon.hk_campusland_backend.organizaciones_proyectos.domain.entity.OrganizacionProyectoPK;

public interface OrganizacionProyectoInterface {
    void save(OrganizacionProyecto organizacionProyecto);
    void delete(OrganizacionProyecto organizacionProyecto);
    void update(OrganizacionProyectoPK id, OrganizacionProyecto organizacionProyecto);
    List<OrganizacionProyecto>  findAll();
    Optional<OrganizacionProyecto> findById(OrganizacionProyectoPK id);
}
