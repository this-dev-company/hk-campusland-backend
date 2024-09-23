package com.hackathon.hk_campusland_backend.usuarios_equipos.domain.entity;

import com.hackathon.hk_campusland_backend.auth.domain.models.User;
import com.hackathon.hk_campusland_backend.equipos.domain.entity.Equipo;
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
@Table(name = "usuarios_equipos")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UsuarioEquipo {
@EmbeddedId
    private UsuarioEquipoPK id;

    @ManyToOne
    @JoinColumn(name = "equipo_id", insertable = false, updatable = false)
    private Equipo equipo;

    @ManyToOne
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
    private User user;

    @Embedded
    private Audit audit = new Audit();
}
