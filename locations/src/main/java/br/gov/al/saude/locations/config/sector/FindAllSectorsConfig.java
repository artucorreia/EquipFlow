package br.gov.al.saude.locations.config.sector;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.gov.al.saude.locations.adapters.sector.outbound.FindAllSectorsAdapter;
import br.gov.al.saude.locations.application.usecase.sector.FindAllSectorsUseCase;

@Configuration
public class FindAllSectorsConfig {

  @Bean
  public FindAllSectorsUseCase findAllSectorsUseCase(FindAllSectorsAdapter findAllSectorsAdapter) {
    return new FindAllSectorsUseCase(findAllSectorsAdapter);
  }

}
