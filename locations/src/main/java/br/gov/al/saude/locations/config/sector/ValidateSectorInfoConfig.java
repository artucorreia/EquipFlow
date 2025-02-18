package br.gov.al.saude.locations.config.sector;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.gov.al.saude.locations.application.usecase.annex.FindAnnexByIdUseCase;
import br.gov.al.saude.locations.application.usecase.sector.FindSectorByAcronymUseCase;
import br.gov.al.saude.locations.application.usecase.sector.FindSectorByNameUseCase;
import br.gov.al.saude.locations.application.usecase.sector.ValidateSectorInfoUseCase;

@Configuration
public class ValidateSectorInfoConfig {

  @Bean
  public ValidateSectorInfoUseCase validateSectorInfoUseCase(
      FindSectorByNameUseCase findSectorByNameUseCase, FindSectorByAcronymUseCase findSectorByAcronymUseCase,
      FindAnnexByIdUseCase findAnnexByIdUseCase) {
    return new ValidateSectorInfoUseCase(findSectorByNameUseCase, findSectorByAcronymUseCase,
        findAnnexByIdUseCase);
  }
}
