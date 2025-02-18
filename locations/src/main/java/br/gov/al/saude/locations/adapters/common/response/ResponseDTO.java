package br.gov.al.saude.locations.adapters.common.response;

import java.time.LocalDateTime;

public class ResponseDTO {

  private String message;
  private String status;
  private LocalDateTime timestamp;

  public ResponseDTO() {
  }

  public ResponseDTO(String message, String status, LocalDateTime timestamp) {
    this.message = message;
    this.status = status;
    this.timestamp = timestamp;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }

}
