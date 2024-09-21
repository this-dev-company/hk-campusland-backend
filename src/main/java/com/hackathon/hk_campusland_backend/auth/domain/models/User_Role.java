package com.hackathon.hk_campusland_backend.auth.domain.models;

import java.io.Serializable;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class User_Role implements Serializable {

    @Column(name = "usuario_id")
    private String userId;

    @Column(name = "rol_id")
    private String rolId;

    
}
