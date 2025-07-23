package com.coworking.coworking.controller;

import com.coworking.coworking.dto.ReservationRequestDTO;
import com.coworking.coworking.model.Reservation;
import com.coworking.coworking.model.Role;
import com.coworking.coworking.model.Room;
import com.coworking.coworking.model.User;
import com.coworking.coworking.service.ReservationService;
import com.coworking.coworking.service.RoomService;
import com.coworking.coworking.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservas")
public class ReservationController {
  private final ReservationService reservationService;
  private final UserService userService;
  private final RoomService roomService;

  @GetMapping
  public ResponseEntity<List<Reservation>> getAllReservations(){
    List<Reservation> reservas = reservationService.getAllReservations();

    // ?? Aca seria correcto devolver un DTO ? es decir, hacer un stream de reservas
    // y transformalo a una lista de dtos y luego devolver esa lista ?

    return ResponseEntity.ok(reservas);
  }

  @GetMapping("/usuario/{id}")
  public ResponseEntity<List<Reservation>> getReservationsByUserId(@PathVariable Long id){
    // ?? Esto no me queda claro si colocarlo en el service,
    // aca lo que hago es validar si el usuario existe, pero podria tener lo mismo en el service.
    User user = userService.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));

    List<Reservation> reservationsByUserId = reservationService.getAllReservationsByUserId(id);

    return ResponseEntity.ok(reservationsByUserId);
  }

  @PostMapping
  public ResponseEntity<Reservation> createReservation(@Valid @RequestBody ReservationRequestDTO dto){
    User user = userService.findById(dto.getUserId())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));

    Room room = roomService.getRoomById(dto.getRoomId())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sala no encontrada"));


    // Validar que la reserva este disponible en este horario
    boolean disponible = reservationService.isAvailable(room.getId(), dto.getStartDateTime(), dto.getEndDateTime());

    if (!disponible){
      throw new ResponseStatusException(HttpStatus.CONFLICT, "La sala no esta disponible en ese horario");
    }

    // Crear reserva
    Reservation reservation = new Reservation();
    reservation.setUser(user);
    reservation.setRoom(room);
    reservation.setStartDateTime(dto.getStartDateTime());
    reservation.setEndDateTime(dto.getEndDateTime());
    reservation.setStatus(dto.getStatus());

    Reservation savedReservation = reservationService.createReservation(reservation);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedReservation);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> cancelReservation(@PathVariable Long id, @RequestHeader("userId") Long userId){
    User user = userService.findById(userId)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuario no encontrado"));

    Reservation reservationToCancel = reservationService.getReservationById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva no encontrada"));

    if(user.getRole().equals(Role.ADMIN) || reservationToCancel.getUser().getId().equals(userId)){
      reservationService.cancelReservation(id);
    }else{
      throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Usted no tiene permiso para realizar la operacion");
    }

    return ResponseEntity.noContent().build();
  }
}
