package br.gov.al.saude.locations.application.ports.sector.outbound;

import java.util.Optional;

import br.gov.al.saude.locations.application.domain.Sector;

public interface FindSectorByIdOutputPort {
  Optional<Sector> find(Long id);
}
