package com.hackathon.hk_campusland_backend.auth.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    @NotBlank(message = "Digita el usuario")
    @Size(min = 8, max = 20, message = "Debe tener minimo 8 caracteres y maximo 20 caracteres")
    String username;

    @NotBlank(message = "Digita la contraseña")
    @Size(min = 8, max = 255, message = "Debe tener minimo 8 caracteres y maximo 255 caracteres")
    String password;
}
