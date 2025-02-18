package br.gov.al.saude.locations.application.usecase.sector;

import java.util.Optional;

import br.gov.al.saude.locations.application.domain.Sector;
import br.gov.al.saude.locations.application.ports.sector.inbound.FindSectorByAcronymInputPort;
import br.gov.al.saude.locations.application.ports.sector.outbound.FindSectorByAcronymOutputPort;

public class FindSectorByAcronymUseCase implements FindSectorByAcronymInputPort {

  private final FindSectorByAcronymOutputPort findSectorByAcronymOutputPort;

  public FindSectorByAcronymUseCase(FindSectorByAcronymOutputPort findSectorByAcronymOutputPort) {
    this.findSectorByAcronymOutputPort = findSectorByAcronymOutputPort;
  }

  @Override
  public Optional<Sector> find(String acronym) {
    return findSectorByAcronymOutputPort.find(acronym);
  }

}
