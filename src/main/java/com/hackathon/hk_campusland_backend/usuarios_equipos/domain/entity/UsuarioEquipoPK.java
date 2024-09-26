package com.hackathon.hk_campusland_backend.usuarios_equipos.domain.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class UsuarioEquipoPK implements Serializable{
    @Column(name = "equipo_id")
    private Long equipo;

    @Column(name = "usuario_id")
    private Long usuario;
}
