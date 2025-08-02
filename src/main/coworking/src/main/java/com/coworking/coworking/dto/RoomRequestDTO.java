package com.coworking.coworking.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RoomRequestDTO {

  @NotBlank(message = "El nombre de la sala no puede estar vacio")
  @Size(min = 3, max = 20, message = "El nombre debe tener entre 3 y 20 caracteres")
  private String name;

  @Min(value = 1, message = "La capacidad minima debe ser 1")
  @Max(value = 10, message = "La capacidad maxima debe ser 10")
  private int capacity;

  @NotBlank(message = "La localizacion no puede estar vacia")
  @Size(min = 3, max = 50, message = "La localizacion debe tener entre 3 y 50 caracteres")
  private String location;
}
