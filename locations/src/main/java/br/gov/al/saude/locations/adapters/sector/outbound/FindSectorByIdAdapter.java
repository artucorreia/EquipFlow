package br.gov.al.saude.locations.adapters.sector.outbound;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.al.saude.locations.adapters.sector.outbound.repository.SectorRepository;
import br.gov.al.saude.locations.adapters.sector.outbound.repository.mapper.SectorMapperOutbound;
import br.gov.al.saude.locations.application.domain.Sector;
import br.gov.al.saude.locations.application.ports.sector.outbound.FindSectorByIdOutputPort;

@Component
public class FindSectorByIdAdapter implements FindSectorByIdOutputPort {
  private final SectorRepository sectorRepository;
  private final SectorMapperOutbound sectorMapperOutbound;

  @Autowired
  public FindSectorByIdAdapter(SectorRepository sectorRepository, SectorMapperOutbound sectorMapperOutbound) {
    this.sectorRepository = sectorRepository;
    this.sectorMapperOutbound = sectorMapperOutbound;
  }

  @Override
  public Optional<Sector> find(Long id) {
    return sectorRepository.findById(id)
        .map(sectorEntity -> sectorMapperOutbound.toDomain(sectorEntity));
  }

}
