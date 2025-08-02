package com.coworking.coworking.dto;

import com.coworking.coworking.model.ReservationStatus;
import com.coworking.coworking.model.Room;
import com.coworking.coworking.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationRequestDTO {
  @NotNull(message = "El usuario no puede ser nulo")
  private Long userId;

  @NotNull(message = "La sala no puede ser nula")
  private Long roomId;

  @NotNull(message = "La fecha de inicio no puede ser nula")
  @Future(message = "La fecha de inicio debe ser futura")
  private LocalDateTime startDateTime;

  @NotNull(message = "La fecha de fin no puede ser nula")
  @Future(message = "La fecha de fin debe ser futura")
  private LocalDateTime endDateTime;

  @NotNull(message = "El estado no puede ser nulo")
  private ReservationStatus status;
}
