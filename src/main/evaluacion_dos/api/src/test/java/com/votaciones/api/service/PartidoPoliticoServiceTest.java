package com.votaciones.api.service;

import com.votaciones.api.exception.ResourceNotFoundException;
import com.votaciones.api.model.PartidoPolitico;
import com.votaciones.api.repository.PartidoPoliticoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Tests para PartidoPoliticoService")
class PartidoPoliticoServiceTest {

  @Mock
  private PartidoPoliticoRepository partidoRepository;
  @InjectMocks
  private PartidoPoliticoService partidoService;
  private PartidoPolitico partido;

  @BeforeEach
  void setUp() {
    partido = new PartidoPolitico();
    partido.setId(1L);
    partido.setNombre("Partido de prueba");
    partido.setSigla("PDP");
  }

  @Test
  @DisplayName("Crear partido - Caso exitoso")
  void testCrear_Exitoso() {
    when(partidoRepository.save(partido)).thenReturn(partido);
    PartidoPolitico resultado = partidoService.crear(partido);

    assertNotNull(resultado);
    assertEquals("Partido de prueba", resultado.getNombre());
    assertEquals("PDP", resultado.getSigla());

    verify(partidoRepository, times(1)).save(partido);
  }

  @Test
  @DisplayName("Obtener todos - Retorna lista")
  void testObtenerTodos() {
    PartidoPolitico nuevoPartido = new PartidoPolitico();
    nuevoPartido.setNombre("Nuevo Partido");
    nuevoPartido.setSigla("NP");
    List<PartidoPolitico> partidos = Arrays.asList(
        partido,
        nuevoPartido
    );
    when(partidoRepository.findAll()).thenReturn(partidos);

    List<PartidoPolitico> resultado = partidoService.obtenerTodos();

    assertEquals(2, resultado.size());
    assertTrue(resultado.contains(partido));
  }


  @Test
  @DisplayName("Obtener por ID - Caso exitoso")
  void testObtenerPorId_Exitoso() {
    when(partidoRepository.findById(1L)).thenReturn(Optional.of(partido));

    PartidoPolitico resultado = partidoService.obtenerPartidoPorId(1L);

    assertEquals(1L, resultado.getId());
    assertEquals("Partido de prueba", resultado.getNombre());

    verify(partidoRepository, times(1)).findById(1L);
  }

  @Test
  @DisplayName("Obtener por ID - No encontrado lanza excepción")
  void testObtenerPorId_NoEncontrado() {
    when(partidoRepository.findById(999L)).thenReturn(Optional.empty());

    ResourceNotFoundException exception = assertThrows(
        ResourceNotFoundException.class,
        () -> partidoService.obtenerPartidoPorId(999L)
    );

    assertTrue(exception.getMessage().contains("999"));
    verify(partidoRepository, times(1)).findById(999L);
  }


  @Test
  @DisplayName("Eliminar - Caso exitoso")
  void testEliminar_Exitoso() {
    when(partidoRepository.findById(1L)).thenReturn(Optional.of(partido));

    doNothing().when(partidoRepository).delete(partido);

    partidoService.eliminar(1L);

    verify(partidoRepository, times(1)).delete(partido);
  }

  @Test
  @DisplayName("Eliminar - No encontrado lanza excepción")
  void testEliminar_NoEncontrado() {
    when(partidoRepository.findById(999L)).thenReturn(Optional.empty());

    assertThrows(ResourceNotFoundException.class, () -> partidoService.eliminar(999L));

    verify(partidoRepository, never()).delete(any(PartidoPolitico.class));
  }
}