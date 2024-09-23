package com.hackathon.hk_campusland_backend.integrantes_equipos.domain.entity;

import com.hackathon.hk_campusland_backend.equipos.domain.entity.Equipo;
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
@Table(name = "integrantes_equipos")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class IntegranteEquipo {
@EmbeddedId
    private IntegranteEquipoPK id;

    @ManyToOne
    @JoinColumn(name = "equipo_id", insertable = false, updatable = false)
    private Equipo equipo;

    @ManyToOne
    @JoinColumn(name = "integrante_id", insertable = false, updatable = false)
    private Integrante integrante;

    @Embedded
    private Audit audit = new Audit();
}
