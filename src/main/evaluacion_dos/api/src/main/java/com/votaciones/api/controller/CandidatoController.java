package com.votaciones.api.controller;

import com.votaciones.api.dto.CandidatoRequestDTO;
import com.votaciones.api.exception.ResourceNotFoundException;
import com.votaciones.api.model.Candidato;
import com.votaciones.api.model.PartidoPolitico;
import com.votaciones.api.service.CandidatoService;
import com.votaciones.api.service.PartidoPoliticoService;
import com.votaciones.api.service.VotoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/candidatos")
@RequiredArgsConstructor
@Tag(name = "Candidatos", description = "API para gestion de candidatos")
public class CandidatoController {
  private final CandidatoService candidatoService;
  private final VotoService votoService;
  private final PartidoPoliticoService partidoService;

  @Operation(summary = "Crear un nuevo candidato")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Candidato creado exitosamente"),
      @ApiResponse(responseCode = "400", description = "Datos inválidos")
  })
  @PostMapping
  public ResponseEntity<Candidato> crear(@Valid @RequestBody CandidatoRequestDTO dto) {
    PartidoPolitico partido = partidoService.obtenerPartidoPorId(dto.getPartidoId())
        .orElseThrow(() -> new ResourceNotFoundException("No se encontro partido con id: " + dto.getPartidoId()));


    Candidato candidato = new Candidato();
    candidato.setNombreCompleto(dto.getNombreCompleto());
    candidato.setPartido(partido);

    Candidato candidatoCreado = candidatoService.crear(candidato);
    return ResponseEntity.status(HttpStatus.CREATED).body(candidatoCreado);
  }

  @Operation(summary = "Obtener todos los candidatos")
  @ApiResponse(responseCode = "200", description = "Lista de candidatos obtenida")
  @GetMapping
  public ResponseEntity<List<Candidato>>obtenerTodos() {
    List<Candidato> candidatos = candidatoService.obtenerTodos();
    return ResponseEntity.ok(candidatos);
  }

  @Operation(summary = "Obtener un candidato por ID")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Candidato encontrado"),
      @ApiResponse(responseCode = "404", description = "Candidato no encontrado")
  })
  @GetMapping("/{id}")
  public ResponseEntity<Candidato> obtenerPorId(
      @Parameter(description = "ID del candidato") @PathVariable Long id) {
    Candidato candidato = candidatoService.obtenerPorId(id).
        orElseThrow(() -> new ResourceNotFoundException("No se encontro candidato con id: " + id));
    return ResponseEntity.ok(candidato);
  }

  @Operation(summary = "Eliminar un candidato")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "204", description = "Candidato eliminado"),
      @ApiResponse(responseCode = "404", description = "Candidato no encontrado")
  })
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminar(@PathVariable Long id) {
    candidatoService.eliminar(id);
    return ResponseEntity.noContent().build();
  }

  @Operation(summary = "Consultar votos de un candidato")
  @ApiResponse(responseCode = "200", description = "Cantidad de votos obtenida")
  @GetMapping("/{id}/votos")
  public ResponseEntity<Map<String, Object>> consultarVotos(@PathVariable Long id){
    Candidato candidato = candidatoService.obtenerPorId(id)
        .orElseThrow(() -> new ResourceNotFoundException("No se encontro candidato con id: " + id));

    Long totalVotos = votoService.contarVotosPorCandidato(id);

    Map<String, Object> response = new HashMap<>();
    response.put("candidatoId", id);
    response.put("candidatoNombre", candidato.getNombreCompleto());
    response.put("partido", candidato.getPartido().getNombre());
    response.put("totalVotos", totalVotos);

    return ResponseEntity.ok(response);
  }

  
}
