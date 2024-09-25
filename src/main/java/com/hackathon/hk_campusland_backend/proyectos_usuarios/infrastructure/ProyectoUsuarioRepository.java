package com.hackathon.hk_campusland_backend.proyectos_usuarios.infrastructure;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hk_campusland_backend.proyectos_usuarios.domain.entity.ProyectoUsuario;
import com.hackathon.hk_campusland_backend.proyectos_usuarios.domain.entity.ProyectoUsuarioPK;

@Repository
public interface ProyectoUsuarioRepository extends JpaRepository<ProyectoUsuario, ProyectoUsuarioPK> {
List<ProyectoUsuario> findByUsuarioId(Long usuarioId);
}
