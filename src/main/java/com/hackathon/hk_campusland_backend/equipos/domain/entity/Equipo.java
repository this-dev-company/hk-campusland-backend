package com.hackathon.hk_campusland_backend.equipos.domain.entity;

import com.hackathon.hk_campusland_backend.organizaciones.domain.entity.Organizacion;
import com.hackathon.hk_campusland_backend.utils.Audit;

import jakarta.persistence.CascadeType;
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
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "equipos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Equipo {
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organizacion_id")
    private Organizacion organizacion;

    @Embedded
    private Audit audit = new Audit();
}
