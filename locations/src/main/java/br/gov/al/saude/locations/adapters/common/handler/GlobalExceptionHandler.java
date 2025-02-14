package br.gov.al.saude.locations.adapters.common.handler;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.gov.al.saude.locations.application.domain.exception.AnnexAlreadyExists;
import br.gov.al.saude.locations.application.domain.exception.ArgumentNotValidExceptionResponse;
import br.gov.al.saude.locations.application.domain.exception.ExceptionResponse;
import br.gov.al.saude.locations.application.domain.exception.ResourceNotFoundException;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
      HttpStatusCode status, WebRequest request) {
    HashMap<String, String> fields = new HashMap<>();
    ex.getFieldErrors().forEach(fieldError -> {
      fields.put(fieldError.getField(), fieldError.getDefaultMessage());
    });
    ArgumentNotValidExceptionResponse response = new ArgumentNotValidExceptionResponse.Builder()
        .title("Dados inválidos")
        .status(HttpStatus.BAD_REQUEST.toString())
        .fieds(fields)
        .path(request.getDescription(false))
        .timestamp(LocalDateTime.now())
        .build();

    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception exception, WebRequest request) {
    ExceptionResponse response = new ExceptionResponse.Builder()
        .title(exception.getMessage())
        .status(HttpStatus.INTERNAL_SERVER_ERROR.toString())
        .path(request.getDescription(false))
        .timestamp(LocalDateTime.now())
        .build();

    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(ResourceNotFoundException.class)
  public final ResponseEntity<ExceptionResponse> handleResourceNotFoundExceptions(Exception exception,
      WebRequest request) {
    ExceptionResponse response = new ExceptionResponse.Builder()
        .title(exception.getMessage())
        .status(HttpStatus.NOT_FOUND.toString())
        .path(request.getDescription(false))
        .timestamp(LocalDateTime.now())
        .build();

    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(AnnexAlreadyExists.class)
  public final ResponseEntity<ExceptionResponse> handleAnnexAlreadyExistsExceptions(Exception exception,
      WebRequest request) {
    ExceptionResponse response = new ExceptionResponse.Builder()
        .title(exception.getMessage())
        .status(HttpStatus.BAD_REQUEST.toString())
        .path(request.getDescription(false))
        .timestamp(LocalDateTime.now())
        .build();

    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }
}
