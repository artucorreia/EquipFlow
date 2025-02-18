package br.gov.al.saude.locations.config.sector;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.gov.al.saude.locations.adapters.sector.outbound.FindSectorByNameAdapter;
import br.gov.al.saude.locations.application.usecase.sector.FindSectorByNameUseCase;

@Configuration
public class FindSectorByNameConfig {

  @Bean
  public FindSectorByNameUseCase findSectorByNameUseCase(FindSectorByNameAdapter findSectorByNameAdapter) {
    return new FindSectorByNameUseCase(findSectorByNameAdapter);
  }

}
