package br.gov.al.saude.locations.config.annex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.gov.al.saude.locations.adapters.annex.outbound.UpdateAnnexAdapter;
import br.gov.al.saude.locations.application.usecase.annex.FindAnnexByIdUseCase;
import br.gov.al.saude.locations.application.usecase.annex.FindAnnexByNameUseCase;
import br.gov.al.saude.locations.application.usecase.annex.UpdateAnnexUseCase;

@Configuration
public class UpdateAnnexConfig {

  @Bean
  public UpdateAnnexUseCase updateAnnexUseCase(FindAnnexByIdUseCase findAnnexByIdUseCase,
      FindAnnexByNameUseCase findAnnexByNameUseCase,
      UpdateAnnexAdapter updateAnnexAdapter) {
    return new UpdateAnnexUseCase(findAnnexByIdUseCase, findAnnexByNameUseCase, updateAnnexAdapter);
  }

}
