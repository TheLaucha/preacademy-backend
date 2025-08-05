package com.segunda_evaluacion.segunda_evaluacion.dto;

import com.segunda_evaluacion.segunda_evaluacion.model.Patient;
import com.segunda_evaluacion.segunda_evaluacion.model.Professional;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
