package com.hackathon.hk_campusland_backend.proyectos.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hackathon.hk_campusland_backend.organizaciones.domain.entity.Organizacion;
import com.hackathon.hk_campusland_backend.proyectos.domain.dto.ProyectoDTO;
import com.hackathon.hk_campusland_backend.proyectos.domain.entity.Proyecto;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

   Optional<Proyecto> findById(Long id);
    
    @Query("SELECT DISTINCT o " +
       "FROM Organizacion o " +
       "JOIN OrganizacionProyecto op ON op.id.organizacion = o.id " +
       "JOIN ProyectoUsuario pu ON pu.id.proyecto = op.id.proyecto " +
       "JOIN User u ON u.id = pu.id.usuario " +
       "WHERE u.id = :usuarioId")
    List<Organizacion> findOrganizacionesByUsuarioId(@Param("usuarioId") Long usuarioId);

    @Query("SELECT new com.hackathon.hk_campusland_backend.proyectos.domain.dto.ProyectoDTO(" +
       "p.id, p.nombre, CAST(p.estadoProyecto AS string)) " + 
       "FROM Proyecto p " +
       "JOIN OrganizacionProyecto op ON op.id.proyecto = p.id " +
       "WHERE op.id.organizacion = :organizacionId")
   List<ProyectoDTO> findProyectosByOrganizacionId(@Param("organizacionId") Long organizacionId);


}
