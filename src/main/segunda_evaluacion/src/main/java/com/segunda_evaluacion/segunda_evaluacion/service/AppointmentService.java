package com.segunda_evaluacion.segunda_evaluacion.service;

import com.segunda_evaluacion.segunda_evaluacion.model.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {
  List<Appointment> findAll();
  List<Appointment> findByDate(LocalDate date);
  Appointment createAppointment(Appointment appointment);
  void deleteAppointment(Long id);
}
