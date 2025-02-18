package br.gov.al.saude.locations.application.ports.sector.inbound;

import java.util.Optional;

import br.gov.al.saude.locations.application.domain.Sector;

public interface FindSectorByNameInputPort {
  Optional<Sector> find(String name);
}
