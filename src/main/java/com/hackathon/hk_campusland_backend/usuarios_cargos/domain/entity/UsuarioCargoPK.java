package com.hackathon.hk_campusland_backend.usuarios_cargos.domain.entity;

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
public class UsuarioCargoPK implements Serializable{
    @Column(name = "cargo_id")
    private Long cargo;

    @Column(name = "usuario_id")
    private Long usuario;
}
