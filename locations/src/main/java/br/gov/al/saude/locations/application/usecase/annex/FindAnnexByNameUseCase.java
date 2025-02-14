package br.gov.al.saude.locations.application.usecase.annex;

import java.util.Optional;
import java.util.logging.Logger;

import br.gov.al.saude.locations.application.domain.Annex;
import br.gov.al.saude.locations.application.ports.annex.inbound.FindAnnexByNameInputPort;
import br.gov.al.saude.locations.application.ports.annex.outbound.FindAnnexByNameOutputPort;

public class FindAnnexByNameUseCase implements FindAnnexByNameInputPort {
  private final Logger LOOGER = Logger.getLogger(FindAnnexByNameUseCase.class.getName());

  private final FindAnnexByNameOutputPort findAnnexByNameOutputPort;

  public FindAnnexByNameUseCase(FindAnnexByNameOutputPort findAnnexByNameOutputPort) {
    this.findAnnexByNameOutputPort = findAnnexByNameOutputPort;
  }

  @Override
  public Optional<Annex> find(String name) {
    LOOGER.info(String.format("Finding annex by name: '%s'", name));
    return findAnnexByNameOutputPort.find(name);
  }

}
