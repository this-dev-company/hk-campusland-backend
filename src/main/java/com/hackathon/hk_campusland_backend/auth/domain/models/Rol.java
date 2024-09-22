package com.hackathon.hk_campusland_backend.auth.domain.models;


import com.hackathon.hk_campusland_backend.utils.Audit;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    @UuidGenerator
    @Column(name = "id", unique = true, updatable = false)
    private String id;

    @NotBlank(message = "Por favor, añade un nombre para el rol")
    @Column(columnDefinition = "VARCHAR(50)", nullable = false, unique = true)
    private String rol;

    @OneToMany(mappedBy = "rol", cascade = CascadeType.PERSIST)
    private List<UserRole> users;

    @Embedded
    private Audit audit = new Audit();
}   
