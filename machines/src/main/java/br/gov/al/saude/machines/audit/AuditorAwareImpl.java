package br.gov.al.saude.machines.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String> {

  // TODO: refactor method to get current user
  @Override
  public Optional<String> getCurrentAuditor() {
    return Optional.of("MACHINES_MS");
  }

}
