package com.segunda_evaluacion.segunda_evaluacion.config;

import com.segunda_evaluacion.segunda_evaluacion.model.Appointment;
import com.segunda_evaluacion.segunda_evaluacion.model.Patient;
import com.segunda_evaluacion.segunda_evaluacion.model.Professional;
import com.segunda_evaluacion.segunda_evaluacion.service.AppointmentService;
import com.segunda_evaluacion.segunda_evaluacion.service.PatientService;
import com.segunda_evaluacion.segunda_evaluacion.service.ProfessionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class TestCargaInicial implements CommandLineRunner {
  private final PatientService patientService;
  private final ProfessionalService professionalService;
  private final AppointmentService appointmentService;

  public void run(String... args) throws Exception{
    // Crear pacientes
    Patient p1 = new Patient();
    p1.setName("Marcos");
    p1.setLastname("Rojo");
    p1.setDni("12345678");
    p1.setEmail("mrojo@gmail.com");
    p1 = patientService.savePatient(p1);

    Patient p2 = new Patient();
    p2.setName("Ander");
    p2.setLastname("Herrera");
    p2.setDni("87654321");
    p2.setEmail("aherrera@example.com");
    p2 = patientService.savePatient(p2);

    // Crear profesionales
    Professional prof1 = new Professional();
    prof1.setFullName("Carlos Lopez");
    prof1.setSpeciality("traumatologia");
    prof1 = professionalService.createProfessional(prof1);

    Professional prof2 = new Professional();
    prof2.setFullName("Ana Martinez");
    prof2.setSpeciality("cardiologia");
    prof2 = professionalService.createProfessional(prof2);


    // Crear turnos
    Appointment turno1 = new Appointment();
    turno1.setPatient(p1);
    turno1.setProfessional(prof1);
    turno1.setDate(LocalDate.now().plusDays(1));
    appointmentService.createAppointment(turno1);

    Appointment turno2 = new Appointment();
    turno2.setPatient(p2);
    turno2.setProfessional(prof2);
    turno2.setDate(LocalDate.now().plusDays(2));
    appointmentService.createAppointment(turno2);

    Appointment turno3 = new Appointment();
    turno3.setPatient(p1);
    turno3.setProfessional(prof2);
    turno3.setDate(LocalDate.now().plusDays(3));
    appointmentService.createAppointment(turno3);
  }
}
