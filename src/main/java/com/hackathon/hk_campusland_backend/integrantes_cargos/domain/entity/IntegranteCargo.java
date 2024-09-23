package com.hackathon.hk_campusland_backend.integrantes_cargos.domain.entity;

import com.hackathon.hk_campusland_backend.cargos.domain.entity.Cargo;
import com.hackathon.hk_campusland_backend.integrantes.domain.entity.Integrante;
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
@Table(name = "integrantes_cargos")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class IntegranteCargo {
    @EmbeddedId
    private IntegranteCargoPK id;

    @ManyToOne
    @JoinColumn(name = "cargo_id", insertable = false, updatable = false)
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "integrante_id", insertable = false, updatable = false)
    private Integrante integrante;

    @Embedded
    private Audit audit = new Audit();
}
