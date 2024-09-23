package com.hackathon.hk_campusland_backend.cargos_organizaciones.domain.entity;

import com.hackathon.hk_campusland_backend.cargos.domain.entity.Cargo;
import com.hackathon.hk_campusland_backend.organizaciones.domain.entity.Organizacion;
import com.hackathon.hk_campusland_backend.utils.Audit;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cargos_organizaciones")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CargoOrganizacion {
    @EmbeddedId
    private CargoOrganizacionPK id;

    @ManyToOne
    @JoinColumn(name = "organizacion_id", insertable = false, updatable = false)
    private Organizacion organizacion;

    @ManyToOne
    @JoinColumn(name = "cargo_id", insertable = false, updatable = false)
    private Cargo cargo;

    @Embedded
    private Audit audit = new Audit();
}
