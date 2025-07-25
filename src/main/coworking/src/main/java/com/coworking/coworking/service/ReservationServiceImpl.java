package com.coworking.coworking.service;

import com.coworking.coworking.model.Reservation;
import com.coworking.coworking.model.ReservationStatus;
import com.coworking.coworking.repository.ReservationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService{
  private final ReservationRepo reservationRepo;

  @Override
  public Reservation createReservation(Reservation reservation) {
    return reservationRepo.save(reservation);
  }

  @Override
  public List<Reservation> getAllReservations() {
    return reservationRepo.findAll();
  }

  @Override
  public Optional<Reservation> getReservationById(Long id) {
    return reservationRepo.findById(id);
  }

  @Override
  public List<Reservation> getAllReservationsByUserId(Long userId) {
    return reservationRepo.findAll().stream()
        .filter(r -> r.getUser().getId().equals(userId))
        .toList();
  }

  @Override
  public void cancelReservation(Long reservationId) {
    Reservation reservationToCancel = reservationRepo.findById(reservationId)
        .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

    reservationToCancel.setStatus(ReservationStatus.CANCELLED);
    reservationRepo.save(reservationToCancel);
  }

  @Override
  public boolean isAvailable(Long roomId, LocalDateTime start, LocalDateTime end) {
    List<Reservation> existingReservations = reservationRepo.findByRoomId(roomId);

    if (start.isAfter(end)){
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La fecha de inicio no puede ser posterior a la fecha de fin");
    }

    return existingReservations.stream()
        .noneMatch(r ->
            start.isBefore(r.getEndDateTime()) &&
            end.isAfter(r.getStartDateTime())
        );
  }
}
