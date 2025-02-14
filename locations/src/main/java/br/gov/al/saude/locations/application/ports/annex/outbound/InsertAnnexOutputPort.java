package br.gov.al.saude.locations.application.ports.annex.outbound;

import br.gov.al.saude.locations.application.domain.Annex;

public interface InsertAnnexOutputPort {
  void insert(Annex annex);
}
