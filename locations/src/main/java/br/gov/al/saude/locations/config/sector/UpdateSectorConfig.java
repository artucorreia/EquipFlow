package br.gov.al.saude.locations.config.sector;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.gov.al.saude.locations.application.ports.sector.outbound.UpdateSectorOutputPort;
import br.gov.al.saude.locations.application.usecase.sector.FindSectorByIdUseCase;
import br.gov.al.saude.locations.application.usecase.sector.UpdateSectorUseCase;
import br.gov.al.saude.locations.application.usecase.sector.ValidateSectorInfoUseCase;

@Configuration
public class UpdateSectorConfig {

  @Bean
  public UpdateSectorUseCase updateSectorUseCase(FindSectorByIdUseCase findSectorByIdUseCase,
      ValidateSectorInfoUseCase validateSectorInfoUseCase, UpdateSectorOutputPort updateSectorOutputPort) {
    return new UpdateSectorUseCase(findSectorByIdUseCase, validateSectorInfoUseCase, updateSectorOutputPort);
  }

}
