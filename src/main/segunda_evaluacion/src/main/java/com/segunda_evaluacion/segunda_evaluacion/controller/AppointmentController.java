package com.segunda_evaluacion.segunda_evaluacion.controller;

import com.segunda_evaluacion.segunda_evaluacion.dto.AppointmentRequestDTO;
import com.segunda_evaluacion.segunda_evaluacion.model.Appointment;
import com.segunda_evaluacion.segunda_evaluacion.model.Patient;
import com.segunda_evaluacion.segunda_evaluacion.model.Professional;
import com.segunda_evaluacion.segunda_evaluacion.service.AppointmentService;
import com.segunda_evaluacion.segunda_evaluacion.service.PatientService;
import com.segunda_evaluacion.segunda_evaluacion.service.ProfessionalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class AppointmentController {
  private final AppointmentService appointmentService;
  private final PatientService patientService;
  private final ProfessionalService professionalService;

  @Autowired
  public AppointmentController(AppointmentService appointmentService, PatientService patientService,
                               ProfessionalService professionalService
  ){
    this.appointmentService = appointmentService;
    this.patientService = patientService;
    this.professionalService = professionalService;
  }


  @GetMapping
  ResponseEntity<List<Appointment>> getAll(){
    List<Appointment> appointments = appointmentService.findAll();

    return ResponseEntity.ok(appointments);
  }

  @PostMapping
  ResponseEntity<Appointment> createAppointment(@RequestBody @Valid AppointmentRequestDTO dto){

    Optional<Patient> patient = patientService.getPatientById(dto.getPatientId());
    Optional<Professional> professional = professionalService.findProfessionalById(dto.getProfessionalId());

    if (patient.isEmpty() || professional.isEmpty()){
      return ResponseEntity.notFound().build();
    }

    Appointment appointment = new Appointment();
    appointment.setPatient(patient.get());
    appointment.setProfessional(professional.get());
    appointment.setDate(dto.getDate());

    Appointment savedAppointment = appointmentService.createAppointment(appointment);

    return ResponseEntity.status(HttpStatus.CREATED).body(savedAppointment);
  }
  
}
