package com.hackathon.hk_campusland_backend.proyectos.domain.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizacionDTO {
    private String nombre;
    private List<ProyectoDTO> proyectos;
}
