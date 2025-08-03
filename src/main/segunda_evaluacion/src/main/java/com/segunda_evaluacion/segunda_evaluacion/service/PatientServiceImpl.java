package com.segunda_evaluacion.segunda_evaluacion.service;

import com.segunda_evaluacion.segunda_evaluacion.model.Patient;
import com.segunda_evaluacion.segunda_evaluacion.repository.PatientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService{
  private final PatientRepo patientRepo;

  @Override
  public List<Patient> findAll() {
    return patientRepo.findAll();
  }

  @Override
  public Optional<Patient> getPatientById(Long id) {
    return patientRepo.findById(id);
  }

  @Override
  public Patient savePatient(Patient patient) {
    return patientRepo.save(patient);
  }

  @Override
  public void deletePatient(Long id) {
    patientRepo.deleteById(id);
  }
}
