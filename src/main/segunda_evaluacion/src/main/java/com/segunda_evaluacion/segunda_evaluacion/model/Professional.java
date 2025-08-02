package com.segunda_evaluacion.segunda_evaluacion.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "professionals")
public class Professional {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "El nombre completo es obligatorio")
  private String fullName;

  @NotBlank(message = "La especialidad es obligatoria")
  private String specialty;
}
