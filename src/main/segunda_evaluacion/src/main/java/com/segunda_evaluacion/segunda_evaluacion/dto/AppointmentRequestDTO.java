package com.segunda_evaluacion.segunda_evaluacion.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AppointmentRequestDTO {
  @NotNull(message = "El ID del paciente es obligatorio")
  private Long patientId;

  @NotNull(message = "El ID del profesional es obligatorio")
  private Long professionalId;

  @NotNull(message = "La fecha del turno es obligatoria")
  private LocalDate date;

}
