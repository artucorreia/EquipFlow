package br.gov.al.saude.locations.application.ports.sector.inbound;

import java.util.Optional;

import br.gov.al.saude.locations.application.domain.Sector;

public interface FindSectorByAcronymInputPort {
  Optional<Sector> find(String acronym);
}
