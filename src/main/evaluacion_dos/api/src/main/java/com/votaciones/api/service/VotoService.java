package com.votaciones.api.service;

import com.votaciones.api.model.Voto;
import com.votaciones.api.repository.VotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VotoService {
  private final VotoRepository votoRepo;

  public Voto crear(Voto voto){
    return votoRepo.save(voto);
  }

  public Long contarVotosPorCandidato(Long id){
    return votoRepo.countByCandidatoId(id);
  }

  public Long contarVotosPorPartido(Long id){
    return votoRepo.countByCandidatoPartidoId(id);
  }
}
