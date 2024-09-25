package com.hackathon.hk_campusland_backend.comentarios_tareas.domain.entity;

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
@Table(name = "comentarios_tareas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ComentarioTarea {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Por favor, escribe el comentario")
    @Column(columnDefinition = "TEXT", nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "tarea_id")
    private Tarea tarea;
    
    @Embedded
    private Audit audit = new Audit();
}
