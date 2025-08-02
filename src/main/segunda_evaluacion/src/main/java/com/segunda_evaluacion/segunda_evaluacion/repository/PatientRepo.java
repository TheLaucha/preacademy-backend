package com.segunda_evaluacion.segunda_evaluacion.repository;

import com.segunda_evaluacion.segunda_evaluacion.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {
}
