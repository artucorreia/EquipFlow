package br.gov.al.saude.locations.adapters.sector.outbound;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.al.saude.locations.adapters.sector.outbound.repository.SectorRepository;
import br.gov.al.saude.locations.adapters.sector.outbound.repository.mapper.SectorMapperOutbound;
import br.gov.al.saude.locations.application.domain.Sector;
import br.gov.al.saude.locations.application.ports.sector.outbound.FindAllSectorsOutputPort;

@Component
public class FindAllSectorsAdapter implements FindAllSectorsOutputPort {

  private final SectorRepository sectorRepository;
  private final SectorMapperOutbound sectorMapperOutbound;

  @Autowired
  public FindAllSectorsAdapter(SectorRepository sectorRepository, SectorMapperOutbound sectorMapperOutbound) {
    this.sectorRepository = sectorRepository;
    this.sectorMapperOutbound = sectorMapperOutbound;
  }

  @Override
  public List<Sector> find() {
    return sectorRepository
        .findAll()
        .stream()
        .map(sectorEntity -> sectorMapperOutbound.toDomain(sectorEntity))
        .toList();
  }

  @Override
  public List<Sector> findBySimpleProjection() {
    return sectorRepository
        .findAllByDeletedIsFalse()
        .stream()
        .map(sectorSimpleProjection -> sectorMapperOutbound.toDomain(sectorSimpleProjection))
        .toList();
  }

}
