package br.gov.al.saude.locations.application.domain;

import java.time.LocalDateTime;

public class Sector extends BaseDomain {
  private Long id;
  private String name;
  private String acronym;
  private Long annexId;

  public Sector() {
  }

  public Sector(LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy, Boolean deleted,
      Long id, String name, String acronym, Long annexId) {
    super(createdAt, createdBy, updatedAt, updatedBy, deleted);
    this.id = id;
    this.name = name;
    this.acronym = acronym;
    this.annexId = annexId;
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

  public String getAcronym() {
    return acronym;
  }

  public void setAcronym(String acronym) {
    this.acronym = acronym;
  }

  public Long getAnnexId() {
    return annexId;
  }

  public void setAnnexId(Long annexId) {
    this.annexId = annexId;
  }

}
