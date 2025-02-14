package br.gov.al.saude.locations.application.ports.annex.inbound;

import br.gov.al.saude.locations.application.domain.Annex;

public interface UpdateAnnexInputPort {
  void update(Long id, Annex updatedAnnex);
}
