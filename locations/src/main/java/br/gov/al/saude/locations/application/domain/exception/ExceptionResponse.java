package br.gov.al.saude.locations.application.domain.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {
  private String title;
  private String status;
  private String path;
  private LocalDateTime timestamp;

  public ExceptionResponse(String title, String status, String path, LocalDateTime timestamp) {
    this.title = title;
    this.status = status;
    this.path = path;
    this.timestamp = timestamp;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public static class Builder {

    private String title;
    private String path;
    private String status;
    private LocalDateTime timestamp;

    public Builder title(String title) {
      this.title = title;
      return this;
    }

    public Builder status(String status) {
      this.status = status;
      return this;
    }

    public Builder path(String path) {
      this.path = path;
      return this;
    }

    public Builder timestamp(LocalDateTime timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    public ExceptionResponse build() {
      return new ExceptionResponse(title, status, path, timestamp);
    }

  }

}
