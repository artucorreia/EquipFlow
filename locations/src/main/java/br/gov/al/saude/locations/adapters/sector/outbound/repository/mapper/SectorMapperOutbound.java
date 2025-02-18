package br.gov.al.saude.locations.adapters.sector.outbound.repository.mapper;

import org.mapstruct.Mapper;

import br.gov.al.saude.locations.adapters.sector.outbound.repository.entity.SectorEntity;
import br.gov.al.saude.locations.application.domain.Sector;

@Mapper(componentModel = "spring")
public interface SectorMapperOutbound {

  SectorEntity toEntity(Sector sector);

  Sector toDomain(SectorEntity sectorEntity);
}
