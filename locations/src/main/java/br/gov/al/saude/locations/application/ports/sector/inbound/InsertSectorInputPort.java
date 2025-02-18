package br.gov.al.saude.locations.application.ports.sector.inbound;

import br.gov.al.saude.locations.application.domain.Sector;

public interface InsertSectorInputPort {
  void insert(Sector sector);
}
