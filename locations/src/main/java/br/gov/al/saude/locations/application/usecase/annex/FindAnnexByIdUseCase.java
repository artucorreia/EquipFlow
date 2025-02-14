package br.gov.al.saude.locations.application.usecase.annex;

import br.gov.al.saude.locations.application.ports.annex.outbound.FindAnnexByIdOutputPort;

import java.util.logging.Logger;

import br.gov.al.saude.locations.application.domain.Annex;
import br.gov.al.saude.locations.application.domain.exception.ResourceNotFoundException;
import br.gov.al.saude.locations.application.ports.annex.inbound.FindAnnexByIdInputPort;

public class FindAnnexByIdUseCase implements FindAnnexByIdInputPort {
  private final Logger LOOGER = Logger.getLogger(FindAnnexByIdUseCase.class.getName());

  private final FindAnnexByIdOutputPort findAnnexByIdOutputPort;

  public FindAnnexByIdUseCase(FindAnnexByIdOutputPort findAnnexByIdOutputPort) {
    this.findAnnexByIdOutputPort = findAnnexByIdOutputPort;
  }

  @Override
  public Annex find(Long id) {
    LOOGER.info(String.format("Finding annex by id: '%s'", id));
    return findAnnexByIdOutputPort.find(id)
        .orElseThrow(() -> new ResourceNotFoundException("Anexo", "id", id.toString()));
  }

}
