package br.gov.al.saude.locations.application.usecase.sector;

import java.util.logging.Logger;

import br.gov.al.saude.locations.application.domain.Sector;
import br.gov.al.saude.locations.application.ports.sector.inbound.DeleteSectorInputPort;
import br.gov.al.saude.locations.application.ports.sector.inbound.FindSectorByIdInputPort;
import br.gov.al.saude.locations.application.ports.sector.outbound.DeleteSectorOutputPort;

public class DeleteSectorUseCase implements DeleteSectorInputPort {
  private final Logger LOGGER = Logger.getLogger(DeleteSectorUseCase.class.getName());

  private final FindSectorByIdInputPort findSectorByIdInputPort;
  private final DeleteSectorOutputPort deleteSectorOutputPort;

  public DeleteSectorUseCase(FindSectorByIdInputPort findSectorByIdInputPort,
      DeleteSectorOutputPort deleteSectorOutputPort) {
    this.findSectorByIdInputPort = findSectorByIdInputPort;
    this.deleteSectorOutputPort = deleteSectorOutputPort;
  }

  @Override
  public void delete(Long id) {
    LOGGER.info(String.format("Deleting (soft) sector by id: '%s", id));
    Sector sector = findSectorByIdInputPort.find(id);
    sector.setDeleted(true);
    deleteSectorOutputPort.delete(sector);
  }

}
