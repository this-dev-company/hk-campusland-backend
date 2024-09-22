package com.hackathon.hk_campusland_backend.organizaciones.domain.entity;

import org.hibernate.annotations.UuidGenerator;
import java.util.UUID;

import com.hackathon.hk_campusland_backend.utils.Audit;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "organizaciones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Organizacion {
    @Id
    @UuidGenerator
    @Column(columnDefinition = "CHAR(36)")
    private UUID id;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String nombre;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String descripcion;

    @Column(columnDefinition = "VARCHAR(30)", nullable = false)
    private String alias;

    // @ManyToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "creador_id")
    // private Persona persona;

    @Embedded
    private Audit audit = new Audit();

}
