package com.hackathon.hk_campusland_backend.organizacion_usuarios.domain.entity;

import com.hackathon.hk_campusland_backend.auth.domain.models.User;
import com.hackathon.hk_campusland_backend.organizaciones.domain.entity.Organizacion;
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
@Table(name = "organizacion_usuarios")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class OrganizacionUsuario {
    @EmbeddedId
    private OrganizacionUsuarioPK id;

    @ManyToOne
    @JoinColumn(name = "organizacion_id", insertable = false, updatable = false)
    private Organizacion organizacion;

    @ManyToOne
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
    private User user;

    @Embedded
    private Audit audit = new Audit();
}
