package com.coworking.coworking.service;

import com.coworking.coworking.model.Reservation;

import java.util.List;

public interface ReservationService {
  Reservation createReservation(Reservation reservation);
  List<Reservation> getAllReservations();
  List<Reservation> getAllReservationsByUserId(Long userId);
  void cancelReservation(Long reservationId);
}
