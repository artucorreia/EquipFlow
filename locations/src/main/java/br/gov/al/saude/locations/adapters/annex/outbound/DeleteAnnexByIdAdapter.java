package br.gov.al.saude.locations.adapters.annex.outbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.gov.al.saude.locations.adapters.annex.outbound.repository.AnnexRepository;
import br.gov.al.saude.locations.application.ports.annex.outbound.DeleteAnnexByIdOutputPort;

@Component
public class DeleteAnnexByIdAdapter implements DeleteAnnexByIdOutputPort {

  private final AnnexRepository annexRepository;

  @Autowired
  public DeleteAnnexByIdAdapter(AnnexRepository annexRepository) {
    this.annexRepository = annexRepository;
  }

  @Modifying
  @Transactional(rollbackFor = Exception.class)
  @Override
  public void delete(Long id) {
    annexRepository.deleteById(id);
  }

}
