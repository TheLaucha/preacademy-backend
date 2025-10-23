package com.votaciones.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "candidatos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Candidato {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "El nombre completo no puede estar vacio")
  @Size(min = 5, max = 100, message = "El nombre debe tener entre 5 y 100 caracteres")
  @Column(nullable = false, length = 100)
  private String nombreCompleto;

  @NotNull(message = "El candidato debe pertencer a un partido")
  @ManyToOne
  @JoinColumn(name = "partido_id", nullable = false)
  private PartidoPolitico partido;
}
