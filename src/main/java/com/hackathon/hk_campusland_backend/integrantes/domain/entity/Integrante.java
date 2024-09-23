package com.hackathon.hk_campusland_backend.integrantes.domain.entity;

import com.hackathon.hk_campusland_backend.personas.domain.entity.Persona;
import com.hackathon.hk_campusland_backend.utils.Audit;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "integrantes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Integrante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_id")
    private Persona persona;

    @Embedded
    private Audit audit = new Audit();
}
