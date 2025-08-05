package com.segunda_evaluacion.segunda_evaluacion.service;

import com.segunda_evaluacion.segunda_evaluacion.model.Appointment;
import com.segunda_evaluacion.segunda_evaluacion.repository.AppointmentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService{
  private final AppointmentRepo appointmentRepo;

  @Override
  public List<Appointment> findAll() {
    return appointmentRepo.findAll();
  }

  @Override
  public List<Appointment> findByDate(LocalDate date) {
    return appointmentRepo.findByDate(date);
  }

  @Override
  public Appointment createAppointment(Appointment appointment) {
    boolean exists = appointmentRepo.existsByPatientAndProfessionalAndDate(
        appointment.getPatient(),
        appointment.getProfessional(),
        appointment.getDate()
    );

    if (exists){
      throw new IllegalArgumentException("Ya existe un turno para ese paciente, profesional y fecha");
    }

    return appointmentRepo.save(appointment);
  }

  @Override
  public void deleteAppointment(Long id) {
    appointmentRepo.deleteById(id);
  }
}
