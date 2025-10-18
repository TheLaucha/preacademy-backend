package com.votaciones.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "partidos_politicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PartidoPolitico {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "El nombre del partido no puede estar vacio")
  @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
  @Column(nullable = false, length = 100)
  private String nombre;

  @NotBlank(message = "La sigla no puede estar vacia")
  @Size(min = 2, max = 10, message = "La sigla debe tener entre 2 y 10 caracteres")
  @Column(nullable = false, unique = true ,length = 10)
  private String sigla;
}
