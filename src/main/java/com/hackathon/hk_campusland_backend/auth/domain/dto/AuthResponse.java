package com.hackathon.hk_campusland_backend.auth.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    String token;
    private Long id;      
    private String username;
    private String nombre;
    private String apellido;
    private String email;
}
