package com.segunda_evaluacion.segunda_evaluacion.service;

import com.segunda_evaluacion.segunda_evaluacion.model.Professional;

import java.util.List;
import java.util.Optional;

public interface ProfessionalService {
  Optional<Professional> findProfessionalById(Long id);
  List<Professional> getProfessionals(String speciality);
  Professional createProfessional(Professional professional);
}
