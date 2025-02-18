package br.gov.al.saude.locations.config.annex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.gov.al.saude.locations.adapters.annex.outbound.FindAnnexByIdAdapter;
import br.gov.al.saude.locations.application.usecase.annex.FindAnnexByIdUseCase;

@Configuration
public class FindAnnexByIdConfig {

  @Bean
  public FindAnnexByIdUseCase findAnnexByIdUseCase(FindAnnexByIdAdapter findAnnexByIdAdapter) {
    return new FindAnnexByIdUseCase(findAnnexByIdAdapter);
  }
}
