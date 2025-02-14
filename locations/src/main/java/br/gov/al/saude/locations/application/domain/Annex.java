package br.gov.al.saude.locations.application.domain;

import java.time.LocalDateTime;

public class Annex extends BaseDomain {
  private Long id;
  private String name;

  public Annex() {
  }

  public Annex(LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy, Boolean deleted,
      Long id, String name) {
    super(createdAt, createdBy, updatedAt, updatedBy, deleted);
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
