package com.hackathon.hk_campusland_backend.organizacion_usuarios.domain.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class OrganizacionUsuarioPK implements Serializable {
    @Column(name = "organizacion_id")
    private Long organizacion;

    @Column(name = "usuario_id")
    private Long user;
}
