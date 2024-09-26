package com.hackathon.hk_campusland_backend.organizacion_usuarios.infrastructure.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hackathon.hk_campusland_backend.organizacion_usuarios.domain.dto.UsuariosOrganizacionDTO;
import com.hackathon.hk_campusland_backend.organizacion_usuarios.domain.entity.OrganizacionUsuario;
import com.hackathon.hk_campusland_backend.organizacion_usuarios.domain.entity.OrganizacionUsuarioPK;

public interface OrganizacionUsuarioRepository extends JpaRepository<OrganizacionUsuario, OrganizacionUsuarioPK> {
    List<OrganizacionUsuario> findByUserId(Long userId);

    @Query(value = "SELECT new com.hackathon.hk_campusland_backend.organizacion_usuarios.domain.dto.UsuariosOrganizacionDTO(u.username, u.nombre, u.apellido) " +
                   "FROM User u " +
                   "JOIN OrganizacionUsuario ou ON ou.id.user = u.id " +
                   "JOIN Organizacion o ON o.id = ou.id.organizacion " +
                   "WHERE o.id = :organizacionId")
    List<UsuariosOrganizacionDTO> getAllUsuariosByOrganizacionId(@Param("organizacionId") Long organizacionId);
}
