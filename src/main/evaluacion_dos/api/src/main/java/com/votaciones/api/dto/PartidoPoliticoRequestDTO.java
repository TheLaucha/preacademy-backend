package com.votaciones.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PartidoPoliticoRequestDTO {
  @NotBlank(message = "El nombre del partido no puede estar vacío")
  @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
  private String nombre;

  @NotBlank(message = "La sigla no puede estar vacía")
  @Size(min = 2, max = 10, message = "La sigla debe tener entre 2 y 10 caracteres")
  private String sigla;
}
