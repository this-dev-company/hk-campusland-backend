package com.hackathon.hk_campusland_backend.auth.domain.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.hackathon.hk_campusland_backend.generos.domain.entity.Genero;
import com.hackathon.hk_campusland_backend.utils.Audit;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "BOOL", nullable = false)
    private boolean enabled;

    @NotBlank(message = "Por favor, añade el nombre de usuario")
    @Column(columnDefinition = "VARCHAR(20)", nullable = false, unique = true)
    @Size(min = 4, max = 20, message = "Debe tener minimo 4 caracteres y maximo 20 caracteres")
    private String username;

    @NotBlank(message = "Por favor, añade una contraseña")
    @Size(min = 4, max = 255, message = "Debe tener minimo 4 caracteres y maximo 255 caracteres")
    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String password;

    @NotBlank(message = "Por favor, añade un nombre  para la persona")
    @Size(min = 2, max = 20, message = "Debe tener minimo 2 caracteres y maximo 20 caracteres")
    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    private String nombre;

    @NotBlank(message = "Por favor, añade un apellido  para la persona")
    @Size(min = 2, max = 20, message = "Debe tener minimo 2 caracteres y maximo 20 caracteres")
    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    private String apellido;

    @NotBlank(message = "Por favor, añade un email  para la persona")
    @Size(min = 2, max = 20, message = "Debe tener minimo 2 caracteres y maximo 20 caracteres")
    @Column(columnDefinition = "VARCHAR(255)", nullable = false, unique = true) 
    @Email(message = "Escribe el email, en formato: johndoe@gmail.com")
    private String email;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;

    @Embedded
    private Audit audit = new Audit();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "usuarios_roles", 
        joinColumns = @JoinColumn(name = "usuario_id"), 
        inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private List<Rol> roles;

    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean admin;

    @PrePersist
    public void prePersist() {
        enabled = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                    .map(role -> new SimpleGrantedAuthority(role.getRol())) 
                    .toList(); 
    }
}
