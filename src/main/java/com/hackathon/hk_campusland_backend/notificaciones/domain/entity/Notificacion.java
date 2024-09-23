package com.hackathon.hk_campusland_backend.notificaciones.domain.entity;

import com.hackathon.hk_campusland_backend.auth.domain.models.User;
import com.hackathon.hk_campusland_backend.tareas.domain.entity.Tarea;
import com.hackathon.hk_campusland_backend.utils.Audit;

import jakarta.persistence.Column;
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
@Table(name = "notificaciones")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Notificacion {
    @EmbeddedId
    private NotificacionPK id;

    @ManyToOne
    @JoinColumn(name = "tarea_id", insertable = false, updatable = false)
    private Tarea tarea;

    @ManyToOne
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
    private User usuario;

    @Column(name = "leido", nullable = false, columnDefinition = "boolean default false")
    private boolean leido = false;  

    @Embedded
    private Audit audit = new Audit();
}
