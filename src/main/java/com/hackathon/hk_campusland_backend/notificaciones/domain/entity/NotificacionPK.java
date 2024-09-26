package com.hackathon.hk_campusland_backend.notificaciones.domain.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class NotificacionPK implements Serializable{
    @Column(name = "tarea_id")
    private Long tarea;

    @Column(name = "usuario_id")
    private Long usuario;
}
