package com.hackathon.hk_campusland_backend.organizaciones_proyectos.infrastructure;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hk_campusland_backend.organizaciones_proyectos.domain.entity.OrganizacionProyecto;
import com.hackathon.hk_campusland_backend.organizaciones_proyectos.domain.entity.OrganizacionProyectoPK;

@Repository
public interface OrganizacionProyectoRepository extends JpaRepository<OrganizacionProyecto, OrganizacionProyectoPK> {
    List<OrganizacionProyecto> findByOrganizacionId(Long organizacionId);
}
