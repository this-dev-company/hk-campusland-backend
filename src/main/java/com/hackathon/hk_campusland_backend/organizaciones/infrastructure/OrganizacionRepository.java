package com.hackathon.hk_campusland_backend.organizaciones.infrastructure;

import java.util.Optional;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hk_campusland_backend.auth.domain.entity.User;
import com.hackathon.hk_campusland_backend.organizaciones.domain.entity.Organizacion;

@Repository
public interface OrganizacionRepository extends JpaRepository<Organizacion, Long> {
    Optional<Organizacion> findByAlias(String alias);
    List<Organizacion> findByUsuarioCreador(User usuario_creador);
}
