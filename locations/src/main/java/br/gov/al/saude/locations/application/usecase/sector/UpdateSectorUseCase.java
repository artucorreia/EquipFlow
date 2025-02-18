package br.gov.al.saude.locations.application.usecase.sector;

import java.util.logging.Logger;

import br.gov.al.saude.locations.application.domain.Sector;
import br.gov.al.saude.locations.application.ports.sector.inbound.FindSectorByIdInputPort;
import br.gov.al.saude.locations.application.ports.sector.inbound.UpdateSectorInputPort;
import br.gov.al.saude.locations.application.ports.sector.inbound.ValidateSectorInfoInputPort;
import br.gov.al.saude.locations.application.ports.sector.outbound.UpdateSectorOutputPort;

public class UpdateSectorUseCase implements UpdateSectorInputPort {
  private final Logger LOGGER = Logger.getLogger(UpdateSectorUseCase.class.getName());

  private final FindSectorByIdInputPort findSectorByIdInputPort;
  private final ValidateSectorInfoInputPort validateSectorInfoInputPort;
  private final UpdateSectorOutputPort updateSectorOutputPort;

  public UpdateSectorUseCase(FindSectorByIdInputPort findSectorByIdInputPort,
      ValidateSectorInfoInputPort validateSectorInfoInputPort, UpdateSectorOutputPort updateSectorOutputPort) {
    this.findSectorByIdInputPort = findSectorByIdInputPort;
    this.validateSectorInfoInputPort = validateSectorInfoInputPort;
    this.updateSectorOutputPort = updateSectorOutputPort;
  }

  @Override
  public void update(Long id, Sector updatedSector) {
    LOGGER.info(String.format("Updating sector whith id: '%s'", id));

    Sector sector = findSectorByIdInputPort.find(id);
    validateSectorInfoInputPort.validateForUpdate(updatedSector);

    if (updatedSector.getName() != null && !updatedSector.getName().equals(""))
      sector.setName(updatedSector.getName().trim());
    if (updatedSector.getAcronym() != null && !updatedSector.getAcronym().equals(""))
      sector.setAcronym(updatedSector.getAcronym().trim());
    if (updatedSector.getAnnexId() != null) {
      sector.setAnnexId(updatedSector.getAnnexId());
    }

    updateSectorOutputPort.update(sector);
  }
}
