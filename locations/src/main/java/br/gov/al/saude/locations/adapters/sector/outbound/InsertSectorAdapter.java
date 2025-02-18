package br.gov.al.saude.locations.adapters.sector.outbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.gov.al.saude.locations.adapters.sector.outbound.repository.SectorRepository;
import br.gov.al.saude.locations.adapters.sector.outbound.repository.mapper.SectorMapperOutbound;
import br.gov.al.saude.locations.application.domain.Sector;
import br.gov.al.saude.locations.application.ports.sector.outbound.InsertSectorOutputPort;

@Component
public class InsertSectorAdapter implements InsertSectorOutputPort {
  private final SectorRepository sectorRepository;
  private final SectorMapperOutbound sectorMapperOutbound;

  @Autowired
  public InsertSectorAdapter(SectorRepository sectorRepository, SectorMapperOutbound sectorMapperOutbound) {
    this.sectorRepository = sectorRepository;
    this.sectorMapperOutbound = sectorMapperOutbound;
  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public void insert(Sector sector) {
    sectorRepository.save(sectorMapperOutbound.toEntity(sector));
  }

}
