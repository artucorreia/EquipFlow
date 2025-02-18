package br.gov.al.saude.locations.adapters.sector.inbound.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.gov.al.saude.locations.adapters.sector.inbound.controller.request.CreateSectorDTO;
import br.gov.al.saude.locations.adapters.sector.inbound.controller.request.UpdateSectorDTO;
import br.gov.al.saude.locations.adapters.sector.inbound.controller.response.SectorDTO;
import br.gov.al.saude.locations.application.domain.Sector;

@Mapper(componentModel = "spring")
public interface SectorMapperInbound {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "createdBy", ignore = true)
  @Mapping(target = "updatedAt", ignore = true)
  @Mapping(target = "updatedBy", ignore = true)
  @Mapping(target = "deleted", ignore = true)
  Sector toDomain(CreateSectorDTO createSectorDTO);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "createdBy", ignore = true)
  @Mapping(target = "updatedAt", ignore = true)
  @Mapping(target = "updatedBy", ignore = true)
  @Mapping(target = "deleted", ignore = true)
  Sector toDomain(UpdateSectorDTO updateSectorDTO);

  SectorDTO toDTO(Sector sector);
}
