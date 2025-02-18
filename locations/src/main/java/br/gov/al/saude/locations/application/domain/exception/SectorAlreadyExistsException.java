package br.gov.al.saude.locations.application.domain.exception;

public class SectorAlreadyExistsException extends RuntimeException {
  public SectorAlreadyExistsException(String message) {
    super(message);
  }
}
