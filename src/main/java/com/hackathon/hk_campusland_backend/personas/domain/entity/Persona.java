package com.hackathon.hk_campusland_backend.personas.domain.entity;

import com.hackathon.hk_campusland_backend.auth.domain.models.User;
import com.hackathon.hk_campusland_backend.generos.domain.entity.Genero;
import com.hackathon.hk_campusland_backend.paises.domain.entity.Pais;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "personas")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Por favor, añade un nombre  para la persona")
    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String nombre;

    @NotBlank(message = "Por favor, añade un apellido  para la persona")
    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String apellido;

    @NotBlank(message = "Por favor, añade un email  para la persona")
    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String email;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genero_id")
    private Genero genero;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pais_id")
    private Pais pais;

    @Embedded
    private Audit audit = new Audit();
}
