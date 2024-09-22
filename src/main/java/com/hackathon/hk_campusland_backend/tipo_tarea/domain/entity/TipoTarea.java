package com.hackathon.hk_campusland_backend.tipo_tarea.domain.entity;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

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
@Table(name = "tipo_tarea")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TipoTarea {

    @Id
    @UuidGenerator
    @Column(columnDefinition = "CHAR(36)")
    private UUID id;

    @Column(columnDefinition = "VARCHAR(30)", nullable = false)
    private String tipo;

    @Embedded
    private Audit audit = new Audit();
}
