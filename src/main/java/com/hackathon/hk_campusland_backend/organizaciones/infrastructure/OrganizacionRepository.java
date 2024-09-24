package com.hackathon.hk_campusland_backend.organizaciones.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hk_campusland_backend.organizaciones.domain.entity.Organizacion;

@Repository
public interface OrganizacionRepository extends JpaRepository<Organizacion, Long> {

}
