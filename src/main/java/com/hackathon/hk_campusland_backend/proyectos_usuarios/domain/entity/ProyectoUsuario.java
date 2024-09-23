package com.hackathon.hk_campusland_backend.proyectos_usuarios.domain.entity;

import com.hackathon.hk_campusland_backend.auth.domain.entity.User;
import com.hackathon.hk_campusland_backend.proyectos.domain.entity.Proyecto;
import com.hackathon.hk_campusland_backend.utils.Audit;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "proyectos_usuarios")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProyectoUsuario {
    @EmbeddedId
    private ProyectoUsuarioPK id;

    @ManyToOne
    @JoinColumn(name = "proyecto_id", insertable = false, updatable = false)
    private Proyecto proyecto;

    @ManyToOne
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
    private User usuario;

    @Embedded
    private Audit audit = new Audit();
}
