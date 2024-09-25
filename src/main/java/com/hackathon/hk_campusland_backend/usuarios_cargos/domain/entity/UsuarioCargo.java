package com.hackathon.hk_campusland_backend.usuarios_cargos.domain.entity;

import com.hackathon.hk_campusland_backend.auth.domain.entity.User;
import com.hackathon.hk_campusland_backend.cargos.domain.entity.Cargo;
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
@Table(name = "usuarios_cargos")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UsuarioCargo {
    @EmbeddedId
    private UsuarioCargoPK id;

    @ManyToOne
    @JoinColumn(name = "cargo_id", insertable = false, updatable = false)
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
    private User usuario;

    @Embedded
    private Audit audit = new Audit();
}
