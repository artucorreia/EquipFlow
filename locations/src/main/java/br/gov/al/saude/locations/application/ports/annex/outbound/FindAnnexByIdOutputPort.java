package br.gov.al.saude.locations.application.ports.annex.outbound;

import java.util.Optional;

import br.gov.al.saude.locations.application.domain.Annex;

public interface FindAnnexByIdOutputPort {
  Optional<Annex> find(Long id);
}
