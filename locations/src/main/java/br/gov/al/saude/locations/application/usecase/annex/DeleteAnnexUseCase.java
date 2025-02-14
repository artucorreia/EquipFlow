package br.gov.al.saude.locations.application.usecase.annex;

import java.util.logging.Logger;

import br.gov.al.saude.locations.application.domain.Annex;
import br.gov.al.saude.locations.application.ports.annex.inbound.DeleteAnnexInputPort;
import br.gov.al.saude.locations.application.ports.annex.inbound.FindAnnexByIdInputPort;
import br.gov.al.saude.locations.application.ports.annex.outbound.DeleteAnnexOutputPort;

public class DeleteAnnexUseCase implements DeleteAnnexInputPort {
  private final Logger LOGGER = Logger.getLogger(DeleteAnnexUseCase.class.getName());

  private final FindAnnexByIdInputPort findAnnexByIdInputPort;
  private final DeleteAnnexOutputPort deleteAnnexOutputPort;

  public DeleteAnnexUseCase(FindAnnexByIdInputPort findAnnexByIdInputPort,
      DeleteAnnexOutputPort deleteAnnexOutputPort) {
    this.findAnnexByIdInputPort = findAnnexByIdInputPort;
    this.deleteAnnexOutputPort = deleteAnnexOutputPort;
  }

  @Override
  public void delete(Long id) {
    LOGGER.info(String.format("Deleting (soft) annex by id: '%s", id));
    Annex annex = findAnnexByIdInputPort.find(id);
    annex.setDeleted(true);
    deleteAnnexOutputPort.delete(annex);
  }

}
