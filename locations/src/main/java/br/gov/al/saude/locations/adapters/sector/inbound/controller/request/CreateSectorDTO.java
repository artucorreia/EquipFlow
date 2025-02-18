package br.gov.al.saude.locations.adapters.sector.inbound.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateSectorDTO {

  @NotBlank(message = "Campo 'nome' não deve estar em branco")
  @Size(min = 5, max = 150, message = "Campo 'nome' deve ter entre 5 e 150 caracteres")
  private String name;

  @Size(min = 2, max = 30, message = "Campo 'sigla' deve ter entre 2 e 30 caracteres")
  private String acronym;

  @NotNull(message = "Campo 'anexo' é obrigatório")
  private Long annexId;

  public CreateSectorDTO(
      @NotBlank(message = "Campo 'nome' não deve estar em branco") @Size(min = 5, max = 150, message = "Campo 'nome' deve ter entre 5 e 150 caracteres") String name,
      @Size(min = 2, max = 30, message = "Campo 'sigla' deve ter entre 2 e 30 caracteres") String acronym,
      @NotNull(message = "Campo 'anexo' é obrigatório") Long annexId) {
    this.name = name;
    this.acronym = acronym;
    this.annexId = annexId;
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
