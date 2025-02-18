package br.gov.al.saude.locations.adapters.sector.outbound.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import br.gov.al.saude.locations.adapters.sector.outbound.projection.SectorSimpleProjection;
import br.gov.al.saude.locations.adapters.sector.outbound.repository.entity.SectorEntity;
import br.gov.al.saude.locations.application.domain.Sector;

@Mapper(componentModel = "spring")
public interface SectorMapperOutbound {

  SectorEntity toEntity(Sector sector);

  Sector toDomain(SectorEntity sectorEntity);

  @Mappings({
      @Mapping(target = "createdAt", ignore = true),
      @Mapping(target = "createdBy", ignore = true),
      @Mapping(target = "updatedAt", ignore = true),
      @Mapping(target = "updatedBy", ignore = true),
      @Mapping(target = "deleted", ignore = true)
  })
  Sector toDomain(SectorSimpleProjection sectorSimpleProjection);
}
