package br.gov.al.saude.locations.application.ports.sector.inbound;

import java.util.List;

import br.gov.al.saude.locations.application.domain.Sector;

public interface FindAllSectorsInputPort {
  List<Sector> find();

  List<Sector> findBySimpleProjection();
}
