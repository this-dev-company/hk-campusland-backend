package com.hackathon.hk_campusland_backend.tareas.domain.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.hackathon.hk_campusland_backend.proyectos.domain.entity.Proyecto;
import com.hackathon.hk_campusland_backend.tipo_tarea.domain.entity.TipoTarea;
import com.hackathon.hk_campusland_backend.utils.Audit;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tareas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Tarea {
    @Id
    @UuidGenerator
    @Column(columnDefinition = "CHAR(36)")
    private UUID id;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String nombre;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String descripcion;

    @Column(name = "fecha_inicio")
    private LocalDateTime startAt;

    @Column(name = "fecha_final")
    private LocalDateTime endAt;

    @Column(name = "horas_estimadas")
    private Integer horasEstimadas;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "proyecto_id")
    private Proyecto proyecto;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_tarea_id")
    private TipoTarea tipoTarea;

    @Embedded
    private Audit audit = new Audit();
}
