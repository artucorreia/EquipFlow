package br.gov.al.saude.locations.adapters.annex.inbound.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateAnnexDTO {
  @NotBlank(message = "Campo 'nome' não deve estar em branco")
  @Size(min = 3, max = 100, message = "Campo 'nome' deve ter entre 3 e 100 caracteres")
  private String name;

  public CreateAnnexDTO(
      @NotBlank(message = "Campo 'nome' não deve estar em branco") @Size(min = 3, max = 100, message = "Campo 'nome' deve ter entre 3 e 100 caracteres") String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
