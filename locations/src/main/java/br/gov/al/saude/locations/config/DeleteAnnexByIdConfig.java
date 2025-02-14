package br.gov.al.saude.locations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.gov.al.saude.locations.adapters.annex.outbound.DeleteAnnexAdapter;
import br.gov.al.saude.locations.application.usecase.annex.DeleteAnnexUseCase;
import br.gov.al.saude.locations.application.usecase.annex.FindAnnexByIdUseCase;

@Configuration
public class DeleteAnnexByIdConfig {

  @Bean
  public DeleteAnnexUseCase deleteAnnexUseCase(FindAnnexByIdUseCase findAnnexByIdUseCase,
      DeleteAnnexAdapter deleteAnnexAdapter) {
    return new DeleteAnnexUseCase(findAnnexByIdUseCase, deleteAnnexAdapter);
  }

}
