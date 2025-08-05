package com.segunda_evaluacion.segunda_evaluacion.repository;

import com.segunda_evaluacion.segunda_evaluacion.model.Appointment;
import com.segunda_evaluacion.segunda_evaluacion.model.Patient;
import com.segunda_evaluacion.segunda_evaluacion.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
  List<Appointment> findByDate(LocalDate date);
  Boolean existsByPatientAndProfessionalAndDate(Patient patient, Professional professional, LocalDate date);
}
