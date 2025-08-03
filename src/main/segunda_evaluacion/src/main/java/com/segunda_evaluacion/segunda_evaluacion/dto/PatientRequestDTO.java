package com.segunda_evaluacion.segunda_evaluacion.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PatientRequestDTO {
  @NotBlank(message = "El nombre es obligatorio")
  @Size(min = 3, max = 20, message = "El nombre debe tener entre 3 y 20 caracteres")
  private String name;

  @NotBlank(message = "El apellido es obligatorio")
  @Size(min = 3, max = 20, message = "El apellido debe tener entre 3 y 20 caracteres")
  private String lastname;

  @NotBlank(message = "El dni es obligatorio")
  @Size(min = 7, max = 10, message = "El DNI debe tener entre 7 y 10 caracteres")
  private String dni;

  @NotBlank(message = "El email es obligatorio")
  @Email(message = "El formato de email no es valido")
  private String email;
}
