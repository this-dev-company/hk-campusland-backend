package com.hackathon.hk_campusland_backend.organizacion_integrantes.domain.entity;

import com.hackathon.hk_campusland_backend.integrantes.domain.entity.Integrante;
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
@Table(name = "organizacion_integrantes")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class OrganizacionIntegrante {
    @EmbeddedId
    private OrganizacionIntegrantePK id;

    @ManyToOne
    @JoinColumn(name = "organizacion_id", insertable = false, updatable = false)
    private Organizacion organizacion;

    @ManyToOne
    @JoinColumn(name = "integrante_id", insertable = false, updatable = false)
    private Integrante integrante;

    @Embedded
    private Audit audit = new Audit();
}
