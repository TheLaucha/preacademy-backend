package com.votaciones.api.service;

import com.votaciones.api.model.Candidato;
import com.votaciones.api.repository.CandidatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CandidatoService {
  private final CandidatoRepository candidatoRepo;

  public Candidato crear(Candidato candidato){
    return candidatoRepo.save(candidato);
  }

  public List<Candidato> obtenerTodos(){
    return candidatoRepo.findAll();
  }

  public Optional<Candidato> obtenerPorId(Long id){
    return candidatoRepo.findById(id);
  }

  public void eliminar(Long id){
    candidatoRepo.deleteById(id);
  }
}
