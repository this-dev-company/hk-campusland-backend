package com.hackathon.hk_campusland_backend.auth.domain.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.hackathon.hk_campusland_backend.utils.Audit;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

import org.hibernate.annotations.UuidGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "usuarios")
public class User implements UserDetails {

    @Id
    @UuidGenerator
    @Column(name = "id", unique = true, updatable = false)
    private String id;

    @NotBlank(message = "Añade el nombre de usuario")
    @Column(columnDefinition = "VARCHAR(50)", nullable = false, unique = true)
    private String username;

    @NotBlank(message = "Añade una contraseña")
    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String password;

    @NotBlank(message = "Añade un alias")
    @Column(columnDefinition = "VARCHAR(255)", nullable = false, unique = true)
    private String alias;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<UserRole> roles;

    @Embedded
    private Audit audit = new Audit();

    @Column(columnDefinition = "BOOL", nullable = false)
    private boolean enabled;

    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean admin;

    @PrePersist
    public void prePersist() {
        enabled = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Convertir los roles a GrantedAuthority
        return roles.stream()
                    .map(role -> new SimpleGrantedAuthority(role.getRol().getRol())) 
                    .toList(); 
    }
}
