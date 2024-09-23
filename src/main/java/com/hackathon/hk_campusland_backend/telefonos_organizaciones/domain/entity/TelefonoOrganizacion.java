package com.hackathon.hk_campusland_backend.telefonos_organizaciones.domain.entity;

import com.hackathon.hk_campusland_backend.organizaciones.domain.entity.Organizacion;
import com.hackathon.hk_campusland_backend.tipos_telefonos.domain.entity.TipoTelefono;
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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "telefonos_organizaciones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TelefonoOrganizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Por favor, añade un numero  para la organizacion")
    @Column(nullable = false)
    private String numero;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organizacion_id")
    private Organizacion organizacion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_telefono_id")
    private TipoTelefono tipoTelefono;

    @Embedded
    private Audit audit = new Audit();
}
