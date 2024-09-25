package com.hackathon.hk_campusland_backend.organizacion_usuarios.infrastructure.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hackathon.hk_campusland_backend.organizacion_usuarios.domain.entity.OrganizacionUsuario;
import com.hackathon.hk_campusland_backend.organizacion_usuarios.domain.entity.OrganizacionUsuarioPK;

public interface OrganizacionUsuarioRepository extends JpaRepository<OrganizacionUsuario, OrganizacionUsuarioPK> {
    List<OrganizacionUsuario> findByUserId(Long userId);
}
