package com.votaciones.api.service;

import com.votaciones.api.exception.ResourceNotFoundException;
import com.votaciones.api.model.PartidoPolitico;
import com.votaciones.api.repository.PartidoPoliticoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

  public PartidoPolitico obtenerPartidoPorId(Long id){
    return partidoRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No se encontro partido con id: " + id));
  }

  public void eliminar(Long id){
    PartidoPolitico partido = partidoRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No existe partido con id: " + id));
    partidoRepo.delete(partido);
  }
}
