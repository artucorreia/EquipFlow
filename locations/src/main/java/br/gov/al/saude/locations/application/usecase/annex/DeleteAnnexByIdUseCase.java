package br.gov.al.saude.locations.application.usecase.annex;

import java.util.logging.Logger;

import br.gov.al.saude.locations.application.ports.annex.inbound.DeleteAnnexByIdInputPort;
import br.gov.al.saude.locations.application.ports.annex.inbound.FindAnnexByIdInputPort;
import br.gov.al.saude.locations.application.ports.annex.outbound.DeleteAnnexByIdOutputPort;

public class DeleteAnnexByIdUseCase implements DeleteAnnexByIdInputPort {
  private final Logger LOGGER = Logger.getLogger(DeleteAnnexByIdUseCase.class.getName());

  private final FindAnnexByIdInputPort findAnnexByIdInputPort;
  private final DeleteAnnexByIdOutputPort deleteAnnexByIdOutputPort;

  public DeleteAnnexByIdUseCase(FindAnnexByIdInputPort findAnnexByIdInputPort,
      DeleteAnnexByIdOutputPort deleteAnnexByIdOutputPort) {
    this.findAnnexByIdInputPort = findAnnexByIdInputPort;
    this.deleteAnnexByIdOutputPort = deleteAnnexByIdOutputPort;
  }

  @Override
  public void delete(Long id) {
    LOGGER.info(String.format("Deleting (soft) annex by id: '%s", id));
    findAnnexByIdInputPort.find(id);
    deleteAnnexByIdOutputPort.delete(id);
  }

}
