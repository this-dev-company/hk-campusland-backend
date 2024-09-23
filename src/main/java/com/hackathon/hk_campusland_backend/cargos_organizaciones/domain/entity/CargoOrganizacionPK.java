package com.hackathon.hk_campusland_backend.cargos_organizaciones.domain.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class CargoOrganizacionPK {
    @Column(name = "organizacion_id")
    private Long organizacion;

    @Column(name = "cargo_id")
    private Long cargo;
}
