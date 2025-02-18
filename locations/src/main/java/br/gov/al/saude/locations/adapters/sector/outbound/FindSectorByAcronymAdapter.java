package br.gov.al.saude.locations.adapters.sector.outbound;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.al.saude.locations.adapters.sector.outbound.repository.SectorRepository;
import br.gov.al.saude.locations.adapters.sector.outbound.repository.mapper.SectorMapperOutbound;
import br.gov.al.saude.locations.application.domain.Sector;
import br.gov.al.saude.locations.application.ports.sector.outbound.FindSectorByAcronymOutputPort;

@Component
public class FindSectorByAcronymAdapter implements FindSectorByAcronymOutputPort {

  private final SectorRepository sectorRepository;
  private final SectorMapperOutbound sectorMapperOutbound;

  @Autowired
  public FindSectorByAcronymAdapter(SectorRepository sectorRepository, SectorMapperOutbound sectorMapperOutbound) {
    this.sectorRepository = sectorRepository;
    this.sectorMapperOutbound = sectorMapperOutbound;
  }

  @Override
  public Optional<Sector> find(String acronym) {
    return sectorRepository.findByAcronym(acronym)
        .map(sectorEntity -> sectorMapperOutbound.toDomain(sectorEntity));
  }

}
