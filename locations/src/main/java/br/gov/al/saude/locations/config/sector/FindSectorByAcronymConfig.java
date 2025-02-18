package br.gov.al.saude.locations.config.sector;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.gov.al.saude.locations.adapters.sector.outbound.FindSectorByAcronymAdapter;
import br.gov.al.saude.locations.application.usecase.sector.FindSectorByAcronymUseCase;

@Configuration
public class FindSectorByAcronymConfig {

  @Bean
  public FindSectorByAcronymUseCase findSectorByAcronymUseCase(FindSectorByAcronymAdapter findSectorByAcronymAdapter) {
    return new FindSectorByAcronymUseCase(findSectorByAcronymAdapter);
  }

}
