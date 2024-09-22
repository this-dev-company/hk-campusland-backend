package com.hackathon.hk_campusland_backend.historial_tareas.domain.entity;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.hackathon.hk_campusland_backend.tareas.domain.entity.Tarea;
import com.hackathon.hk_campusland_backend.utils.Audit;

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
@Table(name = "historial_tareas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HistorialTarea {

    @Id
    @UuidGenerator
    @Column(columnDefinition = "CHAR(36)")
    private UUID id;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Long horas = 0L;

    @ManyToOne
    @JoinColumn(name = "tarea_id")
    private Tarea tarea;
    
    @Embedded
    private Audit audit = new Audit();
}
