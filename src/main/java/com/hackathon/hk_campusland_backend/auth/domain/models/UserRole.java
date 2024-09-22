package com.hackathon.hk_campusland_backend.auth.domain.models;

import java.io.Serializable;

import com.hackathon.hk_campusland_backend.auth.domain.dto.UserRolePK;
import com.hackathon.hk_campusland_backend.utils.Audit;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "usuarios_roles")
public class UserRole implements Serializable {

    @EmbeddedId
    private UserRolePK id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
    @MapsId("userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "rol_id", insertable = false, updatable = false)
    @MapsId("rolId")
    private Rol rol;

    @Embedded
    private Audit audit = new Audit();
}
