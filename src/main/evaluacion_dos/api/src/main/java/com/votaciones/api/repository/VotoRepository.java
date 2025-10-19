package com.votaciones.api.repository;

import com.votaciones.api.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<Voto, Long> {
  Long countByCandidatoId(Long candidatoId);
  Long countByCandidatoPartidoId(Long partidoId);
}