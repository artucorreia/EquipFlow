package br.gov.al.saude.locations.config.sector;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import br.gov.al.saude.locations.adapters.sector.outbound.InsertSectorAdapter;
import br.gov.al.saude.locations.application.usecase.sector.InsertSectorUseCase;
import br.gov.al.saude.locations.application.usecase.sector.ValidateSectorInfoUseCase;

@Component
public class InsertSectorConfig {

  @Bean
  public InsertSectorUseCase insertSectorUseCase(ValidateSectorInfoUseCase validateSectorInfoUseCase,
      InsertSectorAdapter insertSectorAdapter) {
    return new InsertSectorUseCase(validateSectorInfoUseCase, insertSectorAdapter);
  }
}
