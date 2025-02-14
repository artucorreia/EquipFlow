package br.gov.al.saude.locations.application.usecase.annex;

import java.util.Optional;
import java.util.logging.Logger;

import br.gov.al.saude.locations.application.ports.annex.outbound.InsertAnnexOutputPort;
import br.gov.al.saude.locations.application.domain.Annex;
import br.gov.al.saude.locations.application.domain.exception.AnnexAlreadyExists;
import br.gov.al.saude.locations.application.ports.annex.inbound.FindAnnexByNameInputPort;
import br.gov.al.saude.locations.application.ports.annex.inbound.InsertAnnexInputPort;

public class InsertAnnexUseCase implements InsertAnnexInputPort {
  private final Logger LOOGER = Logger.getLogger(InsertAnnexUseCase.class.getName());

  private final InsertAnnexOutputPort insertAnnexOutputPort;
  private final FindAnnexByNameInputPort findAnnexByNameInputPort;

  public InsertAnnexUseCase(InsertAnnexOutputPort insertAnnexOutputPort,
      FindAnnexByNameInputPort findAnnexByNameInputPort) {
    this.insertAnnexOutputPort = insertAnnexOutputPort;
    this.findAnnexByNameInputPort = findAnnexByNameInputPort;
  }

  public void insert(Annex annex) {
    LOOGER.info("Inserting a new annex");
    annex.setName(annex.getName().trim());
    Optional<Annex> optionalAnnex = findAnnexByNameInputPort.find(annex.getName());
    if (optionalAnnex.isPresent())
      throw new AnnexAlreadyExists("Annex already exists");
    annex.setDeleted(false);
    insertAnnexOutputPort.insert(annex);
  }

}
