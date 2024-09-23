package com.hackathon.hk_campusland_backend.direccion_organizacion.domain.entity;

import com.hackathon.hk_campusland_backend.ciudades.domain.entity.Ciudad;
import com.hackathon.hk_campusland_backend.organizaciones.domain.entity.Organizacion;
import com.hackathon.hk_campusland_backend.tipo_direccion.domain.entity.TipoDireccion;
import com.hackathon.hk_campusland_backend.utils.Audit;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "direccion_organizacion")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class DireccionOrganizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Por favor, añade un direccion  para la organizacion")
    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String direccion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organizacion_id")
    private Organizacion organizacion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_direccion_id")
    private TipoDireccion tipoDireccion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ciudad_id")
    private Ciudad ciudad;

    @Embedded
    private Audit audit = new Audit();
}
