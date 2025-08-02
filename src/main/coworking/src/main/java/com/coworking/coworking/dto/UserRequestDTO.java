package com.coworking.coworking.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequestDTO {
  @NotBlank(message = "El nombre completo es obligatorio")
  @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
  private String fullName;

  @NotBlank(message = "El email es obligatorio")
  @Email(message = "Debe ser un email valido")
  private String email;
}
