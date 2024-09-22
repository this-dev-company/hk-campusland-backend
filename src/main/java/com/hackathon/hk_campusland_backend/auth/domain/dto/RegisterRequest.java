package com.hackathon.hk_campusland_backend.auth.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "El usuario no puede ser nulo")
    @Size(min = 8, max = 20, message = "Debe tener minimo 8 caracteres y maximo 20 caracteres")
    private String username;

    @NotBlank(message = "Por favor, añade una contraseña")
    @NotNull(message = "la contraseña no puede ser nula")
    @Size(min = 8, max = 255, message = "Debe tener minimo 8 caracteres y maximo 255 caracteres")
    private String password;

    @NotBlank(message = "Por favor, añade un alias")
    @NotNull(message = "El alias no puede ser nulo")
    @Size(min = 8, max = 20, message = "Debe tener minimo 8 caracteres y maximo 20 caracteres")
    private String alias;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private List<String> roles;
}
