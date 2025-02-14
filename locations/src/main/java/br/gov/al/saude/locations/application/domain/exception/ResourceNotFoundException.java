package br.gov.al.saude.locations.application.domain.exception;

public class ResourceNotFoundException extends RuntimeException {
  public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
    super(String.format("%s não encontrado com o seguinte dado %s: '%s'", resourceName, fieldName, fieldValue));
  }

}
