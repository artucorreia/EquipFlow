package br.gov.al.saude.locations.config.annex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.gov.al.saude.locations.adapters.annex.outbound.FindAnnexByNameAdapter;
import br.gov.al.saude.locations.application.usecase.annex.FindAnnexByNameUseCase;

@Configuration
public class FindAnnexByNameConfig {

  @Bean
  public FindAnnexByNameUseCase findAnnexByNameUseCase(FindAnnexByNameAdapter findAnnexByNameAdapter) {
    return new FindAnnexByNameUseCase(findAnnexByNameAdapter);
  }

}
