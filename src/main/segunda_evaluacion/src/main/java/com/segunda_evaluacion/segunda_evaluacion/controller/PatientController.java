package com.segunda_evaluacion.segunda_evaluacion.controller;

import com.segunda_evaluacion.segunda_evaluacion.dto.PatientRequestDTO;
import com.segunda_evaluacion.segunda_evaluacion.exception.RecursoNoEncontradoException;
import com.segunda_evaluacion.segunda_evaluacion.model.Patient;
import com.segunda_evaluacion.segunda_evaluacion.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PatientController {
  private final PatientService patientService;

  @Autowired
  public PatientController(PatientService patientService){
    this.patientService = patientService;
  }

  @GetMapping
  ResponseEntity<List<Patient>> getAllPatients(){
    List<Patient> patients = patientService.findAll();

    return ResponseEntity.ok(patients);
  }

  @GetMapping("/{id}")
  ResponseEntity<Patient> getPatientById(@PathVariable Long id){
    Patient patient =  patientService.getPatientById(id)
        .orElseThrow(() -> new RecursoNoEncontradoException("No se encontro paciente con id: " + id));

    return ResponseEntity.ok(patient);
  }

  @PostMapping
  ResponseEntity<Patient> createPatient(@Valid @RequestBody PatientRequestDTO dto){
    Patient patient = new Patient();
    patient.setName(dto.getName());
    patient.setLastname(dto.getLastname());
    patient.setDni(dto.getDni());
    patient.setEmail(dto.getEmail());

    Patient savedPatient = patientService.savePatient(patient);

    return ResponseEntity.status(HttpStatus.CREATED).body(savedPatient);
  }

  @DeleteMapping("/{id}")
  ResponseEntity<Void> deletePatient(@PathVariable Long id){
    patientService.deletePatient(id);

    return ResponseEntity.noContent().build();
  }

}
