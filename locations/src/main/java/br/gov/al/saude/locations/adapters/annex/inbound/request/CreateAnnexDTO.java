package br.gov.al.saude.locations.adapters.annex.inbound.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateAnnexDTO {
  @NotBlank(message = "Campo 'name' não deve estar em branco")
  @Size(min = 3, max = 100, message = "Campo 'name' deve ter entre 3 e 100 caracteres")
  private String name;

  public CreateAnnexDTO(
      @NotBlank(message = "Campo 'name' não deve estar em branco") @Size(min = 3, max = 100, message = "Campo 'name' deve ter entre 3 e 100 caracteres") String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
