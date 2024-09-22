package com.hackathon.hk_campusland_backend.auth.domain.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hackathon.hk_campusland_backend.utils.Audit;

import java.io.Serializable;
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "roles")
public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Por favor, añade un nombre para el rol")
    @Column(columnDefinition = "VARCHAR(50)", nullable = false, unique = true)
    private String rol;

    @JsonIgnoreProperties({"roles", "handler", "hibernateLazyInitializer"})
    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    @Embedded
    private Audit audit = new Audit();
}   
