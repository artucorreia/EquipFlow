package br.gov.al.saude.locations.adapters.sector.inbound.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SectorSimpleDTO {

  private Long id;
  private String name;
  private String acronym;
  private Long annexId;

  public SectorSimpleDTO(Long id, String name, String acronym, Long annexId) {
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
