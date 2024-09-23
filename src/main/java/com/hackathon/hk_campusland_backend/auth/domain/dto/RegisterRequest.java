package com.hackathon.hk_campusland_backend.auth.domain.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    @NotBlank(message = "Por favor, añade un username")
    @Size(min = 8, max = 20, message = "Debe tener minimo 8 caracteres y maximo 20 caracteres")
    private String username;

    @NotBlank(message = "Por favor, añade una contraseña")
    @Size(min = 8, max = 255, message = "Debe tener minimo 8 caracteres y maximo 255 caracteres")
    private String password;

    @NotBlank(message = "Por favor, añade un nombre")
    @Size(min = 8, max = 255, message = "Debe tener minimo 8 caracteres y maximo 255 caracteres")
    private String nombre;

    @NotBlank(message = "Por favor, añade un apellido")
    @Size(min = 8, max = 255, message = "Debe tener minimo 8 caracteres y maximo 255 caracteres")
    private String apellido;

    @NotBlank(message = "Por favor, añade un email")
    @Size(min = 8, max = 255, message = "Debe tener minimo 8 caracteres y maximo 255 caracteres")
    private String email;

    // private LocalDateTime createdAt;

    // private LocalDateTime updatedAt;

    private List<String> roles;
}
