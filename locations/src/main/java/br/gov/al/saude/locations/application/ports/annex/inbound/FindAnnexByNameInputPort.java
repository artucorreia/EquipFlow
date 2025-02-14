package br.gov.al.saude.locations.application.ports.annex.inbound;

import java.util.Optional;

import br.gov.al.saude.locations.application.domain.Annex;

public interface FindAnnexByNameInputPort {
  Optional<Annex> find(String name);
}
