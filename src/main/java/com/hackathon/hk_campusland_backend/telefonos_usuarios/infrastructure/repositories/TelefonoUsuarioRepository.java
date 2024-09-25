package com.hackathon.hk_campusland_backend.telefonos_usuarios.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hk_campusland_backend.telefonos_usuarios.domain.entity.TelefonoUsuario;

@Repository
public interface TelefonoUsuarioRepository extends JpaRepository<TelefonoUsuario, Long>{
    Optional<TelefonoUsuario> findByNumero(String numero);
}
