package com.hackathon.hk_campusland_backend.organizacion_usuarios.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuariosOrganizacionDTO {
    private String username;
    private String nombre;
    private String apellido;
}
