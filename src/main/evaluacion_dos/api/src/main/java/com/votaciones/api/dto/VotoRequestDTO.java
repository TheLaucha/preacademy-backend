package com.votaciones.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VotoRequestDTO {
  @NotNull(message = "El ID del candidato es obligatorio")
  private Long candidatoId;
}
