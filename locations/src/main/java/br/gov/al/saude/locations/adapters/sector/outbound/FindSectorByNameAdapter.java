package br.gov.al.saude.locations.adapters.sector.outbound;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.al.saude.locations.adapters.sector.outbound.repository.SectorRepository;
import br.gov.al.saude.locations.adapters.sector.outbound.repository.mapper.SectorMapperOutbound;
import br.gov.al.saude.locations.application.domain.Sector;
import br.gov.al.saude.locations.application.ports.sector.outbound.FindSectorByNameOutputPort;

@Component
public class FindSectorByNameAdapter implements FindSectorByNameOutputPort {

  private final SectorRepository sectorRepository;
  private final SectorMapperOutbound sectorMapperOutbound;

  @Autowired
  public FindSectorByNameAdapter(SectorRepository sectorRepository, SectorMapperOutbound sectorMapperOutbound) {
    this.sectorRepository = sectorRepository;
    this.sectorMapperOutbound = sectorMapperOutbound;
  }

  @Override
  public Optional<Sector> find(String name) {
    return sectorRepository.findByName(name)
        .map(sectorEntity -> sectorMapperOutbound.toDomain(sectorEntity));
  }

}
