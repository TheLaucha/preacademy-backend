package com.segunda_evaluacion.segunda_evaluacion.controller;

import com.segunda_evaluacion.segunda_evaluacion.model.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

  @GetMapping
  ResponseEntity<List<Patient>> getAllPatients(){
    List<Patient> patients = List.of(new Patient(), new Patient(), new Patient());

    return ResponseEntity.ok(patients);
  }

  @GetMapping("/{id}")
  ResponseEntity<Patient> getPatientById(@PathVariable Long patientId){
    Patient patient = new Patient();

    return ResponseEntity.ok(patient);
  }
}
