package com.votaciones.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CandidatoRequestDTO {
  @NotBlank(message = "El nombre completo no puede estar vacio")
  @Size(min = 5, max = 100, message = "El nombre debe tener entre 5 y 100 caracteres")
  private String nombreCompleto;

  @NotNull(message = "Debe especificarse el ID del partido al que pertenece el candidato")
  private Long partidoId;
}
