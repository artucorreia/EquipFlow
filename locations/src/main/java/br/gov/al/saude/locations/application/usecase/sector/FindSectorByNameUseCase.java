package br.gov.al.saude.locations.application.usecase.sector;

import java.util.Optional;

import br.gov.al.saude.locations.application.domain.Sector;
import br.gov.al.saude.locations.application.ports.sector.inbound.FindSectorByNameInputPort;
import br.gov.al.saude.locations.application.ports.sector.outbound.FindSectorByNameOutputPort;

public class FindSectorByNameUseCase implements FindSectorByNameInputPort {

  private final FindSectorByNameOutputPort findSectorByNameOutputPort;

  public FindSectorByNameUseCase(FindSectorByNameOutputPort findSectorByNameOutputPort) {
    this.findSectorByNameOutputPort = findSectorByNameOutputPort;
  }

  @Override
  public Optional<Sector> find(String name) {
    return findSectorByNameOutputPort.find(name);
  }
}
