package com.hackathon.hk_campusland_backend.integrantes_tareas.domain.entity;

import com.hackathon.hk_campusland_backend.integrantes.domain.entity.Integrante;
import com.hackathon.hk_campusland_backend.tareas.domain.entity.Tarea;
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
@Table(name = "integrantes_tareas")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class IntegranteTarea {
    @EmbeddedId
    private IntegranteTareaPK id;

    @ManyToOne
    @JoinColumn(name = "tarea_id", insertable = false, updatable = false)
    private Tarea tarea;

    @ManyToOne
    @JoinColumn(name = "integrante_id", insertable = false, updatable = false)
    private Integrante integrante;

    @Embedded
    private Audit audit = new Audit();
}
