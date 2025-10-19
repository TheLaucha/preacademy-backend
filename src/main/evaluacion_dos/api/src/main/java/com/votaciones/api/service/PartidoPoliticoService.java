package com.votaciones.api.service;

import com.votaciones.api.model.PartidoPolitico;
import com.votaciones.api.repository.PartidoPoliticoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PartidoPoliticoService {
  private final PartidoPoliticoRepository partidoRepo;

  public PartidoPolitico crear(PartidoPolitico partido) {
    return partidoRepo.save(partido);
  }

  public List<PartidoPolitico> obtenerTodos(){
    return partidoRepo.findAll();
  }

  public Optional<PartidoPolitico> obtenerPartidoPorId(Long id){
    return partidoRepo.findById(id);
  }

  public void eliminar(Long id){
    partidoRepo.deleteById(id);
  }
}
