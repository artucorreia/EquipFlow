package br.gov.al.saude.locations.application.domain.exception;

public class AnnexAlreadyExists extends RuntimeException {
  public AnnexAlreadyExists(String message) {
    super(message);
  }
}
