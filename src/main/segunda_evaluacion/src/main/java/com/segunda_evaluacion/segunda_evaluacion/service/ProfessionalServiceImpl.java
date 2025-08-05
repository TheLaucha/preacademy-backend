package com.segunda_evaluacion.segunda_evaluacion.service;

import com.segunda_evaluacion.segunda_evaluacion.model.Professional;
import com.segunda_evaluacion.segunda_evaluacion.repository.ProfessionalRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessionalServiceImpl implements ProfessionalService{
  private final ProfessionalRepo professionalRepo;

  @Override
  public Optional<Professional> findProfessionalById(Long id) {
    return professionalRepo.findById(id);
  }

  @Override
  public List<Professional> getProfessionals(String speciality) {
    if(speciality == null || speciality.isBlank()){
      return professionalRepo.findAll();
    }

    return professionalRepo.findBySpeciality(speciality);
  }

  @Override
  public Professional createProfessional(Professional professional) {
    return professionalRepo.save(professional);
  }
}
