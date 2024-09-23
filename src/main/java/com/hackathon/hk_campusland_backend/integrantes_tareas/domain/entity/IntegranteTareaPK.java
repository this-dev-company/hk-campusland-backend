package com.hackathon.hk_campusland_backend.integrantes_tareas.domain.entity;

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
public class IntegranteTareaPK implements Serializable{
    @Column(name = "tarea_id")
    private Long tarea;

    @Column(name = "integrante_id")
    private Long integrante;
}
