package com.coworking.coworking.service;

import com.coworking.coworking.model.Reservation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReservationService {
  Reservation createReservation(Reservation reservation);
  List<Reservation> getAllReservations();
  Optional<Reservation> getReservationById(Long id);
  List<Reservation> getAllReservationsByUserId(Long userId);
  void cancelReservation(Long reservationId);
  boolean isAvailable(Long roomId, LocalDateTime start, LocalDateTime end);
}
