package com.segunda_evaluacion.segunda_evaluacion.controller;

import com.segunda_evaluacion.segunda_evaluacion.dto.ProfessionalRequestDTO;
import com.segunda_evaluacion.segunda_evaluacion.model.Professional;
import com.segunda_evaluacion.segunda_evaluacion.service.ProfessionalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesionales")
public class ProfessionalController {
  private final ProfessionalService professionalService;

  @Autowired
  public ProfessionalController(ProfessionalService professionalService){
    this.professionalService = professionalService;
  }

  @GetMapping
  ResponseEntity<List<Professional>> getProfessionals(@RequestParam(required = false) String especialidad){
    List<Professional> professionals = professionalService.getProfessionals(especialidad);

    return ResponseEntity.ok(professionals);
  }

  @PostMapping
  ResponseEntity<Professional> createProfessional(@RequestBody @Valid ProfessionalRequestDTO dto){
    Professional professional = new Professional();
    professional.setFullName(dto.getFullName());
    professional.setSpeciality(dto.getSpeciality());

    Professional savedProfessional = professionalService.createProfessional(professional);

    return ResponseEntity.status(HttpStatus.CREATED).body(savedProfessional);
  }
}
