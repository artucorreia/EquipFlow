package br.gov.al.saude.locations.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String> {

  // TODO: refactor method to get the current user
  @Override
  public Optional<String> getCurrentAuditor() {
    return Optional.of("LOCATIONS_MS");
  }

}
