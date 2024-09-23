package com.hackathon.hk_campusland_backend.integrantes_equipos.domain.entity;

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
public class IntegranteEquipoPK implements Serializable{
    @Column(name = "equipo_id")
    private Long equipo;

    @Column(name = "integrante_id")
    private Long integrante;
}
