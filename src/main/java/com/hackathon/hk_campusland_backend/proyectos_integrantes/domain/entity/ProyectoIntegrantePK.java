package com.hackathon.hk_campusland_backend.proyectos_integrantes.domain.entity;

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
public class ProyectoIntegrantePK implements Serializable{
    @Column(name = "proyecto_id")
    private Long proyecto;

    @Column(name = "integrante_id")
    private Long integrante;
}
