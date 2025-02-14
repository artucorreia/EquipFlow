package br.gov.al.saude.locations.adapters.annex.outbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.gov.al.saude.locations.adapters.annex.outbound.repository.AnnexRepository;
import br.gov.al.saude.locations.adapters.annex.outbound.repository.entity.AnnexEntity;
import br.gov.al.saude.locations.adapters.annex.outbound.repository.mapper.AnnexMapperOutbound;
import br.gov.al.saude.locations.application.domain.Annex;
import br.gov.al.saude.locations.application.ports.annex.outbound.UpdateAnnexOutputPort;

@Component
public class UpdateAnnexAdapter implements UpdateAnnexOutputPort {

  private final AnnexRepository annexRepository;
  private final AnnexMapperOutbound annexMapperOutbound;

  @Autowired
  public UpdateAnnexAdapter(AnnexRepository annexRepository, AnnexMapperOutbound annexMapperOutbound) {
    this.annexRepository = annexRepository;
    this.annexMapperOutbound = annexMapperOutbound;
  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public void update(Annex annex) {
    AnnexEntity annexEntity = annexMapperOutbound.toEntity(annex);
    annexRepository.save(annexEntity);
  }

}
