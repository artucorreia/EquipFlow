package br.gov.al.saude.locations.adapters.sector.outbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.al.saude.locations.adapters.sector.outbound.repository.SectorRepository;
import br.gov.al.saude.locations.adapters.sector.outbound.repository.entity.SectorEntity;
import br.gov.al.saude.locations.adapters.sector.outbound.repository.mapper.SectorMapperOutbound;
import br.gov.al.saude.locations.application.domain.Sector;
import br.gov.al.saude.locations.application.ports.sector.outbound.UpdateSectorOutputPort;

@Component
public class UpdateSectorAdapter implements UpdateSectorOutputPort {

  private final SectorRepository sectorRepository;
  private final SectorMapperOutbound sectorMapperOutbound;

  @Autowired
  public UpdateSectorAdapter(SectorRepository sectorRepository, SectorMapperOutbound sectorMapperOutbound) {
    this.sectorRepository = sectorRepository;
    this.sectorMapperOutbound = sectorMapperOutbound;
  }

  @Override
  public void update(Sector sector) {
    SectorEntity sectorEntity = sectorMapperOutbound.toEntity(sector);
    sectorRepository.save(sectorEntity);
  }

}
