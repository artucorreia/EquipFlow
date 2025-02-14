package br.gov.al.saude.locations.application.ports.annex.outbound;

import br.gov.al.saude.locations.application.domain.Annex;

public interface DeleteAnnexOutputPort {
  void delete(Annex annex);
}
