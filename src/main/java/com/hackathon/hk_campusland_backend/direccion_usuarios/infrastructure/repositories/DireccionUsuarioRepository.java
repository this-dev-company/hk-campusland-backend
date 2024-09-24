package com.hackathon.hk_campusland_backend.direccion_usuarios.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hk_campusland_backend.direccion_usuarios.domain.entity.DireccionUsuario;

@Repository
public interface DireccionUsuarioRepository extends JpaRepository<DireccionUsuario, Long> {
    Optional<DireccionUsuario> findDireccionUsuarioByDireccion(String direccion); 
}
