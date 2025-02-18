package br.gov.al.saude.locations.adapters.sector.outbound.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.al.saude.locations.adapters.sector.outbound.projection.SectorSimpleProjection;
import br.gov.al.saude.locations.adapters.sector.outbound.repository.entity.SectorEntity;

@Repository
public interface SectorRepository extends JpaRepository<SectorEntity, Long> {
  Optional<SectorEntity> findByName(String name);

  Optional<SectorEntity> findByAcronym(String acronym);

  List<SectorSimpleProjection> findAllByDeletedIsFalse();
}
