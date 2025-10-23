package com.votaciones.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "votos")
public class Voto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull(message = "El voto debe estar asociado a un candidato")
  @ManyToOne
  @JoinColumn(name = "candidato_id",nullable = false)
  private Candidato candidato;

  @Column(nullable = false)
  private LocalDateTime fechaEmision;
}
