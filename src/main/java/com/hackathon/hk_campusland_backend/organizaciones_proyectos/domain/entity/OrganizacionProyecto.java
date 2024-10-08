package com.hackathon.hk_campusland_backend.organizaciones_proyectos.domain.entity;

import com.hackathon.hk_campusland_backend.organizaciones.domain.entity.Organizacion;
import com.hackathon.hk_campusland_backend.proyectos.domain.entity.Proyecto;
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
@Table(name = "organizaciones_proyectos")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class OrganizacionProyecto {
    @EmbeddedId
    private OrganizacionProyectoPK id;

    @ManyToOne
    @JoinColumn(name = "organizacion_id", insertable = false, updatable = false)
    private Organizacion organizacion;

    @ManyToOne
    @JoinColumn(name = "proyecto_id", insertable = false, updatable = false)
    private Proyecto proyecto;

    @Embedded
    private Audit audit = new Audit();
}
