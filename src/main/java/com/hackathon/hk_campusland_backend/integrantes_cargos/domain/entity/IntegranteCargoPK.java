package com.hackathon.hk_campusland_backend.integrantes_cargos.domain.entity;

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
public class IntegranteCargoPK implements Serializable{
    @Column(name = "cargo_id")
    private Long cargo;

    @Column(name = "integrante_id")
    private Long integrante;
}
