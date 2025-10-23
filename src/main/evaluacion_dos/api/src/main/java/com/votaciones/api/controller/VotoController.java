package com.votaciones.api.controller;

import com.votaciones.api.dto.VotoRequestDTO;
import com.votaciones.api.exception.ResourceNotFoundException;
import com.votaciones.api.model.Candidato;
import com.votaciones.api.model.Voto;
import com.votaciones.api.service.CandidatoService;
import com.votaciones.api.service.VotoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/votos")
@Tag(name = "Votos", description = "API para registroy consulta de votos")
public class VotoController {
  private final VotoService votoService;
  private final CandidatoService candidatoService;

  @Operation(summary = "Registrar un nuevo voto")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Voto registrado exitosamente"),
      @ApiResponse(responseCode = "404", description = "Candidato no encontrado")
  })
  @PostMapping
  public ResponseEntity <Voto> registrar(@RequestBody @Valid VotoRequestDTO dto){
    // Validar que el candidato existe
    Candidato candidato = candidatoService.obtenerPorId(dto.getCandidatoId())
        .orElseThrow(() -> new ResourceNotFoundException("No se encuentra candidato con id: " + dto.getCandidatoId()));

    // Crear el voto
    Voto voto = new Voto();
    voto.setCandidato(candidato);
    voto.setFechaEmision(LocalDateTime.now());

    // Guardar en base de datos
    Voto votoCreado = votoService.crear(voto);

    return ResponseEntity.status(HttpStatus.CREATED).body(votoCreado);
  }

  
}
