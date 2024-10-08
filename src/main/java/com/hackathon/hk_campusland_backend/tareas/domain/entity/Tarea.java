package com.hackathon.hk_campusland_backend.tareas.domain.entity;

import java.time.LocalDateTime;

import com.hackathon.hk_campusland_backend.proyectos.domain.entity.Proyecto;
import com.hackathon.hk_campusland_backend.tipo_tarea.domain.entity.TipoTarea;
import com.hackathon.hk_campusland_backend.utils.Audit;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Por favor, añade un nombre para la tarea")
    @Size(min = 2, max = 100, message = "Debe tener minimo 2 caracteres y maximo 100 caracteres")
    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String nombre;

    @NotBlank(message = "Por favor, añade una descripcion")
    @Column(columnDefinition = "TEXT", nullable = false)
    private String descripcion;

    @NotNull(message = "Por favor, añade una fecha de inicio")
    @Column(name = "fecha_inicio")
    private LocalDateTime startAt;

    @NotNull(message = "Por favor, añade una fecha final")
    @Column(name = "fecha_final")
    private LocalDateTime endAt;

    @NotNull(message = "Por favor, añade las horas estimadas")
    @Column(name = "horas_estimadas")
    private Integer horasEstimadas;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "proyecto_id")
    private Proyecto proyecto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_tarea_id")
    private TipoTarea tipoTarea;

    @Enumerated(EnumType.STRING)  
    @Column(name = "estado_tarea", nullable = false)
    private EstadoTarea estadoTarea;

    @Embedded
    private Audit audit = new Audit();
}
