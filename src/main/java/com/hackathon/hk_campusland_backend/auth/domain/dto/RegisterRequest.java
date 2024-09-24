package com.hackathon.hk_campusland_backend.auth.domain.dto;

import java.util.List;

import jakarta.validation.constraints.Email;
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
    @Size(min = 4, max = 20, message = "Debe tener minimo 4 caracteres y maximo 20 caracteres")
    private String username;

    @NotBlank(message = "Por favor, añade una contraseña")
    @Size(min = 4, max = 255, message = "Debe tener minimo 4 caracteres y maximo 255 caracteres")
    private String password;

    @NotBlank(message = "Por favor, añade un nombre")
    @Size(min = 2, max = 20, message = "Debe tener minimo 2 caracteres y maximo 20 caracteres")
    private String nombre;

    @NotBlank(message = "Por favor, añade un apellido")
    @Size(min = 2, max = 20, message = "Debe tener minimo 2 caracteres y maximo 20 caracteres")
    private String apellido;

    @NotBlank(message = "Por favor, añade un email")
    @Size(min = 4, max = 255, message = "Debe tener minimo 4 caracteres y maximo 255 caracteres")
    @Email(message = "Escribe el email, en formato: johndoe@gmail.com")
    private String email;

    // Aquí se incluye el ID del género
    @NotNull(message = "El campo generoId es obligatorio")
    private Long genero;

    // @NotBlank(message = "Por favor, añade un rol")
    private List<String> roles;
}
