package com.votaciones.api.exception;

public class InvalidDataException extends RuntimeException{
  public InvalidDataException(String mensaje){
    super(mensaje);
  }
}
