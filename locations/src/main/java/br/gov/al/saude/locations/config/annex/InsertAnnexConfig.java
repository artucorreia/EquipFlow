package br.gov.al.saude.locations.config.annex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.gov.al.saude.locations.adapters.annex.outbound.InsertAnnexAdapter;
import br.gov.al.saude.locations.application.usecase.annex.FindAnnexByNameUseCase;
import br.gov.al.saude.locations.application.usecase.annex.InsertAnnexUseCase;

@Configuration
public class InsertAnnexConfig {

  @Bean
  public InsertAnnexUseCase insertAnnexUseCase(InsertAnnexAdapter insertAnnexAdapter,
      FindAnnexByNameUseCase findAnnexByNameUseCase) {
    return new InsertAnnexUseCase(insertAnnexAdapter, findAnnexByNameUseCase);
  }

}
