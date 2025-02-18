package br.gov.al.saude.locations.application.usecase.sector;

import java.util.logging.Logger;

import br.gov.al.saude.locations.application.domain.Sector;
import br.gov.al.saude.locations.application.domain.exception.SectorAlreadyExistsException;
import br.gov.al.saude.locations.application.ports.annex.inbound.FindAnnexByIdInputPort;
import br.gov.al.saude.locations.application.ports.sector.inbound.FindSectorByAcronymInputPort;
import br.gov.al.saude.locations.application.ports.sector.inbound.FindSectorByNameInputPort;
import br.gov.al.saude.locations.application.ports.sector.inbound.ValidateSectorInfoInputPort;

public class ValidateSectorInfoUseCase implements ValidateSectorInfoInputPort {
  private final Logger LOGGER = Logger.getLogger(ValidateSectorInfoUseCase.class.getName());

  private final FindSectorByNameInputPort findSectorByNameInputPort;
  private final FindSectorByAcronymInputPort findSectorByAcronymInputPort;
  private final FindAnnexByIdInputPort findAnnexByIdInputPort;

  public ValidateSectorInfoUseCase(FindSectorByNameInputPort findSectorByNameInputPort,
      FindSectorByAcronymInputPort findSectorByAcronymInputPort, FindAnnexByIdInputPort findAnnexByIdInputPort) {
    this.findSectorByNameInputPort = findSectorByNameInputPort;
    this.findSectorByAcronymInputPort = findSectorByAcronymInputPort;
    this.findAnnexByIdInputPort = findAnnexByIdInputPort;
  }

  @Override
  public void validateForInsertion(Sector sector) {
    validateSectorName(sector.getName().trim());
    if (sector.getAcronym() != null)
      validateSectorAcronym(sector.getAcronym().trim());
    validateAnnexRelationship(sector.getAnnexId());
  }

  @Override
  public void validateForUpdate(Sector sector) {
    if (sector.getName() != null)
      validateSectorName(sector.getName().trim());
    if (sector.getAcronym() != null)
      validateSectorAcronym(sector.getAcronym().trim());
    if (sector.getAnnexId() != null)
      validateAnnexRelationship(sector.getAnnexId());
  }

  // check if the sector name already in use
  private void validateSectorName(String sectorName) {
    LOGGER.info(String.format("Validating sector name: '%s'", sectorName));
    if (findSectorByNameInputPort.find(sectorName).isPresent())
      throw new SectorAlreadyExistsException("Já existe outro setor com este nome");
  }

  // check if the sector acronym already in use
  private void validateSectorAcronym(String sectorAcronym) {
    LOGGER.info(String.format("Validating sector acronym: '%s'", sectorAcronym));
    if (findSectorByAcronymInputPort.find(sectorAcronym).isPresent())
      throw new SectorAlreadyExistsException("Já existe outro setor com esta sigla");
  }

  // check if the annex id exists
  private void validateAnnexRelationship(Long annexId) {
    LOGGER.info(String.format("Validating annex id: '%s'", annexId));
    findAnnexByIdInputPort.find(annexId);
  }
}
