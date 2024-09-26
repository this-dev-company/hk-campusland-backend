package com.hackathon.hk_campusland_backend.organizaciones_proyectos.domain.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class OrganizacionProyectoPK implements Serializable {
    @Column(name = "organizacion_id")
    private Long organizacion;

    @Column(name = "proyecto_id")
    private Long proyecto;
}
