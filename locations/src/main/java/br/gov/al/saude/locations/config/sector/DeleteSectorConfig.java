package br.gov.al.saude.locations.config.sector;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.gov.al.saude.locations.adapters.sector.outbound.DeleteSectorAdapter;
import br.gov.al.saude.locations.application.usecase.sector.DeleteSectorUseCase;
import br.gov.al.saude.locations.application.usecase.sector.FindSectorByIdUseCase;

@Configuration
public class DeleteSectorConfig {

  @Bean
  public DeleteSectorUseCase deleteSectorUseCase(FindSectorByIdUseCase findSectorByIdUseCase,
      DeleteSectorAdapter deleteSectorAdapter) {
    return new DeleteSectorUseCase(findSectorByIdUseCase, deleteSectorAdapter);
  }
}
