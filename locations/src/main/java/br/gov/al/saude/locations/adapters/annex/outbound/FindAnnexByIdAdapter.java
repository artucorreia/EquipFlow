package br.gov.al.saude.locations.adapters.annex.outbound;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.al.saude.locations.adapters.annex.outbound.repository.AnnexRepository;
import br.gov.al.saude.locations.adapters.annex.outbound.repository.mapper.AnnexMapperOutbound;
import br.gov.al.saude.locations.application.domain.Annex;
import br.gov.al.saude.locations.application.ports.annex.outbound.FindAnnexByIdOutputPort;

@Component
public class FindAnnexByIdAdapter implements FindAnnexByIdOutputPort {
  private final AnnexRepository annexRepository;
  private final AnnexMapperOutbound annexMapperOutbound;

  @Autowired
  public FindAnnexByIdAdapter(AnnexRepository annexRepository, AnnexMapperOutbound annexMapperOutbound) {
    this.annexRepository = annexRepository;
    this.annexMapperOutbound = annexMapperOutbound;
  }

  @Override
  public Optional<Annex> find(Long id) {
    return annexRepository.findById(id).map(annexEntity -> annexMapperOutbound.toDomain(annexEntity));
  }

}
