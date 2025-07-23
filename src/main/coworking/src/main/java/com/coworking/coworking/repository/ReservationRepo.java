package com.coworking.coworking.repository;

import com.coworking.coworking.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Long> {
  List<Reservation> findByRoomId(Long roomId);
}
