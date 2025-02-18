package br.gov.al.saude.locations.application.ports.sector.outbound;

import java.util.List;

import br.gov.al.saude.locations.application.domain.Sector;

public interface FindAllSectorsOutputPort {
  List<Sector> find();

  List<Sector> findBySimpleProjection();
}
