package com.hackathon.hk_campusland_backend.tipo_direccion.domain.entity;

import com.hackathon.hk_campusland_backend.utils.Audit;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tipo_direccion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TipoDireccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String tipo;

    @Embedded
    private Audit audit = new Audit();
}
