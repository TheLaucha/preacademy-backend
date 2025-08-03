package com.segunda_evaluacion.segunda_evaluacion.service;

import com.segunda_evaluacion.segunda_evaluacion.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
  List<Patient> findAll();
  Optional<Patient> getPatientById(Long id);
  Patient savePatient(Patient patient);
  void deletePatient(Long id);
}
