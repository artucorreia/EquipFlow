package br.gov.al.saude.locations.application.ports.sector.outbound;

import br.gov.al.saude.locations.application.domain.Sector;

public interface UpdateSectorOutputPort {
  void update(Sector sector);
}
