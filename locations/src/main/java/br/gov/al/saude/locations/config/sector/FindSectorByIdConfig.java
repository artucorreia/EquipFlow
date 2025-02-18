package br.gov.al.saude.locations.config.sector;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import br.gov.al.saude.locations.adapters.sector.outbound.FindSectorByIdAdapter;
import br.gov.al.saude.locations.application.usecase.sector.FindSectorByIdUseCase;

@Component
public class FindSectorByIdConfig {
  @Bean
  public FindSectorByIdUseCase findSectorByIdUseCase(FindSectorByIdAdapter findSectorByIdAdapter) {
    return new FindSectorByIdUseCase(findSectorByIdAdapter);
  }

}
