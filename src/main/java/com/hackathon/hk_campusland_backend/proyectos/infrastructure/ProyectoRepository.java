package com.hackathon.hk_campusland_backend.proyectos.infrastructure;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hackathon.hk_campusland_backend.proyectos.domain.dto.ProyectoDTO;
import com.hackathon.hk_campusland_backend.proyectos.domain.entity.Proyecto;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
    
    @Query(value = "SELECT new com.hackathon.hk_campusland_backend.proyectos.domain.dto.ProyectoDTO(p.nombre, o.nombre) " +
               "FROM Proyecto p " +
               "JOIN OrganizacionProyecto op ON op.id.proyecto = p.id " + 
               "JOIN Organizacion o ON o.id = op.id.organizacion " + 
               "JOIN ProyectoUsuario pu ON pu.id.proyecto = p.id " + 
               "JOIN User u ON u.id = pu.id.usuario " + 
               "WHERE u.id = :usuarioId")
    List<ProyectoDTO> findProyectosByUsuarioId(@Param("usuarioId") Long usuarioId);

}
