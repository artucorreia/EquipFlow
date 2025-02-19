package br.gov.al.saude.machines.config.audit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import br.gov.al.saude.machines.audit.AuditorAwareImpl;

@Configuration
@EnableJpaAuditing
public class AuditorAwareConfig {

  @Bean
  public AuditorAware<String> auditorProvider() {
    return new AuditorAwareImpl();
  }

}
