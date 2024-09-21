package com.hackathon.hk_campusland_backend.auth.domain.models;

import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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
    @UuidGenerator
    private String id;

    @NotBlank(message = "Por favor, añade un nombre para el rol")
    @Column(columnDefinition = "VARCHAR(50)", nullable = false, unique = true)
    private String rol;

    @JsonIgnoreProperties({"roles", "handler", "hibernateLazyInitializer"})
    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}   
