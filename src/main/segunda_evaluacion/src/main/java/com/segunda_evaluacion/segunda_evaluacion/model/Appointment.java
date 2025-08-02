package com.segunda_evaluacion.segunda_evaluacion.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "appointments")
public class Appointment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "patient_id")
  @NotNull
  private Patient patient;

  @ManyToOne
  @JoinColumn(name = "professional_id")
  @NotNull
  private Professional professional;

  @NotNull(message = "La fecha del turno es obligatoria")
  private LocalDate date;
}
