package com.hackathon.hk_campusland_backend.auth.domain.models;

import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "usuarios")
public class User implements Serializable {

    @Id
    @UuidGenerator
    private String id;

    @NotBlank(message = "Añade el nombre de usuario")
    @Column(columnDefinition = "VARCHAR(50)", nullable = false, unique = true)
    private String username;

    @NotBlank(message = "Añade una contraseña")
    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String password;

    @NotBlank(message = "Añade un alias")
    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String alias;

    @OneToMany(mappedBy = "", cascade = CascadeType.PERSIST)
    private List<User_Role> roles;

}
