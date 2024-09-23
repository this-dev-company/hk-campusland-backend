package com.hackathon.hk_campusland_backend.auth.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hackathon.hk_campusland_backend.utils.Audit;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Por favor, añade un nombre para el rol")
    @Size(min = 2, max = 20, message = "Debe tener minimo 2 caracteres y maximo 20 caracteres")
    @Column(columnDefinition = "VARCHAR(20)", nullable = false, unique = true)
    private String rol;

    @JsonIgnoreProperties({"roles", "handler", "hibernateLazyInitializer"})
    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    @Embedded
    private Audit audit = new Audit();
}   
