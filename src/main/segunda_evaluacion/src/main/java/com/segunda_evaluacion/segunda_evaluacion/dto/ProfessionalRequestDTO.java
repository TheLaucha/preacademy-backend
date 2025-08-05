package com.segunda_evaluacion.segunda_evaluacion.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProfessionalRequestDTO {
  @NotBlank(message = "El nombre completo es obligatorio")
  @Size(min = 3, max = 100, message = "El campo fullname debe tener una longitud de entre 3 y 100 caracteres")
  private String fullName;

  @NotBlank(message = "La especialidad es obligatoria")
  private String speciality;
}
