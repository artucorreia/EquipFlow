package br.gov.al.saude.locations.application.usecase.sector;

import java.util.logging.Logger;

import br.gov.al.saude.locations.application.domain.Sector;
import br.gov.al.saude.locations.application.ports.sector.inbound.InsertSectorInputPort;
import br.gov.al.saude.locations.application.ports.sector.inbound.ValidateSectorInfoInputPort;
import br.gov.al.saude.locations.application.ports.sector.outbound.InsertSectorOutputPort;

public class InsertSectorUseCase implements InsertSectorInputPort {
  private final Logger LOGGER = Logger.getLogger(InsertSectorUseCase.class.getName());

  private final ValidateSectorInfoInputPort validateSectorInfoInputPort;
  private final InsertSectorOutputPort insertSectorOutputPort;

  public InsertSectorUseCase(ValidateSectorInfoInputPort validateSectorInfoInputPort,
      InsertSectorOutputPort insertSectorOutputPort) {
    this.validateSectorInfoInputPort = validateSectorInfoInputPort;
    this.insertSectorOutputPort = insertSectorOutputPort;
  }

  @Override
  public void insert(Sector sector) {
    LOGGER.info("Inserting a new sector");
    sector.setDeleted(false);
    sector.setName(sector.getName().trim().toUpperCase());
    if (sector.getAcronym() != null)
      sector.setAcronym(sector.getAcronym().trim().toUpperCase());
    validateSectorInfoInputPort.validateForInsertion(sector);
    insertSectorOutputPort.insert(sector);
  }

}
