package br.gov.al.saude.locations.application.usecase.sector;

import br.gov.al.saude.locations.application.domain.Sector;
import br.gov.al.saude.locations.application.domain.exception.ResourceNotFoundException;
import br.gov.al.saude.locations.application.ports.sector.inbound.FindSectorByIdInputPort;
import br.gov.al.saude.locations.application.ports.sector.outbound.FindSectorByIdOutputPort;

public class FindSectorByIdUseCase implements FindSectorByIdInputPort {

  private final FindSectorByIdOutputPort findSectorByIdOutputPort;

  public FindSectorByIdUseCase(FindSectorByIdOutputPort findSectorByIdOutputPort) {
    this.findSectorByIdOutputPort = findSectorByIdOutputPort;
  }

  @Override
  public Sector find(Long id) {
    return findSectorByIdOutputPort.find(id)
        .orElseThrow(() -> new ResourceNotFoundException("Setor", "id", id.toString()));
  }

}
