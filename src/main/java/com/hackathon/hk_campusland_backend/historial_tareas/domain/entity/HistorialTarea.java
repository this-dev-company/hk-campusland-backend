package com.hackathon.hk_campusland_backend.historial_tareas.domain.entity;

import com.hackathon.hk_campusland_backend.tareas.domain.entity.Tarea;
import com.hackathon.hk_campusland_backend.utils.Audit;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Por favor, añade una descripcion")
    @Column(columnDefinition = "TEXT", nullable = false)
    private String descripcion;
    
    @NotBlank(message = "Por favor, añade cantidad de horas")
    @Column(columnDefinition = "INT",nullable = false)
    private int horas = 0;

    @ManyToOne
    @JoinColumn(name = "tarea_id")
    private Tarea tarea;
    
    @Embedded
    private Audit audit = new Audit();
}
