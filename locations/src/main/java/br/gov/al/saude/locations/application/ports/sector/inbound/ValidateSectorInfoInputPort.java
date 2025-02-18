package br.gov.al.saude.locations.application.ports.sector.inbound;

import br.gov.al.saude.locations.application.domain.Sector;

public interface ValidateSectorInfoInputPort {
  void validateForInsertion(Sector sector);

  void validateForUpdate(Sector sector);
}
