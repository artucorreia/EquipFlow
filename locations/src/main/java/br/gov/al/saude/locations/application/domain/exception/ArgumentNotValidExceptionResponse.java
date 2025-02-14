package br.gov.al.saude.locations.application.domain.exception;

import java.time.LocalDateTime;
import java.util.Map;

public class ArgumentNotValidExceptionResponse extends ExceptionResponse {
  private Map<String, String> fields;

  public ArgumentNotValidExceptionResponse(String title, String status, String path, LocalDateTime timestamp,
      Map<String, String> fields) {
    super(title, status, path, timestamp);
    this.fields = fields;
  }

  public Map<String, String> getFields() {
    return fields;
  }

  public void setFields(Map<String, String> fields) {
    this.fields = fields;
  }

  public static class Builder {

    private String title;
    private String status;
    private String path;
    private LocalDateTime timestamp;
    private Map<String, String> fields;

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

    public Builder fieds(Map<String, String> fields) {
      this.fields = fields;
      return this;
    }

    public ArgumentNotValidExceptionResponse build() {
      return new ArgumentNotValidExceptionResponse(title, status, path, timestamp, fields);
    }
  }
}
