package br.gov.al.saude.locations.application.usecase.annex;

import java.util.Optional;
import java.util.logging.Logger;

import br.gov.al.saude.locations.application.domain.Annex;
import br.gov.al.saude.locations.application.domain.exception.AnnexAlreadyExists;
import br.gov.al.saude.locations.application.ports.annex.inbound.FindAnnexByIdInputPort;
import br.gov.al.saude.locations.application.ports.annex.inbound.FindAnnexByNameInputPort;
import br.gov.al.saude.locations.application.ports.annex.inbound.UpdateAnnexInputPort;
import br.gov.al.saude.locations.application.ports.annex.outbound.UpdateAnnexOutputPort;

public class UpdateAnnexUseCase implements UpdateAnnexInputPort {
  private final Logger LOGGER = Logger.getLogger(UpdateAnnexUseCase.class.getName());

  private final FindAnnexByIdInputPort findAnnexByIdInputPort;
  private final FindAnnexByNameInputPort findAnnexByNameInputPort;
  private final UpdateAnnexOutputPort updateAnnexOutputPort;

  public UpdateAnnexUseCase(FindAnnexByIdInputPort findAnnexByIdInputPort,
      FindAnnexByNameInputPort findAnnexByNameInputPort, UpdateAnnexOutputPort updateAnnexOutputPort) {
    this.findAnnexByIdInputPort = findAnnexByIdInputPort;
    this.findAnnexByNameInputPort = findAnnexByNameInputPort;
    this.updateAnnexOutputPort = updateAnnexOutputPort;
  }

  @Override
  public void update(Long id, Annex updatedAnnex) {
    LOGGER.info(String.format("Updating an annex with id: '%s'", id));
    Annex annex = findAnnexByIdInputPort.find(id);
    Optional<Annex> optionalAnnex = findAnnexByNameInputPort.find(updatedAnnex.getName());
    if (optionalAnnex.isPresent())
      throw new AnnexAlreadyExists("Esse anexo já existe");
    annex.setName(updatedAnnex.getName().trim());
    updateAnnexOutputPort.update(annex);
  }

}
