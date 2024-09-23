package com.hackathon.hk_campusland_backend.organizacion_integrantes.domain.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class OrganizacionIntegrantePK implements Serializable {
    @Column(name = "organizacion_id")
    private Long organizacion;

    @Column(name = "integrante_id")
    private Long integrante;
}
