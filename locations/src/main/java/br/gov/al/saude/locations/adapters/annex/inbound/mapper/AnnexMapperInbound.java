package br.gov.al.saude.locations.adapters.annex.inbound.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.gov.al.saude.locations.adapters.annex.inbound.request.CreateAnnexDTO;
import br.gov.al.saude.locations.adapters.annex.inbound.request.UpdateAnnexDTO;
import br.gov.al.saude.locations.adapters.annex.inbound.response.AnnexDTO;
import br.gov.al.saude.locations.application.domain.Annex;

@Mapper(componentModel = "spring")
public interface AnnexMapperInbound {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "createdBy", ignore = true)
  @Mapping(target = "updatedAt", ignore = true)
  @Mapping(target = "updatedBy", ignore = true)
  @Mapping(target = "deleted", ignore = true)
  Annex toDomain(CreateAnnexDTO createAnnexDTO);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "createdBy", ignore = true)
  @Mapping(target = "updatedAt", ignore = true)
  @Mapping(target = "updatedBy", ignore = true)
  @Mapping(target = "deleted", ignore = true)
  Annex toDomain(UpdateAnnexDTO updateAnnexDTO);

  AnnexDTO toDTO(Annex annex);

}
