package com.segunda_evaluacion.segunda_evaluacion.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "El nombre es obligatorio")
  private String name;

  @NotBlank(message = "El apellido es obligatorio")
  private String lastname;

  @NotBlank(message = "El dni es obligatorio")
  @Size(min = 7, max = 10, message = "El DNI debe tener entre 7 y 10 caracteres")
  private String dni;

  @NotBlank(message = "El email es obligatorio")
  @Email(message = "El formato de email no es valido")
  private String email;
}
