package br.gov.al.saude.locations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.gov.al.saude.locations.adapters.annex.outbound.DeleteAnnexByIdAdapter;
import br.gov.al.saude.locations.application.usecase.annex.DeleteAnnexByIdUseCase;
import br.gov.al.saude.locations.application.usecase.annex.FindAnnexByIdUseCase;

@Configuration
public class DeleteAnnexByIdConfig {

  @Bean
  public DeleteAnnexByIdUseCase deleteAnnexByIdUseCase(FindAnnexByIdUseCase findAnnexByIdUseCase,
      DeleteAnnexByIdAdapter deleteAnnexByIdAdapter) {
    return new DeleteAnnexByIdUseCase(findAnnexByIdUseCase, deleteAnnexByIdAdapter);
  }

}
