package com.hackathon.hk_campusland_backend.organizaciones.domain.entity;

import com.hackathon.hk_campusland_backend.auth.domain.models.User;
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
@Table(name = "organizaciones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Organizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Por favor, añade un nombre para la organizacion")
    @Size(min = 5, max = 20, message = "Debe tener minimo 5 caracteres y maximo 20 caracteres")
    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    private String nombre;

    @NotBlank(message = "Por favor, añade una descripcion")
    @Column(columnDefinition = "TEXT", nullable = false)
    private String descripcion;

    @NotBlank(message = "Por favor, añade un alias para la organizacion")
    @Size(min = 5, max = 20, message = "Debe tener minimo 5 caracteres y maximo 20 caracteres")
    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    private String alias;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_creador_id")
    private User Usuario;

    @Embedded
    private Audit audit = new Audit();

}
