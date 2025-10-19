package com.votaciones.api.controller;

import com.votaciones.api.dto.PartidoPoliticoRequestDTO;
import com.votaciones.api.exception.ResourceNotFoundException;
import com.votaciones.api.model.PartidoPolitico;
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
import java.util.Optional;

@RestController
@RequestMapping("/api/partidos")
@Tag(name = "Partidos politicos", description = "API para gestion de partidos politicos")
@RequiredArgsConstructor
public class PartidoPoliticoController {
  private final PartidoPoliticoService partidoService;
  private final VotoService votoService;

  @Operation(summary = "Crear un nuevo partido politico")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Partido creado exitosamente"),
      @ApiResponse(responseCode = "400", description = "Datos invalidos"),
      @ApiResponse(responseCode = "409", description = "La sigla ya existe")
  })
  @PostMapping
  public ResponseEntity<PartidoPolitico> crear(@Valid @RequestBody PartidoPoliticoRequestDTO dto){
    PartidoPolitico partido = new PartidoPolitico();
    partido.setNombre(dto.getNombre());
    partido.setSigla(dto.getSigla());

    PartidoPolitico partidoGuardado = partidoService.crear(partido);
    return ResponseEntity.status(HttpStatus.CREATED).body(partidoGuardado);
  }

  @Operation(summary = "Obtener todos los partidos politicos")
  @ApiResponse(responseCode = "200", description = "Lista de partidos obtenida")
  @GetMapping
  public ResponseEntity<List<PartidoPolitico>> obtenerTodos() {
    List<PartidoPolitico> partidos = partidoService.obtenerTodos();
    return ResponseEntity.ok(partidos);
  }

  @Operation(summary = "Obtener un partido por ID")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Partido encontrado"),
      @ApiResponse(responseCode = "404", description = "Partido no encontrado")
  })
  @GetMapping("/{id}")
  public ResponseEntity<PartidoPolitico> obtenerPorId(
      @Parameter(description = "ID del partido") @PathVariable Long id) {
    PartidoPolitico partido = partidoService.obtenerPartidoPorId(id)
        .orElseThrow(() -> new ResourceNotFoundException("No se encontro partido con id: " + id));
    return ResponseEntity.ok(partido);
  }

  @Operation(summary = "Eliminar un partido politico")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "204", description = "Partido eliminado"),
      @ApiResponse(responseCode = "404", description = "Partido no encontrado")
  })
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminar(@PathVariable Long id) {
    partidoService.eliminar(id);
    return ResponseEntity.noContent().build();
  }

  @Operation(summary = "Consultar votos de un partido")
  @ApiResponse(responseCode = "200", description = "Cantidad de votos obtenida")
  @GetMapping("/{id}/votos")
  public ResponseEntity<Map<String, Object>> consultarVotos(@PathVariable Long id){
    // Verificar que el partido exista
    PartidoPolitico partido = partidoService.obtenerPartidoPorId(id)
        .orElseThrow(() -> new ResourceNotFoundException("No se encontro partido con id: " + id));

    // Obtener votos del partido
    Long totalVotos = votoService.contarVotosPorPartido(id);

    Map<String, Object> response = new HashMap<>();
    response.put("partidoId", id);
    response.put("partidoNombre", partido.getNombre());
    response.put("partidoSigla", partido.getSigla());
    response.put("totalVotos", totalVotos);
    return ResponseEntity.ok(response);
  }

}
