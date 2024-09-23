package com.hackathon.hk_campusland_backend.generos.domain.entity;

import com.hackathon.hk_campusland_backend.utils.Audit;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "generos")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Por favor, añade un nombre  para el genero")
    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String nombre;

    @Embedded
    private Audit audit = new Audit();
}
