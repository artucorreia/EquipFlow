package br.gov.al.saude.locations.adapters.annex.outbound.repository.mapper;

import org.mapstruct.Mapper;

import br.gov.al.saude.locations.adapters.annex.outbound.repository.entity.AnnexEntity;
import br.gov.al.saude.locations.application.domain.Annex;

@Mapper(componentModel = "spring")
public interface AnnexMapperOutbound {
  Annex toDomain(AnnexEntity annexEntity);

  AnnexEntity toEntity(Annex annex);
}
