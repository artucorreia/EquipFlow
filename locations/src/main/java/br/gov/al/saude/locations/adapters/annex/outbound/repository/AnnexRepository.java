package br.gov.al.saude.locations.adapters.annex.outbound.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.al.saude.locations.adapters.annex.outbound.repository.entity.AnnexEntity;

@Repository
public interface AnnexRepository extends JpaRepository<AnnexEntity, Long> {
  Optional<AnnexEntity> findByName(String name);
}
