package com.segunda_evaluacion.segunda_evaluacion.service;

import com.segunda_evaluacion.segunda_evaluacion.model.Professional;

import java.util.List;

public interface ProfessionalService {
  List<Professional> getProfessionals(String speciality);
  Professional createProfessional(Professional professional);
}
